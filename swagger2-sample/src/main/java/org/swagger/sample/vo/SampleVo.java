package org.swagger.sample.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "示例")
@lombok.Data
public class SampleVo implements Serializable {

    @ApiModelProperty(name = "field1", value = "字段一")
    private String field1;

    @ApiModelProperty(name = "field2", value = "字段二")
    private String field2;

    @ApiModelProperty(name = "field3", value = "字段三")
    private String field3;

    @ApiModelProperty(name = "field4", value = "字段四")
    private String field4;
}
