package dev.kellyburton;
import java.sql.*;
import java.util.Random;

public class Weapon extends Item{
    private int num_dice;
    private int dice_type;
    private String damage_type;


    Weapon(int id, String name, int cost, int weight, int num_dice, int dice_type, String damage_type) {
        super(id, name, cost, weight);
        this.num_dice = num_dice;
        this.dice_type = dice_type;
        this.damage_type = damage_type;
    }

    Weapon(int id) throws SQLException {
        super(id);
        db_get(id);
    }

    private void db_get(int id) throws SQLException {
        String jdbcURL = "jdbc:postgresql://localhost:8877/DND";
        String username = "postgres";
        String password = "test";
        Connection connection = DriverManager.getConnection(jdbcURL, username, password);
        Statement statement = connection.createStatement();
        System.out.println("Connected to PostgreSQL");
        String query1 = String.format(  "SELECT number_dice, dice_type, damage_type " +
                                        "FROM public.weapon " +
                                        "WHERE id = %d;", id);
        ResultSet result = statement.executeQuery(query1);
        while(result.next()) {
            this.num_dice = result.getInt("number_dice");
            this.dice_type = result.getInt("dice_type");
            this.damage_type = result.getString("damage_type");
        }
        connection.close();
    }

    @Override
    public void display() {
        super.display();
        System.out.printf(" %dD%d %s", this.num_dice, this.dice_type, this.damage_type);
    }


    public int damage() {
        Random r = new Random();
        return r.nextInt(6)+1;

    }

}
