package com.example.cce.fazprotocolo.Activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cce.fazprotocolo.R;

import static android.R.id.message;

public class SelecDepActivity extends AppCompatActivity {

    private Button btInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selec_dep);
        findViews();
        setActions();
    }

    private void findViews() {
        btInfo = (Button)findViewById(R.id.bt_inf);
    }

    private void goToProtocolos() {
        Intent intent = new Intent(this,Protocolos.class);
        startActivity(intent);
    }

    private void setActions() {
        //Ação do botão informatica
        btInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToProtocolos();
            }
        });
    }

}
