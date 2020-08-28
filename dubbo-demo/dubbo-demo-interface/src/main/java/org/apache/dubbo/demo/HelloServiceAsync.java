package org.apache.dubbo.demo;

import java.util.concurrent.CompletableFuture;

/**
 * 异步调用
 *
 * @author wangyuanqing1
 * 2020-08-26
 */
public interface HelloServiceAsync {

    CompletableFuture<String> sayHello(String name);
}
