package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UppgiftTwo {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Integer> primeList = new ArrayList<Integer>();
    public static int sum = 0;
    public static int closest;


    public static void main(String[] args) {
        arrayAdd();
        Menu();

        boolean quit = false;
        while (!quit) {
            int actions = sc.nextInt();
            sc.nextLine();
            switch (actions) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    Add();
                    break;
                case 2:
                    selSort(primeList);
                    break;
                case 3:
                    Search(primeList);
                    break;
                case 4:
                    Extra();
                    break;
            }
        }
    }
    private static void Add() {
        int numInput, i;
        while (true) {
            System.out.println("Enter a number");
            String input = sc.next();
            try {
                numInput = Integer.valueOf(input);
                break;
            } catch (NumberFormatException ne) {
                System.out.println("Invalid input!");
            }
        }
        //checking if its a prime number
        boolean flag = false;
        for (i = 2; i <= numInput / 2; ++i) {
            // nonprime number
            if (numInput % i == 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println(numInput + " b) is a prime number.");
            if (primeList.contains(numInput)) {
                System.out.println("c) The given input already exists");
            } else {
                primeList.add(numInput);
                System.out.println("Got put in the array");
            }
        } else {
            System.out.println(numInput + " is not a prime number.");
        }
        if (primeList.contains(sum)) {
            sum = 0;
        } else {
            adderaArray();
            System.out.println(sum + " d) Is the 'added' total sum of the list");
            sum = 0;
        }
        Menu();
    }

    private static void Menu() {
        System.out.println( "\n" +
                "Uppgift 2 prime numbers" + "\n" + primeList + "\n" + "\n" +
                        "Menu" + "\n" +
                        "1: Add" + "\n" +
                        "2: Sort" + "\n" +
                        "3: Search" + "\n" +
                        "4: Extra" + "\n" +
                        "0: Quit" + "\n");
        System.out.println("Enter Choice");


    }
    //adds values to the array
    private static void arrayAdd() {
        primeList.add(5);
        primeList.add(2);
        primeList.add(19);
        primeList.add(11);
        primeList.add(23);
    }
    // the add sum method: checks if total sum is prime or not. if it is. put in array
    private static void adderaArray() {
        int i;
        boolean prime = false;
        //looping through array then duoble sum
        do {
            for (i = 0; i < primeList.size(); i++) {
                sum = sum + primeList.get(i);
            }
            //check if prime number
            boolean flag = false;
            for (i = 2; i <= sum / 2; ++i) {
                // nonprime number
                if (sum % i == 0) {
                    flag = true;
                    prime = true;
                    break;
                }
            }
            if (!flag) {
                primeList.add(sum);
            }

        } while (!prime);
    }
    //Selection sort
    private static ArrayList<Integer> selSort(ArrayList<Integer> array) {
        System.out.println("Before: " + primeList);
        int list = array.size();
        for (int i = 0; i < list - 1; i++) {
            int imin = i;
            for (int j = i + 1; j < list; j++) {
                if (array.get(j) < array.get(imin)) {
                    imin = j;
                }
            }
            Collections.swap(array, i, imin);
        }
        System.out.println("After: " + primeList);
        Menu();
        return array;
    }
    //Search method
    private static ArrayList<Integer> Search(ArrayList<Integer> primeList) {
        System.out.println("Search a number: ");
        int searchNumber = sc.nextInt();
        int smallestDiff = Math.abs(searchNumber - primeList.get(0));

        //if the array contains the searched number or not
        if (primeList.contains(searchNumber)) {
            System.out.println(searchNumber + " Was Found!");
        } else {
            System.out.println(searchNumber + " Was not found!");
            //loops through the list
            for (int i = 0; i < primeList.size(); i++) {
                int currentDiff = Math.abs(searchNumber - primeList.get(i));
                //compares variabels
                if (currentDiff < smallestDiff) {
                    smallestDiff = currentDiff;
                    closest = i;
                }
            }
            System.out.println(primeList.get(closest) + " is the closest value");
        }
        Menu();
        return primeList;
    }

    private static void Extra() {
        System.out.println("Input how many prime numbers you want to find");
        int moreSc = sc.nextInt();
        int maxPrime = Collections.max(primeList);
        int i, j;
        //loops as many times as the given input
        for (i = 0; i < moreSc; i++) {
            //loops forward from max value in array
            for (j = maxPrime + 1; j > maxPrime; j++) {
                //checks if the new numbers are prime
                if(ifPrime(j)){
                    maxPrime = j;
                    primeList.add(j);
                    System.out.println(j);
                    break;
                }
            }
        }
        Menu();
    }
    //method that check if the number is prime
    private static boolean ifPrime(int j) {
        for (int i = 2; i <= j / 2; ++i) {
            // nonprime number
            if (j % i == 0) {
                return false;
            }
        }
        return true;
    }
}


