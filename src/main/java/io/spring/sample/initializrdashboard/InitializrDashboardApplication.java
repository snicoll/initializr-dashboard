package io.spring.sample.initializrdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DashboardProperties.class)
public class InitializrDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitializrDashboardApplication.class, args);
	}

}
