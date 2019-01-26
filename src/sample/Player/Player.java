package sample.Player;


import sample.Gear.Item;

public class Player {
    private String Name;
    private int Defence;
    private int Healt = 100;
    private int Attack;
    private int MaxWeight = 100;
    private Item Armor = null;
    private Item Weapon = null;
    private Item Shield = null;

    public Player(String name, int attack)
    {
      Name = name;
      Attack = attack;
    }


    public Item getArmor() { return Armor; }

    public void setArmor(Item armor) { Armor = armor; }

    public void setMaxWeight(int maxWeight) {
        MaxWeight = maxWeight;
    }

    public Item getShield() {
        return Shield;
    }

    public int getDefence() {
        return Defence;
    }

    public String getName() {
        return Name;
    }

    public void setWeapon(Item weapon) {
        Weapon = weapon;
    }

    public int getMaxWeight() {
        return MaxWeight;
    }

    public Item getWeapon() {
        return Weapon;
    }

    public int getAttack() {
        return Attack;
    }

    public void setShield(Item shield) {
        Shield = shield;
    }

}
