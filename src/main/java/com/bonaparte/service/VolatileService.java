package com.bonaparte.service;

import org.springframework.stereotype.Service;

/**
 * Created by yangmingquan on 2018/10/3.
 */
@Service
public class VolatileService {
    public volatile double chargeMoney;

    public void checkCharge(Integer uid){
        // 获取chargeMoney
        chargeMoney = 0;
    }

    public double getChargeMoney(){
        return chargeMoney;
    }
}
