package org.apache.dubbo.demo;

/**
 * AsyncContext实现异步执行
 *
 * @author wangyuanqing1
 * 2020-08-26
 */
public interface HelloServiceRpcContext {

    String sayHello(String name);
}
