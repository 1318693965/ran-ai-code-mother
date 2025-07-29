package com.ran.ranAICodeMother.service.impl;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.ran.ranAICodeMother.model.entity.User;
import com.ran.ranAICodeMother.mapper.UserMapper;
import com.ran.ranAICodeMother.service.UserService;
import org.springframework.stereotype.Service;

/**
 *  服务层实现。
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService{

}
