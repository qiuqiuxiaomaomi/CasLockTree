package com.bonaparte.service;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yangmingquan on 2018/10/4.
 */
@Service
public class BlockingQueueService {
    ConcurrentLinkedDeque<Integer> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();

    public void blockQueueCheck(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new ProducerExt());
        executorService.submit(new ConsumerExt());
    }

    public ConcurrentLinkedDeque getConcurrentLinkedQueue(){
        return concurrentLinkedDeque;
    }

    public class ConsumerExt implements Runnable {
        @Override
        public void run() {
            Integer year = new Date().getYear();
            concurrentLinkedDeque.add(year);
        }
    }

    public class ProducerExt implements Runnable{
        @Override
        public void run() {
            concurrentLinkedDeque.remove();
            //concurrentLinkedDeque.poll();
        }
    }
}
