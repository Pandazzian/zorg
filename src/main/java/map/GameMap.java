package map;

import items.Weapon;
import monster.Monster;

import java.util.List;
import java.util.Random;

/**
 * Created by pandazzian on 28/1/2018 AD.
 */
public class GameMap {
    private Room[][] rooms;
    private int currentPositionX;
    private int currentPositionY;
    private List<Monster> monsters;
    private List<Weapon> weapons;
    public GameMap(Room[][] rooms, int startPositionX, int startPositionY, List<Monster> monsters, List<Weapon> weapons){
        this.rooms = rooms;
        this.currentPositionX=startPositionX;
        this.currentPositionY=startPositionY;
        this.monsters = monsters;
        this.weapons = weapons;
        this.setup();
        this.getCurrentRoom().getInfo();
    }
    private void setup() {
        Random rand = new Random();
        this.rooms[this.currentPositionX][this.currentPositionY].addLoot(this.weapons.get(0));

        for (Monster monster : this.monsters) {
            for (; ; ) {
                Room r = this.rooms[rand.nextInt(this.rooms.length)][rand.nextInt(this.rooms[0].length)];
                if (!r.hasMonster()) {
                    r.addMonster(monster);
                    break;
                }
            }
        }
        for (Weapon weapon : this.weapons.subList(1, this.weapons.size())) {
            for (; ; ) {
                Room r = this.rooms[rand.nextInt(this.rooms.length)][rand.nextInt(this.rooms[0].length)];
                if (!r.hasLoot()) {
                    r.addLoot(weapon);
                    break;
                }
            }
        }
    }

    public Room getCurrentRoom(){
        return this.rooms[currentPositionX][currentPositionY];
    }
    public void goTo(String direction){
        switch (direction){
            case "north":
                changeCurrentRoom(1,0);
                break;
            case "south":
                changeCurrentRoom(-1,0);
                break;
            case "west":
                changeCurrentRoom(0,-1);
                break;
            case "east":
                changeCurrentRoom(0,1);
                break;

        }
    }
    private void changeCurrentRoom(int x,int y){
        int newPositionX = this.currentPositionX+x;
        int newPositionY = this.currentPositionY+y;
        if(canGoToRoomAt(newPositionX,newPositionY)){
            this.currentPositionX = newPositionX;
            this.currentPositionY = newPositionY;
            this.getCurrentRoom().getInfo();
        }
        else{
            System.out.println("Cannot go to this direction");
        }
    }
    private boolean canGoToRoomAt(int x,int y){
        if(0<=x && x<rooms.length && 0<=y && y<rooms[0].length){
            return this.rooms[x][y]!=null;
        }
        else{
            return false;
        }
    }
    public boolean isCleared(){
        for (Monster monster:this.monsters) {
            if(monster.isAlive()){
                return false;
            }
        }
        return true;
    }
}
