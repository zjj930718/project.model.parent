package com.info.dubbo;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import com.info.component.JdbcTemplatePool;
import com.info.entity.DataSourceInfo;
import com.info.entity.InterfaceRelation;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shuzheng on 2019/9/21.
 */
public class InterfaceGenericService implements GenericService{

    private InterfaceRelation interfaceRelation;

    public InterfaceGenericService(InterfaceRelation interfaceRelation) {
        this.interfaceRelation = interfaceRelation;
    }

    @Override
    public Object $invoke(String method, String[] parameterTypes, Object[] objects) throws GenericException {
        Map<String,Object> map = new HashMap<>();
        map.put(parameterTypes[0],objects[0]);
        return getData(interfaceRelation.getRunSql(),map);
    }



    public List<Map<String,Object>> getData(String sql,Map<String,Object> map){

        DataSourceInfo dataSourceInfo = new DataSourceInfo();
        dataSourceInfo.setSourceType("mysql");
        dataSourceInfo.setSourceIp("192.168.40.14");
        dataSourceInfo.setSourcePort(3306);
        dataSourceInfo.setSourceSchema("test_db");
        dataSourceInfo.setSourceUser("root");
        dataSourceInfo.setSourcePassword("123456");

        DruidDataSource t = JdbcTemplatePool.createDataSource(dataSourceInfo);
        List<Map<String,Object>> list = new ArrayList<>();
        try {
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = JdbcTemplatePool.createJdbcTemplate(t);
            list = namedParameterJdbcTemplate.queryForList(sql,map);
        }catch (Exception e){

        }finally {
            t.close();
        }
        return list;
    }

    public InterfaceRelation getInterfaceRelation() {
        return interfaceRelation;
    }

    public void setInterfaceRelation(InterfaceRelation interfaceRelation) {
        this.interfaceRelation = interfaceRelation;
    }
}
