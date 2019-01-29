package sample.Attacks;
import sample.Player.Player;
import sample.Gear.Armor;
import sample.Gear.Item;
import sample.Gear.Shield;
import sample.Gear.Weapon;

import java.util.Random;

public class Attack {
    private int damage = 0;

    public int normalAttack(Player player, Player enemy, String attackname) {
        int defence = 0;
        Random rand = new Random();
        int change = rand.nextInt(100);
        if(attackname.equals("simple"))
        {
            change = 0;
        }
        if (change <= player.getWeapon().getAccuracy()) {
            if (enemy.getShield() != null && enemy.getArmor() != null) {
                defence = enemy.getArmor().getDefence() + enemy.getShield().getDefence();
            } else if (enemy.getArmor() != null && enemy.getShield() == null){
                defence = enemy.getArmor().getDefence();
            }else if (enemy.getShield() == null && enemy.getArmor() != null)
            {
                defence = enemy.getShield().getDefence();
            }
            if(!enemy.getRest()) {
                defence = defence / 2;
            }



            if(player.getWeapon() != null) {
                if(attackname.equals("heavy")) {
                    damage = player.getAttack() + player.getWeapon().getStrength() * 2;
                }
                else if(attackname.equals("simple"))
                {
                    damage = player.getAttack() + player.getWeapon().getStrength();
                    damage = damage / 2;
                }
                else {
                    damage = player.getAttack() + player.getWeapon().getStrength();
                }

                damage = damage - defence;
                if(damage <= 0)
                {
                    damage = player.getAttack();
                }
            }
            else
            {
                if(enemy.getRest()) {
                    damage = 0;
                }
                else if(attackname.equals("simple"))
                {
                    damage = player.getAttack();
                    damage = damage / 2;
                }
                 else{
                damage = player.getAttack();
                 }
            }
            enemy.setHealt(enemy.getHealt() - damage);
            loseweapon(player, enemy);
        }
        return damage;
    }


    private void loseweapon(Player player, Player enemy) {
        int enemydur = 10;
        if(enemy.getRest())
        {
            enemydur = 20;
        }
        if(player.getWeapon() != null) {

            player.getWeapon().setDurabillity(player.getWeapon().getDurabillity() - 10);

            if (player.getWeapon().getDurabillity() <= 0) {
                player.setWeapon(null);
            }
        }
        if(enemy.getShield() != null) {

            enemy.getShield().setDurabillity(enemy.getShield().getDurabillity() - enemydur);

            if(enemy.getShield().getDurabillity() <= 0)
            {
                   enemy.setShield(null);
            }
        }
        if(enemy.getArmor() != null)
        {
            enemy.getArmor().setDurabillity(enemy.getArmor().getDurabillity() - enemydur);

            if(enemy.getArmor().getDurabillity() <= 0)
            {
                enemy.setArmor(null);
            }
        }
    }
}