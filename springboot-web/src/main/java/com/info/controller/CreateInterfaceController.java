package com.info.controller;

import com.info.ResponseMsg;
import com.info.entity.InterfaceRelation;
import com.info.service.InterfaceRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zjj on 2019/9/22.
 */
@RestController
@RequestMapping("/interface")
public class CreateInterfaceController {


    @Autowired
    InterfaceRelationService interfaceRelationService;

    @PostMapping("/create")
    public ResponseMsg create(InterfaceRelation interfaceRelation){
        return new ResponseMsg(interfaceRelationService.create(interfaceRelation));
    }
}
