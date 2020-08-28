package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.demo.HelloService;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author wangyuanqing1
 * 2020-08-26
 */
public class ApiAsyncConsumer {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ReferenceConfig<HelloService> reference = new ReferenceConfig<>();
        reference.setInterface(HelloService.class);
        reference.setAsync(true);

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("dubbo-demo-api-myconsumer"))
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .reference(reference)
                .start();

        HelloService demoService = reference.get();
        RpcContext.getContext().setAttachment("company", "alibaba");
        String message = demoService.sayHello("world");
        System.out.println(message);

        Future<String> future = RpcContext.getContext().getFuture();
        System.out.println(future.get());
    }
}
