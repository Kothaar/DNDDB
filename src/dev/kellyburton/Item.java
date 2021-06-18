package dev.kellyburton;

import java.sql.*;

public class Item {
    private int id;
    private String name;
    private int cost;
    private int weight;

    Item(int id, String name, int cost, int weight) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.weight = weight;

    }

    Item(int id){
        this.id = id;
        try {
            db_get();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void db_get() throws SQLException {
        String jdbcURL = "jdbc:postgresql://localhost:8877/DND";
        String username = "postgres";
        String password = "test";
        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
        Statement statement = connection.createStatement();
        System.out.println("\nConnected to PostgreSQL");
        String query1 = String.format("SELECT id, name, cost, weight FROM public.weapon WHERE id = %d;", this.id);
        ResultSet result = statement.executeQuery(query1);
        while(result.next()) {
            this.name = result.getString("name");
            this.cost = result.getInt("cost");
            this.weight = result.getInt("weight");
        }
        connection.close();
    }

    public void display(){
        System.out.printf("%d %s %d %d", this.id, this.name, this.cost, this.weight);
    }

}
