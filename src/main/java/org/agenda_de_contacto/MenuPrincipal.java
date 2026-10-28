package org.agenda_de_contacto;

import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion = 0;

        while (opcion != 10) {
            mostrarMenu();
            System.out.print("Elige una opción: ");

            String respuesta = scanner.nextLine();

            try {
                opcion = Integer.parseInt(respuesta);
            } catch (NumberFormatException e) {
                System.out.println("Opción inválida, intenta de nuevo.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    agenda.agregarContacto(new Contacto(nombre, telefono, email));
                    break;

                case 2:
                    System.out.print("Nombre del contacto: ");
                    nombre = scanner.nextLine();

                    Contacto encontrado = agenda.buscarContacto(nombre);

                    if (encontrado == null) {
                        System.out.println("Contacto no encontrado: " + nombre);
                    } else {
                        System.out.println(encontrado);
                    }
                    break;

                case 3:
                    System.out.print("Nombre del contacto que deseas eliminar: ");
                    nombre = scanner.nextLine();

                    if (agenda.eliminarContacto(nombre)) {
                        System.out.println("Contacto eliminado: " + nombre);
                    } else {
                        System.out.println("Contacto no encontrado: " + nombre);
                    }
                    break;

                case 4:
                    System.out.println("--- CONTACTOS EN ORDEN ALFABÉTICO ---");
                    agenda.listarContactos();
                    break;

                case 5:
                    System.out.println("--- HISTORIAL EN ORDEN DE INSERCIÓN ---");
                    agenda.listarHistorial();
                    break;

                case 6:
                    System.out.print("Nombre del grupo: ");
                    String grupo = scanner.nextLine();
                    agenda.agregarGrupo(grupo);
                    break;

                case 7:
                    System.out.print("Nombre del contacto: ");
                    nombre = scanner.nextLine();

                    System.out.print("Nombre del grupo: ");
                    grupo = scanner.nextLine();

                    agenda.agregarContactoAGrupo(nombre, grupo);
                    break;

                case 8:
                    System.out.println("--- GRUPOS EN ORDEN ALFABÉTICO ---");
                    agenda.listarGrupos();
                    break;

                case 9:
                    System.out.print("Nombre del grupo: ");
                    grupo = scanner.nextLine();
                    agenda.mostrarContactosPorGrupo(grupo);
                    break;

                case 10:
                    System.out.println("Saliendo de la agenda...");
                    break;

                default:
                    System.out.println("Opción inválida, intenta de nuevo.");
            }
        }

        scanner.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n=== AGENDA DE CONTACTOS ===");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Listar contactos (orden alfabético)");
        System.out.println("5. Listar historial (orden de inserción)");
        System.out.println("6. Agregar grupo");
        System.out.println("7. Agregar contacto a grupo");
        System.out.println("8. Listar grupos");
        System.out.println("9. Mostrar contactos por grupo");
        System.out.println("10. Salir");
    }
}



