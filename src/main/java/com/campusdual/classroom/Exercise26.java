package com.campusdual.classroom;


public class Exercise26 {
    public static void main(String[] args) {
        Contact c1 = new Contact("Javier","López", "654321321");
        Contact c2 = new Contact("Carlos","Fernández-Simón ", "654321321");
        Contact c3 = new Contact("Jose Manuel","Soria ", "654321321");
        Contact c4 = new Contact("Santiago","Fernández Rocha ", "654321321");
        Contact c5 = new Contact("Esteban","Serrano del Río", "654321321");
        Contact c6 = new Contact("Fernando Miguel","Juan de los Santos Requejo León", "654321321");
        Phonebook p = new Phonebook();
        System.out.println(c1.getCode());
        System.out.println(c2.getCode());
        System.out.println(c3.getCode());
        System.out.println(c4.getCode());
        System.out.println(c5.getCode());
        System.out.println(c6.getCode());
        p.addContact(c1);
        p.addContact(c2);
        System.out.println(" ");
        c1.callMyNumber();
        c1.callOtherNumber("1234");
        System.out.println("mostrar contactos");
        p.showPhonebook();
    }
}
