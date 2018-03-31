package items;

import monster.Monster;
import player.Player;

public class Weapon implements Item{

    private String weaponName;
    private int attackPoint;

    public Weapon(String weaponName,int attackPoint){
        this.weaponName = weaponName;
        this.attackPoint = attackPoint;
    }

    @Override
    public void use() {
        System.out.println(String.format("Attacking with %s", weaponName));
    }

    public void attack(Monster monster, Player player){
        use();
        monster.isAttacked(this.attackPoint+player.getAttackPower());
    }

    @Override
    public void getInfo() {
        System.out.println(String.format("Weapon :%s", this.weaponName));
        System.out.println(String.format("ATK: %d", this.attackPoint));
    }
}
