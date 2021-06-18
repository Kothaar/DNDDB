package dev.kellyburton;

public class Item {
    private int id;
    private String name;
    private int cost;
    private int weight;

    Item(int id, String name, int cost, int weight){
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.weight = weight;

    }
    public void display(){
        System.out.printf("%d %s %d %d", this.id, this.name, this.cost, this.weight);

    }
}
