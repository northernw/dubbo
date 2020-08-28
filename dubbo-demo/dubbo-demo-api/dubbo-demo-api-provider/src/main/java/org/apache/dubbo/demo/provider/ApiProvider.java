package org.apache.dubbo.demo.provider;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.demo.HelloService;

/**
 * @author wangyuanqing1
 * 2020-08-26
 */
public class ApiProvider {
    public static void main(String[] args) {
        ServiceConfig<HelloService> service = new ServiceConfig<>();
        service.setInterface(HelloService.class);
        service.setRef(new HelloServiceImpl());
        service.setId("helloService");

//        ServiceConfig<HelloServiceAsync> service2 = new ServiceConfig<>();
//        service2.setInterface(HelloServiceAsync.class);
//        service2.setRef(new HelloServiceAsyncImpl());
//        service2.setId("helloServiceAsync");

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("dubbo-demo-api-myprovider"))
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .service(service)
//                .services(Lists.newArrayList(service2, service))
                .start()
                .await();
    }
}
