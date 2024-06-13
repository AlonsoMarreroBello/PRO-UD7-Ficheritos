package net.salesianos.activityFour;

public class Menu {
    public static void mostrarMenu() {
        String menu = """
                Seleccione una opción:
                1. Guardar mesa en fichero.
                2. Obtener todas las mesas guardadas del fichero.
                3. Salir del programa.

                """;
        System.out.println(menu);
    }
}
