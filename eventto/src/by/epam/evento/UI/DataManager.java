package by.epam.evento.UI;

import by.epam.evento.daodb.*;
import by.epam.evento.entity.*;
import by.epam.evento.service.AddressService;
import by.epam.evento.service.CommentService;
import by.epam.evento.service.EventService;
import by.epam.evento.serviceDB.*;
import by.epam.evento.service.UserService;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class DataManager {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        UserServiceDB userDB = new UserServiceDB();
        AddressServiceDB addressDB = new AddressServiceDB();
        CommentServiceDB commentDB = new CommentServiceDB();
        MembersServiceDB membersDB = new MembersServiceDB();
        EventServiceDB eventDB = new EventServiceDB();
        User user = new User("fff@gmail.com", "fff", "ggg", (byte)12, "F", 1);
        //userDB.create(user);
        //userDB.read();
        //userDB.update(user);
        //userDB.delete(user);
        //userDB.read();
        //System.out.println(userDB.getData());
        Address address = new Address(3,"Belarus", "Stolbtsy", "Gayduka", "15");
        //addressDB.create(address);
        //addressDB.read();
        //addressDB.update(address);
        //addressDB.delete(address);
        //addressDB.read();
        //System.out.println(addressDB.getData());
        //Event event = new Event("a","a",2, simpleDateFormat.parseObj"15-12-2019"),"lehaloh@gmail.com ",123);
       // eventDao.create(event);
        //userDB.read();


//        Comment comment=new Comment("example1@gmail.com","Good",2,15,6);
//        commentDB.read();
//        commentDB.delete(comment);
//        commentDB.read();
//        System.out.println(commentDB.getData());

//        Members member = new Members(1,2,"example1@gmail.com","PART");
//        membersDB.read();
//        membersDB.update(member);
//        membersDB.read();
//        System.out.println(membersDB.getData());

        //String name, String description, long addressId, Date date, String ownerEmail, int maxPeople




//        while (true) {
//            System.out.println("Choose what to manage: \n1.UserManager\n2.EventManager\n3.AddressManager\n0.Exit");
//            int choice = scan.nextInt();
//            switch (choice) {
//                case 1: {
//                    userManager();
//                    break;
//                }
//                case 2: {
//                    eventManager();
//                    break;
//                }
//                case 3: {
//                    addressManager();
//                    break;
//                }
//                case 0:
//                    System.exit(0);
//                default:
//                    continue;
//            }
//        }
    }

    private static void userManager() {
        UserService controller = new UserService();
        controller.read();
        while (true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    controller.create(userBuilder());
                    break;
                }
                case 2: {
                    controller.delete(userBuilder());
                    break;
                }
                case 3: {
                    controller.update(userBuilder());
                    break;
                }
                case 4: {
                    System.out.println(controller.getData().toString());
                    break;
                }
                case 0: {
                    controller.save();
                    main(new String[0]);
                }
                default:
                    continue;
            }
        }
    }

    private static void eventManager() {
        EventService controller = new EventService();
        controller.read();
        while (true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    controller.create(eventBuilder());
                    break;
                }
                case 2: {
                    controller.delete(eventBuilder());
                    break;
                }
                case 3: {
                    controller.update(eventBuilder());
                    break;
                }
                case 4: {
                    System.out.println(controller.getData().toString());
                    break;
                }
                case 0: {
                    controller.save();
                    main(new String[0]);
                }
                default:
                    continue;
            }
        }
    }

    private static void addressManager() {
        AddressService controller = new AddressService();
        controller.read();
        while (true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n3.Update\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice) {
                case 1: {
                    controller.create(addressBuilder());
                    break;
                }
                case 2: {
                    controller.delete(addressBuilder());
                    break;
                }
                case 3: {
                    controller.update(addressBuilder());
                    break;
                }
                case 4: {
                    System.out.println(controller.getData().toString());
                    break;
                }
                case 0: {
                    controller.save();
                    main(new String[0]);
                }
                default:
                    continue;
            }
        }
    }

    public static User userBuilder() {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        System.out.println("Enter email:");
        user.setEmail(sc.nextLine());
        System.out.println("Enter first name:");
        user.setFirstName(sc.nextLine());
        System.out.println("Enter last name:");
        user.setLastName(sc.nextLine());
        System.out.println("Enter age:");
        try {
            user.setAge(sc.nextByte());
        }
        catch (InputMismatchException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Enter gender:");
        String gender = sc.next().toUpperCase();
        user.setGender(gender);
        return user;
    }

    public static Event eventBuilder() {
        Scanner sc = new Scanner(System.in);
        Event event = new Event();
        System.out.println("Enter owner email:");
        event.setOwnerEmail(sc.nextLine());
        System.out.println("Enter name:");
        event.setName(sc.nextLine());
        System.out.println("Enter   description:");
        event.setDescription(sc.nextLine());
        System.out.println("Enter address:");
        event.setAddressId(Integer.valueOf(sc.nextLine()));
        System.out.println("Enter date:");
        event.setDate(Date.valueOf(sc.nextLine()));
        System.out.println("Enter max value of  the participants:");
        event.setMaxPeople(scan.nextInt());
        return event;
    }

    public static Address addressBuilder() {
        Scanner sc = new Scanner(System.in);
        Address address = new Address();
        System.out.println("Enter country:");
        address.setCountry(sc.nextLine());
        System.out.println("Enter town:");
        address.setTown(sc.nextLine());
        System.out.println("Enter street:");
        address.setStreet(sc.nextLine());
        System.out.println("Enter house:");
        address.setHouse(sc.nextLine());
        return address;
    }
}