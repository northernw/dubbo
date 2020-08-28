package org.apache.dubbo.demo;

/**
 * @author wangyuanqing1
 * 2020-08-26
 */
public class PoJo {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PoJo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
