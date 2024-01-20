
package com.mycompany.investigacion;

import java.util.Scanner;


public class Investigacion {

     public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArticuloDAO ArticuloDAO = new ArticuloDAO(); 
        CLNArticulo ArticuloService = new CLNArticulo(ArticuloDAO); 
        CEditar Articulo = new CEditar(); 
        
        try {
            while (true) {
                System.out.println("Menú:");
                System.out.println("1. Agregar Articulo");
                System.out.println("2. Modificar Articulo");
                System.out.println("3. Salir");
                System.out.print("Elija una opción: ");
                int opcion = sc.nextInt();
                sc.nextLine(); // Consumir la nueva línea

                switch (opcion) {
                    case 1:
                        // Opción para agregar una prenda
                        System.out.println("Digite el nombre del articulo: ");
                        String nom = sc.nextLine();
                        System.out.println("Digite la descripcion del articulo : ");
                        String des = sc.nextLine();
                        System.out.println("Digite el precio del articulo : ");
                        int pre = sc.nextInt();
                        System.out.println("Digite  la cantidad del articulo : ");
                        int cant = sc.nextInt();
                        sc.nextLine(); // Consumir la nueva línea
                        ArticuloService.agregarArticulo(nom, des, pre,cant);
                        break;

                    case 2:
                        // Opción para modificar una prenda
                        System.out.println("Digite el nombre del articulo a modificar: ");
                        String descrpcionModificar = sc.nextLine();
                        System.out.println("Digite el nuevo nombre del articulo : ");
                        String nuevoNombre = sc.nextLine();
                        System.out.println("Digite el nuevo precio del articulo : ");
                        int nuevoPrecio = sc.nextInt();
                        System.out.println("Digite una nueva cantidad ");
                        int cantidad = sc.nextInt();
                        sc.nextLine(); // Consumir la nueva línea
                        Articulo.modificarArticulo(nuevoNombre, descrpcionModificar, nuevoPrecio,cantidad); // Usa el método adecuado para modificar
                        ArticuloService.agregarArticulo(nuevoNombre, descrpcionModificar, nuevoPrecio,cantidad);
                        break;

                    case 3:
                        // Opción para salir del programa
                        sc.close(); // Cerrar el scanner
                        return;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close(); // Cerrar el scanner al salir del programa
        }
    }

    
}
