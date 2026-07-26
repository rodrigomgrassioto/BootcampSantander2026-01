package com.devrodrigo.persistence;

import com.devrodrigo.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class EmployeeDAO {
    public void insert(final EmployeeEntity entity){
        // Pesquisa pessoal, usando o PreparedStatement para melhorar a concatenação
        final String sql = "INSERT INTO employees (name, salary, birthday) VALUES (?, ?, ?)";
        try(
            var connection = ConnectUtil.getConnection();
//            var statement = connection.createStatement()
            var statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
//            var sql = "INSERT INTO employees (name, salary, birthday) values ('"+
//                    entity.getName() + "', " +
//                    entity.getSalary().toString() + ", "+
//                    "'" + formatOffsetDateTime(entity.getBirthday()) + "')";

            // inserindo as variáveis
            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setObject(3, entity.getBirthday());

            statement.executeUpdate();
//            System.out.printf("Foram afetados %s, no banco de dados", statement.getUpdateCount());

            if (statement instanceof StatementImpl impl)
                entity.setId(impl.getLastInsertID());

        } catch (SQLException exception){
            exception.printStackTrace();
        }

    }
    public void update(final EmployeeEntity entity){

    }
    public void delete(final long id){

    }

    public List<EmployeeEntity> findAll (){
        return null;
    }

    public EmployeeEntity findById(final long id){
        return  null;
    }

    private String formatOffsetDateTime(final OffsetDateTime dateTime){
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
