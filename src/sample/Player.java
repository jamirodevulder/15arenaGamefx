package sample;


public class Player {
    private String Name;
    private int Defence;
    private int Healt = 100;
    private int Attack;
    private int MaxWeight = 100;
    private Item Weapon = new Item();
    private Item Shield = new Item();

    public Player(String name, int attack, int defence)
    {
      Name = name;
      Attack = attack;
      Defence = defence;
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
