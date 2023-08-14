
package com.mque.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


import com.mque.services.MessageService;

@RestController
public class MqueController {

	private final MessageService messageService;
	@Value("${ibm.mq.connName}")
    private String connName;

	@Autowired
	public MqueController(MessageService messageService) {
		this.messageService = messageService;
	}

	@GetMapping("sendMessage")
	public String sendMessage(@RequestParam("msg") String msg) {
		return messageService.sendMessage(msg);
	}

	@GetMapping("getMessage")
	public String getMessage() {
		return messageService.getMessage();
	}

	@GetMapping("getAddress")
	public String getAddress() {
		try {
			String address_ = connName.split("\\(")[0];;			
			return "{ \"message\" : \""+ address_ +"\",  \"message\" : \""+ address_ +"\" }";
		} catch(Exception e) {
			return "{ \"message\" : \"Please ensure that your application.properties file is set up correctly.\" }";
		}
		
	}
}
