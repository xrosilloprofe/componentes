package es.ieslavereda.componentes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private TextView textViewCB;
    private TextView textViewS;
    private RadioGroup radioGroup;
    private Button buttonAdd;
    private EditText nombre;
    private EditText apellidos;
    private Spinner spinner;
    private List<Usuario> usuarios;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkBox);
        textViewCB = findViewById(R.id.textViewCB);
        radioGroup = findViewById(R.id.radioGroup);
        textViewS = findViewById(R.id.textViewSeleccion);
        nombre = findViewById(R.id.nombreEditText);
        apellidos = findViewById(R.id.apellidosEditText);
        spinner = findViewById(R.id.spinner);
        buttonAdd = findViewById(R.id.buttonAdd);

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

        if(savedInstanceState==null){
            usuarios = new ArrayList<>();
            usuarios.add(new Usuario("Joaquín","Alonso"));
            usuarios.add(new Usuario("Xavier","Rosillo"));
            usuarios.add(new Usuario("Juan Carlos","Pareja"));
        } else {
            usuarios = (List<Usuario>) savedInstanceState.getSerializable("claveUsuario");
        }

        ArrayAdapter<Usuario> miAdaptador=
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,usuarios);
        spinner.setAdapter(miAdaptador);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                textViewS.setText(usuarios.get(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        buttonAdd.setOnClickListener(view -> {
            usuarios.add(new Usuario(nombre.getText().toString(),
                    apellidos.getText().toString()));
            nombre.setText("");
            apellidos.setText("");
            miAdaptador.notifyDataSetChanged();
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("claveUsuario",(Serializable) usuarios);
    }




}