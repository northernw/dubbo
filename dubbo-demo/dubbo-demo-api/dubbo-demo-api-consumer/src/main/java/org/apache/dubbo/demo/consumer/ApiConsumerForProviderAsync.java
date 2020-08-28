package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.demo.HelloServiceAsync;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;

/**
 * @author wangyuanqing1
 * 2020-08-26
 */
public class ApiConsumerForProviderAsync {
    public static void main(String[] args) throws InterruptedException {
        ReferenceConfig<HelloServiceAsync> reference = new ReferenceConfig<>();
        reference.setInterface(HelloServiceAsync.class);

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("dubbo-demo-api-myconsumer"))
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .reference(reference)
                .start();

        HelloServiceAsync demoService = reference.get();
        RpcContext.getContext().setAttachment("company", "alibaba");
        CompletableFuture<String> future = demoService.sayHello("world");
        future.whenComplete((v, t) -> {
            if (t != null) {
                t.printStackTrace();
            } else {
                System.out.println(v);
            }
        });
        Thread.currentThread().join();
    }
}
