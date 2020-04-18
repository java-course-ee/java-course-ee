package edu.javacourse.testcontainers;

import org.junit.ClassRule;
import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostgresContainerExample {

    @ClassRule
    public static PostgreSQLContainer postgreSQLContainer = (PostgreSQLContainer) new PostgreSQLContainer("postgres:12.2")
            .withDatabaseName("testdb")
            .withUsername("sa")
            .withPassword("sa")
            .withInitScript("db.sql");

    @Test
    public void test() {
        try (
                Connection connection = DriverManager.getConnection(postgreSQLContainer.getJdbcUrl(), postgreSQLContainer.getUsername(), postgreSQLContainer.getPassword());
                PreparedStatement statement = connection.prepareStatement("SELECT id, name, birth FROM users");
                ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                System.out.println("Found user id: " + resultSet.getInt("id") + ", name: " + resultSet.getString("name") + ", birth: " + resultSet.getDate("birth"));
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
