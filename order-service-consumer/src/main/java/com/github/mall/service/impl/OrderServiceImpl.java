package com.github.mall.service.impl;

import java.util.Arrays;
import java.util.List;

import com.github.mall.bean.UserAddress;
import com.github.mall.service.OrderService;
import com.github.mall.service.UserService;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 		1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 		2）、配置服务提供者
 * 
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 * @author KL
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	//@Autowired
	@Reference(loadbalance="random",timeout=1000) //dubbo提供的的注解直连
	UserService userService;
	
	@HystrixCommand(fallbackMethod="hello")    //springcloud提供的注解,服务降级
	@Override
	public List<UserAddress> initOrder(String userId) {
		// TODO Auto-generated method stub
		System.out.println("用户id："+userId);
		//1、查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		return addressList;
	}
	
	
	public List<UserAddress> hello(String userId) {
		// TODO Auto-generated method stub
	
		return Arrays.asList(new UserAddress(10, "测试地址", "1", "测试", "测试", "Y"));
	}
	

}
