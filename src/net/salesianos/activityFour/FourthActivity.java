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

public class FourthActivity {
  public static void main(String[] args) {
    String fileName = "src/net/salesianos/files/FourthActivity.txt";
    Table table = new Table("red", 10);
    Table table2 = new Table("blue", 4);
    Table table3 = new Table("green", 6);
    Table[] tables = { table, table2, table3 };
    saveTableOnFile(tables, fileName);
    printAllTables(fileName);
  }

  private static void saveTableOnFile(Table[] table, String fileName) {
    try (ObjectOutputStream ObjectWriter = new ObjectOutputStream(
        new BufferedOutputStream(new FileOutputStream(fileName)))) {
      for (Table t : table) {
        ObjectWriter.writeObject(t);
      }
      System.out.println("escribido en el fichero");
    } catch (IOException e) {
      System.out.println("ERROR: Problema de I/O.");
    }
  }

  private static void printAllTables(String fileName) {
    try (ObjectInputStream ObjectWriter = new ObjectInputStream(
        new BufferedInputStream(new FileInputStream(fileName)))) {
      while (true) {
        Table t = (Table) ObjectWriter.readObject();
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