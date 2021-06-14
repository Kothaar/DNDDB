package dev.kellyburton;
import javax.swing.JOptionPane;
import java.sql.*;


public class Main {

    public static void main(String[] args) {
        /*
        String name = JOptionPane.showInputDialog("What is your name?");
        String message = String.format("Welcome, %s, to Java Programming!", name);


        //display the me
        JOptionPane.showMessageDialog(null, message);

        int x = Integer.parseInt(JOptionPane.showInputDialog("Input first number"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Input Second number"));
        String message1 = String.format("Welcome, %s, to Java Programming!", x + y);
        JOptionPane.showMessageDialog(null, message1);

         */

        String jdbcURL = "jdbc:postgresql://localhost:8877/DND";
        String username = "postgres";
        String password = "test";

        String query1 = "SELECT * FROM public.weapon;";

        try {
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to PostgreSQL");

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query1);

            System.out.printf("id, name, cost, damage, damage_type, weight\n");
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

    void insert(Connection connection, Statement statement) {

        try {

            String sql = "INSERT INTO public.weapon (id, name, cost, damage, damage_type, weight) "
                    + "VALUES (2, 'Axe', 10, '1d8', 'slashing', 4 )";

            int rows = statement.executeUpdate(sql);
            if (rows > 1) {
                System.out.println("A new weapon inserted");
            }

        } catch (SQLException e) {
            System.out.println("Error in connection to PostgresSQL server");
            e.printStackTrace();
        }

    }
}
