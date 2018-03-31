package monster;

import interfaces.Informative;

/**
 * Created by pandazzian on 28/1/2018 AD.
 */
public class Monster implements Informative{
    String monsterName;
    int HP,attackPoint;

    public Monster(String monsterName,int HP,int attackPoint){
        this.HP=HP;
        this.attackPoint=attackPoint;
        this.monsterName=monsterName;
    }
    @Override
    public void getInfo(){
        if(this.isAlive()){
            System.out.println(String.format("%s",this.monsterName ));
            System.out.println(String.format("HP : %d",this.HP ));
            System.out.println(String.format("ATK : %d", this.attackPoint));
        }
        else{
            System.out.println(String.format("%s is ded", this.monsterName));
        }

    }
    public boolean isAlive(){
        return this.HP>0;
    }
    public void isAttacked(int damage){
        this.HP-=damage;
    }

    public int getAttackPoint() {
        return attackPoint;
    }
}
