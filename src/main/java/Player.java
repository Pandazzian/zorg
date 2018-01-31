/**
 * Created by pandazzian on 27/1/2018 AD.
 */
public class Player {

    private int playerLevel,HP;
    private String name,race,gender;
    private Inventory inventory;

    public Player(){
        inventory = new Inventory();
    }

    public void addInfo(String name,String race,String gender){
        addInfo(name,race,gender,1,100);
    }
    public void addInfo(String name,String race,String gender,int playerLevel,int HP){
        this.name=name;
        this.race=race;
        this.gender=gender;
        this.playerLevel=playerLevel;
        this.HP=HP;
    }

}
