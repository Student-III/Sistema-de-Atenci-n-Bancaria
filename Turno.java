
package com.mycompany.sistemaatencionbancaria;

public class Turno {
    private String numeroturno;
    private String nombrecliente;
    private String tipocliente;
    private int minutosespera;

    public Turno(String numeroturno, String nombrecliente, String tipocliente, int minutosespera) {
        this.numeroturno = numeroturno;
        this.nombrecliente = nombrecliente;
        this.tipocliente = tipocliente;
        this.minutosespera = minutosespera;
    }

    public String getNumeroturno() {
        return numeroturno;
    }

    public void setNumeroturno(String numeroturno) {
        this.numeroturno = numeroturno;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getTipocliente() {
        return tipocliente;
    }

    public void setTipocliente(String tipocliente) {
        this.tipocliente = tipocliente;
    }

    public int getMinutosespera() {
        return minutosespera;
    }

    public void setMinutosespera(int minutosespera) {
        this.minutosespera = minutosespera;
    }
    
    
}
