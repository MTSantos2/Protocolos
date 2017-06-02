package com.example.cce.fazprotocolo.Activities;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;

import com.example.cce.fazprotocolo.Auxiliares.Firebase;
import com.example.cce.fazprotocolo.R;
import com.example.cce.fazprotocolo.tipos.Morador;

import java.util.Calendar;

public class CadastroActivity extends AppCompatActivity {

    private View mainContent;
    private Button button;
    private TextInputEditText edNome;
    private TextInputEditText edEmail;
    private TextInputEditText edQuarto;
    private TextInputEditText edSenha;
    private Morador morador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        findViews();
        setActions();

    }

    private void findViews(){
        mainContent = findViewById(R.id.cadastro_layout);
        button = (Button)findViewById(R.id.bt_cadastrar);
        edNome = (TextInputEditText)findViewById(R.id.Ed_nome_cad);
        edEmail = (TextInputEditText)findViewById(R.id.Ed_email_cad);
        edQuarto = (TextInputEditText)findViewById(R.id.Ed_quarto_cad);
        edSenha = (TextInputEditText)findViewById(R.id.Ed_senha_cad);
    }

    //Ação botão cadastrar
    private void setActions() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = edNome.getText().toString();
                String email = edEmail.getText().toString();
                String quarto = edQuarto.getText().toString();
                String senha = edSenha.getText().toString();
                if(!nome.isEmpty() && !email.isEmpty() && !quarto.isEmpty() && !senha.isEmpty()) {
                    long id = Calendar.getInstance().getTimeInMillis();
                    morador = new Morador(id,nome, email,senha,quarto);
                    new Firebase().SalvaMorador(morador, id);
                    finish();
                }else {
                    //Mensagem de erro caso aja campos em branco
                    Snackbar.make(mainContent, getString(R.string.cadastro_vazio), Snackbar.LENGTH_LONG)
                            .setAction("", null)
                            .show();
                }
            }
        });
    }
}
