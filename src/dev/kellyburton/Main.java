package dev.kellyburton;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Arrays;
import java.util.Collections;


public class Main {

    public static void main(String[] args) {
        String[] p = {"versatile", "Test", "test3"};
        Weapon sword = new Weapon(1, "Longsword", 3, 4, 1,8, "Slicing" );
        sword.display();
        int[] rolls = new int[1000];
        int max = 0;
        for(int i = 0; i < 1000; i++){
            rolls[i] = sword.damage();
            if(rolls[i] >= max)
                max = rolls[i];
        }

        Weapon sword2 = new Weapon(1);
        sword2.display();

    }

    void gui_test() {
        String name = JOptionPane.showInputDialog("What is your name?");
        String message = String.format("Welcome, %s, to Java Programming!", name);


        //display the me
        JOptionPane.showMessageDialog(null, message);

        int x = Integer.parseInt(JOptionPane.showInputDialog("Input first number"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Input Second number"));
        String message1 = String.format("Welcome, %s, to Java Programming!", x + y);
        JOptionPane.showMessageDialog(null, message1);


    }

    static void insert() {

        try {
            String jdbcURL = "jdbc:postgresql://localhost:8877/DND";
            String username = "postgres";
            String password = "test";
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            System.out.println("Connected to PostgreSQL");

            String sql = "INSERT INTO public.weapon (id, name, cost, damage, damage_type, weight) "
                    + "VALUES (2, 'Axe', 10, '1d8', 'slashing', 4 )";

            int rows = statement.executeUpdate(sql);
            if (rows > 1) {
                System.out.println("A new weapon inserted");
            }
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error in connection to PostgresSQL server");
            e.printStackTrace();
        }

    }

    static void display() {

        String query1 = "SELECT * FROM public.weapon;";

        try {
            String jdbcURL = "jdbc:postgresql://localhost:8877/DND";
            String username = "postgres";
            String password = "test";

            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query1);

            System.out.print("id, name, cost, damage, damage_type, weight\n");

            while(result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                int cost = result.getInt("cost");
                String damage = result.getString("damage");
                String damage_type = result.getString("damage_type");
                int weight = result.getInt("weight");


                System.out.printf("%d %s %d %s %s %d\n", id, name, cost, damage, damage_type, weight);
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error in connection to PostgresSQL server");
            e.printStackTrace();
        }

    }
}
