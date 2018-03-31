package map;



public class RoomFactory {
    public static Room create(String roomName){
        return new Room(roomName);
    }
    public static Room[][] create(int row,int col){
        Room[][] rooms = new Room[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rooms[i][j] = create(String.valueOf((i*row)+j));
            }
        }
        return rooms;
    }
}
