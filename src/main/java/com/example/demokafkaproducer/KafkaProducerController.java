package com.example.demokafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.model.Student;

@RestController
@RequestMapping("/v1/kafka")
public class KafkaProducerController {
	
	@Autowired
	private KafkaSender sender;
	
	@PostMapping("send")
	public ResponseEntity<String> sendData(@RequestBody Student student){
		sender.sendData(student);
		return new ResponseEntity<>("Data sent to kafka", HttpStatus.OK);
	}
	
	@PostMapping("/send/employee")
	public ResponseEntity<String> sendData(@RequestBody Employee employee){
		sender.sendDataEmployee(employee);
		return new ResponseEntity<>("Data sent to kafka", HttpStatus.OK);
	}
}
 