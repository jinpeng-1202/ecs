package com.jin.service.impl; 

import com.alibaba.fastjson.JSON;
import com.jin.base.BaseServiceImpl;
import com.jin.model.TApplyDetail;
import com.jin.service.TApplyDetailService;
import org.springframework.stereotype.Service;
@Service
public class TApplyDetailServiceImpl extends BaseServiceImpl<TApplyDetail>  implements TApplyDetailService {

    public void saveDetail(){
        TApplyDetail detail=new TApplyDetail();
        detail.setId(50L);
        detail=queryObj(detail);
        System.out.println(JSON.toJSON(detail));
    }
}
