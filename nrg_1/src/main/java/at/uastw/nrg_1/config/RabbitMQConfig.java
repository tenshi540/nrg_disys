package at.uastw.nrg_1.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    
    public static final String QUEUE_NAME = "energy-data";
    
    
    @Bean
    public Queue energyQueue() {
        return new Queue(QUEUE_NAME, false);
        }      
}
