package com.example.cce.fazprotocolo.Auxiliares;

//Classe criada para facilitar o uso do firebase e a reutilizaçção do codigo

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.cce.fazprotocolo.Activities.MainActivity;
import com.example.cce.fazprotocolo.tipos.Morador;
import com.example.cce.fazprotocolo.tipos.modeloProtocolos;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Firebase {

    private static final String TAG = "Firebase";

    private FirebaseDatabase databaseMorador = FirebaseDatabase.getInstance();
    private DatabaseReference moradorDatabase = databaseMorador.getReference("Moradores");

    private FirebaseDatabase databaseProtocolo = FirebaseDatabase.getInstance();
    private DatabaseReference protocoloDatabase = databaseProtocolo.getReference("Protocolos");

    public void SalvaMorador( Morador morador, long id) {
        moradorDatabase.child(String.valueOf(id)).setValue(morador);
    }

    public void SalvaProtocolo (modeloProtocolos protocolo, long id) {
        protocoloDatabase.child(String.valueOf(id)).setValue(protocolo);
    }


}
