package monster;

/**
 * Created by pandazzian on 28/1/2018 AD.
 */
public class Monster {
    String monsterName;
    int Health,attackPoint;

    public Monster(String monsterName,int HP,int attackPoint){
        this.Health=HP;
        this.attackPoint=attackPoint;
        this.monsterName=monsterName;
    }

}
