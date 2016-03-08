package io.tracee.examples.microservicedemo.jms;

import io.tracee.Tracee;
import io.tracee.TraceeBackend;
import io.tracee.TraceeConstants;
import io.tracee.binding.jaxrs2.TraceeClientFilter;
import io.tracee.contextlogger.TraceeContextLogger;
import io.tracee.examples.microservicedemo.jms.config.JmsConfig;
import org.slf4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.ws.rs.client.ClientBuilder;
import java.util.Map;

import static io.tracee.configuration.TraceeFilterConfiguration.Channel.AsyncProcess;

/**
 * Sorry for this implementation, it's not the preferred way to do it.
 * We still need to provide a proper binding for spring-jms consumers.
 */

@Component
public class JmsMessageConsumer {

    @JmsListener(destination = JmsConfig.QUEUE)
    public void receiveOrder(String calculation, Message message) {
        Logger logger = org.slf4j.LoggerFactory.getLogger(JmsMessageProducerService.class);

        // like explained in class comment - this code works, but it is not the proper way to do it
        try {
            beforeProcessing(message);

            logger.info("Do asynchronous calculation of {} for message {}‚", calculation, message.getJMSMessageID());


            CalculationResult result = ClientBuilder.newClient().target("http://jaxrs:8081/api/calculate").queryParam("calculation", calculation).register(TraceeClientFilter.class).request().buildGet().invoke(CalculationResult.class);

            logger.info("Solved calculation: {} = {}", result.getCalculation(), result.getResult());

        } catch (Exception e) {
            logger.error("Error during processing of calculation {}", calculation, e);
        } finally {
            cleanUp();
        }

    }

    @SuppressWarnings("unchecked")
    public void beforeProcessing(final Message message) throws JMSException {
        TraceeBackend backend = Tracee.getBackend();
        if (backend.getConfiguration().shouldProcessContext(AsyncProcess)) {
            final Object encodedTraceeContext = message.getObjectProperty(TraceeConstants.TPIC_HEADER);
            if (encodedTraceeContext != null) {
                final Map<String, String> contextFromMessage = (Map<String, String>) encodedTraceeContext;
                backend.putAll(backend.getConfiguration().filterDeniedParams(contextFromMessage, AsyncProcess));
            }
        }

    }

    void cleanUp() {
        TraceeBackend backend = Tracee.getBackend();

        if (backend.getConfiguration().shouldProcessContext(AsyncProcess)) {
            backend.clear();
        }
    }

}
