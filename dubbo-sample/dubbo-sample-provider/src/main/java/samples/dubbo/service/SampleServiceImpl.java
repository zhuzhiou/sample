package samples.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import samples.dubbo.vo.SampleVo;

@Service(version = "1.0", timeout = 10000)
public class SampleServiceImpl implements SampleService {

    @Override
    public void sampleMethod(SampleVo sampleVo) {
        System.out.println(sampleVo);
    }
}
