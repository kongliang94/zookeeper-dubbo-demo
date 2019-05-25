package com.github.mall.controller;

import java.util.List;

import com.github.mall.bean.UserAddress;
import com.github.mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author KL
 * @date 2019/5/25
 */
@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@RequestMapping("/initOrder")
	public List<UserAddress> initOrder(@RequestParam("userId")String userId) {
		return orderService.initOrder(userId);
	}

}
