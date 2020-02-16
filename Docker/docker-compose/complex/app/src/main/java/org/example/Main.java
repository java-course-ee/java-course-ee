package org.example;

import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Started to listen telnet connections on port 8080");

        while (true) {
            final Socket accept = serverSocket.accept();

            final Connection connection = DriverManager.getConnection("jdbc:postgresql://db:5432/demo", "postgres", "postgres");
            final Statement statement = connection.createStatement();
            final ResultSet resultSet = statement.executeQuery("SELECT model, range FROM bookings.aircrafts");

            StringBuilder sb = new StringBuilder();
            while (resultSet.next()) {
                sb.append(resultSet.getString("model"));
                sb.append(";");
                sb.append(resultSet.getInt("range"));
                sb.append("\r\n");
            }

            resultSet.close();
            statement.close();
            connection.close();

            OutputStreamWriter writer = new OutputStreamWriter(accept.getOutputStream());
            writer.write(sb.toString());
            writer.flush();
            accept.close();
        }
    }

}