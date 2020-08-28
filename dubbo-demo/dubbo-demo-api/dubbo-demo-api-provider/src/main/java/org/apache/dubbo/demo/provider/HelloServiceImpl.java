package org.apache.dubbo.demo.provider;

import com.alibaba.fastjson.JSON;
import org.apache.dubbo.demo.HelloService;
import org.apache.dubbo.demo.PoJo;
import org.apache.dubbo.demo.Result;
import org.apache.dubbo.rpc.RpcContext;

/**
 * @author wangyuanqing1
 * 2020-08-26
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello " + name + " " + RpcContext.getContext().getAttachment("company");
    }

    @Override
    public Result<String> testGeneric(PoJo poJo) {
        Result<String> result = new Result<>();
        result.setSuccess(true);
        result.setData(JSON.toJSONString(poJo));
        return result;
    }
}
