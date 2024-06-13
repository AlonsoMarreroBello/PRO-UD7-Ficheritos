package net.salesianos.activityTwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SecondActivity {
  public static void main(String[] args) {
    String fileRoute;
    if (args.length != 0) {
      fileRoute = args[0];
    } else {
      fileRoute = "src/net/salesianos/files/SecondActivity";
    }

    try (BufferedReader reader = new BufferedReader(new FileReader(fileRoute))) {
      int character;
      StringBuilder result = new StringBuilder();

      while ((character = reader.read()) != -1) {
        result.append((char) character)
            .append("_")
            .append((int) character)
            .append(", ");
      }
      // Remove the last comma and space
      if (result.length() > 0) {
        result.setLength(result.length() - 2);
        result.append('.');
      }
      System.out.println(result);
    } catch (IOException e) {
      System.out.println("An error occurred while reading the file: " + e.getMessage());
    }
  }
}
