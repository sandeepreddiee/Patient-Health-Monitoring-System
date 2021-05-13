package com.ltts.gateway.consumer;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class Consumer implements ChannelAwareMessageListener {

	@ResponseBody
	@RequestMapping(value = "/getString", method = RequestMethod.POST)
	@Override
	public void onMessage(Message message, com.rabbitmq.client.Channel channel) throws Exception {
		System.out.println("Received <" + message + ">");

		channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

	}

}
