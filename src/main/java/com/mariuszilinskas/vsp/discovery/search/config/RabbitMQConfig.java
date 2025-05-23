package com.mariuszilinskas.vsp.discovery.search.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.queues.add-update-content}")
    private String addUpdateContentQueue;

    @Value("${rabbitmq.routing-keys.add-update-content}")
    private String addUpdateContentRoutingKey;

    @Value("${rabbitmq.queues.delete-content}")
    private String deleteContentQueue;

    @Value("${rabbitmq.routing-keys.delete-content}")
    private String deleteContentRoutingKey;

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue addUpdateContentQueue() {
        return new Queue(addUpdateContentQueue, true);
    }

    @Bean
    public Binding addUpdateContentBinding() {
        return BindingBuilder.bind(addUpdateContentQueue())
                .to(exchange())
                .with(addUpdateContentRoutingKey);
    }

    @Bean
    public Queue deleteContentQueue() {
        return new Queue(deleteContentQueue, true);
    }

    @Bean
    public Binding deleteContentBinding() {
        return BindingBuilder.bind(deleteContentQueue())
                .to(exchange())
                .with(deleteContentRoutingKey);
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jacksonConverter());
        return rabbitTemplate;
    }

    @Bean
    public MessageConverter jacksonConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
