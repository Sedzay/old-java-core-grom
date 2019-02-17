package lesson11.homework;

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

        //BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        /*for (Room room : bookingComAPI.findRooms(100,4,"Kiev", "Hilton")) {
            System.out.println(room.getId());
        }*/

        Controller controller = new Controller(new API[]{new BookingComAPI(rooms)/*null*/, new TripAdvisorAPI(rooms)/*,new GoogleAPI(rooms)*/});
        Room[] roomNeed = new Room[18];
                roomNeed = controller.requestRooms(100, 4,"Kiev","Hilton");
        for (Room room : roomNeed) {
            if (room!=null)
                System.out.println(room.getId());
            else
                System.out.println("null");
        }

       /* Room[]checkRooms = controller.check(new TripAdvisorAPI(rooms),new GoogleAPI(rooms));
        for (Room room : checkRooms) {
            System.out.println(room.getId());
        }*/

        /*Room cheaperRoom = controller.cheapestRoom();
        System.out.println(cheaperRoom.getId());*/
    }

}
