package sv.edu.catolica.nextquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sv.edu.catolica.nextquiz.databinding.ActivityLoginBinding;

public class RecuperarActivity extends AppCompatActivity {

    private EditText correo, palabra;

    private Button boton;

    private TextView redirectLogin;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        databaseHelper = new DatabaseHelper(this);
        correo = findViewById(R.id.r_email);
        palabra = findViewById(R.id.r_palabra);
        boton = findViewById(R.id.r_boton);
        redirectLogin = findViewById(R.id.loginRedirect);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = correo.getText().toString();
                String palabras = palabra.getText().toString();
                if(email.equals("")||palabras.equals(""))
                    Toast.makeText(RecuperarActivity.this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                else{
                    String checkCredentials = databaseHelper.checkPalabraCorreo(email, palabras);
                    if(checkCredentials != ""){
                        AlertDialog.Builder builder = new AlertDialog.Builder(RecuperarActivity.this);
                        builder.setMessage("Su contraseña es : "+ checkCredentials) // El valor recuperado se muestra como el mensaje del diálogo
                                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // Acción a realizar al hacer clic en el botón "OK"
                                        Intent intent  = new Intent(getApplicationContext(), LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });

                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }else{
                        Toast.makeText(RecuperarActivity.this, "Los datos son invalidos, no podemos recuperar su contraseña", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}