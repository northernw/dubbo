package org.apache.dubbo.demo.provider;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.demo.HelloServiceAsync;

/**
 * @author wangyuanqing1
 * 2020-08-26
 */
public class ApiProviderForAsync {
    public static void main(String[] args) {
        ServiceConfig<HelloServiceAsync> service = new ServiceConfig<>();
        service.setInterface(HelloServiceAsync.class);
        service.setRef(new HelloServiceAsyncImpl());

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("dubbo-demo-api-myprovider"))
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .service(service)
                .start()
                .await();
    }
}
