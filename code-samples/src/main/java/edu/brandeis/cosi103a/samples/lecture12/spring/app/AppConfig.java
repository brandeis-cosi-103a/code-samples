package edu.brandeis.cosi103a.samples.lecture12.spring.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "edu.brandeis.cosi103a.samples.lecture12.spring") // Scans for @Component, @Service, etc.
public class AppConfig {
}
