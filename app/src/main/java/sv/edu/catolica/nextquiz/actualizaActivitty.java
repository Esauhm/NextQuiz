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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class actualizaActivitty extends AppCompatActivity {

    LinearLayout home, nosotros, nuevos, logout,perfil;
    ImageView menu;
    DrawerLayout drawerLayout;
    EditText  editaCorreo, editaContra,confirma;
    Button btnActualiza;
    String correo;
    DatabaseHelper bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actualiza_activitty);
        bd = new DatabaseHelper(this);
        drawerLayout = findViewById(R.id.drawerlayout);
        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        nosotros = findViewById(R.id.nosotros);
        nuevos = findViewById(R.id.nuevos);
        logout = findViewById(R.id.logOut);
        perfil = findViewById(R.id.perfil);
        editaCorreo = findViewById(R.id.editaCorreo);
        editaContra = findViewById(R.id.ingPass);
        confirma = findViewById(R.id.ConfPass);
        btnActualiza = findViewById(R.id.btnActualiza);
        // Obtener el valor del extra
        String metodo = getIntent().getStringExtra("metodo");
        correo = getIntent().getStringExtra("correo");

        // Realizar acciones según el método enviado
        if (metodo != null) {

            // Establecer los hint según el método enviado
            setHintBasedOnMethod(metodo);
        }

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                redirectActivity(actualizaActivitty.this, MainActivity.class);
            }
        });

        nosotros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(actualizaActivitty.this, settingsActivity.class);
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
                redirectActivity(actualizaActivitty.this, nuevosActivity.class);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(actualizaActivitty.this, LoginActivity.class);
                Toast.makeText(actualizaActivitty.this, "Sesion cerrada correctamente", Toast.LENGTH_SHORT).show();
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

    private String getCurrentUserEmail() {
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

    private void setHintBasedOnMethod(String metodo) {

        if (metodo != null) {
            switch (metodo) {
                case "editarCorreo":
                    editaCorreo.setHint("Nuevo correo electrónico");
                    editaContra.setHint("Ingrese su contraseña actual");
                    confirma.setHint("Escriba de nuevo la contraseña");
                    break;
                case "editarContrasenia":
                    editaCorreo.setHint("Nueva Contraseña");
                    editaContra.setHint("Ingrese su contraseña actual");
                    confirma.setHint("Escriba de nuevo la contraseña");
                    break;
                case "editarPalabra":
                    editaCorreo.setHint("Nueva palabra clave");
                    editaContra.setHint("Ingrese su contraseña actual");
                    confirma.setHint("Escriba de nuevo la contraseña");
                    break;
            }
        }
    }


    public void ActualizaInformacion(View view) {
        String correoN = editaCorreo.getText().toString().trim();
        String pass1 = editaContra.getText().toString().trim();
        String pass2 = confirma.getText().toString().trim();

       String valida =  editaCorreo.getHint().toString().trim();
        switch (valida) {
            case "Nuevo correo electrónico":
                    bd.updateEmail(correo,correoN,pass1,pass2);
                    this.limpia();
                break;
            case "Nueva Contraseña":
                    bd.updatePassword(correo,correoN,pass1,pass2);
                this.limpia();

                break;
            case "Nueva palabra clave":
                bd.updateKeyword(correo,correoN,pass1,pass2);
                this.limpia();

                break;
        }
    }
    public  void limpia(){
            editaCorreo.setText("");
        editaContra.setText("");
        confirma.setText("");
    }

}