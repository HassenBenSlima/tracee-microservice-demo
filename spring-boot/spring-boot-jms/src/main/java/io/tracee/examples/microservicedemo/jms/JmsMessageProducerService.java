package io.tracee.examples.microservicedemo.jms;


import io.tracee.binding.jms.TraceeMessageWriter;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class JmsMessageProducerService {

    Logger logger = org.slf4j.LoggerFactory.getLogger(JmsMessageProducerService.class);


    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private Queue queue;

    public void produceCalculationMessage(String calculation) {

        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            final javax.jms.MessageProducer producer = TraceeMessageWriter.wrap(session.createProducer(queue));
            final TextMessage textMessage = session.createTextMessage();
            textMessage.setText(calculation);
            logger.info("I am about to send the calculation \"{}\" to {}", calculation, queue.toString());
            producer.send(textMessage);
        } catch (JMSException jmse) {
            throw new RuntimeException("This example is so cheap, this must not have happened!", jmse);
        }

    }


}
