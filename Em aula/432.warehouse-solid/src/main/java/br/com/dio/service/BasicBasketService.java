package br.com.dio.service;

import br.com.dio.BasicBasket;
import br.com.dio.Box;
import br.com.dio.dao.BasicBasketDAO;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

public class BasicBasketService {

    private final BasicBasketDAO dao;
    private final MoneyService moneyService;

    public BasicBasketService(BasicBasketDAO dao, MoneyService moneyService) {
        this.dao = dao;
        this.moneyService = moneyService;
    }

    public List<BasicBasket> receive(final Box box){
        var unitPrice = box.unitPrice();
        var finalPrice = unitPrice.add(unitPrice.multiply(new BigDecimal("0.20")));
        var baskets = Stream.generate(()-> new BasicBasket(box.validate(), finalPrice))
                .limit(box.amount())
                .toList();
        return dao.addBatch(baskets);
    }

    public BigDecimal sold(final int amount){
        var toSold = dao.remove(amount);
        // incrementa valor das sextas para adicionar total no caixa
        var total = toSold.stream().map(BasicBasket::price).reduce(BigDecimal.ZERO, BigDecimal::add);
        moneyService.add(total);
//        return toSold;
        return total;
    }
}
