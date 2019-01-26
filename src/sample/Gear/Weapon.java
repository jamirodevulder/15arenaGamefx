package sample.Gear;

import sample.Gear.Item;

public class Weapon extends Item {
    private int Strength = 0;
    private int Accuracy;


    public Weapon(int strength, int accuracy)
    {

        Strength = strength;
        Accuracy = accuracy;
    }

    public void setStrength(int strength) {
        Strength = strength;
    }

    public void setAccuracy(int accuracy) {
        Accuracy = accuracy;
    }

    public int getAccuracy() {
        return Accuracy;
    }

    public int getStrength() {
        return Strength;
    }
}
