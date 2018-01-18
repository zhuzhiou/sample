package samples.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class SampleInterceptor implements MethodInterceptor {

    public Object getProxy(Class clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        String methodName = method.getName();
        if ("helloworld".equals(methodName)) {
            System.out.println(method.getName() + "执行之前做一些准备工作");
        }
        Object result = proxy.invokeSuper(object, args);
        if ("helloworld".equals(methodName)) {
            System.out.println(method.getName() + "执行之后做一些准备的工作");
        }
        return result;
    }
}
