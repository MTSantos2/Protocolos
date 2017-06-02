package com.example.cce.fazprotocolo.tipos;

//Classe criada para ser modelo de cada item da tela activity_protocolos.xml

public class Item {

    //Propriedades dos Itens
    private String assunto;
    private String nome;
    private String quarto;

    public Item(){

    }

    public Item (String assunto, String nome, String quarto){
        this.assunto = assunto;
        this.nome = nome;
        this.quarto = quarto;
    }

    //Métodos get
    public String getAssunto() {return assunto;}
    public String getNome() {return nome;}
    public String getQuarto() {return quarto;}

    //Métodos set
    public void setAssunto(String assunto) {this.assunto = assunto;}
    public void setNome(String nome) {this.nome = nome;}
    public void setQuarto(String quarto) {this.quarto = quarto;}

    @Override
    public String toString() {
        return "Item{" +
                "assunto='" + assunto + '\'' +
                ", nome='" + nome + '\'' +
                ", quarto='" + quarto + '\'' +
                '}';
    }
}

