package com.example.cce.fazprotocolo.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.cce.fazprotocolo.R;
import com.example.cce.fazprotocolo.tipos.modeloProtocolos;

import java.io.Serializable;

public class ProtocoloSelecionado extends AppCompatActivity {

    private EditText edMorador;
    private EditText edAssunto;
    private EditText edTexto;
    private String morador;
    private String assunto;
    private String texto;

    public ProtocoloSelecionado() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protocolo_selecionado);

        findViews();
        setActions();

    }

    private void findViews() {
        edMorador = (EditText) findViewById(R.id.morador_le_prot);
        edAssunto = (EditText) findViewById(R.id.assunto_le_prot);
        edTexto = (EditText) findViewById(R.id.texto_le_prot);
    }

    private void setActions() {
        Serializable protSerializable =  getIntent().getSerializableExtra("Protocolo Selecionado");
        modeloProtocolos protocolo = (modeloProtocolos) protSerializable;

        edTexto.setText(protocolo.getCorpo());
        edAssunto.setText(protocolo.getAssunto());
        edMorador.setText(protocolo.getMorador().getNome());


    }
}
