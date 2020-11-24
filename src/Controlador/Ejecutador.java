package Controlador;

import Modelo.Registro;

import java.util.Scanner;

public class Ejecutador {

    public static void main (String[] args){

        Scanner teclado = new Scanner(System.in);
        Registro registro = null;
        System.out.print("Introduzca el número de registros que desea insertar: ");
        int registros = teclado.nextInt();
        System.out.print("Introduzca el número de hilos para insertar los registros: ");
        int nHilos = teclado.nextInt();
        int registrosPorHilo = registros / nHilos;
        int auxInicial = 0, auxFinal = 0, registrosRealizados = 0;

        for(int i = 1; i <= nHilos; i++){
            auxInicial = registrosPorHilo * i;
            auxFinal = auxInicial + 1;
            System.out.println("••••••••••••••••• HILO " + i + " •••••••••••••••••");
            registro = new Registro(auxInicial, auxFinal, registrosPorHilo);
            registro.start();
            registrosRealizados = (registrosRealizados + registrosPorHilo);//recogemos los registros que vamos realizando
            //Se calculan los registros sobrantes (si son números impares) para que se metan en el último hilo
            if(i == nHilos - 1){
                int restantes = registros - registrosRealizados;
                if (restantes > registrosPorHilo ){
                    registrosPorHilo = restantes;
                }
            }
            try {
                registro.join();
            } catch ( InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
}
