
package com.mycompany.practicalab1;

  
public class Pelicula {
    private String nombre;
    private String director;
    private Genero genero;
    private int duracion;
    private int ano;
    private double calificacion;

    public enum Genero {
        ACCION, COMEDIA, DRAMA, SUSPENSO
    }

    public Pelicula(String nombre, String director, Genero genero, int duracion, int ano, double calificacion) {
        this.nombre = nombre;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.ano = ano;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Director: " + director);
        System.out.println("Género: " + genero);
        System.out.println("Duración: " + duracion + " minutos");
        System.out.println("Año: " + ano);
        System.out.println("Calificación: " + calificacion);
    }

    protected boolean esPeliculaEpica() {
        return duracion >= 180; // 3 horas en minutos
    }

    private String calcularValoracion() {
        if (calificacion >= 8.0) {
            return "Excelente";
        } else if (calificacion >= 6.0) {
            return "Buena";
        } else {
            return "Regular";
        }
    }

    protected boolean esSimilar(Pelicula otraPelicula) {
        return genero == otraPelicula.genero && calificacion == otraPelicula.calificacion;
    }

    public static void main(String[] args) {
        Pelicula pelicula1 = new Pelicula("El Padrino", "Francis Ford Coppola", Genero.DRAMA, 175, 1972, 9.2);
        Pelicula pelicula2 = new Pelicula("Pulp Fiction", "Quentin Tarantino", Genero.SUSPENSO, 154, 1994, 8.9);

        System.out.println("Información de la Película 1:");
        pelicula1.imprimir();
        System.out.println("¿Es película épica? " + pelicula1.esPeliculaEpica());
        System.out.println("Valoración: " + pelicula1.calcularValoracion());

        System.out.println("\nInformación de la Película 2:");
        pelicula2.imprimir();
        System.out.println("¿Es película épica? " + pelicula2.esPeliculaEpica());
        System.out.println("Valoración: " + pelicula2.calcularValoracion());

        System.out.println("\n¿Son películas similares? " + pelicula1.esSimilar(pelicula2));
    }
}
