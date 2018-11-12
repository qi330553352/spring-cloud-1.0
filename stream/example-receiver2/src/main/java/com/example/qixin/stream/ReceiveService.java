package com.example.qixin.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
@EnableBinding({IReceiveService.class})
public class ReceiveService {

	@StreamListener("agan-exchange")
	public void onReceive(byte[] msg){
		System.out.println("receive:"+ new String(msg));
	}
}
