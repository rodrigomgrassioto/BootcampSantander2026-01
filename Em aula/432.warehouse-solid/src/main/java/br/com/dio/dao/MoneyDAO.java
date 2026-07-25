package br.com.dio.dao;

import java.math.BigDecimal;

public class MoneyDAO {
    private BigDecimal money = BigDecimal.ZERO;

    public BigDecimal add(final BigDecimal value){
        this.money = this.money.add(value);
        return this.money;
    }
}
