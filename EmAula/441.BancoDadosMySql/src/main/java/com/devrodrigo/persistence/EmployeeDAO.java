package com.devrodrigo.persistence;

import com.devrodrigo.persistence.entity.EmployeeEntity;
import com.mysql.cj.jdbc.StatementImpl;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

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
        List<EmployeeEntity> entities = new ArrayList<>();

        // Pesquisa pessoal, usando o PreparedStatement para melhorar a concatenação
        final String sql = "SELECT * FROM employees ORDER BY name";
        try(
                var connection = ConnectUtil.getConnection();

                var statement = connection.prepareStatement(sql)
        ) {
            statement.executeQuery();
            final var resultSet = statement.getResultSet();
            while (resultSet.next()){
                final var entity = new EmployeeEntity();
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                final var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
                entities.add(entity);
            }
//            System.out.printf("Foram afetados %s, no banco de dados", statement.getUpdateCount());
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        return entities;
    }

    public EmployeeEntity findById(final long id){
        final var entity = new EmployeeEntity();

        // Pesquisa pessoal, usando o PreparedStatement para melhorar a concatenação
        final String sql = "SELECT * FROM employees WHERE ID = ?";
        try(
                var connection = ConnectUtil.getConnection();

                var statement = connection.prepareStatement(sql)
        ) {
            // setar variável
            statement.setLong(1, id);
            statement.executeQuery();
            final var resultSet = statement.getResultSet();
            if (resultSet.next()){
                entity.setId(resultSet.getLong("id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                final var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
            }
//            System.out.printf("Foram afetados %s, no banco de dados", statement.getUpdateCount());
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        return entity;    }

    private String formatOffsetDateTime(final OffsetDateTime dateTime){
        final var utcDateTime = dateTime.withOffsetSameInstant(UTC);
        return utcDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
