package dev.kellyburton;
import java.util.Random;

public class Weapon extends Item{
    private int num_dice;
    private int dice_type;
    private String []properties;


    Weapon(int id, String name, int cost, int weight, int num_dice, int dice_type, String[] properties) {
        super(id, name, cost, weight);
        this.num_dice = num_dice;
        this.dice_type = dice_type;
        this.properties = properties;
    }

    @Override
    public void display() {
        super.display();
        System.out.printf(" %dD%d", this.num_dice, this.dice_type);
        for (String str: this.properties){
            System.out.printf(" %s", str);
        }
    }

    public int damage() {
        Random r = new Random();
        return r.nextInt(5)+1;

    }
}
