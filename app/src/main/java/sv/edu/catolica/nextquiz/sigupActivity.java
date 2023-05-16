package sv.edu.catolica.nextquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sv.edu.catolica.nextquiz.databinding.ActivitySigupBinding;

public class sigupActivity extends AppCompatActivity {


    ActivitySigupBinding binding;
    DatabaseHelper databaseHelper;

    String emailPattern = "^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(\\.\\w{2,})+$";
    Pattern pattern = Pattern.compile(emailPattern);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySigupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);

        binding.sgBoton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String email = binding.sgEmail.getText().toString();
                String password = binding.sgPassword.getText().toString();
                String confirmPassword = binding.sgConfirm.getText().toString();
                Matcher matcher = pattern.matcher(email);

                if (matcher.matches()) {
                    if(email.equals("")||password.equals("")||confirmPassword.equals(""))
                        Toast.makeText(sigupActivity.this, "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
                    else{
                        if(password.equals(confirmPassword)){
                            Boolean checkUserEmail = databaseHelper.checkEmail(email);
                            if(checkUserEmail == false){
                                Boolean insert = databaseHelper.insertData(email, password);
                                if(insert == true){
                                    Toast.makeText(sigupActivity.this, "¡Sesión iniciada correctamente!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                                    startActivity(intent);
                                }else{
                                    Toast.makeText(sigupActivity.this, "¡Registro Fallido!", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(sigupActivity.this, "¡El usuario ya existe! Iniciar Sesión", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(sigupActivity.this, "¡La contraseña no es la misma!", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(sigupActivity.this, "El formato del correo no es correcto", Toast.LENGTH_SHORT).show();
                }


            }
        });

        binding.loginRedirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sigupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}