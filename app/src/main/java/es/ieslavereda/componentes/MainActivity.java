package es.ieslavereda.componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private TextView textViewCB;
    private TextView textViewS;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkBox);
        textViewCB = findViewById(R.id.textViewCB);
        radioGroup = findViewById(R.id.radioGroup);
        textViewS = findViewById(R.id.textViewSeleccion);

        checkBox.setOnClickListener(view -> {
            if(checkBox.isChecked())
                textViewCB.setText("CheckBox activado");
            else
                textViewCB.setText("CheckBox desactivado");
        });

        radioGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            if(i==R.id.radioButtonHombre)
                textViewS.setText("HOMBRE");
            else if (i==R.id.radioButtonMujer)
                textViewS.setText("MUJER");
            else if (i==R.id.radioButtonOtro)
                textViewS.setText("OTRO");
            else
                textViewS.setText("Imposible");
        });

    }
}