package org.agenda_de_contacto;

import java.util.*;

public class Agenda {
    private Map<String, Contacto> contactos = new TreeMap<>();
    private Set<String> grupos = new TreeSet<>();
    private Map<String, Set<String>> contactosPorGrupo = new TreeMap<>();
    private List<Contacto> historial = new ArrayList<>();

    public void agregarContacto(Contacto contacto) {
        String nombre = contacto.getNombre();

        if (contactos.containsKey(nombre)) {
            System.out.println("Error: Ya existe un contacto con el nombre '" + nombre + "'.");
        } else {
            contactos.put(nombre, contacto);
            historial.add(contacto);
            System.out.println("Contacto agregado: " + nombre);
        }
    }

    public Contacto buscarContacto(String nombre) {
        return contactos.get(nombre);
    }

    public boolean eliminarContacto(String nombre) {
        Contacto contacto = contactos.remove(nombre);

        if (contacto == null) {
            return false;
        }

        historial.remove(contacto);

        for (String grupo : grupos) {
            contactosPorGrupo.get(grupo).remove(nombre);
        }

        return true;
    }

    public void listarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos.");
            return;
        }

        for (Contacto contacto : contactos.values()) {
            System.out.println(contacto);
        }
    }

    public void listarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
            return;
        }

        for (Contacto contacto : historial) {
            System.out.println(contacto);
        }
    }

    public void agregarGrupo(String nombreGrupo) {
        if (grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' ya existe.");
        } else {
            grupos.add(nombreGrupo);
            contactosPorGrupo.put(nombreGrupo, new TreeSet<String>());
            System.out.println("Grupo '" + nombreGrupo + "' creado.");
        }
    }

    public boolean agregarContactoAGrupo(String nombreContacto, String nombreGrupo) {
        if (!contactos.containsKey(nombreContacto)) {
            System.out.println("Error: El contacto '" + nombreContacto + "' no existe.");
            return false;
        }

        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe.");
            return false;
        }

        contactosPorGrupo.get(nombreGrupo).add(nombreContacto);
        System.out.println("Contacto agregado al grupo '" + nombreGrupo + "'.");
        return true;
    }

    public void listarGrupos() {
        if (grupos.isEmpty()) {
            System.out.println("No hay grupos.");
            return;
        }

        for (String grupo : grupos) {
            System.out.println(grupo);
        }
    }

    public void mostrarContactosPorGrupo(String nombreGrupo) {
        if (!grupos.contains(nombreGrupo)) {
            System.out.println("Error: El grupo '" + nombreGrupo + "' no existe.");
            return;
        }

        Set<String> nombres = contactosPorGrupo.get(nombreGrupo);

        if (nombres.isEmpty()) {
            System.out.println("El grupo '" + nombreGrupo + "' no tiene contactos.");
            return;
        }

        for (String nombre : nombres) {
            System.out.println(contactos.get(nombre));
        }
    }
}
