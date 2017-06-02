package com.example.cce.fazprotocolo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.cce.fazprotocolo.R;

public class SelecDepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selec_dep);
    }

    //Ação do botão informatica
    public void vaiProtosInfo (View view){
        Intent intent = new Intent(this, Protocolos.class);
        startActivity(intent);
    }
}
