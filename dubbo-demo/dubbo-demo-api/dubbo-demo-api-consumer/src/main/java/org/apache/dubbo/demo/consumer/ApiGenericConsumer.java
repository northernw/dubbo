package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.bootstrap.DubboBootstrap;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.GenericService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyuanqing1
 * 2020-08-26
 */
public class ApiGenericConsumer {
    public static void main(String[] args) {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setInterface("org.apache.dubbo.demo.HelloService");
        reference.setGeneric(true);

        DubboBootstrap bootstrap = DubboBootstrap.getInstance();
        bootstrap.application(new ApplicationConfig("dubbo-demo-api-myconsumer"))
                .registry(new RegistryConfig("zookeeper://127.0.0.1:2181"))
                .reference(reference)
                .start();

        GenericService genericService = reference.get();
        RpcContext.getContext().setAttachment("company", "alibaba");
        Object message = genericService.$invoke("sayHello", new String[]{"java.lang.String"}, new Object[]{"world"});
        System.out.println(message);

        Map<String, Object> map = new HashMap<>();
        map.put("class", "org.apache.dubbo.demo.PoJo");
        map.put("id", "1990");
        map.put("name", "jiaduo");
        message = genericService.$invoke("testGeneric", new String[]{"org.apache.dubbo.demo.PoJo"}, new Object[]{map});
        System.out.println(message);
    }
}
