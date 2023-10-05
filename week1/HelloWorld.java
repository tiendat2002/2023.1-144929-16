package week1;

import java.util.Scanner;

public class HelloWorld {
  public static void main(String[] args) {
    // Create a Scanner object to read input from the console.
    Scanner scanner = new Scanner(System.in);

    // Prompt the user to enter their name.
    System.out.print("Enter your name: ");

    // Read the user's name from the console.
    String name = scanner.nextLine();

    // Display a greeting message to the user.
    System.out.println("Hello, " + name + "!");
  }
}
