import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Main main = new Main();
        //main.printMenu();
        new Main().printMenu();
        //  main.printSeats();
        //  main.createSeats();

    }

    // Var
    static Scanner sc = new Scanner(System.in);
    private static char[][] cinemaHall;

    public void printDemo() {
        System.out.println("Cinema: ");
        System.out.println("  1 2 3 4 5 6 7 8");
        for (int i = 1; i < 8; i++) {
            System.out.print(i + " ");
            for (int j = 1; j < 9; j++) {
                System.out.print("S ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    public void createCinema() {
        int ticketPrice = 0;
        int totalIncome = 0;

        System.out.println("Enter the number of rows:");
        int numberOfRows = sc.nextInt();
        System.out.println("Enter the number of seats on each row:");
        int numberOfSeats = sc.nextInt();
        cinemaHall = new char[numberOfRows][numberOfSeats];

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfSeats; j++) {
                cinemaHall[i][j] = 'S';
            }
        }

        int totalNumberOfSeats = numberOfRows * numberOfSeats;
        if (totalNumberOfSeats <= 60) {
            ticketPrice = 10;
            totalIncome = totalNumberOfSeats * ticketPrice;
        } else {
            int firstHalf = (numberOfRows / 2);
            int secondHalf = (numberOfRows - firstHalf);

            int totalFirstHalf = firstHalf * numberOfSeats;
            int totalSecondHalf = secondHalf * numberOfSeats;

            totalIncome = totalFirstHalf * 10 + totalSecondHalf * 8;
            System.out.println("total first half " + totalFirstHalf + " second half " + totalSecondHalf);

        }
        System.out.println("total number of seats " + totalNumberOfSeats);
        System.out.println("total income " + totalIncome);
        System.out.println("-------------------------------------------------------------------------");
    }

    public void printCinemaHall() {

        try {
            System.out.println("Cinema: ");
            System.out.print(" ");
            for (int i = 1; i <= cinemaHall[0].length; i++) {
                System.out.print(" " + i);
            }
            System.out.println();
            for (int i = 0; i < cinemaHall.length; i++) {
                System.out.print(i + 1);
                for (int j = 0; j < cinemaHall[0].length; j++) {
                    System.out.print(" " + cinemaHall[i][j]);
                }
                System.out.println();
            }

        } catch (NullPointerException e) {
            System.err.println("Create the Cinema Hall first");
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    public void takeTicket() {
        if (cinemaHall != null) {
            int totalNumberOfSeats = 0;
            int priceTicket;
            System.out.println("Enter a row number: ");
            int seatRow = sc.nextInt() - 1;
            System.out.println("Enter a seat number in that row: ");
            int seatNumber = sc.nextInt() - 1;

            try {
                totalNumberOfSeats = cinemaHall.length * cinemaHall[0].length;
            } catch (IndexOutOfBoundsException e) {
                System.err.println("Not a valid choice");
            }

            if (totalNumberOfSeats <= 60) {
                priceTicket = 10;
            } else {
                int firstHalf = cinemaHall.length / 2;
                if (seatRow <= firstHalf) {
                    priceTicket = 10;
                } else {
                    priceTicket = 8;
                }

            }
            System.out.println("You paid: $" + priceTicket);
            cinemaHall[seatRow][seatNumber] = 'B';
        } else {
            System.err.println("Cinema Hall hasn`t been initialised yet");
            System.out.println("-------------------------------------------------------------------------");
            return;
        }

    }

    public void printMenu() {
        int input;
        do {
            System.out.println("1.Show the seats ");
            System.out.println("2.Init Cinema Hall ");
            System.out.println("3.Buy a ticket ");
            System.out.println("0.Exit ");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    // this.printDemo();
                    this.printCinemaHall();
                    break;
                case 2:
                    this.createCinema();
                    break;
                case 3:
                    this.takeTicket();
                    break;
                case 0:
                    System.out.println("Good Bye");
                    System.exit(1);
                default:
                    System.out.println(" Unknown Command");
                    System.out.println("-------------------------------------------------------------------------");
            }
        } while (input != 0);
    }
}
