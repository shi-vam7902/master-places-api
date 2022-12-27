package com.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.Bean.PlaceBean;

@RestController
public class SessionController {// 9899-9000

	@Autowired
	RestTemplate restTemplate;

	@PostMapping("/login")
	public ResponseEntity loginDetails(@RequestBody PlaceBean bean) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		System.out.println(entity);
		Object resObject = restTemplate.exchange("http://localhost:9000/login", HttpMethod.POST, entity, String.class).getBody(); 
		return ResponseEntity.ok(resObject);
	}
}
