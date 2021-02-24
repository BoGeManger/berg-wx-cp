package com.berg.cp.controller;

import com.berg.common.constant.Result;
import com.berg.common.controller.AbstractController;
import com.berg.cp.service.cp.UserService;
import com.berg.vo.cp.out.CpUserInfoOutVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

@RestController
@RequestMapping("/user")
@Api(tags = "微信企业用户")
public class UserController extends AbstractController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "获取用户信息")
    @GetMapping(value = "userInfo")
    public Result<CpUserInfoOutVo> userInfo(@NotBlank(message = "网页授权地址code不能为空") @RequestParam(name = "code", required = true) String code){
        return success("请求成功",()->userService.userInfo(code));
    }
}
