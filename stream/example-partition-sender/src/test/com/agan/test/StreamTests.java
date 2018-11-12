package com.agan.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import com.agan.book.stream.ISendService;
import com.agan.book.stream.Product;
import com.agan.book.stream.StreamSenderApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StreamSenderApplication.class)
public class StreamTests {

	@Autowired
	private ISendService send;

	@Test
	public void send() throws InterruptedException {
		Product obj=new Product();
		obj.setId(100);
		obj.setName("spring cloud");
		for (int i = 0; i <10; i++) {
			Message message=MessageBuilder.withPayload(obj).build();
			this.send.send().send(message);
		}

	}

}
