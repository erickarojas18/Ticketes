
package com.mycompany.practicalab1;


import java.util.ArrayList;
import java.util.List;

class EstacionPeaje {
    private String nombre;
    private String departamento;
    private int valorTotalPeaje;

    public EstacionPeaje(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.valorTotalPeaje = 0;
    }

    public void cobrarPeaje(Vehiculo vehiculo) {
        int valorPeaje = 0;

        if (vehiculo instanceof Carro) {
            valorPeaje = 1000;
        } else if (vehiculo instanceof Moto) {
            valorPeaje = 700;
        } else if (vehiculo instanceof Camion) {
            Camion camion = (Camion) vehiculo;
            valorPeaje = 5000 * camion.getNumEjes();
        }

        valorTotalPeaje += valorPeaje;
        System.out.println("Vehículo con placa " + vehiculo.getPlaca() + " pagó " + valorPeaje + " colones.");
    }

    public void imprimirTotalPeajesRecolectados() {
        System.out.println("Total de peajes recolectados en la estación de peaje " + nombre + " (" + departamento + "): " + valorTotalPeaje + " colones.");
    }
}

class Vehiculo {
    private String placa;

    public Vehiculo(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }
}

class Carro extends Vehiculo {
    public Carro(String placa) {
        super(placa);
    }
}

class Moto extends Vehiculo {
    public Moto(String placa) {
        super(placa);
    }
}

class Camion extends Vehiculo {
    private int numEjes;

    public Camion(String placa, int numEjes) {
        super(placa);
        this.numEjes = numEjes;
    }

    public int getNumEjes() {
        return numEjes;
    }
}

public class SistemaPeaje {
    public static void main(String[] args) {
        EstacionPeaje estacion = new EstacionPeaje("Estación A", "Departamento X");

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Carro("ABC123"));
        vehiculos.add(new Moto("DEF456"));
        vehiculos.add(new Camion("GHI789", 3));

        for (Vehiculo vehiculo : vehiculos) {
            estacion.cobrarPeaje(vehiculo);
        }

        estacion.imprimirTotalPeajesRecolectados();
    }
}
