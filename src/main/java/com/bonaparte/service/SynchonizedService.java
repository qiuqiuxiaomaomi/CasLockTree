package com.bonaparte.service;

import org.springframework.stereotype.Service;

/**
 * Created by yangmingquan on 2018/10/3.
 */
@Service
public class SynchonizedService {

    public void chargeMoney(Integer uid){
        synchronized (this){
            // 业务
        }
    }

    public synchronized void chargeMoneyFun(Integer uid){
        // 业务
    }
}
