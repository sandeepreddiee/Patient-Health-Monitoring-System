package com.ltts.Patients;




import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.fasterxml.jackson.databind.ObjectMapper;



@SpringBootApplication
@EnableScheduling


public class PatientApplication {
	
	
	
	public static final String EXCHANGE_NAME = "exchange_name";
	public static final String  Blood_Pressure = "Blood_Pressure";
	public static final String  Oxygen_level = "Oxygen_level";
	public static final String  Heart_rate = "Heart_rate";

	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
	}

	

@Bean
Queue Blood_Pressure() {
	return new Queue("Blood_Pressure", false);
}

@Bean
Queue Blood_oxygen_level() {
	return new Queue("Oxygen_level", false);
}

@Bean
Queue Heart_rate() {
	return new Queue("Heart_rate", false);
}

@Bean
DirectExchange exchange() {
	return new DirectExchange("exchange_name");
}
	
	

	@Bean
	Binding Blood_PressureBinding(Queue Blood_Pressure, DirectExchange exchange) {
		return BindingBuilder.bind(Blood_Pressure).to(exchange).with("Blood_Pressure");
	}

	@Bean
	Binding OxygenBinding(Queue Blood_oxygen_level, DirectExchange exchange) {
		return BindingBuilder.bind(Blood_oxygen_level).to(exchange).with("Oxygen_level");
	}

	@Bean
	Binding HeartBinding(Queue Heart_rate, DirectExchange exchange) {
		return BindingBuilder.bind(Heart_rate).to(exchange).with("Heart_rate");
	}

	@Bean
	public Jackson2JsonMessageConverter messageConverter() {
	   ObjectMapper mapper = new ObjectMapper();
	   return new Jackson2JsonMessageConverter(mapper);
	}

	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
	   RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	   rabbitTemplate.setMessageConverter(messageConverter());
	   return rabbitTemplate;
	}
	@Bean
	public ConnectionFactory connectionFactory()
	{
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(
				"localhost");
		connectionFactory.setPort(5672);
		connectionFactory.setUsername("guest");
		connectionFactory.setPassword("guest");
		return connectionFactory;
	}
}