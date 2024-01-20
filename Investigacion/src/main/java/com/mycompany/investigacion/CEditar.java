
package com.mycompany.investigacion;

import java.io.*;

public class CEditar implements lEditar {
    
    public void modificarArticulo(String inventario, String antiguoNombre, String nuevoNombre, String antiguoCodigo, String nuevoCodigo, String antiguoPrecio, String nuevoPrecio) {
        try {
            // Abre el archivo en modo lectura/escritura
            File archivo = new File(inventario);
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false)); // Sobrescribe el archivo

            String linea;
            StringBuilder nuevoContenido = new StringBuilder();

            // Realiza las modificaciones necesarias
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 3) {
                    String nombre = partes[0];
                    String codigo = partes[1];
                    String precio = partes[2];

                    if (nombre.equals(antiguoNombre)) {
                        nombre = nuevoNombre;
                    }
                    if (codigo.equals(antiguoCodigo)) {
                        codigo = nuevoCodigo;
                    }
                    if (precio.equals(antiguoPrecio)) {
                        precio = nuevoPrecio;
                    }

                    String lineaModificada = nombre + "," + codigo + "," + precio;
                    nuevoContenido.append(lineaModificada).append("\n");
                }
            }

            // Cierra el archivo de entrada
            br.close();

            // Reescribe el archivo con los cambios
            bw.write(nuevoContenido.toString());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void modificarArticulo(String nombre, String descripcion, int precio, int cantidad) {
        
    }
}

    
