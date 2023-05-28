package sv.edu.catolica.nextquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

public class DescripcionActivity extends AppCompatActivity {

    private Button repetir, regresar;

    ImageView imagen;

    Drawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        regresar = findViewById(R.id.btn_regresar);
        repetir = findViewById(R.id.btn_repetir);
        imagen = findViewById(R.id.img_card);

        String Cuestionario = getIntent().getStringExtra("cst");
        int Vimagen = getIntent().getIntExtra("img", 0);


        try {
            switch (Cuestionario) {
                //Cuestionario 1
                case "Questionario1":
                    if (Vimagen == 1) {
                        // Cargar la imagen desde el código
                        drawable = getResources().getDrawable(R.drawable.d2);
                        imagen.setImageDrawable(drawable);


                    } else if (Vimagen == 2) {
                        //imagen =
                    } else if (Vimagen == 3) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (Vimagen == 4) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else if (Vimagen == 5) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (Vimagen == 6) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else if (Vimagen == 7) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (Vimagen == 8) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else if (Vimagen == 9) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (Vimagen == 10) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else {
                        System.out.println("Respuesta fuera de rango");
                    }
                    break;

                //Cuestionario 2
                case "Questionario2":
                    if (Vimagen == 1) {
                        // Cargar la imagen desde el código
                        System.out.println("Respuesta dentro del rango 7-9");

                    } else if (Vimagen == 2) {
                        //imagen =
                    } else if (Vimagen == 3) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (Vimagen == 4) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else if (Vimagen == 5) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (Vimagen == 6) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else if (Vimagen == 7) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (Vimagen == 8) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else if (Vimagen == 9) {
                        System.out.println("Respuesta dentro del rango 7-9");
                    } else if (Vimagen == 10) {
                        System.out.println("Respuesta dentro del rango 4-6");
                    } else {
                        System.out.println("Respuesta fuera de rango");
                    }
                    break;
            }


        }catch (Exception e){
            System.out.println("Respuesta fuera de rango");
        }

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DescripcionActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        repetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DescripcionActivity.this, PreguntaActivity.class);
                intent.putExtra("set", Cuestionario);
                startActivity(intent);
                finish();
            }
        });


    }
}