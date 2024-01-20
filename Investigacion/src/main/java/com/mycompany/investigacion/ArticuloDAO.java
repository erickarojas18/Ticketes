
package com.mycompany.investigacion;

import java.io.*;

/**
 * capa de datos
 */
public class ArticuloDAO implements IDAOArticulo{
    
 public void guardarArticulo(String nombre, String descripcion, int precio, int cantidad) {
        // Lógica de negocio
        String articuloData = "Nombre: " + nombre + " Descripcion: " + descripcion + " Precio: " + precio + " Cantidad: " + cantidad;
        String filePath = "inventario.txt";

        try {
            // Agrega el nuevo artículo o modifica el existente
            agregarOActualizarArticulo(filePath, nombre, descripcion, precio, cantidad);
            
            System.out.println("Articulo agregado o actualizado en el inventario\n");
        } catch (IOException e) {
            System.out.println("Error al guardar el articulo en el inventario: " + e.getMessage());
        }
    }

    public void agregarOActualizarArticulo(String filePath, String nombre, String descripcion, int precio, int cantidad) throws IOException {
        File archivo = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true));  // True para agregar al final del archivo

        String linea;
        boolean articuloExistente = false;
        StringBuilder nuevoContenido = new StringBuilder();

        // Realiza las modificaciones necesarias y verifica si el artículo ya existe
        while ((linea = br.readLine()) != null) {
            if (linea.contains("Nombre: " + nombre + " Descripcion: " + descripcion)) {
                // El artículo ya existe, realiza las modificaciones
                articuloExistente = true;
                linea = "Nombre: " + nombre + " Descripcion: " + descripcion + " Precio: " + precio + " Cantidad: " + cantidad;
            }
            nuevoContenido.append(linea).append("\n");
        }

        // Si el artículo no existe, agrégalo al final del archivo
        if (!articuloExistente) {
            String nuevoArticulo = "Nombre: " + nombre + " Descripcion: " + descripcion + " Precio: " + precio + " Cantidad: " + cantidad;
            nuevoContenido.append(nuevoArticulo).append("\n");
        }

        // Cierra el archivo de entrada
        br.close();

        // Reescribe el archivo con los cambios
        bw.write(nuevoContenido.toString());
        bw.close();
    }
}
