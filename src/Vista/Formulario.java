package Vista;

import Controlador.GestionBbdd;
import Modelo.Registro;

import java.util.Random;

public class Formulario {

    public void aleatorio(int nRegistros){
        Registro registro = null;
        GestionBbdd gBbdd = new GestionBbdd();
    //PARA GENERAR EL EMAIL Y EL INGRESO ALEATORIO
        String letras = "abcdefghijklmnopqrstuvwxyz123456789";
        String emailAleat = "";
        String email = "@hotmail.com";
        Random random = new Random();
        int ingresosAleat = 0;
        char[] nombre = new char[8];
    //Bucle que genere las veces que le diga el usuario los registros
        for(int i = 1; i <= nRegistros; i++){
            registro = new Registro();
            //generamos los nombres aleatorios
            for(int x = 0; x < nombre.length; x++){
                nombre[x] = letras.charAt(random.nextInt(letras.length()));
                emailAleat += nombre[x];
            }
            System.out.println("El email es: " + emailAleat + email);
            registro.setEmail(emailAleat + email); //Se le añade @hotmail.com
            ingresosAleat = (int) ((Math.random() * 1000) + 10);
            System.out.println("Su ingreso es de: " + ingresosAleat);
            registro.setIngresos(ingresosAleat);
            //insertamos el registro en la bbdd
            gBbdd.insertar(registro);
        }
    }
}
