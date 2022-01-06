package cinema;


import java.util.Scanner;

public class Cinema {

    public static void room() {
        String[][] seat = new String[7][8];
        System.out.println("Cinema:");
        System.out.println("  1 2 3 4 5 6 7 8");
        int row = 1;
        for (int i = 0; i < seat.length; i++) {
            System.out.print(row++ + " ");
            for (int j = 0; j < seat[i].length; j++) {
                System.out.print(seat[i][j] = "S" + " ");
            }
            System.out.println();
        }
    }

    public static void cost() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows:\n" + "> ");
        int row = scanner.nextInt();
        System.out.print("Enter the number of seats in each row:\n" + "> ");
        int numberOfSeat = scanner.nextInt();
        int allSeatsCost = 0;
        if (row * numberOfSeat <= 60) {
            allSeatsCost = row * numberOfSeat * 10;
            System.out.println("Total income:\n" + "$" + allSeatsCost);
        } else if (row * numberOfSeat > 60) {
            if (row % 2 == 0) {
                allSeatsCost = row / 2 * numberOfSeat * 10 + row / 2 * numberOfSeat * 8;
            } else {
                allSeatsCost = row / 2 * numberOfSeat * 10 + (row / 2 + 1) * numberOfSeat * 8;
            }
            System.out.println("Total income:\n" + "$" + allSeatsCost);
        }
    }

    public static void main(String[] args) {
        room();
        cost();
    }
}