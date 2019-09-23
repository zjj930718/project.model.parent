package com.info.dubbo;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zjj on 2019/9/22.
 */
@Component
public class DubboUtil {

    private static final Logger logger = LoggerFactory.getLogger(DubboUtil.class);

    @Autowired
    RegistryConfig registryConfig;
    @Autowired
    ApplicationConfig applicationConfig;

    //dubbo通过API方式暴露接口服务
    public void export(InterfaceGenericService interfaceGenericService){
        ServiceConfig<InterfaceGenericService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setRef(interfaceGenericService);
        serviceConfig.setInterface(interfaceGenericService.getInterfaceRelation().getInterfaceCode());
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.export();
    }
}
