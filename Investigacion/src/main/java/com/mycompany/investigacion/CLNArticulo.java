
package com.mycompany.investigacion;


public class CLNArticulo implements ILNArticulo {
    
    private IDAOArticulo ArticuloDAO;
    
    public CLNArticulo(IDAOArticulo ArticuloDAO){
        this.ArticuloDAO = ArticuloDAO;
    }
    
    public void agregarArticulo(String nombre, String descripcion, int precio, int cantidad){
        //Logica de negocio
        String info = "Se agrego el articulo: " + nombre + " " + descripcion + " con un precio de " + precio + " y " + "cantidad de " + cantidad;
        ArticuloDAO.guardarArticulo(nombre, descripcion, precio, cantidad);
        new CPArticulo().mostrarInformacion(info);
    }
    
  
}


