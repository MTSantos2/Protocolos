package com.example.cce.fazprotocolo.Auxiliares;

//Classe para criar novo modelo de list view do tipo item

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.cce.fazprotocolo.R;
import com.example.cce.fazprotocolo.tipos.Item;

import java.util.ArrayList;

public class ListaProtocolos extends ArrayAdapter<Item> {

    private Context contexto;
    private ArrayList<Item> lista;

    //Construtor padrão que recebe um array do tipo Item e o contexto
    public ListaProtocolos(Context contexto, ArrayList<Item> lista) {
        super(contexto,0,lista);
        this.contexto = contexto;
        this.lista = lista;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Pega o iten da lista da posição que o metodo get view é chamado
        Item itemPosicao = this.lista.get(position);
        //Puxa direto de modelo_prot.xml o modelo de como será cada item com o método inflate
        convertView = LayoutInflater.from(this.contexto).inflate(R.layout.modelo_prot,null);

        //Seta para cada textview do item especifico do array list
        TextView viewAssunto = (TextView) convertView.findViewById(R.id.ass_mod);
        viewAssunto.setText(itemPosicao.getAssunto());

        TextView viewNome = (TextView) convertView.findViewById(R.id.nome_mod);
        viewNome.setText(itemPosicao.getNome());

        TextView viewQuarto = (TextView) convertView.findViewById(R.id.quarto_mod);
        viewQuarto.setText(itemPosicao.getQuarto());

        return convertView;
    }
}
