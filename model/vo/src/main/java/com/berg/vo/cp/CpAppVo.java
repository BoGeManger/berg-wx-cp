package com.berg.vo.cp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CpAppVo {

    @ApiModelProperty(value = "企业微信应用的agentId")
    Integer agentId;
    @ApiModelProperty(value = "企业微信的corpId")
    String corpId;
    @ApiModelProperty(value = "企业微信名称")
    String name;
}
