package com.berg.vo.cp.in;

import com.berg.vo.common.PageInVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class GetMediaPageInVo extends PageInVo {

    @NotBlank(message = "微信企业号corpId不能为空")
    @ApiModelProperty(value = "微信企业号corpId")
    String corpId;
    @ApiModelProperty(value = "描述")
    String remark;
}
