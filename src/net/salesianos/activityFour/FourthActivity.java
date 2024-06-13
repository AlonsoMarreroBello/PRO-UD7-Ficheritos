package net.salesianos.activityFour;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FourthActivity {
  public static void main(String[] args) {
    String fileName = "src/net/salesianos/files/FourthActivity.txt";
    ArrayList<Table> tableList = new ArrayList<>();

    String option = "";
    Boolean getOut = true;
    Scanner scanner = new Scanner(System.in);

    while (getOut) {
      Menu.mostrarMenu();
      option = scanner.nextLine();
      switch (option) {
        case "1":
          System.out.println("Introduce el color de la mesa");
          String color = scanner.nextLine();
          System.out.println("Introduce las patas totales de la mesa");
          int legs = scanner.nextInt();
          tableList.add(new Table(color, legs));
          saveTableOnFile(tableList, fileName);
          break;
        case "2":
          printAllTables(fileName);
          break;
        case "3":
          getOut = false;
          System.out.println("Cerraste el programa");
          break;

        default:
          break;
      }
    }

    scanner.close();
  }

  private static void saveTableOnFile(ArrayList<Table> tables, String fileName) {
    try (ObjectOutputStream ObjectWriter = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream(fileName)))) {
      for (Table t : tables) {
        ObjectWriter.writeObject(t);
      }
    } catch (IOException e) {
      System.out.println("ERROR: Problema de I/O.");
    }
  }

  private static void printAllTables(String fileName) {
    try (ObjectInputStream objectReader = new ObjectInputStream(
        new BufferedInputStream(new FileInputStream(fileName)))) {
      while (true) {
        Table t = (Table) objectReader.readObject();
        System.out.println(t);
      }
    } catch (EOFException e) {
      System.out.println("Fin del fichero");
    } catch (FileNotFoundException e) {
      System.out.println("ERROR: Fichero no encontrado.");
    } catch (IOException e) {
      System.out.println("ERROR: Problema de I/O.");
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      System.out.println("ERROR: Clase no encontrada.");
    }
  }
}