package sv.edu.catolica.nextquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {


    private ImageView imagen, imagen2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        imagen = findViewById(R.id.blueTwitter);
        imagen2 = findViewById(R.id.whiteTwitter);



        int totalscore = getIntent().getIntExtra("src", 0);
        String Cuestionario = getIntent().getStringExtra("cst");


        try {
            switch (Cuestionario) {
                //Cuestionario 1
                case "Questionario1":
                    if (totalscore >= 0 && totalscore <= 13) {
                        // Cargar la imagen desde el código
                        Drawable drawable = getResources().getDrawable(R.drawable.d2);
                        imagen.setImageDrawable(drawable);
                        Drawable drawable2 = getResources().getDrawable(R.drawable.d2);
                        imagen2.setImageDrawable(drawable2);
                    } else if (totalscore >= 14 && totalscore <= 16) {
                        //imagen =
                    } else if (totalscore >= 17 && totalscore <= 19) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (totalscore >= 20 && totalscore <= 22) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else if (totalscore >= 23 && totalscore <= 25) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (totalscore >= 26 && totalscore <= 28) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else if (totalscore >= 29 && totalscore <= 32) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (totalscore >= 33 && totalscore <= 35) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else if (totalscore >= 36 && totalscore <= 38) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (totalscore >= 39 && totalscore <= 40) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else {
                        System.out.println("Respuesta fuera de rango");
                    }
                    break;

                //Cuestionario 2
                case "Questionario2":
                    if (totalscore >= 10 && totalscore <= 13) {
                        System.out.println("Respuesta dentro del rango 1-3");
                    } else if (totalscore >= 14 && totalscore <= 16) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else if (totalscore >= 17 && totalscore <= 19) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (totalscore >= 20 && totalscore <= 22) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else if (totalscore >= 23 && totalscore <= 25) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (totalscore >= 26 && totalscore <= 28) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else if (totalscore >= 29 && totalscore <= 32) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (totalscore >= 33 && totalscore <= 35) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else if (totalscore >= 36 && totalscore <= 38) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (totalscore >= 39 && totalscore <= 40) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else {
                        System.out.println("Respuesta fuera de rangos");
                    }
                    break;
            }


        }catch (Exception e){
            System.out.println("Respuesta fuera de rango");
        }


    }
}