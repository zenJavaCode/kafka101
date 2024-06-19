package com.piyush.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Slf4j
@Component
public class KafkaProducer {


    private final KafkaTemplate <String,String> kafkaTemplate;

    public void sendMessage(String message){

        log.info(String.format("Sending message to piyush topic :: %s",message));
        kafkaTemplate.send("piyush",message);

    }




}
