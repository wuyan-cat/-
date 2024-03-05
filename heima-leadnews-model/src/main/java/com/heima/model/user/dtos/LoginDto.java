/**
 * z作者:无言
 * 版本:1.0
 * 2024-3-5 14:39
 */


package com.heima.model.user.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LoginDto {

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号",required = true)
    private String phone;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",required = true)

    private  String password;
}
