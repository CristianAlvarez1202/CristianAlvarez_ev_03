package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Libros_Activity extends AppCompatActivity {

    private Spinner spn1;
    private EditText editCosto;
    private EditText editPrestamo;
    private TextView txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros_);

        spn1 = (Spinner) findViewById(R.id.spn1);
        editCosto = (EditText) findViewById(R.id.editCosto);
        editPrestamo = (EditText) findViewById(R.id.editPrestamo);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        Bundle b = this.getIntent().getExtras();

        String[] nom = b.getStringArray("nombres");

        ArrayAdapter adp1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nom);


        spn1.setAdapter(adp1);

    }

    public void MostrarResultado(View view) {
        Bundle b = this.getIntent().getExtras();
        int[] valores = b.getIntArray("valores");

        int stock = Integer.parseInt(editCosto.getText().toString());
        int prestamo = Integer.parseInt(editPrestamo.getText().toString());

        if (spn1.getSelectedItem().equals("Farenheit")) {
            int suma = valores[0] * stock + prestamo;
            txtResultado.setText("El resultado es : " + suma);
        } else {
            if (spn1.getSelectedItem().equals("Revival")) {
                int suma = valores[1] * stock + prestamo;
                txtResultado.setText("El resultado es : " + suma);
            } else {
                if (spn1.getSelectedItem().equals("Tesla")) {
                    int suma = valores[2] * stock + prestamo;
                    txtResultado.setText("El resultado es : " + suma);
                }
            }

        }

    }

    public void abrirMqttBooks(View view)
    {
        Intent i = new Intent(this,mqtt_act.class);
        startActivity(i);

    }
}
