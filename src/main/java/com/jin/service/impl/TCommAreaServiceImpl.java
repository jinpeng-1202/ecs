package com.jin.service.impl;

import com.jin.base.BaseServiceImpl;
import com.jin.model.TCommArea;
import com.jin.service.TCommAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TCommAreaServiceImpl extends BaseServiceImpl<TCommArea> implements TCommAreaService {

    @Autowired
    private TDataDictServiceImpl dataDictService;

    public synchronized void com1() {
        System.out.println(" 进入 TCommAreaServiceImpl  ");
        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dataDictService.data();

    }
}
