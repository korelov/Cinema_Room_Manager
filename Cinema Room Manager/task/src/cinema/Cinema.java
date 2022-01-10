package cinema;

import java.util.Scanner;

public class Cinema {

    static Scanner scanner = new Scanner(System.in);
    static int row;
    static int numberOfSeat;
    static int rowNumber;
    static int seatNumber;
    static int oneTicketCost;
    static int allSeatsCost;
    static int currentIncome;
    static String[][] room;

    public static void showTheSeats() {

        System.out.println("Cinema:");
        System.out.print("  ");

        int horizontalRow = 1;

        for (int i = 1; i <= numberOfSeat; i++) {
            if (i != numberOfSeat) {
                System.out.print(i + " ");
            } else {
                System.out.println(i);
            }
        }
        for (int i = 0; i < room.length; i++) {
            System.out.print(horizontalRow++ + " ");
            for (int j = 0; j < room[i].length; j++) {
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void buyATicket() {

        System.out.print("Enter a row number:\n" + "> ");
        rowNumber = scanner.nextInt();
        System.out.print("Enter a seat number in that row:\n" + "> ");
        seatNumber = scanner.nextInt();

        if (rowNumber > row || rowNumber < 1 || seatNumber > numberOfSeat || seatNumber < 1) {
            System.out.println("Wrong input!");
        } else {

            if (room[rowNumber - 1][seatNumber - 1].equals("B")) {
                System.out.println("That ticket has already been purchased!");
                buyATicket();
            } else {
                room[rowNumber - 1][seatNumber - 1] = "B";
                if (row * numberOfSeat <= 60) {
                    System.out.println("Ticket price: $10\n");
                    oneTicketCost = 10;
                    currentIncome += oneTicketCost;
                } else {
                    if (row / 2 >= rowNumber) {
                        System.out.println("Ticket price: $10\n");
                        oneTicketCost = 10;
                        currentIncome += oneTicketCost;
                    } else {
                        System.out.println("Ticket price: $8\n");
                        oneTicketCost = 8;
                        currentIncome += oneTicketCost;
                    }
                }
            }
        }
    }

    public static void makeRoom() {

        System.out.print("Enter the number of rows:\n" + "> ");
        row = scanner.nextInt();
        System.out.print("Enter the number of seats in each row:\n" + "> ");
        numberOfSeat = scanner.nextInt();

        room = new String[row][numberOfSeat];

        if (row > 9 || row < 1 || numberOfSeat > 9 || numberOfSeat < 1) {
            System.out.println("the number of rows and seats won't be greater than 9");
            makeRoom();
        } else {
            for (int i = 0; i < room.length; i++) {
                for (int j = 0; j < room[i].length; j++) {
                    room[i][j] = "S";
                }
            }
        }
    }

    public static void statistic() {

        System.out.println();
        int count = 0;
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (room[i][j].equals("B")) {
                    count++;
                }
            }
        }
        System.out.printf("Number of purchased tickets: %d%n", count);

        double percentage = (count / (double) (row * numberOfSeat) * 100);
        System.out.printf("Percentage: %.2f%%%n", percentage);

        System.out.println("Current income: " + "$" + currentIncome);

        if (row * numberOfSeat <= 60) {
            allSeatsCost = row * numberOfSeat * 10;
        } else if (row * numberOfSeat > 60) {
            if (row % 2 == 0) {
                allSeatsCost = row / 2 * numberOfSeat * 10 + row / 2 * numberOfSeat * 8;
            } else {
                allSeatsCost = row / 2 * numberOfSeat * 10 + (row / 2 + 1) * numberOfSeat * 8;
            }
        }
        System.out.println("Total income: " + "$" + allSeatsCost);
    }

    public static void menu() {
        int menuNumber;
        do {
            System.out.print("1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit\n" +
                    "> ");

            menuNumber = scanner.nextInt();

            switch (menuNumber) {
                case 1:
                    showTheSeats();
                    break;
                case 2:
                    buyATicket();
                    break;
                case 3:
                    statistic();
                    break;
                case 0:
                    break;
            }
        } while (menuNumber != 0);
    }

    public static void main(String[] args) {

        makeRoom();
        menu();
    }
}