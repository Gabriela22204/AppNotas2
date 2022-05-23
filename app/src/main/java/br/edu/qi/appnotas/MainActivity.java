package br.edu.qi.appnotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.edu.qi.appnotas.bo.NotaBo;
import br.edu.qi.appnotas.model.Nota;

public class MainActivity extends AppCompatActivity {

    private EditText edNota1;
    private EditText edNota2;
    private EditText edTotal;
    private Button btCalc;
    private Button btNCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNota1 = (EditText) findViewById(R.id.edNota1);
        edNota2 = (EditText) findViewById(R.id.edNota2);
        edTotal = (EditText) findViewById(R.id.edTotal);

        btCalc = (Button) findViewById(R.id.btCalc);
        btNCalc = (Button) findViewById(R.id.btNCalc);

        btCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edTotal.setText(String.valueOf(new NotaBo(new Nota(Double.parseDouble(edNota1.getText().toString()),
                        Double.parseDouble(edNota2.getText().toString() ) ) ).total() ) );
            }
        });

        btNCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putSerializable("nota", new Nota(Double.parseDouble(edNota1.getText().toString()),
                       Double.parseDouble((edNota2.getText().toString()))));

                Intent intent = new Intent(MainActivity.this, SubsActivity.class);
                intent.putExtra("nota", args);
                startActivity(intent);
            }
        });


    }
}