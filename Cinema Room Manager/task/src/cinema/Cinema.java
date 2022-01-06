package cinema;

import java.util.Scanner;

public class Cinema {

    static Scanner scanner = new Scanner(System.in);
    static int[] cinemaRoom = new int[2];
    static int row;
    static int numberOfSeat;
    static int rowNumber;
    static int seatNumber;

    public static void room(int[] cinemaRoom) {

        row = cinemaRoom[0];
        numberOfSeat = cinemaRoom[1];

        String[][] seat = new String[row][numberOfSeat];
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

        if (rowNumber == 0 && seatNumber == 0) {
            for (int i = 0; i < seat.length; i++) {
                System.out.print(horizontalRow++ + " ");
                for (int j = 0; j < seat[i].length; j++) {
                    System.out.print(seat[i][j] = "S" + " ");
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < seat.length; i++) {
                System.out.print(horizontalRow++ + " ");
                for (int j = 0; j < seat[i].length; j++) {
                    if (i == rowNumber - 1 && j == seatNumber - 1) {
                        System.out.print(seat[i][j] = "B" + " ");
                    } else {
                        System.out.print(seat[i][j] = "S" + " ");
                    }
                }
                System.out.println();
            }
        }

    }

    public static void cost() {

        System.out.print("Enter a row number:\n" + "> ");
        rowNumber = scanner.nextInt();
        System.out.print("Enter a seat number in that row:\n" + "> ");
        seatNumber = scanner.nextInt();

        if (row * numberOfSeat <= 60) {
            System.out.println("Ticket price: $10\n");
            room(cinemaRoom);
        } else {
            if (row / 2 >= rowNumber) {
                System.out.println("Ticket price: $10\n");
                room(cinemaRoom);
            } else {
                System.out.println("Ticket price: $8\n");
                room(cinemaRoom);
            }
        }
    }

//        int allSeatsCost = 0;
//        if (row * numberOfSeat <= 60) {
//            allSeatsCost = row * numberOfSeat * 10;
//            System.out.println("Total income:\n" + "$" + allSeatsCost);
//        } else if (row * numberOfSeat > 60) {
//            if (row % 2 == 0) {
//                allSeatsCost = row / 2 * numberOfSeat * 10 + row / 2 * numberOfSeat * 8;
//            } else {
//                allSeatsCost = row / 2 * numberOfSeat * 10 + (row / 2 + 1) * numberOfSeat * 8;
//            }
//            System.out.println("Total income:\n" + "$" + allSeatsCost);
//        }


    public static int[] makeRoom() {

        System.out.print("Enter the number of rows:\n" + "> ");
        int row = scanner.nextInt();
        System.out.print("Enter the number of seats in each row:\n" + "> ");
        int numberOfSeat = scanner.nextInt();
        //int[] cinemaRoom = new int[2];
        cinemaRoom[0] = row;
        cinemaRoom[1] = numberOfSeat;
        if (row > 9 || row < 1 || numberOfSeat > 9 || numberOfSeat < 1) {
            System.out.println("the number of rows and seats won't be greater than 9");
            makeRoom();
        } else {
            room(cinemaRoom);
        }
        return cinemaRoom;
    }

    public static void main(String[] args) {

        makeRoom();
        cost();
    }
}