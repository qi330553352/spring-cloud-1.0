package com.agan.book.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding({IReceiveService.class})
public class ReceiveService {

	@StreamListener(IReceiveService.INPUT)
	public void onReceive(Product obj){
		System.out.println("receive:"+ obj.toString());
	}
}
