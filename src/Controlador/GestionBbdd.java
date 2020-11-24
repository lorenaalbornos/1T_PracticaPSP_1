package Controlador;

import Modelo.Registro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GestionBbdd {

    public void insertar(Registro r){
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/BBDD_PSP_1", "DAM2020_PSP", "DAM2020_PSP");
            // Crear consulta
            Statement consulta = conexion.createStatement();
            consulta.executeUpdate("insert into empleados (email, ingresos) values('" + r.getEmail() + "',"
                    + r.getIngresos() + ")");
            conexion.close();
            System.out.println("Articulo introducido correctamente");
            System.out.println("••••••••••••••••••••••••••••••••••••••••••");
        } catch (SQLException e) {
            System.out.println("No es posible conectarse a la base de datos");
            e.printStackTrace();
        }
    }
}
