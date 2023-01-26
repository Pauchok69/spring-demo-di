package com.andy.springdemodi;

import com.andy.springdemodi.controllers.ConstructorInjectedController;
import com.andy.springdemodi.controllers.MyController;
import com.andy.springdemodi.controllers.PropertyInjectedController;
import com.andy.springdemodi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDemoDiApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringDemoDiApplication.class, args);

        System.out.println("---------- Primary Bean");
        MyController myController = context.getBean("myController", MyController.class);
        System.out.println(myController.sayHello());

        System.out.println("---------- Property");
        PropertyInjectedController propertyInjectedController
                = (PropertyInjectedController) context.getBean("propertyInjectedController");
        System.out.println("propertyInjectedController.getGreeting() = " + propertyInjectedController.getGreeting());

        System.out.println("---------- Setter");
        SetterInjectedController setterInjectedController
                = context.getBean("setterInjectedController", SetterInjectedController.class);
        System.out.println("setterInjectedController.getGreeting() = " + setterInjectedController.getGreeting());

        System.out.println("---------- Constructor");
        ConstructorInjectedController constructorInjectedController
                = context.getBean("constructorInjectedController", ConstructorInjectedController.class);
        System.out.println("constructorInjectedController.getGreeting() = " + constructorInjectedController.getGreeting());
    }

}
