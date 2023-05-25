package sv.edu.catolica.nextquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {


    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        result = findViewById(R.id.txt_resultado);


        int totalscore = getIntent().getIntExtra("src", 0);


        result.setText(String.valueOf(totalscore));
    }
}