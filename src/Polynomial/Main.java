package Polynomial;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        ArrayList<Polynomial> polynomialList = new ArrayList<>();

        // Read polynomials from file
        try {
            File file = new File("polynomials.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String polynomialString = scanner.nextLine();
                Polynomial polynomial = new Polynomial(polynomialString);
                polynomialList.add(polynomial);
                System.out.println(polynomialList.indexOf(polynomial) + ": " + polynomial);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        }

        // Prompt user to select polynomials to add
        Scanner scanner = new Scanner(System.in);
        int polyIndex1, polyIndex2;
        while (true) {
            System.out.println("Which polynomials do you wish to add? Press -1 to exit.");
            try {
                String input = scanner.nextLine();
                if (input.equals("-1")) {
                    break;
                }
                String[] inputArray = input.split(" ");
                if (inputArray.length != 2) {
                    System.out.println("Invalid input.");
                    continue;
                }
                polyIndex1 = Integer.parseInt(inputArray[0]);
                polyIndex2 = Integer.parseInt(inputArray[1]);
                if (polyIndex1 < 0 || polyIndex1 >= polynomialList.size() ||
                        polyIndex2 < 0 || polyIndex2 >= polynomialList.size()) {
                    System.out.println("Invalid input.");
                    continue;
                }
                Polynomial result = Polynomial.add(polynomialList.get(polyIndex1), polynomialList.get(polyIndex2));
                polynomialList.add(result);
                System.out.println(polynomialList.indexOf(result) + ": " + result);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }

        scanner.close();
    }
}

