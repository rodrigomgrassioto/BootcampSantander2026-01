package com.devrodrigo;

import org.flywaydb.core.Flyway;

public class Main {
    static void main(){
        final var flyway = Flyway.configure()
                .dataSource("jdbc:mysql://localhost:3306/bcsantander_441aula","root","")
                .load();
        flyway.migrate();
    }
}