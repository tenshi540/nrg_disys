// Die Testklassen (MessageConsumer und TestProducer) sind 
// nur für uns zum Debuggen und schnellen Testen gedacht!

package at.uastw.nrg_1.messaging;

import at.uastw.nrg_1.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EnergyMessageConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Empfangen: " + message);
    }
}

