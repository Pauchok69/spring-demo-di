package com.andy.springdemodi;

import com.andy.springdemodi.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDemoDiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDemoDiApplication.class, args);

		MyController myController = context.getBean("myController", MyController.class);
		String greeting = myController.sayHello();
		System.out.println(greeting);
	}

}
