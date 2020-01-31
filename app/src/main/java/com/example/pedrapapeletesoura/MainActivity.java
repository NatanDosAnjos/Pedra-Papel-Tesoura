package com.example.pedrapapeletesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView pedra;
    ImageView papel;
    ImageView tesoura;
    ImageView npcImage;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pedra       = findViewById(R.id.imagePedra);
        papel       = findViewById(R.id.imagePapel);
        tesoura     = findViewById(R.id.imageTesoura);
        npcImage = findViewById(R.id.imageNpc);
        resultado   = findViewById(R.id.textView);
    }

    private String aleatorio() {
        int random = (int)(Math.random()*3);

        switch(random) {
            case 0:
                npcImage.setImageResource(R.drawable.pedra);
                return "Pedra";

            case 1:
                npcImage.setImageResource(R.drawable.papel);
                return "Papel";

            case 2:
                npcImage.setImageResource(R.drawable.tesoura);
                return "Tesoura";

        }
        return "p";
    }

    public void jogada(String jogador) {
        String npc = aleatorio();

        if (jogador == npc) {
            resultado.setText("Empate !");
        }

        else if ((jogador == "Pedra" && npc == "Tesoura") || (jogador == "Tesoura" && npc == "Papel") || (jogador == "Papel" && npc == "Pedra")) {
            resultado.setText("Parabéns Você GANHOU :)");
        }
        else {
            resultado.setText("Você perdeu ;(");
        }

    }

    public void zerar(View view) {
        npcImage.setImageResource(R.drawable.padrao);
        resultado.setText("");
    }

    public void escolhePedra(View view) {
        this.jogada("Pedra");
    }

    public void escolhePapel(View view) {
        this.jogada("Papel");
    }

    public void escolheTesoura(View view) {
        this.jogada("Tesoura");
    }
}
