//Tela de login
package com.example.cce.fazprotocolo.Activities;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.design.widget.TextInputEditText;
import android.widget.Button;

import com.example.cce.fazprotocolo.R;
import com.example.cce.fazprotocolo.tipos.Morador;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final String TAG = "Login";

    private FirebaseDatabase databaseMorador = FirebaseDatabase.getInstance();
    private DatabaseReference moradorDatabase = databaseMorador.getReference("Moradores");

    private View mainContent;
    private TextInputEditText email;
    private TextInputEditText senha;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setActions();
    }
    //Função para botão de novo cadastro
    public void goCadastro(View view) {
        Intent cadastrar = new Intent(this,CadastroActivity.class);
        startActivity(cadastrar);
    }
    private void setActions() {
        //Função para botão de entrar
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!email.getText().toString().equals("") && !senha.getText().toString().equals("")) {
                    LeMoradores();
                }else{
                    //Mensagem de erro caso aja campos em branco
                    Snackbar.make(mainContent,getText(R.string.login_vazio),Snackbar.LENGTH_SHORT)
                            .setAction("",null)
                            .show();
                }
            }
        });
    }
    //Função para botão ler protocolos
    public void ler (View view){
        Intent lerProt = new Intent(this, SelecDepActivity.class);
        startActivity(lerProt);
        lerProt.putExtra("deps",1);
    }

    private void findViews (){
        mainContent = findViewById(R.id.login_layout);
        button = (Button)findViewById(R.id.bt_login);
        email = (TextInputEditText)findViewById(R.id.Ed_email_login);
        senha = (TextInputEditText)findViewById(R.id.Ed_senha_login);

    }

    private void goToEscreveProtocolos(Morador morador){
        Intent intent = new Intent(MainActivity.this, EscreveProtocolo.class);
        startActivity(intent);
        Bundle extras = new Bundle();
        //Envia a informação de qual usuário se logou para a próxima activity
        extras.putSerializable("Morador logado", morador);
        intent.putExtras(extras);
        finish();
    }

    public void LeMoradores (){

        //Mantém valor sempre atualizado no banco
        moradorDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<Morador> moradores = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    moradores.add(snapshot.getValue(Morador.class));
                }
                autenticacao((ArrayList<Morador>) moradores);
            }

            //Se verificação no banco der errado
            @Override
            public void onCancelled(DatabaseError error) {
                Log.w(TAG, "Falha na leitura da lista ", error.toException());
            }
        });

    }

    public void autenticacao(ArrayList<Morador> lista) {
        Morador m ;
        for(int i = 0; i < lista.size(); i++){
            m = lista.get(i);
            Snackbar.make(mainContent,m.toString(),Snackbar.LENGTH_SHORT)
                    .setAction("",null)
                    .show();
            if (m.getEmail().equals(email.getText().toString())){
                if (m.getSenha().equals(senha.getText().toString())){
                    goToEscreveProtocolos(m);
                }else{
                    //Mensagem de erro caso senha esteja incorreta
                    Snackbar.make(mainContent,getText(R.string.lg_senha_errada),Snackbar.LENGTH_SHORT)
                            .setAction("",null)
                            .show();
                    i = lista.size();

                }
            }else{
                //Mensagem de erro caso email esteja incorreto
                Snackbar.make(mainContent,getText(R.string.lg_email_errado),Snackbar.LENGTH_SHORT)
                        .setAction("",null)
                        .show();
            }
        }
    }
}
