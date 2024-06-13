package net.salesianos.activityOne;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FirstActivity {

  public static void main(String[] args) {
    String fileRoute;
    if (args.length != 0) {
      fileRoute = args[0];
    } else {
      fileRoute = "src/net/salesianos/files/FirstActivity";
    }
    writeFile(fileRoute);
    // checkFile(fileRoute);
  }

  public static void writeFile(String fileRoute) {

    Scanner scanner = new Scanner(System.in);
    String text = "";
    while (text.length() < 30) {
      System.out.println("Introduce un texto de al menos 30 caracteres");
      text = scanner.nextLine();
    }
    text = text.toUpperCase().replaceAll(" ", "_");

    try {
      File file = new File(fileRoute);
      FileOutputStream outputStream = new FileOutputStream(file);
      BufferedOutputStream buffOutputStream = new BufferedOutputStream(outputStream);
      DataOutputStream dataOutputStream = new DataOutputStream(buffOutputStream);

      dataOutputStream.writeUTF(text);
      dataOutputStream.close();
    } catch (SecurityException e) {
      System.out.println("Violación de seguridad");
    } catch (NullPointerException e) {
      System.out.println("Error al crear el archivo");
    } catch (FileNotFoundException e) {
      System.out.println("No se encontró el archivo");
    } catch (IOException e) {
      System.out.println("Error al escribir en el archivo");
    }
    scanner.close();
  }

  public static void checkFile(String fileRoute) {
    try (DataInputStream dataInputStream = new DataInputStream(
        new BufferedInputStream(new FileInputStream(fileRoute)))) {
      String currentMessage = dataInputStream.readUTF();
      while (true) {
        System.out.println(currentMessage);
        currentMessage = dataInputStream.readUTF();
      }
    } catch (FileNotFoundException e) {
      System.out.println("ERROR: Fichero no encontrado.");
    } catch (EOFException e) {
      System.out.println("Fin del programa.");
    } catch (IOException e) {
      System.out.println("ERROR: Problema de I/O.");
    }
  }
}
