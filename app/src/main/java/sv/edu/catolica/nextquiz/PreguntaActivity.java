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
        }else if (setName.equals("Questionario3")){
            setThree();
        }else if (setName.equals("Questionario4")){
            setFour();
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


    //Preguntas de Dragon Ball
    private void setOne() {

        list.add(new QuestionModel("¿Cuál es tu estilo de lucha preferido?", "a) Velocidad y agilidad", "b) Fuerza y poder físico", "c) Técnicas de energía y ataques a distancia", "d) Estrategia y astucia"));
        list.add(new QuestionModel("¿Cuál es tu motivación principal en la vida?", "a) Proteger a tus seres queridos", "b) Superar tus propios límites", "c) Conseguir la paz y justicia en el mundo", "d) Obtener poder y dominio absoluto"));
        list.add(new QuestionModel("¿Cómo describirías tu personalidad en batalla?", "a) Apasionado y valiente", "b) Determinado y tenaz", "c) Justiciero y noble", "d) Calculador y frío"));
        list.add(new QuestionModel("¿Cuál sería tu ataque especial característico?", "a) Kamehameha", "b) Puño del Dragón", "c) Genkidama", "d) Esfera de Energía"));
        list.add(new QuestionModel("¿Cuál es tu transformación o estado de poder favorito?", "a) Super Saiyan", "b) Ultra Instinto", "c) Super Saiyan Blue", "d) Forma de Majin Buu"));
        list.add(new QuestionModel("¿Cómo te gusta entrenar para mejorar tus habilidades?", "a) Entrenamiento intensivo y físico", "b) Meditación y concentración mental", "c) Práctica constante de técnicas y movimientos", "d) Estudio y análisis de tácticas de combate"));
        list.add(new QuestionModel("¿Cuál es tu comida favorita?", "a) Arroz y carne a la parrilla", "b) Tarta de manzana", "c) Pescado fresco", "d) Cualquier cosa que sea deliciosa"));
        list.add(new QuestionModel("¿Cuál es tu relación con tus compañeros de equipo?", "a) Proteges y cuidas de ellos", "b) Compites y te desafías mutuamente", "c) Te unes para luchar por una causa común", "d) Los utilizas para alcanzar tus propios objetivos"));
        list.add(new QuestionModel("¿Cómo reaccionas ante una amenaza poderosa?", "a) Te enfrentas directamente, sin temor", "b) Te esfuerzas al máximo para superarla", "c) Analizas la situación y buscas una solución estratégica", "d) Utilizas tus habilidades de manipulación para enfrentarla"));
        list.add(new QuestionModel("¿Cuál es tu deseo más profundo si pudieras invocar al dragón Shenlong?", "a) Recuperar a un ser querido fallecido", "b) Obtener poder ilimitado", "c) Conseguir la paz y armonía en el mundo", "d) Convertirte en el ser más poderoso del universo"));

    }

    //Preguntas de Unicornios
    private void setTwo() {
        list.add(new QuestionModel("¿Cuál sería el color de tu pelaje de unicornio?", "a) Rosa", "b) Azul", "c) Violeta", "d) Dorado"));
        list.add(new QuestionModel("¿Qué tipo de adorno llevarías en tu cuerno?", "a) Brillantes y coloridos", "b) Flores y hojas", "c) Estrellas y lunas", "d) Glitter y purpurina"));
        list.add(new QuestionModel("¿Cómo sería tu personalidad de unicornio?", "a) Amigable y juguetón", "b) Sereno y sabio", "c) Mágico y enérgico", "d) Elegante y encantador"));
        list.add(new QuestionModel("¿Qué tipo de poderes mágicos tendrías?", "a) Poder de curación", "b) Poder de teletransportación", "c) Poder de crear ilusiones", "d) Poder de controlar el clima"));
        list.add(new QuestionModel("¿Cuál sería tu lugar mágico favorito para vivir?", "a) Un prado lleno de flores", "b) Un bosque encantado", "c) Un castillo en las nubes", "d) Una cascada brillante"));
        list.add(new QuestionModel("¿Cuál sería tu comida mágica favorita?", "a) Arcoíris de algodón de azúcar", "b) Nubes de malvavisco", "c) Estrellas de azúcar", "d) Pastel de unicornio con glaseado brillante"));
        list.add(new QuestionModel("¿Cómo sería tu canto mágico de unicornio?", "a) Alegre y animado", "b) Suave y relajante", "c) Encantador y melodioso", "d) Brillante y poderoso"));
        list.add(new QuestionModel("¿Cuál sería tu misión especial como unicornio?", "a) Llevar alegría y esperanza a todos", "b) Proteger y preservar la naturaleza", "c) Ayudar a cumplir los sueños de las personas", "d) Inspirar la creatividad y la imaginación"));
        list.add(new QuestionModel("¿Qué tipo de amistades te gustaría tener como unicornio?", "a) Otras criaturas mágicas como hadas y duendes", "b) Animales del bosque como ciervos y conejos", "c) Seres de otros mundos y dimensiones", "d) Personas creativas y soñadoras"));
        list.add(new QuestionModel("¿Cómo te gustaría volar como unicornio?", "a) Con alas de mariposa", "b) Con una estela de estrellas brillantes", "c) Con un arcoíris como sendero", "d) Con un aura mágica luminosa"));

    }


    //Preguntas de Princesas
    private void setThree() {
        list.add(new QuestionModel("¿Cuál sería tu color favorito para tu vestido real?", "a) Rosa", "b) Azul", "c) Verde", "d) Morado"));
        list.add(new QuestionModel("Si pudieras tener un poder mágico, ¿cuál sería?", "a) Volar", "b) Teletransportación", "c) Leer mentes", "d) Controlar el fuego"));
        list.add(new QuestionModel("¿Qué tipo de corona usarías como princesa?", "a) Con joyas y brillantes", "b) Floral y elegante", "c) Simple y delicada", "d) Llamativa y única"));
        list.add(new QuestionModel("¿Cuál sería tu animal mágico favorito?", "a) Unicornio", "b) Dragón", "c) Hada", "d) Fénix"));
        list.add(new QuestionModel("¿Cuál sería tu lugar mágico favorito para explorar?", "a) Bosque encantado", "b) Mar profundo", "c) Montañas nevadas", "d) Jardín secreto"));
        list.add(new QuestionModel("¿Qué tipo de baile te gustaría aprender como princesa?", "a) Ballet clásico", "b) Danza contemporánea", "c) Baile de salón", "d) Baile folklórico"));
        list.add(new QuestionModel("¿Cómo te gustaría que fuera tu transporte real?", "a) Carroza tirada por caballos", "b) Alfombra voladora", "c) Barco de cristal", "d) Carruaje de hielo"));
        list.add(new QuestionModel("¿Cuál sería tu dulce favorito en el banquete real?", "a) Pastel de chocolate", "b) Macarons de frambuesa", "c) Helado de vainilla", "d) Cupcakes de fresa"));
        list.add(new QuestionModel("¿Qué tipo de música te gustaría escuchar en el baile real?", "a) Música clásica", "b) Pop moderno", "c) Música tradicional", "d) Baladas románticas"));
        list.add(new QuestionModel("¿Cómo te imaginas tu final de cuento de hadas?", "a) Casándome con mi amor verdadero", "b) Viajando por el mundo en aventuras emocionantes", "c) Ayudando a construir un reino próspero", "d) Cumpliendo mis sueños y metas personales"));
    }


    //Preguntas de comida
    private void setFour() {
        list.add(new QuestionModel("¿Prefieres dulce o salado?", "a) Dulce", "b) Salado", "c) Ambos", "d) Depende del día"));
        list.add(new QuestionModel("¿Qué tipo de cocina te gusta más?", "a) Italiana", "b) Mexicana", "c) Asiática", "d) Mediterránea"));
        list.add(new QuestionModel("¿Cuál es tu snack favorito?", "a) Papas fritas", "b) Galletas", "c) Frutas", "d) Chocolate"));
        list.add(new QuestionModel("¿Tienes alguna preferencia alimentaria?", "a) Vegetariano", "b) Vegano", "c) Sin gluten", "d) No tengo preferencias especiales"));
        list.add(new QuestionModel("¿Cuál es tu bebida favorita?", "a) Café", "b) Té", "c) Refresco", "d) Agua"));
        list.add(new QuestionModel("¿Qué tipo de comida rápida te gusta más?", "a) Hamburguesas", "b) Pizza", "c) Tacos", "d) Pollo frito"));
        list.add(new QuestionModel("¿Qué tipo de desayuno prefieres?", "a) Cereal", "b) Huevos y tocino", "c) Panqueques", "d) Batido de frutas"));
        list.add(new QuestionModel("¿Cuál es tu plato principal favorito?", "a) Filete de carne", "b) Salmón a la parrilla", "c) Pollo al horno", "d) Ensalada mixta"));
        list.add(new QuestionModel("¿Qué tipo de postre te gusta más?", "a) Pastel de chocolate", "b) Helado", "c) Flan", "d) Frutas frescas"));
        list.add(new QuestionModel("¿Qué ingredientes no pueden faltar en tu comida favorita?", "a) Queso", "b) Tomate", "c) Aguacate", "d) Cebolla"));
    }
}