package com.example.cce.fazprotocolo.Activities;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cce.fazprotocolo.Auxiliares.Firebase;
import com.example.cce.fazprotocolo.R;
import com.example.cce.fazprotocolo.tipos.Morador;
import com.example.cce.fazprotocolo.tipos.modeloProtocolos;

import java.io.Serializable;
import java.util.Calendar;


public class EscreveProtocolo extends AppCompatActivity {

    Context context;
    private View mainContent;
    private Button button;
    private TextInputEditText edAssunto;
    private TextInputEditText edCorpo;
    private modeloProtocolos protocolo;
    private Serializable m;
    String dep = "";
    Spinner deps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escreve_protocolo);


        findViews();
        selecListaSpinner();
        setActions();
    }

    private void setActions(){
        //recebe da activity de login qual o usuário logado
//        Bundle data = getIntent().getExtras();
//        morador =  data.getSerializable("Morador logado");
        m = (Morador) getIntent().getSerializableExtra("Morador logado");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String assunto = edAssunto.getText().toString();
                String corpo = edCorpo.getText().toString();
                if( !assunto.isEmpty() && !corpo.isEmpty()){
                    Morador morador = (Morador) m;
                    Toast.makeText(context, morador.toString(), Toast.LENGTH_SHORT).show();
//                    long id = Calendar.getInstance().getTimeInMillis();
//                    protocolo = new modeloProtocolos(id, assunto, morador, corpo );
//                    new Firebase().SalvaProtocolo(protocolo, id);
                }else{
                }

            }
        });
    }

    private void findViews() {
        mainContent = findViewById(R.id.env_prot_activity);
        deps = (Spinner)findViewById(R.id.lista_deps_protocolo);
        edAssunto = (TextInputEditText)findViewById(R.id.assunto_protcolo);
        edCorpo = (TextInputEditText)findViewById(R.id.corpo_protcolo);
        button = (Button)findViewById(R.id.bt_enviar_protocolo);
    }

    //Seleciona o array definido em código salvo em deps como o que será mostrado na lista
    private void selecListaSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.deps, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        deps.setAdapter(adapter);
    }
    //Ação para a sleeção de item no spinner
//    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
//    }
//    public void onNothingSelected(AdapterView<?> arg0){
//
//    }
}
