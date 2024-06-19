package com.piyush.kafka.consumer;

import com.piyush.kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "piyush", groupId = "myGroup")
    public void consumeMsg(Student student) {
        log.info(String.format("Consumeing the message form  topic Piyush :: %s", student.toString()));


    }
}
