package map;

import items.Weapon;
import items.WeaponFactory;
import monster.Monster;
import monster.MonsterFactory;

import java.util.List;

public class GameMapFactory {

    private static GameMap createMapLevelOne(){
        Room[][] rooms = RoomFactory.create(3,3);
        List<Monster> monsters = MonsterFactory.createMonsterLevelOne();
        List<Weapon> weapons = WeaponFactory.createWeaponLevelOne();

        return new GameMap(rooms,1,1,monsters,weapons);
    }
    private static GameMap createMapLevelTwo(){
        Room[][] rooms = RoomFactory.create(4,4);
        List<Monster> monsters = MonsterFactory.createMonsterLevelTwo();
        List<Weapon> weapons = WeaponFactory.createWeaponLevelTwo();
        return new GameMap(rooms,1,0,monsters,weapons);
    }
    private static GameMap createMapLevelThree(){
        Room[][] rooms = RoomFactory.create(5,5);
        List<Monster> monsters = MonsterFactory.createMonsterLevelThree();
        List<Weapon> weapons = WeaponFactory.createWeaponLevelThree();
        return new GameMap(rooms,4,4,monsters,weapons);
    }

    public static GameMap createMap(int level){
        switch (level){
            case 1:
                return createMapLevelOne();
            case 2:
                return createMapLevelTwo();
            case 3:
                return createMapLevelThree();
            default:
                return createMapLevelOne();
        }
    }
}
