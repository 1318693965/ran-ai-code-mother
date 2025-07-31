package com.ran.ranAICodeMother.service.impl;

import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.StringUtil;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.ran.ranAICodeMother.exception.BusinessException;
import com.ran.ranAICodeMother.exception.ErrorCode;
import com.ran.ranAICodeMother.model.dto.UserRegisterRequest;
import com.ran.ranAICodeMother.model.entity.User;
import com.ran.ranAICodeMother.mapper.UserMapper;
import com.ran.ranAICodeMother.model.enums.UserRoleEnum;
import com.ran.ranAICodeMother.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 *  服务层实现。
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>  implements UserService{


    @Override
    public long userRegister(String userAccount,String userPassword, String checkPassword) {
        //1.校验
        if (StrUtil.hasBlank(userAccount,userPassword,checkPassword)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"参数为空");
        }
        if(userAccount.length()<4){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户账号过短");
        }
        if(userPassword.length()<8 || checkPassword.length()<8){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"用户密码过短");
        }
        if(!userPassword.equals(checkPassword)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"两次输入的密码不一致");
        }
        //2.检查账号是否重复
        QueryWrapper query = new QueryWrapper();
        query.eq(User::getUserAccount,userAccount);
        long count = this.mapper.selectCountByQuery(query);
        if(count>0){
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"账号重复");
        }
        //3.加密
        String encryptPassword = getEncryptPassword(userPassword);
        //4.插入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        user.setUserName("默认姓名");
        user.setUserRole(UserRoleEnum.USER.getValue());
        boolean save = this.save(user);
        if (!save){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR,"注册失败，数据库错误");
        }

        return user.getId();
    }

    @Override
    public String getEncryptPassword(String userPassword) {
        // 盐值，混淆密码
        final String SALT = "ran";
        return DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
    }

}
