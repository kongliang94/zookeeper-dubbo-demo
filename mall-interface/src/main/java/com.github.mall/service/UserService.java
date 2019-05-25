package com.github.mall.service;


import com.github.mall.bean.UserAddress;

import java.util.List;

/**
 * 用户服务
 * @author KL
 *
 */
public interface UserService {
	
	/**
	 * 按照用户id返回所有的收货地址
	 * @param userId
	 * @return
	 */
	public List<UserAddress> getUserAddressList(String userId);

}
