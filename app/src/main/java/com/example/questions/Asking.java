package com.example.questions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Asking extends AppCompatActivity {

    private ArrayList<Question> questions = new ArrayList<>();
    private Question ask = new Question();
    private ArrayList<Answer> answers = new ArrayList<>();
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private TextView textView;
    private TextView title1;
    private ImageView imageView;
    private int count=1;
    private int sum=1;
    private int images[]={R.drawable.food, R.drawable.happy, R.drawable.sign, R.drawable.relation, R.drawable.lgtbi, R.drawable.cookies, R.drawable.profession, R.drawable.colours, R.drawable.look, R.drawable.travel};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        setContentView(R.layout.activity_asking);
        getSupportActionBar().hide();
        radioButton1 = findViewById(R.id.radio_button_1);
        radioButton2 = findViewById(R.id.radio_button_2);
        radioButton3 = findViewById(R.id.radio_button_3);
        radioButton4 = findViewById(R.id.radio_button_4);
        textView = findViewById(R.id.Textview1);
        title1=findViewById(R.id.title1);
        imageView=findViewById(R.id.image_view);
        FloatingActionButton fab = findViewById(R.id.floating_action_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater factory1 = LayoutInflater.from(getApplication());
                final View view1 = factory1.inflate(Integer.parseInt(String.valueOf(R.layout.sample+1)), null);
                    alerDialog("QR", "", 0, view1);
            }
        });
        ask.setAsk("¿Cuál es mi comida favorita?");
        answers.add(new Answer("Pastas", true));
        answers.add(new Answer("Mote de queso", false));
        answers.add(new Answer("Patacón", false));
        answers.add(new Answer("Ninguna de las anteriores", false));
        ask.setResponse(answers);
        questions.add(ask);
        answers=new ArrayList<>();
        answers.add(new Answer("15 de Abril", false));
        answers.add(new Answer("17 de Abril", false));
        answers.add(new Answer("16 de Abril", true));
        answers.add(new Answer("18 de Abril", false));
        questions.add(new Question("¿Qué día es mi cumpleaños?", answers));
        answers=new ArrayList<>();
        answers.add(new Answer("Aries", true));
        answers.add(new Answer("Piscis", false));
        answers.add(new Answer("Leo", false));
        answers.add(new Answer("Cancer", false));
        questions.add(new Question("Mi signo zodical es...", answers));
        answers=new ArrayList<>();
        answers.add(new Answer("Respeto, comunicación y apoyo mutuo", true));
        answers.add(new Answer("Respeto, amabilidad y sinceridad", false));
        answers.add(new Answer("Amabilidad, comunicación y amor", false));
        answers.add(new Answer("Sinceridad y amor", false));
        questions.add(new Question("Para ambos, ¿qué es lo mas importante en una relación?", answers));
        answers=new ArrayList<>();
        answers.add(new Answer("Muy atractivo", false));
        answers.add(new Answer("Nada atractivo", false));
        answers.add(new Answer("Atractivo", false));
        answers.add(new Answer("Un gay te ve y se enamora de ti (casi siempre)", true));
        questions.add(new Question("¿Que tan atractivo soy para las personas de mi mismo genero?", answers));
        answers=new ArrayList<>();
        answers.add(new Answer("Avena y miel", false));
        answers.add(new Answer("Chocolate y miel", false));
        answers.add(new Answer("Avena y chocolate blanco", true));
        answers.add(new Answer("Todas lass anteriores", false));
        questions.add(new Question("¿Si fuese una galleta de que sabor sería?", answers));
        answers=new ArrayList<>();
        answers.add(new Answer("Actor porno", false));
        answers.add(new Answer("Playboy", false));
        answers.add(new Answer("Ingeniero de Sistemas y telecomunicaciones", true));
        answers.add(new Answer("Stripper", false));
        questions.add(new Question("¿Cuál es mi profesión?", answers));
        answers=new ArrayList<>();
        answers.add(new Answer("Azul", false));
        answers.add(new Answer("Verde", false));
        answers.add(new Answer("Negro", false));
        answers.add(new Answer("Rojo", true));
        questions.add(new Question("¿Cuál es mi color favorito?", answers));
        answers=new ArrayList<>();
        answers.add(new Answer("Las piernas", false));
        answers.add(new Answer("La cintura", false));
        answers.add(new Answer("El trasero", false));
        answers.add(new Answer("Los labios", true));
        questions.add(new Question("¿Qué es lo primero que miro físicamente en una mujer?", answers));
        answers=new ArrayList<>();
        answers.add(new Answer("España o México", true));
        answers.add(new Answer("Argentina o España", false));
        answers.add(new Answer("Estados Unidos o España", false));
        answers.add(new Answer("Todas las anteriores", false));
        questions.add(new Question("En un futuro... ¿a que país pienso mudarme?", answers));
        textView.setText(questions.get(0).getAsk());
        radioButton1.setText(questions.get(0).getResponse().get(0).getReponse());
        radioButton2.setText(questions.get(0).getResponse().get(1).getReponse());
        radioButton3.setText(questions.get(0).getResponse().get(2).getReponse());
        radioButton4.setText(questions.get(0).getResponse().get(3).getReponse());

    }

    public void alerDialog(String title, String text, int drawable, View view) {
        new MaterialAlertDialogBuilder(this,R.style.RoundShapeTheme)
                .setIcon(drawable)
                .setTitle(title)
                .setView(view)
                .setMessage(text)
                .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .show();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void validation(RadioButton radioButton) {
        LayoutInflater factory = LayoutInflater.from(this);
        final View vie = factory.inflate(Integer.parseInt(String.valueOf(R.layout.sample+1)), null);
        if (radioButton.getText().equals(questions.get(0).getAnswer())) {
            alerDialog(" Tú progreso","¡Has acertado!", R.drawable.ic_check, vie);
            sum+=1;
        } else {
            alerDialog(" Tú progreso","¡Casi pero no!", R.drawable.ic_cancel, vie);
        }
    }

    public void aceptar(View view) throws InterruptedException {
        if (questions.size() > 0) {
            if (radioButton1.isChecked()) {
                validation(radioButton1);
            } else if (radioButton2.isChecked()) {
                validation(radioButton2);
            } else if (radioButton3.isChecked()) {
                validation(radioButton3);
            } else if (radioButton4.isChecked()) {
                validation(radioButton4);
            }
            if(questions.size()>1){
                count+=1;
                questions.remove(0);
                imageView.setImageResource(images[count-1]);
                title1.setText("Pregunta "+count);
                textView.setText(questions.get(0).getAsk());
                radioButton1.setText(questions.get(0).getResponse().get(0).getReponse());
                radioButton2.setText(questions.get(0).getResponse().get(1).getReponse());
                radioButton3.setText(questions.get(0).getResponse().get(2).getReponse());
                radioButton4.setText(questions.get(0).getResponse().get(3).getReponse());
            }else{
                alerDialog(" ¡Fin del juego!", "No hay mas preguntas por realizar",R.drawable.ic_sad,null);
            }
        }
    }
}