package com.keyrus.kit.services;

import com.keyrus.kit.data.PatientData;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

@Service
public class KafkaService {

    @Resource
    private KafkaTemplate<String, PatientData> kafkaTemplate;

    public void sendMessage(String topicName, PatientData message) {
        ListenableFuture<SendResult<String, PatientData>> future =
                kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, PatientData>>() {
            @Override
            public void onSuccess(SendResult<String, PatientData> result) {
                System.out.println("Success");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Error");
            }
        });
    }

}
