package com.ran.ranAICodeMother.service;

import com.mybatisflex.core.service.IService;
import com.ran.ranAICodeMother.model.dto.UserRegisterRequest;
import com.ran.ranAICodeMother.model.entity.User;

/**
 *  服务层。
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 */
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount、userPassword、checkPassword 用户信息
     * @return 注册结果
     */
    long userRegister(String userAccount,String userPassword, String checkPassword);
}
