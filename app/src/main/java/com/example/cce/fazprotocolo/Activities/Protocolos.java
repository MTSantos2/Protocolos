package com.example.cce.fazprotocolo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.cce.fazprotocolo.Auxiliares.ListaProtocolos;
import com.example.cce.fazprotocolo.R;
import com.example.cce.fazprotocolo.tipos.Item;
import com.example.cce.fazprotocolo.tipos.modeloProtocolos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Protocolos extends AppCompatActivity {

    public static final String TAG = "Lista de protocolos";

    //ArrayList utilizado para colocar itens e mostra-los na lista
    ArrayList<Item> lista = new ArrayList<Item>();

    private ListView listView;

    private List<modeloProtocolos> paraEnvio = new ArrayList<>();

    private FirebaseDatabase databaseProtocolo = FirebaseDatabase.getInstance();
    private DatabaseReference protocoloDatabase = databaseProtocolo.getReference("Protocolos");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protocolos);
        findViews();
        setActions();
    }

    private void setActions(){
        leProtocolos();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int i = position;
                goToProtocoloSelecionado(i);
            }
        });
    }

    private void goToProtocoloSelecionado(int i) {
        Intent intent = new Intent(Protocolos.this, ProtocoloSelecionado.class);
        Bundle extras = new Bundle();
        //Envia o protocolo que foi selecionado para a view de apresentação
        extras.putSerializable("Protocolo Selecionado", (Serializable) paraEnvio.get(i));
        intent.putExtras(extras);
        startActivity(intent);
    }

    private void findViews() {

        listView = (ListView)findViewById(R.id.list_prot);
    }

    private void addToList(ArrayList<modeloProtocolos> prot) {
        paraEnvio = prot;
        for(int i = 0; i< prot.size();i++ ) {
            Item a = new Item(prot.get(i).getAssunto(),prot.get(i).getMorador().getNome(),prot.get(i).getMorador().getQuarto());
            lista.add(a);
        }

    }

    private void setlist() {
        //Instanciando Array adapter do tipo criado em ListaProtocolos.java
        ListaProtocolos listaProt = new ListaProtocolos(this, lista);
        //Setando valor na list view
        listView.setAdapter(listaProt);
    }

    private void leProtocolos() {
        protocoloDatabase.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<modeloProtocolos> protocolo = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    protocolo.add(snapshot.getValue(modeloProtocolos.class));
                }
                addToList((ArrayList<modeloProtocolos>) protocolo);
                setlist();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Falha na leitura da lista ", error.toException());
            }
        });
    }
}
