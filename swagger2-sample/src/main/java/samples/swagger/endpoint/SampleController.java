package samples.swagger.endpoint;

import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import samples.swagger.vo.ErrorVo;
import samples.swagger.vo.SampleVo;
import springfox.documentation.annotations.ApiIgnore;

import java.net.URI;
import java.util.Collections;

@Api(value = "示例接口", description = "在XML中配置Swagger2", protocols = "http")
@RequestMapping("/sample")
@RestController
public class SampleController {

    @ApiOperation(value = "查询接口", notes = "GET示例")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "query")
    })
    @GetMapping(path = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<SampleVo> sampleGet(@ApiIgnore Pageable pageable, @ApiIgnore SampleVo sampleVo) {
        return new PageImpl<>(Collections.emptyList(), pageable, 0);
    }

    @ApiOperation(value = "创建接口", notes = "POST示例", code = 201, response = SampleVo.class, responseHeaders = { @ResponseHeader(name = "Location", description = "URL")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名字", required = true, paramType = "body"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "body"),
            @ApiImplicitParam(name = "sex", value = "性别，男：male，女：female", required = true, paramType = "body")
    })
    @ApiResponses({
            @ApiResponse(code = 201, message = "创建成功", responseHeaders = @ResponseHeader(name = "Location", response = URI.class)),
            @ApiResponse(code = 401, message = "无权访问", response = ErrorVo.class),
            @ApiResponse(code = 403, message = "认证失败", response = ErrorVo.class)
    })
    @PostMapping(path = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Resource<SampleVo> addUser(@ApiIgnore  SampleVo sampleVo) {
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
        UriComponents uriComponents = builder.build();
        return null;//ResponseEntity.created(uriComponents.toUri()).body(sampleVo);
    }
}
