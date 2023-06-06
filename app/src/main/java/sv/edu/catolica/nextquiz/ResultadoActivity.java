package sv.edu.catolica.nextquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class ResultadoActivity extends AppCompatActivity {


    private ImageView imagen, imagen2;

    Drawable drawable;

    int valorImg = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        int totalscore = getIntent().getIntExtra("src", 0);
        String Cuestionario = getIntent().getStringExtra("cst");

        imagen = findViewById(R.id.blueTwitter);
        imagen2 = findViewById(R.id.whiteTwitter);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(ResultadoActivity.this, DescripcionActivity.class);
                intent.putExtra("cst", Cuestionario);
                intent.putExtra("img", valorImg);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 4000);






        try {
            switch (Cuestionario) {
                //Cuestionario 1
                case "Questionario1":
                    if (totalscore >= 0 && totalscore <= 13) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d1);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.d1);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 1;


                    } else if (totalscore >= 14 && totalscore <= 16) {

                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d2);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.d2);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 2;

                    } else if (totalscore >= 17 && totalscore <= 19) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d3);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.d3);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 3;
                    } else if (totalscore >= 20 && totalscore <= 22) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d4);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.d4);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 4;
                    } else if (totalscore >= 23 && totalscore <= 25) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d5);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.d5);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 5;
                    } else if (totalscore >= 26 && totalscore <= 28) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d6);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.d6);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 6;
                    } else if (totalscore >= 29 && totalscore <= 32) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d7);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.d7);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 7;
                    } else if (totalscore >= 33 && totalscore <= 35) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d8);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.d8);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 8;
                    } else if (totalscore >= 36 && totalscore <= 38) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d9);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.d9);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 9;
                    } else if (totalscore >= 39 && totalscore <= 40) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d10);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.d10);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 10;
                    } else {
                        System.out.println("Respuesta fuera de rango");
                    }
                    break;


                //Cuestionario 2
                case "Questionario2":
                    if (totalscore >= 10 && totalscore <= 13) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.unicornio_salvaje);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.unicornio_salvaje);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 1;
                    } else if (totalscore >= 14 && totalscore <= 16) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.gatocornio);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.gatocornio);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 2;
                    } else if (totalscore >= 17 && totalscore <= 19) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.pandicornio);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.pandicornio);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 3;
                    } else if (totalscore >= 20 && totalscore <= 22) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.puercornio);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.puercornio);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 4;
                    } else if (totalscore >= 23 && totalscore <= 25) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.unicornio_bebe);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.unicornio_bebe);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 5;
                    } else if (totalscore >= 26 && totalscore <= 28) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.unicornio_estelar);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.unicornio_estelar);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 6;
                    } else if (totalscore >= 29 && totalscore <= 32) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.unicornio_salvaje);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.unicornio_salvaje);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 7;
                    } else if (totalscore >= 33 && totalscore <= 35) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.pandicornio);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.pandicornio);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 8;
                    } else if (totalscore >= 36 && totalscore <= 38) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.unicornio_bebe);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.unicornio_bebe);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 9;
                    } else if (totalscore >= 39 && totalscore <= 40) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.gatocornio);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.gatocornio);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 10;
                    } else {
                        System.out.println("Respuesta fuera de rangos");
                    }
                    break;


                //Cuestionario 3
                case "Questionario3":
                    if (totalscore >= 10 && totalscore <= 13) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p1);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.p1);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 1;
                    } else if (totalscore >= 14 && totalscore <= 16) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p2);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.p2);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 2;
                    } else if (totalscore >= 17 && totalscore <= 19) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p3);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.p3);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 3;
                    } else if (totalscore >= 20 && totalscore <= 22) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p4);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.p4);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 4;
                    } else if (totalscore >= 23 && totalscore <= 25) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p5);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.p5);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 5;
                    } else if (totalscore >= 26 && totalscore <= 28) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p6);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.p6);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 6;
                    } else if (totalscore >= 29 && totalscore <= 32) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p7);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.p7);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 7;
                    } else if (totalscore >= 33 && totalscore <= 35) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p8);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.p8);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 8;
                    } else if (totalscore >= 36 && totalscore <= 38) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p9);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.p9);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 9;
                    } else if (totalscore >= 39 && totalscore <= 40) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.p10);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.p10);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 10;
                    } else {
                        System.out.println("Respuesta fuera de rangoss");
                    }
                    break;

                //Cuestionario 4
                case "Questionario4":
                    if (totalscore >= 10 && totalscore <= 13) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.c1);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.c1);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 1;
                    } else if (totalscore >= 14 && totalscore <= 16) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.c2);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.c2);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 2;
                    } else if (totalscore >= 17 && totalscore <= 19) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.c3);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.c3);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 3;
                    } else if (totalscore >= 20 && totalscore <= 22) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.c4);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.c4);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 4;
                    } else if (totalscore >= 23 && totalscore <= 25) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.c5);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.c5);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 5;
                    } else if (totalscore >= 26 && totalscore <= 28) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.c6);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.c6);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 6;
                    } else if (totalscore >= 29 && totalscore <= 32) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.c7);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.c7);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 7;
                    } else if (totalscore >= 33 && totalscore <= 35) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.c1);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.c1);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 8;
                    } else if (totalscore >= 36 && totalscore <= 38) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.c2);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.c2);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 9;
                    } else if (totalscore >= 39 && totalscore <= 40) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.c3);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.c3);
                        imagen2.setImageDrawable(drawable2);

                        //guardar la imagen
                        valorImg = 10;
                    } else {
                        System.out.println("Respuestas fuera de rangos");
                    }
                    break;
            }


        }catch (Exception e){
            System.out.println("Respuesta fuera de rango");
        }


    }
}