package com.example.cce.fazprotocolo.tipos;

//Objeto para cada morador

import java.io.Serializable;

public class Morador implements Serializable {

    //Propriedades dos moradores
    private static final long serialVersionUID = 1L;
    private long id;
    private String nome;
    private String email;
    private String senha;
    private String quarto;

    public Morador(){

    }

    //Método construtor


    public Morador(long id, String nome, String email, String senha, String quarto) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.quarto = quarto;
    }

    //Métodos de get
    public long getId() {return id;}
    public String getNome() {return nome;}
    public String getEmail() {return email;}
    public String getQuarto() {return quarto;}
    public String getSenha() {return senha;}

    //Métodos set
    public void setId(long id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setEmail(String email) {this.email = email;}
    public void setQuarto(String quarto) {this.quarto = quarto;}
    public void setSenha(String senha) {this.senha = senha;}

    @Override
    public String toString() {
        return "Morador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", quarto=" + quarto +
                '}';
    }
}
