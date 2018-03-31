package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeaponFactory {
    public static List<Weapon> createWeaponLevelOne(){
        return new ArrayList<>(
                Arrays.asList(
                        new Weapon("Wooden Stick",4),
                        new Weapon("Wooden Stick",4)
                ));
    }
    public static List<Weapon> createWeaponLevelTwo(){
        return new ArrayList<>(
                Arrays.asList(
                        new Weapon("Wooden Stick",4),
                        new Weapon("Wooden Sword",6),
                        new Weapon("Wooden Sword",6)
                ));
    }
    public static List<Weapon> createWeaponLevelThree(){
        return new ArrayList<>(
                Arrays.asList(
                        new Weapon("Wooden Sword",6),
                        new Weapon("Iron Sword",10),
                        new Weapon("Iron Sword",10),
                        new Weapon("Rusty Iron Sword",8),
                        new Weapon("Qu'ran",30)
                ));
    }

}
