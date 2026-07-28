package com.devrodrigo.persistence;

import com.devrodrigo.persistence.entity.EmployeeEntity;
import com.devrodrigo.persistence.entity.ModuleEntity;
import java.sql.SQLException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.ZoneOffset.UTC;

public class ModuleDAO {
    public List<ModuleEntity> findAll(){
        final List<ModuleEntity> entities = new ArrayList<>();
        final String sql = "SELECT " +
                    "m.id module_id, " +
                    "m.name module_name," +
                    "e.id employee_id, " +
                    "e.name employee_name, " +
                    "e.salary, " +
                    "e.birthday " +
                "FROM modules m " +
                "INNER JOIN accesses a " +
                    "ON a.module_id = m.id " +
                "INNER JOIN employees e " +
                    "ON e.id = a.employee_id " +
                "ORDER BY m.id";
        try(
                final var connection = ConnectUtil.getConnection();
                final var statement = connection.prepareStatement(sql)
        ) {
            statement.executeQuery();
            final var resultSet = statement.getResultSet();
            var hasNext = resultSet.next();
            while (hasNext){
                final ModuleEntity module = new ModuleEntity();
                module.setId(resultSet.getLong("module_id"));
                module.setName(resultSet.getString("module_name"));
                module.setEmployees(new ArrayList<>());
                do {
                    final var employee = new EmployeeEntity();
                    employee.setId(resultSet.getLong("employee_id"));
                    employee.setName(resultSet.getString("employee_name"));
                    employee.setSalary(resultSet.getBigDecimal("salary"));
                    final var birthdayInstant = resultSet.getTimestamp("birthday").toInstant();
                    employee.setBirthday(OffsetDateTime.ofInstant(birthdayInstant, UTC));
                    module.getEmployees().add(employee);
                    hasNext = resultSet.next();
                } while ((hasNext) && (module.getId() == resultSet.getLong("module_id")));
                entities.add(module);
            }
        } catch (final SQLException exception){
            exception.printStackTrace();
        }
        return entities;
    }
}
