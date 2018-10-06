package com.bonaparte.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by yangmingquan on 2018/10/4.
 */
@Service
public class ReadWriteLockService {
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public double chargeMoney = 0;

    public void setChargeMoney(double chargeMoney){
        readWriteLock.writeLock().lock();
        this.chargeMoney = chargeMoney;
        readWriteLock.writeLock().unlock();
    }

    public double getChargeMoney(double chargeMoney){
        readWriteLock.readLock().lock();
        double chargeMoneyTemp = chargeMoney;
        readWriteLock.readLock().unlock();
        return chargeMoney;
    }
}
