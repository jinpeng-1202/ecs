package com.jin.service.impl;

import com.jin.base.BaseServiceImpl;
import com.jin.model.TDataDict;
import com.jin.service.TDataDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TDataDictServiceImpl extends BaseServiceImpl<TDataDict> implements TDataDictService {

    public void saveDict() throws Exception {
        TDataDict dataDict = new TDataDict();
        dataDict.setType("test444444444");
        dataDict.setName("name4444444444");
        saveOrUpdate(dataDict);

        test();

        throw new Exception("error!!!!!!!!!!!!!!");
    }

    public void test() throws Exception {

        TDataDict dataDict = new TDataDict();
        dataDict.setType("a4444444");
        dataDict.setName("b44444444444444");
        saveOrUpdate(dataDict);

        //saveDict();

        throw new Exception("error!!!!!!!!!!!!!!");
    }

    @Autowired
    private TCommAreaServiceImpl commAreaService;

    public synchronized void data() {
        System.out.println("进入 TDataDictServiceImpl");
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        commAreaService.com1();
    }
}
