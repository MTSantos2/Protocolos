package com.example.cce.fazprotocolo.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.cce.fazprotocolo.Auxiliares.ListaProtocolos;
import com.example.cce.fazprotocolo.R;
import com.example.cce.fazprotocolo.tipos.Item;

import java.util.ArrayList;

public class Protocolos extends AppCompatActivity {

    //Array utilizado para colocar itens e mostra-los na lista
    ArrayList<Item> lista = new ArrayList<Item>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protocolos);

        addToList();
        setVariables();
    }

    private void addToList(){
        //Criando itens a ser mostrados na lista(Feitos a mão até agora)
        Item a = new Item("Primeiro protocolo de teste","Zé","1234");
        Item b = new Item("Segundo Protocolo de teste","Tião", "910");
        Item c = new Item("Terceiro Protocolo de teste", "Marcelo", "1212");

        //Adicionando itens a lista
        lista.add(a);
        lista.add(b);
        lista.add(c);
    }

    private void setVariables() {
        //Instanciando Array adapter do tipo criado em ListaProtocolos.java
        ListaProtocolos listaProt = new ListaProtocolos(this, lista);
        //Setando valor na list view
        ListView listView = (ListView)findViewById(R.id.list_prot);
        listView.setAdapter(listaProt);
    }

}
