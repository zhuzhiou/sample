package org.swagger.sample.endpoint;

import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.swagger.sample.vo.ErrorVo;
import org.swagger.sample.vo.SampleVo;

import java.util.Collections;

@Api(value = "用户相关接口", description = "在XML中配置Swagger2", protocols = "http")
@RequestMapping("/users")
@RestController
public class SampleController {

    @ApiOperation(value = "查询接口", notes = "GET示例")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "query")
    })
    @GetMapping(path = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<SampleVo> getUsers(@PageableDefault(sort = "username") Pageable pageable, SampleVo sampleVo) {
        return new PageImpl<>(Collections.emptyList(), pageable, 0);
    }

    @ApiOperation(value = "创建接口", notes = "POST示例", code = 201, response = SampleVo.class, responseHeaders = { @ResponseHeader(name = "Location", description = "URL")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名字", required = true, paramType = "body")
    })
    @ApiResponses({
            @ApiResponse(code = 201, message = "创建成功", response = SampleVo.class),
            @ApiResponse(code = 401, message = "无权访问", response = ErrorVo.class),
            @ApiResponse(code = 403, message = "认证失败", response = ErrorVo.class)
    })
    @PostMapping(path = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUser(SampleVo sampleVo) {
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
        UriComponents uriComponents = builder.build();
        return ResponseEntity.created(uriComponents.toUri()).body(sampleVo);
    }
}
