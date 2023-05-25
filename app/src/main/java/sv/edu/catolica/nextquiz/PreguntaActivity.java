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

import java.util.ArrayList;

public class PreguntaActivity extends AppCompatActivity {

    private ConstraintLayout optionContainer;
    private Button btnNext;

    TextView question, totalQuestion, Ettimer;

    ArrayList<QuestionModel> list = new ArrayList<>();

    private int count = 0;

    private int position = 0;

    private int score = 0;

    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);

        optionContainer = findViewById(R.id.optionContainer);
        btnNext = findViewById(R.id.btnNext);
        question = findViewById(R.id.question);
        totalQuestion = findViewById(R.id.totalQuestion);
        Ettimer = findViewById(R.id.timer);

        resetTimer();
        timer.start();

        String setName = getIntent().getStringExtra("set");

        if(setName.equals("Questionario1")){
            setOne();
        } else if (setName.equals("Questionario2")){
            setTwo();
        }


        for(int i = 0; i<4; i++){
            optionContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    RevisarRespuesta((Button) v);
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

                if(position == list.size()){
                    //Aqui vamos a mandar un codigo de puntaje para el otro lado solo mostrar la imagen
                    Intent intent = new Intent(PreguntaActivity.this, ResultadoActivity.class);
                    //intent.putExtra()
                    startActivity(intent);
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
                optionContainer.getChildAt(i).setBackgroundResource(R.drawable.btn_continuar);
            }
        }


    }

    private void RevisarRespuesta(Button opcionSeleccionada) {
        if(timer != null){
            timer.cancel();
        }

        btnNext.setEnabled(true);
        btnNext.setAlpha(1);

        opcionSeleccionada.setBackgroundResource(R.drawable.btn_seleccionado);
    }

    private void setTwo() {

        list.add(new QuestionModel("Preguntas cuationario 2 Quien es mas alto?", "1", "2", "3", "4"));
        list.add(new QuestionModel(" Preguntas cuationario 2 Quien es mas gordo?", "5", "6", "7", "8"));
    }

    private void setOne() {

        list.add(new QuestionModel(" Preguntas cuationario 1 Quien es mas alto?", "1", "2", "3", "4"));
        list.add(new QuestionModel(" Preguntas cuationario 1 Quien es mas gordo?", "5", "6", "7", "8"));
    }
}