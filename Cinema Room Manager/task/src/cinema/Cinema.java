package cinema;


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

    public static void main(String[] args) {
        room();
    }
}