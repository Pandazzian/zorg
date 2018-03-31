package monster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonsterFactory {

    public static List<Monster> createMonsterLevelOne(){
        return new ArrayList<>(
                Arrays.asList(
                        new Monster("Slime",10,1),
                        new Monster("Slime",10,1)
                ));
    }
    public static List<Monster> createMonsterLevelTwo(){
        return new ArrayList<>(
                Arrays.asList(
                        new Monster("Slime",10,1),
                        new Monster("Ugandan",20,5),
                        new Monster("Ugandan",20,5)
                ));
    }
    public static List<Monster> createMonsterLevelThree(){
        return new ArrayList<>(
                Arrays.asList(
                        new Monster("Slime",10,1),
                        new Monster("Slime",10,1),
                        new Monster("Ugandan",20,5),
                        new Monster("Ugandan",20,5),
                        new Monster("Ugandan Queen",100,5)
                ));
    }
}
