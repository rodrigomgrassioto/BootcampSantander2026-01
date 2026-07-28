package com.devrodrigo.persistence;

import com.devrodrigo.persistence.entity.ContactEntity;
import com.devrodrigo.persistence.entity.EmployeeEntity;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class ContactDAO {
    public void insert(final ContactEntity entity){
        final String sql = "INSERT INTO contacts (description, type, employee_id) VALUES (?, ?, ?)";
        try(
            var connection = ConnectUtil.getConnection();
            var statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            // inserindo as variáveis
            statement.setString(1, entity.getDescription());
            statement.setString(2, entity.getType());
            statement.setLong(3, entity.getEmployee().getId() );

            statement.executeUpdate();

            // Recupera o ID gerado pelo auto_increment de forma elegante e segura
            try (var generatedKeys = statement.getGeneratedKeys()) {
                System.out.println(generatedKeys);
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getLong(1));
                }
            }

        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }
}
