package lesson11.homework;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Room room1 = new Room(1,100,4,new Date(),"Hilton", "Kiev");
        Room room2 = new Room(2,150,3,new Date(),"Tesla", "Kiev");
        Room room3 = new Room(3,200,5,new Date(),"Hilton", "Kiev");
        Room room4 = new Room(4,900,2,new Date(),"John", "Kiev");
        Room room5 = new Room(5,1000,1,new Date(),"Hilton", "Ugorod");
        Room room6 = new Room(6,100,4,new Date(),"Hilton", "Kiev");

        Room[] rooms = new Room[]{room1,room2,room3,room4,room5,room6};

        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        for (Room room : bookingComAPI.findRooms(100,4,"Kiev", "Hilton")) {
            System.out.println(room.getId());
        }

        //если Room null
        Controller controller = new Controller(new API[]{new BookingComAPI(rooms), new TripAdvisorAPI(rooms),new GoogleAPI(rooms)});
        Room[] roomNeed = new Room[18];
        roomNeed = controller.requestRooms(100, 4,"Kiev","Hilton");

        Room cheaperRoom = controller.cheapestRoom();
        System.out.println(cheaperRoom.getId());

        //если API null
        /*Controller controller = new Controller(new API[]{null, new TripAdvisorAPI(rooms),new GoogleAPI(rooms)});
        Room[] roomNeed = new Room[18];
        roomNeed = controller.requestRooms(100, 4,"Kiev","Hilton");*/
        /* Room[]checkRooms = controller.check(new TripAdvisorAPI(rooms),new GoogleAPI(rooms));
        for (Room room : checkRooms) {
            System.out.println(room.getId());
        }*/

        //если нет списка комнат
        Room[] rooms1 = null;
        Controller controller1 = new Controller(new API[]{new GoogleAPI(rooms1)});
        Room[] rooms2 = controller1.requestRooms(100,4,"Hilton", "Kiev");
        System.out.println(Arrays.toString(rooms2));

    }

}
