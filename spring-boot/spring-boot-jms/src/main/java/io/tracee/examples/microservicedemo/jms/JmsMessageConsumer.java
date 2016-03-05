package io.tracee.examples.microservicedemo.jms;

import io.tracee.examples.microservicedemo.jms.config.JmsConfig;
import org.slf4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;


@Component
public class JmsMessageConsumer {

    @JmsListener(destination = "queue://" + JmsConfig.QUEUE)
    public void receiveOrder(String calculation) {
        Logger logger = org.slf4j.LoggerFactory.getLogger(JmsMessageProducerService.class);
        logger.info("Do asynchronous calculation of {} , ", calculation);
        //storeService.registerOrder(order);
    }

}
