package br.com.dio.dao;

import br.com.dio.BasicBasket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BasicBasketDAO {
    private final List<BasicBasket> stock = new ArrayList<>();

    public List<BasicBasket> addBatch(final List<BasicBasket> baskets){
        stock.addAll(baskets);
        return baskets;
    }

    public List<BasicBasket> remove(final int amount){
        // ordenar lista por preço
        stock.sort(Comparator.comparing(BasicBasket::price));
        return stock.subList(0, amount);
    }
}
