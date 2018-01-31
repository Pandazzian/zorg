import java.util.Scanner;

/**
 * Created by pandazzian on 28/1/2018 AD.
 */
public class PlayerFactory {
    private static Player player;

    public static Player create(){
        player=new Player();
        initializeNewPlayer();
        return player;
    }

    private static void initializeNewPlayer(){
        Scanner sc = new Scanner(System.in);
        String name,race,gender;
        String ans;

        System.out.print("Alright welcome to the game.\nFirst I would like to know your name.\n>");
        name = sc.nextLine();
        System.out.print("Ok "+name+"! now what is your race? eg. orc,african american,ceiling lamp and etc.\n>");
        race = sc.nextLine();
        System.out.print("alright!... and your gender?\n>");
        gender=sc.nextLine();
        System.out.println("Okay! so you are a "+gender+" "+race+" name "+name+".");
        for(;;){
            System.out.print("is this correct? y/n\n>");
            ans=sc.nextLine();
            if (ans.equals("n")){
                initializeNewPlayer();
                break;
            }
            if (ans.equals("y")){
                break;
            }
        }
        player.addInfo(name,race,gender);
    }
}
