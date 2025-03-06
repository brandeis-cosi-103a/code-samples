package edu.brandeis.cosi103a.samples.lecture12.spring.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        // Initialize Spring application context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        
        // Retrieve the GreetingController bean
        GreetingController controller = context.getBean(GreetingController.class);
        controller.sayHello();
    }
}
