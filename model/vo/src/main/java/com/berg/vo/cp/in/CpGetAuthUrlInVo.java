package com.berg.vo.cp.in;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CpGetAuthUrlInVo {

    @NotBlank(message = "用户授权完成后的重定向链接不能为空")
    @ApiModelProperty(value = "用户授权完成后的重定向链接")
    String redirectUri;
    @ApiModelProperty(value = "重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节")
    String state;
}
