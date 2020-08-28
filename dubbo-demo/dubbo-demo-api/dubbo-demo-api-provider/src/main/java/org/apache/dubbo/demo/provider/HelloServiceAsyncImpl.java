package org.apache.dubbo.demo.provider;

import org.apache.dubbo.common.utils.NamedThreadFactory;
import org.apache.dubbo.demo.HelloServiceAsync;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wangyuanqing1
 * 2020-08-26
 */
public class HelloServiceAsyncImpl implements HelloServiceAsync {
    private final ThreadPoolExecutor bizThreadPool = new ThreadPoolExecutor(
            8,
            16,
            1,
            TimeUnit.MINUTES,
            new SynchronousQueue<>(),
            new NamedThreadFactory("biz-thread-pool"),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    @Override
    public CompletableFuture<String> sayHello(String name) {
        RpcContext context = RpcContext.getContext();
        // 由业务线程来处理
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("async return");
            return "Hello " + name + " " + context.getAttachment("company");
        }, bizThreadPool);
    }
}
