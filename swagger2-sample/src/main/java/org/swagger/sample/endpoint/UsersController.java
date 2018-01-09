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
import org.swagger.sample.vo.UserVo;

import java.util.Collections;

@Api(value = "用户相关接口", description = "在XML中配置Swagger2", protocols = "http")
@RequestMapping("/users")
@RestController
public class UsersController {

    @ApiOperation(value = "用户列表", notes = "查询用户列表，支持byExample查询。")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "页码", required = true, paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页记录数", required = true, paramType = "query")
    })
    @GetMapping(path = "", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<UserVo> getUsers(@PageableDefault(sort = "username") Pageable pageable, UserVo userVo) {
        return new PageImpl<>(Collections.emptyList(), pageable, 0);
    }

    @ApiOperation(value = "创建用户", notes = "成功返回201状态码。")
    //@ApiImplicitParam(name = "user", value = "用户信息", paramType = "body", dataTypeClass = User.class)
    @ApiResponse(code = 201, message = "创建成功", response = UserVo.class)
    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addUser(UserVo userVo) {
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequestUri();
        UriComponents uriComponents = builder.build();
        return ResponseEntity.created(uriComponents.toUri()).body(userVo);
    }
}
