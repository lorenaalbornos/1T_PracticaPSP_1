package Modelo;

import Vista.Formulario;

public class Registro extends Thread{

    private String email;
    private int ingresos;

    private int auxInicial;
    private int auxFinal;
    private int nRegistros;

    public Registro(){
        this.email ="";
        this.ingresos = 0;
    }

    public Registro(int auxInicial, int auxFinal, int nRegistros){
        this.auxInicial = auxInicial;
        this.auxFinal = auxFinal;
        this.nRegistros = nRegistros;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIngresos() {
        return ingresos;
    }

    public void setIngresos(int ingresos) {
        this.ingresos = ingresos;
    }

    @Override
    public void run() {
        insertarRegistro();
    }

    public synchronized  void insertarRegistro(){
        for (int i = auxInicial; i < auxFinal; i++){
            Formulario datos = new Formulario();
            datos.aleatorio(nRegistros);
        }
    }
}
