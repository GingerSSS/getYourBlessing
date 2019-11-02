package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRepository repository;

    /* Get luckymoney receive list */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list() {
        return repository.findAll();
    }

    /* Create new luckymoney bag */
    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money")BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return repository.save(luckymoney);
    }

    /* Query luckymoney by id */
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(null);
    }

    /* update luckymoney (get luckymoney from list) */
    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer){

        Optional<Luckymoney> optional = repository.findById(id);
        
        if(optional.isPresent()){
            Luckymoney luckymoney = optional.get();
            luckymoney.setId(id);
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }
            return null;
    }
}
