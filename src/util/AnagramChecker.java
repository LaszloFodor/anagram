package util;

import service.AnagramService;

import java.util.*;
import java.util.Scanner;

public class AnagramChecker {
    private final AnagramService anagramService;

    public AnagramChecker(AnagramService anagramService) {
        this.anagramService = anagramService;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    handleAnagramCheck(scanner);
                    break;
                case 2:
                    handleAnagramRetrieval(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("Choose an option:");
        System.out.println("1 - Check if two texts are anagrams of each other");
        System.out.println("2 - Get all anagrams for a given string from previous inputs");
        System.out.println("3 - Exit");
    }

    private void handleAnagramCheck(Scanner scanner) {
        System.out.println("Enter the first text:");
        String text1 = scanner.nextLine();
        System.out.println("Enter the second text:");
        String text2 = scanner.nextLine();

        if (anagramService.areAnagrams(text1, text2)) {
            System.out.println("The texts are anagrams.");
            anagramService.addToAnagramMap(text1, text2);
        } else {
            System.out.println("The texts are not anagrams.");
        }
    }

    private void handleAnagramRetrieval(Scanner scanner) {
        System.out.println("Enter the text to get its anagrams:");
        String text = scanner.nextLine();

        Set<String> anagrams = anagramService.getAnagrams(text);
        if (anagrams.isEmpty()) {
            System.out.println("No anagrams found.");
        } else {
            System.out.println("Anagrams found: " + anagrams);
        }
    }
}
