package samples.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import samples.dubbo.service.SampleService;
import samples.dubbo.vo.SampleVo;

@RestController
public class SampleController {

    @Reference(version = "1.0", cluster = "failover")
    private SampleService sampleService;

    @PostMapping(path = "/sample")
    public ResponseEntity<?> doGet(@RequestBody SampleVo sampleVo) {
        sampleService.sampleMethod(sampleVo);
        return ResponseEntity.ok("ok");
    }
}
