package org.swagger.sample.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
@lombok.Data
public class UserVo implements Serializable {

    @ApiModelProperty(name = "username", value = "账号，建议使用手机号、邮箱。")
    private String username;

    @ApiModelProperty(name = "password", value = "密码，使用sha256不可逆加密。")
    private String password;

    @ApiModelProperty(name = "sex", value = "性别，男：male，女：female。")
    private String sex;

    @ApiModelProperty(name = "createDate", value = "创建日期，使用2018-01-09T13:39:55格式的字符串。")
    private String createDate;
}
