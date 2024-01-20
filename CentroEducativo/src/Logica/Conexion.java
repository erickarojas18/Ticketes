
package Logica;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Conexion {
     public static Connection getConexion() throws SQLException{
        String conexion = "jdbc:sqlserver://localhost:1433;"
                + "database=Escuela;"                
                + "user=sa;"
                + "password=123;"
                + "encrypt=true;trustServerCertificate=true;";
            
        
        try{
            Connection con = DriverManager.getConnection(conexion);
            System.out.println("Conexion realizada");
            return con;
 
        } catch(SQLServerException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
                
    }
   public static int InsertarProd(int id_estudiante,int Cedula, String Nombre,int Edad) throws SQLException {
        int rowsAffected = 0;

        Statement sql = (Statement) Conexion.getConexion().createStatement();
        String Qry = "Insert Into Estudiantes "
            + "Values (" + id_estudiante + "" + Cedula + ",'" + Nombre + "'," + Edad + ")";
        rowsAffected = sql.executeUpdate(Qry);
        
        return rowsAffected;
    }
   
      public static void Prueba() throws SQLException {
    
        String Deptos = "";
        try{
            Statement sql = (Statement) Conexion.getConexion().createStatement();
            String Qry = "Select* From Estudiantes";
            ResultSet resultado = sql.executeQuery(Qry);
            while(resultado.next()) {
                Deptos += resultado.getString(2) + "\n";
            }           
            JOptionPane.showMessageDialog(null, Deptos);
            
        } catch(SQLServerException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
     
}



//    public static void main(String[] args) throws SQLException {
//        Conexion conecta = new Conexion();
//        Connection con = Conexion.getConexion();
//    }
    

