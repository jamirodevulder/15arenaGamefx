package sample.Gear;

import sample.Gear.Item;

public class Weapon extends Item {
    private int Strength;
    private int Accuracy;


    public Weapon(int strength, int accuracy)
    {

    }

    public void setAccuracy(int accuracy) {
        Accuracy = accuracy;
    }

    public int getAccuracy() {
        return Accuracy;
    }
}
