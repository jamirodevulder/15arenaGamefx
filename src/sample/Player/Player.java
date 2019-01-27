package sample.Player;


import sample.Gear.Item;
import sample.Gear.Shield;
import sample.Gear.Weapon;
import sample.Gear.Armor;

public class Player {
    private String Name;
    private int Defence;
    private int Healt = 100;
    private int Attack;
    private int MaxWeight = 100;
    private Armor Gear = null;
    private Weapon Weapon = null;
    private Shield Shield = null;
    private boolean Dead = false;
    private boolean Rest = false;
    private boolean Waitfornextturn = false;


    public void setWaitfornextturn(boolean waitfornextturn) {
        Waitfornextturn = waitfornextturn;
    }
    public boolean getWaitfornextturn()
    {
        return Waitfornextturn;
    }

    public boolean getRest()
    {
        return Rest;
    }

    public void setRest(boolean rest) {
        Rest = rest;
    }

    public boolean getDead()
    {
        return Dead;
    }

    public void setDead(boolean dead) {
        Dead = dead;
    }

    public Player(String name, int attack)
    {
      Name = name;
      Attack = attack;
    }

    public int getHealt() {
        return Healt;
    }

    public void setHealt(int healt) {
        Healt = healt;
    }

    public Armor getArmor() { return Gear; }

    public void setArmor(Armor armor) { Gear = armor; }

    public void setMaxWeight(int maxWeight) {
        MaxWeight = maxWeight;
    }

    public Shield getShield() {
        return Shield;
    }

    public int getDefence() {
        return Defence;
    }

    public String getName() {
        return Name;
    }

    public void setWeapon(Weapon weapon) {
        Weapon = weapon;
    }

    public int getMaxWeight() {
        return MaxWeight;
    }

    public Weapon getWeapon() {
        return Weapon;
    }

    public int getAttack() {
        return Attack;
    }

    public void setShield(Shield shield) {
        Shield = shield;
    }

}
