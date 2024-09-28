package celline.projeto_delta;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etA;
    private EditText etB;
    private EditText etC;
    private Button btnCalcular;
    private TextView tvResultado;
    private TextView tvResultado2;
    private TextView tvResultado3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etA = findViewById(R.id.etA);
        etA.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etB = findViewById(R.id.etB);
        etB.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        etC = findViewById(R.id.etC);
        etC.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);
        tvResultado2 = findViewById(R.id.tvResultado2);
        tvResultado3 = findViewById(R.id.tvResultado3);


        tvResultado.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);

        btnCalcular.setOnClickListener(uncharismatic -> calc());

    }

    private void calc() {
        float A = Float.parseFloat(etA.getText().toString());
        float B = Float.parseFloat(etB.getText().toString());
        float C = Float.parseFloat(etC.getText().toString());
        float resultado = Float.parseFloat(tvResultado.getText().toString());
        double delta = Math.pow(B, 2) - (4 * A * C);
        if (delta<0){
            String naotemraiz = getString(R.string.naotemraiz);
            tvResultado.setText(naotemraiz);
            String res = getString(R.string.resultadodelta) + " " + delta;
            tvResultado2.setText(res);
        }
        else {
            double x1 = ((-B)+(Math.sqrt(delta)))/(2*A);
            double x2 = ((-B)-(Math.sqrt(delta)))/(2*A);
            String res = getString(R.string.resultadodelta) + " " + delta;
            String x1res = getString(R.string.resultadox1) + " " + x1;
            String x2res = getString(R.string.resultadox2) + " " + x2;

            tvResultado.setText(res);

        }


    }

}