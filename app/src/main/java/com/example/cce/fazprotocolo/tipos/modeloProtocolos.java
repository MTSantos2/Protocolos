package com.example.cce.fazprotocolo.tipos;

//Objeto para cada protocolo

import com.example.cce.fazprotocolo.tipos.Morador;

import java.io.Serializable;

public class modeloProtocolos implements Serializable {

    //Propriedades dos protocolos
    private Long id;
    private String assunto;
    private String corpo;
    private Morador morador;

    public modeloProtocolos() {

    }

    //Método construtor
       public modeloProtocolos(Long id, String assunto, Morador morador, String corpo) {
        this.id = id;
        this.assunto = assunto;
        this.morador = morador;
        this.corpo = corpo;
    }

    //Métodos get
    public String getCorpo() {return corpo;}
    public Long getId() {return id;}
    public String getAssunto() {return assunto;}
    public Morador getMorador() {return morador;}

    //Métodos set

    public void setCorpo(String corpo) {this.corpo = corpo;}
    public void setId(Long id) {this.id = id;}
    public void setAssunto(String assunto) {this.assunto = assunto;}
    public void setMorador(Morador morador) {this.morador = morador;}

    @Override
    public String toString() {
        return "modeloProtocolos{" +
                "id=" + id +
                ", assunto='" + assunto + '\'' +
                ", corpo='" + corpo + '\'' +
                ", morador=" + morador +
                '}';
    }
}
