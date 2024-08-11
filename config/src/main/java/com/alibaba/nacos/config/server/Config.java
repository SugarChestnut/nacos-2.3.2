/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.alibaba.nacos.config.server;

import com.alibaba.nacos.sys.env.Constants;
import com.alibaba.nacos.sys.env.EnvUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Config main.
 *
 * @author Nacos
 */
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.alibaba.nacos.config.server", "com.alibaba.nacos.core"})
public class Config {
    
    public static void main(String[] args) {
        System.setProperty(Constants.STANDALONE_MODE_PROPERTY_NAME, Boolean.toString(Boolean.TRUE));
        System.setProperty(EnvUtil.NACOS_HOME_KEY, "E:\\Java\\nacos-2.3.2");

        SpringApplication.run(Config.class, args);
    }
}
