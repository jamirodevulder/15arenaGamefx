package sample.Gear;

public class Item {
    private int Weight;
    private String Name;
    private int Durabillity;

    public void setName(String name) {
        Name = name;
    }

    public void setDurabillity(int durabillity) {
        Durabillity = durabillity;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }



    public int getWeight() {
        return Weight;
    }

    public int getDurabillity() {
        return Durabillity;
    }

    public String getName() {
        return Name;
    }



}
