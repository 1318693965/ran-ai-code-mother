package com.ran.ranAICodeMother.controller;

import com.ran.ranAICodeMother.common.BaseResponse;
import com.ran.ranAICodeMother.common.ResultUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaozhi
 * @date 2025/7/28
 */

@RestController
@RequestMapping("/health")
@Tag(name = "健康检查接口", description = "用于检查服务是否正常运行的接口") // 类级别注解
public class HealthController {

    //ranAICodeMotherFront
    @GetMapping("/")
    @Operation(summary = "健康检查", description = "返回服务状态是否正常") // 方法级别注解
    public BaseResponse<String> healthCheck() {
        return ResultUtils.success( "ok");
    }
}

