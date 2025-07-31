package com.ran.ranAICodeMother.model.enums;

import cn.hutool.core.util.ObjectUtil;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;

/**
 * @author xiaozhi
 * @date 2025/7/30
 */
@Getter
public enum UserRoleEnum {
    USER("user", "普通用户"),
    ADMIN("admin", "管理员");

    private final String text;
    private final String value;

    UserRoleEnum(String text, String value)
    {
        this.text = text;
        this.value = value;
    }
    /**
     * 根据value获取枚举
     *
     * @param value
     * @return
     */
    public static UserRoleEnum getEnumByValue(String value)
    {
        if (ObjectUtil.isEmpty( value))
        {
            return null;
        }
        for (UserRoleEnum anEnum : UserRoleEnum.values())
        {
            if (anEnum.value.equals(value))
            {
                return anEnum;
            }
        }
        return null;
    }


}
