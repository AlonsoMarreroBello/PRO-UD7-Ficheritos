package net.salesianos.activityThree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ThirdActivity {
  public static void main(String[] args) {
    String fileRoute;
    String firstFileRouteForCopy;
    String secondFileRouteForCopy;

    if (args.length >= 3) {
      fileRoute = args[0];
      firstFileRouteForCopy = args[1];
      secondFileRouteForCopy = args[2];
    } else {
      fileRoute = "src/net/salesianos/files/ThirdActivity";
      firstFileRouteForCopy = "src/net/salesianos/files/FirstActivity";
      secondFileRouteForCopy = "src/net/salesianos/files/SecondActivity";
    }

    createFile(fileRoute);
    copyFile(fileRoute, firstFileRouteForCopy, secondFileRouteForCopy);
    singFile(fileRoute, "hola k ase");
  }

  private static void createFile(String fileRoute) {

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileRoute))) {
      writer.write("This file will be used to merge contents.");
    } catch (IOException e) {
      System.out.println("An error occurred while creating the file: " + e.getMessage());
    }
  }

  private static void copyFile(String mergedFile, String fileOne, String fileTwo) {
    try (BufferedReader readerOne = new BufferedReader(new FileReader(fileOne));
        BufferedReader readerTwo = new BufferedReader(new FileReader(fileTwo));
        BufferedWriter writer = new BufferedWriter(new FileWriter(mergedFile, true))) {

      writer.write("\n- Contenido del Fichero Uno:\n");
      String line;
      while ((line = readerOne.readLine()) != null) {
        writer.write(line);
        writer.write("\n");
      }

      writer.write("\n- Contenido del Fichero Dos:\n");
      while ((line = readerTwo.readLine()) != null) {
        writer.write(line);
        writer.write("\n \n");
      }

    } catch (IOException e) {
      System.out.println("Ha ocurrido un error al leer el archivo: " + e.getMessage());
    }
  }

  private static void singFile(String fileRoute, String signature) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileRoute, true))) {
      writer.write(signature);
    } catch (IOException e) {
      System.out.println("An error occurred while adding the signature: " + e.getMessage());
    }
  }

}