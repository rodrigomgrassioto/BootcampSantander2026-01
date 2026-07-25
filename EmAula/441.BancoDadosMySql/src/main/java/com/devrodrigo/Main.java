package com.devrodrigo;

import com.devrodrigo.persistence.ConnectUtil;

import java.io.Console;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args){
        try(var connection = ConnectUtil.getConnection()){
            System.out.println("Conectou");
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
