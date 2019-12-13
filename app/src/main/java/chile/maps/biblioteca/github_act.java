package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class github_act extends AppCompatActivity {
    private Spinner spnGit;
    private TextView txtgit;
    private Button btngit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_github_act);

        spnGit = (Spinner)findViewById(R.id.spnGit);
        txtgit = (TextView)findViewById(R.id.txtGit);
        btngit = (Button) findViewById(R.id.btngit);

        Bundle b = this.getIntent().getExtras();

        String[] nom2 = b.getStringArray("nombres2");

        ArrayAdapter adp1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nom2);


        spnGit.setAdapter(adp1);


    }
    public void MostrarLibros2 (View view)
    {
        Bundle x = this.getIntent().getExtras();
        int[] valores = x.getIntArray("valores2");

        if (spnGit.getSelectedItem().equals("Farenheit")) {

            txtgit.setText("El valor de Farenheit es : " + valores[0]);
        } else {
            if (spnGit.getSelectedItem().equals("Revival")) {

                txtgit.setText("El valor de Revival es : " + valores[1]);

            } else {
                if (spnGit.getSelectedItem().equals("El Alquimista")) {
                    txtgit.setText("El valor de El Alquimista es : " + valores[2] );
                }
            }

        }
    }

}
