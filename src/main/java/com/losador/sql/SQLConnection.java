package com.losador.sql;

import java.sql.*;

public class SQLConnection {

    private Connection connection;
    private PreparedStatement preparedLoginStatement;
    private PreparedStatement preparedRegisterStatement;
    private Statement statement;

    public PreparedStatement getPreparedRegisterStatement() {
        return preparedRegisterStatement;
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }


    public PreparedStatement getPreparedLoginStatement() {
        return preparedLoginStatement;
    }

    public void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:login.db");
            statement = connection.createStatement();
            preparedLoginStatement = connection.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?;");
            preparedRegisterStatement = connection.prepareStatement("INSERT INTO users (login, password, email) VALUES (?, ?, ?);");
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Unable to connect");
        }
    }

    public void disconnect(){
        try {
            preparedLoginStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
