package com.piyush.kafka.rest;

import com.piyush.kafka.KafkaJsonProducer;
import com.piyush.kafka.payload.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.piyush.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {


    private final KafkaProducer kafkaProducer;

    private final KafkaJsonProducer kafkaJsonProducer;

    @Autowired
    public MessageController(KafkaProducer kafkaProducer,KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaJsonProducer = kafkaJsonProducer;
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student message){
        kafkaJsonProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully as JSON.");
    }


}
