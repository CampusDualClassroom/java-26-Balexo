package com.campusdual.classroom;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    private Map<String, Contact> listaContactos = new HashMap<>();

    public void addContact(Contact contact){
        listaContactos.put(contact.getCode(), contact);
        System.out.printf("Contacto añadido %s", contact.getCode());
    }

    public void showPhonebook() {
        if (listaContactos.isEmpty()) {
            System.out.println("No hay contactos añadidos");
        } else {
            for (Contact contact : listaContactos.values()) {
                System.out.println("Clave: " + contact.getCode());
                System.out.println("Nombre: " + contact.getName());
                System.out.println("Apellidos: " + contact.getSurnames());
                System.out.println("Telefono: " + contact.getPhone());
            }
        }
    }

    public void deleteContact(String codigo){
        Contact contact = listaContactos.remove(codigo);
        if(contact!=null) {
            System.out.printf("Contacto eliminado: %s", contact.getName());
        }else{
            System.out.println("No existe ese contacto.");
        }
    }

    public void selectContact(String codigo){
        Contact contact = listaContactos.get(codigo);
        if(contact!=null){
            System.out.printf("Menú acciones para %s", contact.getCode());
            System.out.println("1. Llamar");
            System.out.println("2. Mostrar detalles contacto");
            System.out.println("Selecciona una opción");
        }
    }

    public Map<String, Contact> getData(){
        return listaContactos;
    }

    public void menu(){
        Scanner scanner = new Scanner(System.in);
        String boton="";
        while(!"5".equals(boton)){
            System.out.println("Menú de opciones:");
            System.out.println("1. Añadir contacto");
            switch (boton){
                case "1":
                    System.out.println("Ingrese el nombre");
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese los apellidos");
                    String apellidos = scanner.nextLine();
                    System.out.println("Ingrese el número de teléfono");
                    String numero = scanner.nextLine();

                    Contact nuevoContacto = new Contact(nombre, apellidos, numero);
                    addContact(nuevoContacto);
                    break;
                case "2":
                    showPhonebook();
                case "3":
                    System.out.println("Ingrese el código del contacto");
                    String contactoSeleccion = scanner.nextLine();
                    selectContact(contactoSeleccion);
                case "4":
                    System.out.println("Seleccione contacto a borrar");
                    String contactoEliminar = scanner.nextLine();
                    deleteContact(contactoEliminar);
                case "5":
                    System.out.println("Saliendo del la agenda");
                default:
                    System.out.println("Opción no válida");
            }
        }
        scanner.close();
    }

}
