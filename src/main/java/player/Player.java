package player;

/**
 * Created by pandazzian on 27/1/2018 AD.
 */
public class Player {

    private int playerLevel,HP,attackPower;
    private String name,race,gender;
    private Inventory inventory;

    public Player(){
        inventory = new Inventory();
    }

    public void addInfo(String name,String race,String gender){
        addInfo(name,race,gender,1,100,15);
    }
    public void addInfo(String name,String race,String gender,int playerLevel,int HP,int attackPower) {
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.playerLevel = playerLevel;
        this.HP = HP;
        this.attackPower = attackPower;
    }

    public void getInfo(){
        System.out.println("Player Info ---------");
        System.out.println(
                String.format("Player :%s[%d]\nRace :{%s}\nHP :{%d}\nATK :{%d}",
                        this.name,this.playerLevel,this.race,this.HP,this.attackPower)
        );
        System.out.println("---------------------");
    }
    public boolean isAlive(){
        return this.HP>0;
    }
    public void isAttacked(int damage){
        this.HP -= damage;
        this.getInfo();
    }

    public int getAttackPower() {
        return attackPower;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
