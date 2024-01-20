
package com.mycompany.practicalab1;


public class Planeta {
    // Enumeración para el tipo de planeta
    public enum TipoPlaneta {
        GASEOSO, TERRESTRE, ENANO
    }

    // Atributos del planeta
    private String nombre;
    private int cantidadSatelites;
    private double masa;
    private double volumen;
    private int diametro;
    private int distanciaMediaAlSol;
    private TipoPlaneta tipo;
    private boolean observableSimpleVista;

    // Constructor
    public Planeta(String nombre, int cantidadSatelites, double masa, double volumen, int diametro, int distanciaMediaAlSol, TipoPlaneta tipo, boolean observableSimpleVista) {
        this.nombre = nombre;
        this.cantidadSatelites = cantidadSatelites;
        this.masa = masa;
        this.volumen = volumen;
        this.diametro = diametro;
        this.distanciaMediaAlSol = distanciaMediaAlSol;
        this.tipo = tipo;
        this.observableSimpleVista = observableSimpleVista;
    }

    // Método para imprimir los valores de los atributos
    public void imprimirInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Cantidad de Satélites: " + cantidadSatelites);
        System.out.println("Masa (kg): " + masa);
        System.out.println("Volumen (km^3): " + volumen);
        System.out.println("Diámetro (km): " + diametro);
        System.out.println("Distancia Media al Sol (millones de km): " + distanciaMediaAlSol);
        System.out.println("Tipo de Planeta: " + tipo);
        System.out.println("Observable a simple vista: " + observableSimpleVista);
    }

    // Método para calcular la densidad del planeta
    public double calcularDensidad() {
        return masa / volumen;
    }

    // Método para determinar si el planeta es exterior
    public boolean esExterior() {
        double distanciaEnMillonesDeKm = distanciaMediaAlSol * 149597870; // Convertir UA a km
        return (distanciaEnMillonesDeKm > 3400 || distanciaEnMillonesDeKm < 2100);
    }

    public static void main(String[] args) {
        // Crear dos planetas
        Planeta planeta1 = new Planeta("Júpiter", 79, 1.898e27, 1.43128e15, 139822, 778, TipoPlaneta.GASEOSO, true);
        Planeta planeta2 = new Planeta("Tierra", 1, 5.972e24, 1.08321e12, 12742, 149, TipoPlaneta.TERRESTRE, true);

        // Imprimir información de los planetas
        System.out.println("Información del Planeta 1:");
        planeta1.imprimirInformacion();
        System.out.println("Densidad del Planeta 1: " + planeta1.calcularDensidad() + " kg/km^3");
        System.out.println("¿Planeta 1 es un planeta exterior? " + planeta1.esExterior());
        
        System.out.println("\nInformación del Planeta 2:");
        planeta2.imprimirInformacion();
        System.out.println("Densidad del Planeta 2: " + planeta2.calcularDensidad() + " kg/km^3");
        System.out.println("¿Planeta 2 es un planeta exterior? " + planeta2.esExterior());
    }
}
