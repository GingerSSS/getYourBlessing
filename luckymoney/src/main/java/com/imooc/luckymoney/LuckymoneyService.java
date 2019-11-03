package com.imooc.luckymoney;

import com.sun.javaws.progress.PreloaderPostEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository repository;

    public void createTwo() {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer("JingjieSheng");
        luckymoney.setMoney(new BigDecimal("520"));
        repository.save(luckymoney);

        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setProducer("JingjieSheng");
        luckymoney2.setMoney(new BigDecimal("1314"));
        repository.save(luckymoney2);
    }
}
