package cinema;

import java.util.Scanner;

public class Cinema {

    static Scanner scanner = new Scanner(System.in);
    static int row;
    static int numberOfSeat;
    static int rowNumber;
    static int seatNumber;
    static String[][] room;


    public static void printRoom() {

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
        menu();
    }

    public static void cost() {

        System.out.print("Enter a row number:\n" + "> ");
        rowNumber = scanner.nextInt();
        System.out.print("Enter a seat number in that row:\n" + "> ");
        seatNumber = scanner.nextInt();

        room[rowNumber-1][seatNumber-1]="B";

        if (row * numberOfSeat <= 60) {
            System.out.println("Ticket price: $10\n");
            menu();
        } else {
            if (row / 2 >= rowNumber) {
                System.out.println("Ticket price: $10\n");
                menu();
            } else {
                System.out.println("Ticket price: $8\n");
                menu();
            }
        }
    }

    public static void makeRoom() {

        System.out.print("Enter the number of rows:\n" + "> ");
        row = scanner.nextInt();
        System.out.print("Enter the number of seats in each row:\n" + "> ");
        numberOfSeat = scanner.nextInt();

        room = new String[row][numberOfSeat];

        for (int i = 0 ; i< room.length;i++){
            for (int j = 0; j<room[i].length;j++){
                room[i][j]="S";
            }
        }

        if (row > 9 || row < 1 || numberOfSeat > 9 || numberOfSeat < 1) {
            System.out.println("the number of rows and seats won't be greater than 9");
            makeRoom();
        }
    }

    public static void menu() {

        System.out.print("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "0. Exit\n" +
                "> ");

        int menuNumber = scanner.nextInt();

        switch (menuNumber) {
            case 1:
                printRoom();
            case 2:
                cost();
            case 0:
                break;
        }
    }

    public static void main(String[] args) {

        makeRoom();
        menu();
    }
}