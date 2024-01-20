
package com.mycompany.practicalab1;

import java.util.ArrayList;
import java.util.List;

class Publicacion {
    private String titulo;
    private String autor;
    private int anoPublicacion;
    private String editorial;

    public Publicacion(String titulo, String autor, int anoPublicacion, String editorial) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacion = anoPublicacion;
        this.editorial = editorial;
    }

    public void imprimir() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Año de Publicación: " + anoPublicacion);
        System.out.println("Editorial: " + editorial);
    }
}

class Libro extends Publicacion {
    private String referenciaBibliografica;

    public Libro(String titulo, String autor, int anoPublicacion, String editorial, String referenciaBibliografica) {
        super(titulo, autor, anoPublicacion, editorial);
        this.referenciaBibliografica = referenciaBibliografica;
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Referencia Bibliográfica: " + referenciaBibliografica);
    }
}

class Revista extends Publicacion {
    private String nombreRevista;
    private String periodicidad;
    private String pais;

    public Revista(String titulo, String autor, int anoPublicacion, String editorial, String nombreRevista, String periodicidad, String pais) {
        super(titulo, autor, anoPublicacion, editorial);
        this.nombreRevista = nombreRevista;
        this.periodicidad = periodicidad;
        this.pais = pais;
    }

    public void imprimir() {
        super.imprimir();
        System.out.println("Nombre de la Revista: " + nombreRevista);
        System.out.println("Periodicidad: " + periodicidad);
        System.out.println("País: " + pais);
    }
}

class Biblioteca {
    private String nombre;
    private List<Publicacion> publicaciones;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.publicaciones = new ArrayList<>();
    }

    public void agregarPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }

    public void listarPublicaciones() {
        System.out.println("Publicaciones en la Biblioteca " + nombre + ":");
        for (Publicacion publicacion : publicaciones) {
            publicacion.imprimir();
            System.out.println();
        }
    }
}

public class PruebaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Nacional");

        // Agregar libros
        Libro libro1 = new Libro("Libro 1", "Autor 1", 2020, "Editorial 1", "Referencia 1");
        Libro libro2 = new Libro("Libro 2", "Autor 2", 2019, "Editorial 2", "Referencia 2");

        // Agregar revistas
        Revista revista1 = new Revista("Revista 1", "Autor 3", 2022, "Editorial 3", "Nombre Revista 1", "Mensual", "País 1");
        Revista revista2 = new Revista("Revista 2", "Autor 4", 2021, "Editorial 4", "Nombre Revista 2", "Quincenal", "País 2");

        biblioteca.agregarPublicacion(libro1);
        biblioteca.agregarPublicacion(libro2);
        biblioteca.agregarPublicacion(revista1);
        biblioteca.agregarPublicacion(revista2);

        // Listar publicaciones
        biblioteca.listarPublicaciones();
    }
}
