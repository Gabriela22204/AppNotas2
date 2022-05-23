package br.edu.qi.appnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.edu.qi.appnotas.bo.NotaBo;
import br.edu.qi.appnotas.model.Nota;

public class SubsActivity extends AppCompatActivity {

    private EditText edNota1;
    private EditText edNota2;
    private EditText edTotal;
    private Button btCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subs);

        edNota1 = (EditText) findViewById(R.id.edSNota1);
        edNota2 = (EditText) findViewById(R.id.edSNota2);
        edTotal = (EditText) findViewById(R.id.edNTotal);
        btCalc = (Button) findViewById(R.id.btSubsCalc);

        Bundle args = getIntent().getBundleExtra("nota");
        if (args == null)
            finish();

        Nota nota = (Nota) args.getSerializable("nota");

        edNota1.setText(String.valueOf(nota.getNota1()));
        edNota2.setText(String.valueOf(nota.getNota2()));

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                edTotal.setText(String.valueOf(new NotaBo(new Nota(Double.parseDouble(edNota1.getText().toString()),
                        Double.parseDouble(edNota2.getText().toString()))).total()));
            }
        });
    }
}