package com.mariuszilinskas.vsp.discovery.search.consumer;

import com.mariuszilinskas.vsp.discovery.search.dto.MediaRequest;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMQConsumer {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);
//    private final UserService userService;

    @RabbitListener(queues = "${rabbitmq.queues.add-update-content}")
    public void consumeAddUpdateContentMessage(MediaRequest request) {
        logger.info("Received request to add/update media content data [title: {}]", request.title());
//        userService.verifyUser(userId);
    }

    @RabbitListener(queues = "${rabbitmq.queues.delete-content}")
    public void consumeDeleteContentMessage(String contentId) {
        logger.info("Received request to delete media content data [contentId: {}]", contentId);
//        userService.verifyUser(userId);
    }

}
