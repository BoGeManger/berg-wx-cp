package com.berg.vo.cp.out;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CpUserInfoOutVo {

    @ApiModelProperty(value = "非企业成员的标识，对当前企业唯一")
    String openId;
    @ApiModelProperty(value = "手机设备号(由企业微信在安装时随机生成，删除重装会改变，升级不受影响)")
    String deviceId;
    @ApiModelProperty(value = "成员UserID。若需要获得用户详情信息，可调用通讯录接口：读取成员")
    String userId;
}
