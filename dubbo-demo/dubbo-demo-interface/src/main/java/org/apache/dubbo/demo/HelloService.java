package org.apache.dubbo.demo;

/**
 * 同步调用
 * @author wangyuanqing1
 * 2020-08-26
 */
public interface HelloService {

    String sayHello(String name);

    Result<String> testGeneric(PoJo poJo);
}
