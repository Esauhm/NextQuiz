package sv.edu.catolica.nextquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PreguntaActivity extends AppCompatActivity {

    private ConstraintLayout optionContainer;
    private Button btnNext;
    TextView question, totalQuestion, Ettimer;

    ArrayList<QuestionModel> list = new ArrayList<>();

    private int count = 0;

    private int position = 0;

    private int score = 0;
    private int acumulador = 0;

    private LinearLayout principal;

    CountDownTimer timer;

    String setName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        optionContainer = findViewById(R.id.optionContainer);
        btnNext = findViewById(R.id.btnNext);
        question = findViewById(R.id.question);
        totalQuestion = findViewById(R.id.totalQuestion);
        Ettimer = findViewById(R.id.timer);
        principal = findViewById(R.id.lLprincipal);



        resetTimer();
        timer.start();

        setName = getIntent().getStringExtra("set");

        if(setName.equals("Questionario1")){
            //principal.setBackgroundResource(R.drawable.fondop_img);
            setOne();
        } else if (setName.equals("Questionario2")){
            setTwo();
        }


        for(int i = 0; i<4; i++){
            acumulador=0;

            optionContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  acumulador =  RevisarRespuesta((Button) v);

                }
            });
        }

        playAnimation(question, 0, list.get(position).getQuestion());

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(timer != null){
                    timer.cancel();
                }

                timer.start();
                btnNext.setEnabled(false);
                btnNext.setAlpha((float) 0.3);
                enableOption(true);
                position++;

                score += acumulador;


                if(position == list.size()){
                    //Aqui vamos a mandar un codigo de puntaje para el otro lado solo mostrar la imagen
                    Intent intent = new Intent(PreguntaActivity.this, ResultadoActivity.class);
                    intent.putExtra("src", score);
                    intent.putExtra("cst", setName);
                    startActivity(intent);
                    timer.cancel();
                    finish();
                    return;


                }

                count = 0;

                playAnimation(question, 0, list.get(position).getQuestion());



            }
        });


    }

    private void resetTimer() {
        timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Ettimer.setText(String.valueOf(millisUntilFinished/1000));
            }


            @Override
            public void onFinish() {
                Dialog dialog = new Dialog(PreguntaActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.tiempo_dialog);
                dialog.findViewById(R.id.btn_tiempo_fin).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PreguntaActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
                dialog.show();
            }
        };
    }

    private void playAnimation(TextView question, int value, String data) {

        question.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(@NonNull Animator animation) {
                        if(value == 0 && count <4){
                            String option = "";

                            if(count == 0){
                                option = list.get(position).getOptionA();

                            }else if (count == 1){
                                option = list.get(position).getOptionB();

                            }else if(count == 2){
                                option = list.get(position).getOptionC();

                            }else if (count == 3){
                                option = list.get(position).getOptionD();
                            }

                            playAnimation((TextView) optionContainer.getChildAt(count), 0, option);
                            count ++;
                        }
                    }

                    @Override
                    public void onAnimationEnd(@NonNull Animator animation) {

                        if(value == 0){

                            try {
                                ((TextView)question).setText(data);
                                totalQuestion.setText(position+1+"/"+list.size());
                            }catch (Exception e){
                                ((Button)question).setText(data);
                            }

                            question.setTag(data);
                            playAnimation(question, 1, data);




                        }

                    }

                    @Override
                    public void onAnimationCancel(@NonNull Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(@NonNull Animator animation) {

                    }
                });

    }


    private void enableOption(boolean enable) {
        for (int i=0; i<4; i++){
            optionContainer.getChildAt(i).setEnabled(enable);

            if(enable){
                optionContainer.getChildAt(i).setBackgroundResource(R.drawable.btn_questions);
            }
        }


    }

    private Button botonSeleccionado;
    private int RevisarRespuesta(Button opcionSeleccionada) {
        int puntos=0;
        if(timer != null){
            timer.cancel();
        }


        if (botonSeleccionado != null && botonSeleccionado != opcionSeleccionada) {
            botonSeleccionado.setBackgroundResource(R.drawable.btn_questions);
        }

        opcionSeleccionada.setBackgroundResource(R.drawable.btn_seleccionado);
        botonSeleccionado = opcionSeleccionada;

        btnNext.setEnabled(true);
        btnNext.setAlpha(1);

        if(opcionSeleccionada.getText().toString().equals(list.get(position).getOptionA())){
            puntos = 1;
        } else if (opcionSeleccionada.getText().toString().equals(list.get(position).getOptionB())){
            puntos = 2;
        } else if (opcionSeleccionada.getText().toString().equals(list.get(position).getOptionC())){
            puntos = 3;
        } else if (opcionSeleccionada.getText().toString().equals(list.get(position).getOptionD())){
            puntos = 4;
        }
        return puntos;
    }

    private void setTwo() {

        list.add(new QuestionModel("Preguntas cuationario 2 Quien es mas alto?", "1", "2", "3", "4"));
        list.add(new QuestionModel(" Preguntas cuationario 2 Quien es mas gordo?", "5", "6", "7", "8"));
        list.add(new QuestionModel("Preguntas cuationario 2 Quien es mas alto?", "10", "2", "3", "4"));
        list.add(new QuestionModel(" Preguntas cuationario 2 Quien es mas gordo?", "11", "6", "7", "8"));
    }

    private void setOne() {

        list.add(new QuestionModel(" Preguntas cuationario 1 Quien es mas alto?", "1", "2", "3", "4"));
        list.add(new QuestionModel(" Preguntas cuationario 1 Quien es mas gordo?", "5", "6", "7", "8"));
    }
}