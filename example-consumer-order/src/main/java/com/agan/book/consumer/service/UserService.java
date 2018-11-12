package com.agan.book.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.agan.book.user.facade.UserFacade;


@FeignClient(name="e-book-user")
public interface UserService extends UserFacade{

}
