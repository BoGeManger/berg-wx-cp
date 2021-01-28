package com.berg.cp.controller;

import com.berg.common.constant.Result;
import com.berg.common.controller.AbstractController;
import com.berg.cp.service.cp.LoginService;
import com.berg.vo.cp.in.CpGetAuthUrlInVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Api(tags = "微信企业用户登录")
public class LoginController extends AbstractController {

    @Autowired
    LoginService loginService;

    @ApiOperation(value = "获取公众号网页授权地址")
    @GetMapping(value = "getAuthUrl")
    public Result<String> getAuthUrl(@Validated CpGetAuthUrlInVo input){
        return getSuccessResult("请求成功",loginService.getAuthUrl(input));
    }
}
