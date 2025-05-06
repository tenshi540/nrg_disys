// Die Testklassen (MessageConsumer und TestProducer) sind 
// nur für uns zum Debuggen und schnellen Testen gedacht!

package at.uastw.nrg_1.messaging;

import at.uastw.nrg_1.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestProducer implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public TestProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_NAME, "Hallo von Producer!");
        System.out.println("Nachricht gesendet!");
    }
}
