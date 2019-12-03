package com.manager.crm.services;

import com.manager.base.BaseService;
import com.manager.crm.db.dao.CustomerServeMapper;
import com.manager.crm.po.CustomerServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServeService  extends BaseService<CustomerServe,Integer> {


    @Autowired
    private CustomerServeMapper customerServeMapper;

    public void saveCustomerServe(){

    }

    public void updateCustomerServe(){

    }
    public void deleteCustomerServe(){

    }

    public Map<String, Object> countServeTypeParams() {

        List<Map<String, Object>> list = customerServeMapper.countServeTypeParams();
        //如果list集合不为空
        Map<String,Object> result = new HashMap<String,Object>();
        List<Object> objects = new ArrayList<>();
        if (!(CollectionUtils.isEmpty(list))){
            for (Map<String, Object> map : list) {
                objects.add(map.get("name").toString());
            }
            result.put("data1",list);
            result.put("data2",objects);
        }
        return result;
    }


}
