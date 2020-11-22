package com.example.demokafkaproducer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import com.example.model.Employee;
import com.example.model.Student;

@Service
public class KafkaSender {

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	@Value("${kafka.topic.name}")
	private String topicName;
	
	@Value("${kafka.topic.name.employee}")
	private String topicNameEmp;
	
	public void sendData(Student student) {
		Map<String,Object> headers = new HashMap<>();
		headers.put(KafkaHeaders.TOPIC, topicName);
		kafkaTemplate.send(new GenericMessage<Student>(student,headers));
	}
	
	public void sendDataEmployee(Employee student) {
		Map<String,Object> headers = new HashMap<>();
		headers.put(KafkaHeaders.TOPIC, topicNameEmp);
		kafkaTemplate.send(new GenericMessage<Employee>(student,headers));
	}
}
