package com.github.mall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.mall.bean.UserAddress;
import com.github.mall.service.UserService;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@Service
@Component
public class UserServiceImpl implements UserService {

    @Override
    public List<UserAddress> getUserAddressList(String userId) {

        //模拟数据的小工具,等价于第35,36行
        /*EasyRandomParameters parameters = new EasyRandomParameters()
                .seed(123L)
                .objectPoolSize(100)
                .randomizationDepth(3)
                .charset(Charset.forName("UTF-8"))
                .stringLengthRange(5, 50)
                .collectionSizeRange(1, 10)
                .scanClasspathForConcreteTypes(true)
                .overrideDefaultInitialization(false)
                .ignoreRandomizationErrors(true);
        EasyRandom easyRandom = new EasyRandom();
        UserAddress address1 = easyRandom.nextObject(UserAddress.class);
        UserAddress address2 = easyRandom.nextObject(UserAddress.class);*/
        UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");
        List<UserAddress> userAddresses= Arrays.asList(address1,address2);

        return userAddresses;
    }
}
