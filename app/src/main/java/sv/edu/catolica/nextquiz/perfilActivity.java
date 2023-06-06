package sv.edu.catolica.nextquiz;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class perfilActivity extends AppCompatActivity {

    LinearLayout home, nosotros, nuevos, logout,perfil;
    DrawerLayout drawerLayout;
    ImageView menu, editCorreo,editPass,editPalabra;
    EditText correo, contraseña, clave ;

    DatabaseHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bd = new DatabaseHelper(this);

        setContentView(R.layout.activity_perfiles);

        drawerLayout = findViewById(R.id.drawerlayout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        nosotros = findViewById(R.id.nosotros);
        nuevos = findViewById(R.id.nuevos);
        logout = findViewById(R.id.logOut);
        perfil = findViewById(R.id.perfil);

        editCorreo = findViewById(R.id.editCorreo);
        editPass = findViewById(R.id.editPass);
        editPalabra = findViewById(R.id.editPalabra);




        correo = findViewById(R.id.edtCorreo);
        correo.setText(getCurrentUserEmail());
        contraseña = findViewById(R.id.edtContraseña);

        clave = findViewById(R.id.edtPalabra);
        clave.setText(bd.obtienePalabra(getCurrentUserEmail()));
        contraseña.setText(bd.checkPalabraCorreo(getCurrentUserEmail(),bd.obtienePalabra(getCurrentUserEmail())));

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                redirectActivity(perfilActivity.this, MainActivity.class);
            }
        });

        nosotros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(perfilActivity.this, settingsActivity.class);
            }
        });

        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
        nuevos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(perfilActivity.this, nuevosActivity.class);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(perfilActivity.this, LoginActivity.class);
                Toast.makeText(perfilActivity.this, "Sesion cerrada correctamente", Toast.LENGTH_SHORT).show();
            }
        });

    }
    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public  static  void closeDrawer(DrawerLayout drawerLayout){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    
    public String getCurrentUserEmail() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return sharedPreferences.getString("email", "");
    }


    public static void redirectActivity(Activity activity, Class secondActivity){
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }


    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }



    @Override
    public void onBackPressed() {
        // Mostrar un diálogo de confirmación antes de cerrar la actividad
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmación");
        builder.setMessage("¿Estás seguro de que deseas salir?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("No", null);
        builder.show();
    }

    public void editarCorreo(View view) {

        Intent intent = new Intent(perfilActivity.this, actualizaActivitty.class);
        intent.putExtra("metodo", "editarCorreo");
        intent.putExtra("correo",getCurrentUserEmail());
        startActivity(intent);

    }

    public void editarContrasenia(View view) {

        Intent intent = new Intent(perfilActivity.this, actualizaActivitty.class);
        intent.putExtra("metodo", "editarContrasenia");
        intent.putExtra("correo",getCurrentUserEmail());

        startActivity(intent);
    }

    public void editarPalabra(View view) {

        Intent intent = new Intent(perfilActivity.this, actualizaActivitty.class);
        intent.putExtra("metodo", "editarPalabra");
        intent.putExtra("correo",getCurrentUserEmail());
        startActivity(intent);
    }
}