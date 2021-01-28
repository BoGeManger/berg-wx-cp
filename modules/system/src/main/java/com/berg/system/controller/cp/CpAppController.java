package com.berg.system.controller.cp;

import com.berg.common.controller.AbstractController;
import com.berg.common.constant.Result;
import com.berg.system.service.miniapp.AppService;
import com.berg.vo.cp.CpAppVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cpapp")
@Api(tags = "微信企业号应用")
public class CpAppController extends AbstractController {

    @Autowired
    AppService appService;

    @ApiOperation("获取企业号应用列表")
    @GetMapping(value = "getAppList")
    public Result<List<CpAppVo>> getAppList(){
        return getSuccessResult("请求成功",appService.getAppList());
    }
}
