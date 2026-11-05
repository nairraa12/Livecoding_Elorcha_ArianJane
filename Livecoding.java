package livecoding;

import java.util.Scanner;

public class Livecoding {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int ch;

        do {

            System.out.println("\nJAVA PROGRAMMING LABORATORY");
            System.out.println("1. Student Grade Evaluator");
            System.out.println("2. Electricity Bill Calculator");
            System.out.println("3. Array Statistics Analyzer");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            ch = input.nextInt();

            switch (ch) {

                case 1:

                    System.out.println("\nSTUDENT GRADE EVALUATOR");

                    System.out.print("Enter Prelim Score: ");
                    double prelim = input.nextDouble();

                    System.out.print("Enter Midterm Score: ");
                    double midterm = input.nextDouble();

                    System.out.print("Enter Final Score: ");
                    double finals = input.nextDouble();

                    double average = CalcAve(prelim, midterm, finals);
                    char grade = GradeEq(average);
                    boolean passed = isPassed(average);

                    System.out.println("Average: " + average);
                    System.out.println("Grade: " + grade);

                    if (passed) {
                        System.out.println("Status: Passed");
                    } else {
                        System.out.println("Status: Failed");
                    }
                    break;

                case 2:
                    System.out.println("\nELECTRICITY BILL CALCULATOR");

                    System.out.print("Enter Electricity Consumption (kWh): ");
                    double consumption = input.nextDouble();

                    System.out.print("Enter Rate per kWh: ");
                    double rate = input.nextDouble();

                    System.out.print("Enter Additional Charge (%): ");
                    double percentage = input.nextDouble();

                    double consumptionCharge = calcConsumptionCharge(consumption, rate);

                    double additionalCharge = calcAdditionalCharge(consumptionCharge, percentage);

                    double totalBill = calcTotalBill(consumptionCharge, additionalCharge);

                    System.out.printf("\nConsumption Charge: PHP %.2f%n", consumptionCharge);

                    System.out.printf("Additional Charge: PHP %.2f%n", additionalCharge);

                    System.out.printf("Total Electricity Bill: PHP %.2f%n", totalBill);

                    break;

                case 3:
                    System.out.println("\nARRAY STATISTICS ANALYZER");

                    int[] scores = {85, 90, 72, 65, 95, 78, 88, 70};

                    if (scores == null || scores.length == 0) {
                        System.out.println("Error: The array is empty.");
                        break;
                    }

                    int sum = calculateSum(scores);

                    double arrayAverage = calculateAverage(scores);

                    int highest = findHighest(scores);

                    int lowest = findLowest(scores);

                    int passing = countPassing(scores);

                    System.out.println("\nStatistical Information");

                    System.out.println("Total Number of Scores: "
                            + scores.length);

                    System.out.println("Sum of Scores: " + sum);

                    System.out.println("Average Score: " + arrayAverage);

                    System.out.println("Highest Score: " + highest);

                    System.out.println("Lowest Score: " + lowest);

                    System.out.println("Number of Passing Students: "
                            + passing);

                    break;

                case 0:

                    System.out.println("\nThank you for using the program!");

                    break;

                default:

                    System.out.println("\nInvalid choice! Please try again.");

            }

        } while (ch != 0);

    }
    // 1

    static double CalcAve(double prelim, double midterm, double finals) {

        double average = (prelim + midterm + finals) / 3;
        return average;
    }

    static char GradeEq(double average) {

        if (average >= 90) {
            return 'A';
        } else if (average >= 85) {
            return 'B';
        } else if (average >= 80) {
            return 'C';
        } else if (average >= 75) {
            return 'D';
        } else {
            return 'F';
        }
    }

    static boolean isPassed(double average) {

        if (average >= 75) {
            return true;
        } else {
            return false;
        }

    }

    //2
    static double calcConsumptionCharge(double consumption, double rate) {

        double charge = consumption * rate;
        return charge;
    }

    static double calcAdditionalCharge(double consumptionCharge, double percentage) {

        double additionalCharge = consumptionCharge * (percentage / 100);
        return additionalCharge;
    }

    static double calcTotalBill(double consumptionCharge, double additionalCharge) {

        double totalbill = consumptionCharge + additionalCharge;
        return totalbill;
    }

    static int calculateSum(int[] scores) {

        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        return sum;
    }

    static double calculateAverage(int[] scores) {

        int sum = calculateSum(scores);

        return (double) sum / scores.length;
    }

    //3
    static int findHighest(int[] scores) {

        int highest = scores[0];

        for (int i = 1; i < scores.length; i++) {

            if (scores[i] > highest) {
                highest = scores[i];
            }
        }

        return highest;
    }

    static int findLowest(int[] scores) {

        int lowest = scores[0];

        for (int i = 1; i < scores.length; i++) {

            if (scores[i] < lowest) {
                lowest = scores[i];
            }
        }

        return lowest;
    }

    static int countPassing(int[] scores) {

        int count = 0;

        for (int i = 0; i < scores.length; i++) {

            if (scores[i] >= 75) {
                count++;
            }
        }

        return count;
    }

}
