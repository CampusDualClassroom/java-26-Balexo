package com.campusdual.classroom;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Contact implements ICallActions{
    private String nombre;
    private String surname;
    private String numeroTelefono;
    private String codigo;

    public Contact(String nombre, String surname, String numeroTelefono) {
        this.nombre = nombre;
        this.surname = surname;
        this.numeroTelefono = numeroTelefono;
        this.codigo=generateCode(nombre, surname);
    }

    public String getName() {
        return nombre;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public String getSurnames() {
        return surname;
    }

    public void setSurnames(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return numeroTelefono;
    }

    public void setPhone(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCode() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

       public static String removerSignosDiacriticos(String texto){
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCOMBINING_DIACRITICAL_MARKS}+");

        return pattern.matcher(textoNormalizado).replaceAll("");
    }
    public static String generateCode(String name, String surname) {
        String nameNormalized = removerSignosDiacriticos(name).toLowerCase();
        String surnameNormalized = removerSignosDiacriticos(surname).toLowerCase();

        String firstLetterName = String.valueOf(nameNormalized.charAt(0));
        String[] surnameParts = surnameNormalized.split(" ");
        String code;

        if (surnameParts.length > 1) {
            code = firstLetterName + surnameParts[0].charAt(0);
            for (int i = 1; i < surnameParts.length; i++) {
                code += surnameParts[i];
            }
        } else {
            code = firstLetterName + surnameParts[0];
        }

        return code.replaceAll("[^a-zA-Z0-9-]", "");
    }


    @Override
    public void callMyNumber() {
        System.out.printf("Se está llamando a %s %s al número %s \n", getName(), getSurnames(), getPhone());
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.printf("Se está llamando al número de teléfono %s %s %s \n", getName(), getSurnames(),number);
    }


    @Override
    public void showContactDetails() {
        System.out.printf("Los detalles de contacto son:\nNombre: %s\nApellidos: %s\nNúmero de teléfono: %s\nCódigo: %s\n",
            getName(), getSurnames(), getPhone(), getCode()); }
}
