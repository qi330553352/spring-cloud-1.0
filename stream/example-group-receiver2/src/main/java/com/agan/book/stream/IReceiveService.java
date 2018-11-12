package com.agan.book.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface IReceiveService {
	
	String INPUT="inputProduct";
	
	@Input(INPUT)
	SubscribableChannel receive();
}
