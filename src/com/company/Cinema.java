package com.company;
import java.util.Scanner;


class Cinema {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scan.nextInt();
        System.out.println();

        String[][] array = new String[rows][seats];

        //fill in the table
        for (int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                array[i][j] = "S";
            }
        }

        boolean turnOn = true;
        int currentIncome = 0;

        while (turnOn) {
            //Menu
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            int num = scan.nextInt();
            System.out.println();

            switch (num) {
                case 1: showSeats(array, seats);
                    break;
                case 2:
                    while (true) {
                        System.out.println("Enter a row number:");
                        int rowNum = scan.nextInt();

                        System.out.println("Enter a seat number in that row:");
                        int seatNum = scan.nextInt();

                        System.out.println();

                        //If a coordinates are out of bounds
                        if (rowNum > array.length || seatNum > array.length) {
                            System.out.println("Wrong input!");
                            System.out.println();
                        } else {
                            //If a user chooses an already taken seat
                            if (array[rowNum - 1][seatNum - 1] == "B") {
                                System.out.println("That ticket has already been purchased!");
                                System.out.println();
                            } else {
                                currentIncome += buyTicket(rowNum, seatNum, rows, seats, array);
                                break;
                            }
                        }
                    }
                    break;
                case 3: showStatistics(array, rows, seats, currentIncome);
                    break;
                case 0:
                    turnOn = false;
            }
        }
    }

    //1. Show the seats
    public static void showSeats(String[][] array, int seats) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < array.length; i++) {
            System.out.print(i + 1 + " ");
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //2. Buy a ticket
    public static int buyTicket(int rowNum, int seatNum, int rows, int seats, String[][] array) {
        //formula for calculating the price
        int price = formula(rows, seats, rowNum);

        array[rowNum - 1][seatNum - 1] = "B";

        System.out.println("Ticket price: $" + price);
        System.out.println();

        return price;
    }

    //3.Statistics
    public static void showStatistics(String[][] array, int rows, int seats, int currentIncome) {
        int sold = 0;
        float totalSeats = seats * rows;

        //check of sold seats
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j].equals("B")) {
                    sold++;
                }
            }
        }
        float percentage = sold * 100 / totalSeats;

        System.out.printf("Number of purchased tickets: %d", sold);
        System.out.println();

        System.out.printf("Percentage: %.2f", percentage);
        System.out.println("%");

        System.out.println("Current income: $" + currentIncome);

        totalIncome(rows, seats);
        System.out.println();
    }

    //formula for calculating the price
    public static int formula(int rows, int seats, int rowNum) {
        int price = 0;

        if (rows * seats <= 60) {
            return price = 10;
        } else {
            if (rows % 2 == 1) {
                if (rowNum <= rows / 2) {
                    return price = 10;
                } else {
                    return price = 8;
                }
            } else {
                if (rowNum <= rows / 2) {
                    return price = 10;
                } else {
                    return price = 8;
                }
            }
        }
    }

    //formula for calculating total income
    public static void totalIncome(int rows, int seats) {
        if (rows * seats <= 60) {
            System.out.println("Total income: $" + rows * seats * 10);
        } else {
            if (rows % 2 == 1) {
                int one = rows / 2 * seats * 10;
                int two = (rows / 2 + 1) * seats * 8;
                System.out.println("Total income: $" + (one + two));
            } else {
                int one = rows / 2 * seats * 10;
                int two = rows / 2 * seats * 8;
                System.out.println("Total income: $" + (one + two));
            }
        }
    }

}













