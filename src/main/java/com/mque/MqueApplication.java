
package com.mque;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class MqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqueApplication.class, args);
	}
}
