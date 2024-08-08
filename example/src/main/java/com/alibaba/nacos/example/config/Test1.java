package com.alibaba.nacos.example.config;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

/**
 * @author rtt
 * @date 2024/8/6 14:57
 */
public class Test1 {

    public static void main(String[] args) throws NacosException, InterruptedException {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.SERVER_ADDR, "127.0.0.1:8848");
        properties.setProperty(PropertyKeyConst.USERNAME, "nacos");
        properties.setProperty(PropertyKeyConst.PASSWORD, "nacos");
        properties.setProperty(PropertyKeyConst.NAMESPACE, "eshop");
        properties.setProperty(PropertyKeyConst.SERVER_NAME, "product");
        properties.setProperty("tenant.id", "eshop");

        ConfigService configService = NacosFactory.createConfigService(properties);

        String content = configService.getConfig("product", "config", 5000);
        System.out.println("[config content] " + content);

        configService.addListener("product", "config", new AbstractListener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println(configInfo);
            }
        });

        Thread.sleep(300 * 1000);

        configService.shutDown();
    }
}
