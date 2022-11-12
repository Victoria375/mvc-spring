package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Arrays;

@SpringBootApplication
public class MvcSpringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MvcSpringApplication.class, args);

		DispatcherServlet bean = context.getBean(DispatcherServlet.class);
		System.out.println(bean);

		Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
	}

}
