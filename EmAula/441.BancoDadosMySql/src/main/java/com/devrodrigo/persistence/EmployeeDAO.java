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

            // pegar o id assim, só funciona no MYSQL se migrar para outro banco, vai quebrar
//            if (statement instanceof StatementImpl impl)
//                entity.setId(impl.getLastInsertID());

            // Recupera o ID gerado pelo auto_increment de forma elegante e segura
            try (var generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getLong(1));
                }
            }

        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }

    public void insertBatch(final List<EmployeeEntity> entities){
        // Pesquisa pessoal, usando o PreparedStatement para melhorar a concatenação

        try (var connection = ConnectUtil.getConnection()) {
            final String sql = "INSERT INTO employees (name, salary, birthday) VALUES (?, ?, ?)";

            try(
                    var statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
            ) {
                connection.setAutoCommit(false);
                // inserindo as variáveis
                for (final var entity : entities){
                    statement.setString(1, entity.getName());
                    statement.setBigDecimal(2, entity.getSalary());
//                    final var timesTamp = Timestamp.valueOf(entity.getBirthday().atZoneSimilarLocal(UTC).toLocalDateTime());
                    // Converte os milissegundos exatos do UTC diretamente para o Timestamp
//                    final var timesTamp = Timestamp.from(entity.getBirthday().toInstant());
//                    statement.setObject(3, entity.getBirthday().toLocalDateTime());
                    statement.setObject(3, entity.getBirthday());


//                    statement.setObject(3, timesTamp);

                    statement.addBatch();
                }
                statement.executeBatch();
                connection.commit();

            } catch (SQLException exception){
                connection.rollback();
                exception.printStackTrace();
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    public void update(final EmployeeEntity entity){
        // Pesquisa pessoal, usando o PreparedStatement para melhorar a concatenação
        final String sql = "UPDATE employees set name = ?, salary = ?, birthday = ? WHERE id = ?";
        try(
                var connection = ConnectUtil.getConnection();
//            var statement = connection.createStatement()
                var statement = connection.prepareStatement(sql)
        ) {
            // inserindo as variáveis
            statement.setString(1, entity.getName());
            statement.setBigDecimal(2, entity.getSalary());
            statement.setObject(3, entity.getBirthday());
            statement.setLong(4, entity.getId());

            statement.executeUpdate();
//            System.out.printf("Foram afetados %s, no banco de dados", statement.getUpdateCount());

        } catch (SQLException exception){
            exception.printStackTrace();
        }
    }
    public void delete(final long id){
        // Pesquisa pessoal, usando o PreparedStatement para melhorar a concatenação
        final String sql = "DELETE FROM employees WHERE id = ?";
        try(
                var connection = ConnectUtil.getConnection();
//            var statement = connection.createStatement()
                var statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            // inserindo as variáveis
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException exception){
            exception.printStackTrace();
        }
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
        final String sql = "SELECT e.id as employee_id, " +
                "e.name, e.salary, e.birthday, c.id as contact_id, " +
                "c.description, c.type FROM employees e LEFT JOIN contacts c ON c.employee_id = e.id WHERE e.id = ?";
        try(
                var connection = ConnectUtil.getConnection();

                var statement = connection.prepareStatement(sql)
        ) {
            // setar variável
            statement.setLong(1, id);
            statement.executeQuery();
            final var resultSet = statement.getResultSet();
            if (resultSet.next()){
                entity.setId(resultSet.getLong("employee_id"));
                entity.setName(resultSet.getString("name"));
                entity.setSalary(resultSet.getBigDecimal("salary"));
                final var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                entity.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
                entity.setContact(new ContactEntity());
                entity.getContact().setId(resultSet.getLong("contact_id"));
                entity.getContact().setDescription(resultSet.getString("description"));
                entity.getContact().setType(resultSet.getString("type"));
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
