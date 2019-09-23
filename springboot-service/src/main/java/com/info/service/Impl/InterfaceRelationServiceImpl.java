package com.info.service.Impl;

import com.info.dao.mapper.InterfaceRelationMapper;
import com.info.dubbo.DubboUtil;
import com.info.dubbo.InterfaceGenericService;
import com.info.entity.InterfaceRelation;
import com.info.service.InterfaceRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zjj on 2019/9/22.
 */
@Service
public class InterfaceRelationServiceImpl implements InterfaceRelationService {

    @Autowired
    InterfaceRelationMapper interfaceRelationMapper;
    @Autowired
    DubboUtil dubboUtil;


    @Override
    public int create(InterfaceRelation interfaceRelation) {
        interfaceRelationMapper.insertSelective(interfaceRelation);
        dubboUtil.export(new InterfaceGenericService(interfaceRelation));
        return 1;
    }
}
