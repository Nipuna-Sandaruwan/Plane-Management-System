import java.io.File;
import java.util.Scanner;

public class w2051666_PlaneManagement {


private static int[][] allseats = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    private static boolean founded = false;


    private static Ticket[] array = new Ticket[100];
    private static int ticketCount = 0;
    private static int price;
    private static int count;



    public static void main(String[] args) {
        boolean exit = false;
        resetAllSeats();
        System.out.println();
        System.out.println("Welcome to the Plane Management application.");
        System.out.println();

        System.out.println("**************************************************");
        System.out.println("*                  MENU OPTIONS                  *");
        System.out.println("**************************************************");
        System.out.println();
        System.out.println("1) Buy a seat");
        System.out.println("2) Cancel a seat");
        System.out.println("3) Find first available seat");
        System.out.println("4) Show seating plan");
        System.out.println("5) Print tickets information and total sales");
        System.out.println("6) Search tickets");
        System.out.println("0) Quit");
        System.out.println();
        System.out.println("**************************************************");
        System.out.println();
        show_seating_plan();
        System.out.println();
        System.out.println();

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please select an option: ");
            while (!sc.hasNextInt()) {
                System.out.println("Inger required.");
                sc.next();
            }
            int option = sc.nextInt();
            if (option <= 6 && option >= 0) {
                switch (option) {
                    case 1:
                        buy_seat();
                        break;
                    case 2:
                        cancel_seat();
                        break;
                    case 3:
                        find_first_available();
                        break;
                    case 4:
                        show_seating_plan();
                        break;
                    case 5:
                        print_tickets_info();
                        break;
                    case 6:
                        search_ticket();
                        break;
                    case 0:
                        exit = true;
                        break;

                }
            } else {
                System.out.println("Enter a Number Between 0-6: ");
            }

            if (!exit) {
                System.out.println();

                System.out.println("Welcome to the Plane Management application.");
                System.out.println();

                System.out.println("**************************************************");
                System.out.println("*                  MENU OPTIONS                  *");
                System.out.println("**************************************************");
                System.out.println();
                System.out.println("1) Buy a seat");
                System.out.println("2) Cancel a seat");
                System.out.println("3) Find first available seat");
                System.out.println("4) Show seating plan");
                System.out.println("5) Print tickets information and total sales");
                System.out.println("6) Search tickets");
                System.out.println("0) Quit");
                System.out.println();
                System.out.println("**************************************************");
                System.out.println();
                System.out.println();
            }
        } while (!exit);
    }



    private static void resetAllSeats() {
        for (int l = 0; l < 4; l++) {
            for (int k = 0; k < allseats[l].length; k++) {
                allseats[l][k] = 0;
            }
        }
    }



    private static void buy_seat() {

        Scanner sc1 = new Scanner(System.in);
        System.out.print("Enter Row Name: ");
        String row = sc1.next();

        while (!row.matches("[a-dA-D]+")) {
            System.out.println("Select a row: ");
            row = sc1.next();
        }
        row = row.toUpperCase();

        while (true) {
            if (row.equals("A") || row.equals("D")) {
                System.out.print("Enter seat Number: ");
                while (!sc1.hasNextInt()) {
                    System.out.println("Integer Required: ");
                    sc1.next();
                }
                int seatNumber = sc1.nextInt();
                if (seatNumber<=5) {
                    price = 200;
                } else if (seatNumber<=9) {
                    price = 150;
                }else {
                    price =180;
                }
                if (seatNumber <= 14 && seatNumber >= 1) {
                    if (row.equals("A") && allseats[0][seatNumber - 1] == 0) {
                        allseats[0][seatNumber - 1] = 1;
                        System.out.println("You booked Row " + row + " Seat " + seatNumber );;
                        System.out.print("Enter your Name: ");
                        String name = sc1.next();
                        System.out.print("Enter your Surname: ");
                        String surname = sc1.next();
                        System.out.print("Enter your Email: ");
                        String email = sc1.next();
                        Person p = new Person(name, surname, email);
                        Ticket t = new Ticket("A", seatNumber, price, p);
                        array[ticketCount] = t;
                        ticketCount++;
                        t.save();

                        break;
                    } else if (row.equals("D") && allseats[3][seatNumber - 1] == 0) {
                        allseats[3][seatNumber - 1] = 1;
                        System.out.println("You booked Row " + row + " Seat " + seatNumber);
                        System.out.print("Enter your Name: ");
                        String name = sc1.next();
                        System.out.print("Enter your Surname: ");
                        String surname = sc1.next();
                        System.out.print("Enter your Email: ");
                        String email = sc1.next();
                        Person p = new Person(name, surname, email);
                        Ticket t = new Ticket("A", seatNumber, price, p);
                        array[ticketCount] = t;
                        ticketCount++;
                        t.save();

                        break;
                    } else {
                        System.out.println("Seat is not available");
                        break;
                    }

                } else {
                    System.out.println("Number should be in between 1-14");
                }
            } else if (row.equals("B") || row.equals("C")) {
                System.out.print("Enter Seat Number: ");
                while (!sc1.hasNextInt()) {
                    System.out.println("Integer Required: ");
                    sc1.next();
                }
                int seatNumber = sc1.nextInt();
                if (seatNumber <= 12 && seatNumber >= 1) {
                    if (row.equals("B") && allseats[1][seatNumber - 1] == 0) {
                        allseats[1][seatNumber - 1] = 1;
                        System.out.println("You booked Row " + row + " Seat " + seatNumber);
                        System.out.print("Enter your Name: ");
                        String name = sc1.next();
                        System.out.print("Enter your Surname: ");
                        String surname = sc1.next();
                        System.out.print("Enter your Email: ");
                        String email = sc1.next();
                        Person p = new Person(name, surname, email);
                        Ticket t = new Ticket("A", seatNumber, price, p);
                        array[ticketCount] = t;
                        ticketCount++;
                        t.save();
                        break;
                    } else if (row.equals("C") && allseats[2][seatNumber - 1] == 0) {
                        allseats[2][seatNumber - 1] = 1;
                        System.out.println("You booked Row " + row + " Seat " + seatNumber);
                        System.out.print("Enter your Name: ");
                        String name = sc1.next();
                        System.out.print("Enter your Surname: ");
                        String surname = sc1.next();
                        System.out.print("Enter your Email: ");
                        String email = sc1.next();
                        Person p = new Person(name, surname, email);
                        Ticket t = new Ticket("A", seatNumber, price, p);
                        array[ticketCount] = t;
                        ticketCount++;
                        t.save();
                        break;
                    } else {
                        System.out.println("Seat is not available");
                        break;
                    }

                } else {
                    System.out.println("Number should be in between 1-12");

                }
            }
        }
    }


    private static void cancel_seat() {
        Scanner sc2 = new Scanner(System.in);
        System.out.print("Enter Row Name: ");
        String row = sc2.next();

        while (!row.matches("[a-dA-D]+")) {
            System.out.println("Select a row: ");
            row = sc2.next();
        }
        row = row.toUpperCase();

            while (true) {
                if (row.equals("A") || row.equals("D")) {
                    System.out.print("Enter Column Number: ");
                    while (!sc2.hasNextInt()) {
                        System.out.println("Integer Required: ");
                        sc2.next();
                    }
                    int seatNumber = sc2.nextInt();
                    if (seatNumber <= 14 && seatNumber >= 1) {
                        if (row.equals("A") && allseats[0][seatNumber - 1] == 1) {
                            allseats[0][seatNumber - 1] = 0;
                            System.out.println("You cancelled Row " + row + " Seat " + seatNumber);
                            for (int i = 0; i < ticketCount; i++) {
                                Ticket ticket = array[i];
                                if (ticket.getRow().equals(row) && ticket.getSeat() == seatNumber) {
                                    File f = new File(ticket.getRow()+ticket.getSeat()+".txt");
                                    f.delete();
                                    for (int k = i; k < ticketCount; k++) {
                                        array[k] = array[k + 1];
                                    }
                                }
                            }
                            ticketCount--;
                            break;
                        } else if (row.equals("D") && allseats[3][seatNumber - 1] == 1) {
                            allseats[3][seatNumber - 1] = 0;
                            System.out.println("You cancelled Row " + row + " Seat " + seatNumber);
                            for (int i = 0; i < ticketCount; i++) {
                                Ticket ticket = array[i];
                                if (ticket.getRow().equals(row) && ticket.getSeat() == seatNumber) {
                                    File f = new File(ticket.getRow()+ticket.getSeat()+".txt");
                                    f.delete();
                                    for (int k = i; k < ticketCount; k++) {
                                        array[k] = array[k + 1];
                                    }
                                }
                            }
                            ticketCount--;
                            break;
                        } else {
                            System.out.println("Seat is already available");
                            break;
                        }

                    } else {
                        System.out.println("Number must be in between 1-14");
                    }
                } else if (row.equals("B") || row.equals("C")) {
                    System.out.print("Enter seat Number: ");
                    while (!sc2.hasNextInt()) {
                        System.out.println("Integer Required: ");
                        sc2.next();
                    }
                    int seatNumber = sc2.nextInt();
                    if (seatNumber <= 12 && seatNumber >= 1) {
                        if (row.equals("B") && allseats[1][seatNumber - 1] == 1) {
                            allseats[1][seatNumber - 1] = 0;
                            System.out.println("You cancelled Row " + row + " Seat " + seatNumber);
                            for (int i = 0; i < ticketCount; i++) {
                                Ticket ticket = array[i];
                                if (ticket.getRow().equals(row) && ticket.getSeat() == seatNumber) {
                                    File f = new File(ticket.getRow()+ticket.getSeat()+".txt");
                                    f.delete();
                                    for (int k = i; k < ticketCount; k++) {
                                        array[k] = array[k + 1];
                                    }
                                }
                            }
                            ticketCount--;
                            break;
                        } else if (row.equals("C") && allseats[2][seatNumber - 1] == 1) {
                            allseats[2][seatNumber - 1] = 0;
                            System.out.println("You cancelled Row " + row + " Seat " + seatNumber);
                            for (int i = 0; i < ticketCount; i++) {
                                Ticket ticket = array[i];
                                if (ticket.getRow().equals(row) && ticket.getSeat() == seatNumber) {
                                    File f = new File(ticket.getRow()+ticket.getSeat()+".txt");
                                    f.delete();
                                    for (int k = i; k < ticketCount; k++) {
                                        array[k] = array[k + 1];
                                    }
                                }
                            }
                            ticketCount--;
                            break;
                        } else {
                            System.out.println("Seat is already available");
                            break;
                        }

                    } else {
                        System.out.println("Number must be in between 1-12");

                    }
                }
            }
        }

    private static void find_first_available() {
        for (int i = 0; i < allseats.length; i++) {
            for (int j = 0; j < allseats[i].length; j++) {
                if (allseats[i][j] == 0) {
                    founded = true;
                    if (i == 0) {
                        System.out.println("Row A Column " + j + 1 + " seat is available");
                        break;
                    } else if (i == 1) {
                        System.out.println("Row B Column " + j + 1 + " seat is available");
                        break;
                    } else if (i == 2) {
                        System.out.println("Row C Column " + j + 1 + " seat is available");
                        break;
                    } else {
                        System.out.println("Row D Column " + j + 1 + " seat is available");
                        break;
                    }
                }
            }
            if (founded) {
                break;
            }
        }
    }
    private static void show_seating_plan() {
        for (int i =0; i< allseats.length; i++) {
            for (int j=0; j<allseats[i].length; j++) {
                if (allseats[i][j] == 0) {
                    System.out.print("O");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }


    }


    private static void print_tickets_info(){
        int total = 0;
        for (Ticket ticket : array) {
            if (ticket == null) {
                break;
            } else {
                ticket.printTicketsInfo();
                total += ticket.getPrice();
            }

        }
        System.out.println("Total Price: £"+total);
    }


    private static void search_ticket(){
        Scanner scanner3 = new Scanner(System.in);
        boolean exit    =false;
        System.out.print("Enter Row Name: ");
        String row = scanner3.next();

        while (!row.matches("[a-dA-D]+")) {
            System.out.println("Select a row: ");
            row = scanner3.next();
        }
        row = row.toUpperCase();

        while (true) {
            if (row.equals("A") || row.equals("D")) {
                count = 14;
                break;
            } else if (row.equals("B") || row.equals("C")) {
                count = 12;
                break;
            }
        }

        while (true){
            System.out.print("Enter Column Number: ");
            while (!scanner3.hasNextInt()) {
                System.out.println("Integer Required: ");
                scanner3.next();
            }

            int seatNumber = scanner3.nextInt();
            if (seatNumber <= count && seatNumber >= 1){
                for (Ticket t : array) {
                    if (t == null) {
                        exit = true;
                        break;
                    } else {
                        if (t.getRow().equals(row) && t.getSeat() == seatNumber) {
                            t.printTicketsInfo();
                            System.out.println("This seat is not available.");
                            exit = true;
                            break;
                        }
                    }
                }if (exit){
                    break;
                }
                System.out.println("This seat is available.");
                break;

            }else{
                System.out.println("Number should be in between 1-" + count + ": ");
            }
        }
    }
}