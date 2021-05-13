package com.ltts.gateway.configuration;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import com.ltts.gateway.consumer.Consumer;



@Configuration


public class GatewayConfig {

	public static final String  Blood_Pressure = "Blood_Pressure";
	public static final String  Oxygen_level = "Oxygen_level";
	public static final String  Heart_rate = "Heart_rate";
	

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
		return new DirectExchange("direct-exchange");
	}

	@Bean
	Binding Blood_PressureBinding(Queue Blood_Pressure, DirectExchange exchange) {
		return BindingBuilder.bind(Blood_Pressure).to(exchange).with("Blood_Pressure");
	}

	@Bean
	Binding OxygenBinding(Queue Blood_oxygen_level, DirectExchange exchange) {
		return BindingBuilder.bind(Blood_oxygen_level).to(exchange).with("Blood_oxygen_level");
	}

	@Bean
	Binding HeartBinding(Queue Heart_rate, DirectExchange exchange) {
		return BindingBuilder.bind(Heart_rate).to(exchange).with("Heart_rate");
	}
	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter)
	{
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		container.setQueueNames(Blood_Pressure);
		container.setMessageListener(listenerAdapter);
		return container;
	}
	@Bean
	SimpleMessageListenerContainer container1(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter)
	{
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
	
		container.setQueueNames(Oxygen_level);

		container.setMessageListener(listenerAdapter);
		return container;
	}
	@Bean
	SimpleMessageListenerContainer container2(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter)
	{
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		container.setQueueNames(Heart_rate);
		container.setMessageListener(listenerAdapter);
		return container;
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
	@Bean
	MessageListenerAdapter listenerAdapter(Consumer consumer)
	{
		return new MessageListenerAdapter(consumer, "receiveMessage");
	}

}
