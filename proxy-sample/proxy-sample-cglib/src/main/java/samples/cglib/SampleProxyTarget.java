package samples.cglib;

public class SampleProxyTarget {

    public void sampleMethod() {
        System.out.println("sampleMethod");
    }

    /**
     * 测试，代理SampleObject
     * @param args
     */
    public static void main(String[] args) {
        SampleInterceptor interceptor = new SampleInterceptor();
        SampleProxyTarget sampleProxyTarget = (SampleProxyTarget) interceptor.getProxy(SampleProxyTarget.class);
        sampleProxyTarget.sampleMethod();
    }
}
