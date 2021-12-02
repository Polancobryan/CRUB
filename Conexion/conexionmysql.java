/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author brpol
 */
public class conexionmysql {

    Connection con = null;

    //Clase para establecer conexión con mi Base De Datos.
    public conexionmysql(){

        var url = "jdbc:mysql://localhost:3306/trabajo_programacion?characterEncoding=latin1&useConfigs=maxPerformance";
        try {
            //Colocando la ruta de mi Base De Datos junto a mi usuario y contraseña para poder acceder al mismo.
            con = (Connection) DriverManager.getConnection(url, "root", "admin");
            //Mensaje para saber si la conexión fue exitosa.
            System.out.println("Conexión establecida");
        } catch (Exception e) {
            //Mensaje para saber si la conexión no fue exitosa, y a la vez, para conocer el motivo del mismo.
            System.out.println("Error de conexión: "+e);
        }

    }
    //Método para ejecutar las sentencias en MYSQL.
    public int ejecutarSentenciaMYSQL(String strSentenciaMYSQL){

        try {
            PreparedStatement pstm = (PreparedStatement) con.prepareStatement(strSentenciaMYSQL);
            pstm.execute();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }

    }
    //Método para llevar a cabo consultas en MYSQL.
    public ResultSet consultarRegistros(String strSentenciaMySQL){
        try {
            PreparedStatement pstm = (PreparedStatement)con.prepareStatement(strSentenciaMySQL);
            ResultSet respuesta = pstm.executeQuery();
            return respuesta;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}