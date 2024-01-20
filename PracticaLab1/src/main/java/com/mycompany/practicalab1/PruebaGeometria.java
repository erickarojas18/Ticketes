
package com.mycompany.practicalab1;


class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

class Circulo {
    private Punto centro;
    private double radio;

    public Circulo(Punto centro, double radio) {
        this.centro = centro;
        this.radio = radio;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void imprimir() {
        System.out.println("El centro del círculo es la coordenada (" + centro.getX() + ", " + centro.getY() + "), y tiene un radio de " + radio + ".");
    }
}

class Recta {
    private Punto punto1;
    private Punto punto2;

    public Recta(Punto punto1, Punto punto2) {
        this.punto1 = punto1;
        this.punto2 = punto2;
    }

    public double calcularPendiente() {
        if (punto1.getX() == punto2.getX()) {
            return Double.POSITIVE_INFINITY; // Pendiente infinita (vertical)
        } else {
            return (punto2.getY() - punto1.getY()) / (punto2.getX() - punto1.getX());
        }
    }

    public double calcularLongitud() {
        double dx = punto2.getX() - punto1.getX();
        double dy = punto2.getY() - punto1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }
}

class Poligono {
    private String nombre;
    private Punto[] puntos;

    public Poligono(String nombre, Punto[] puntos) {
        this.nombre = nombre;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Punto[] getPuntos() {
        return puntos;
    }

    public void setPuntos(Punto[] puntos) {
        this.puntos = puntos;
    }
}

public class PruebaGeometria {
    public static void main(String[] args) {
        Punto centro = new Punto(2.0, 3.0);
        Circulo circulo = new Circulo(centro, 5.0);

        System.out.println("Información del Círculo:");
        circulo.imprimir();

        Punto punto1 = new Punto(1.0, 2.0);
        Punto punto2 = new Punto(4.0, 5.0);
        Recta recta = new Recta(punto1, punto2);

        double pendiente = recta.calcularPendiente();
        double longitud = recta.calcularLongitud();

        System.out.println("\nPendiente de la Recta: " + pendiente);
        System.out.println("Longitud de la Recta: " + longitud);

        Punto[] puntosPoligono = {new Punto(0.0, 0.0), new Punto(0.0, 2.0), new Punto(2.0, 2.0)};
        Poligono poligono = new Poligono("Triángulo", puntosPoligono);

        System.out.println("\nNombre del Polígono: " + poligono.getNombre());
        System.out.println("Puntos del Polígono:");
        for (Punto punto : poligono.getPuntos()) {
            System.out.println("(" + punto.getX() + ", " + punto.getY() + ")");
        }
    }
}
