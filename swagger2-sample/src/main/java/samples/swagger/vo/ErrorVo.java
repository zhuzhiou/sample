package samples.swagger.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
@lombok.Data
public class ErrorVo {

    @ApiModelProperty(name = "errno", value = "错误编码")
    private int errno;

    @ApiModelProperty(name = "errmsg", value = "错误描述")
    private String errmsg;
}
