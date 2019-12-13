package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class mqtt_act extends AppCompatActivity {
    static String MQTTHOST = "tcp://tailor.cloudmqtt.com:13653";
    static String USERNAME = "ntycfvlt";
    static String PASSWORD = "b3XXk38ObhgW";
    String topicStr = "LIBROS.ERR";
    MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt_act);

        //GENERAR CLIENDID PARA CONECTAR
        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(),MQTTHOST,clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());
        try {
            IMqttToken token = client.connect(options);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Toast.makeText(getBaseContext(),"Se ha conectado",Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Toast.makeText(getBaseContext(),"NO SE CONECTO",Toast.LENGTH_LONG).show();

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }
    public void LibroRevival(View view)
    {
        String topic = topicStr;
        String message = "Libro Revival ";
        try
        {
            client.publish(topic,message.getBytes(),0,false);

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }
    public void LibroFarenheit(View view)
    {
        String topic = topicStr;
        String message = "Libro Farenheit ";
        try
        {
            client.publish(topic,message.getBytes(),0,false);

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }


    }
    public void Libro1ElAlquimista(View view)
    {
        String topic = topicStr;
        String message = "Libro El Alquimista ";
        try
        {
            client.publish(topic,message.getBytes(),0,false);

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }
    public void LibroElPoder(View view)
    {
        String topic = topicStr;
        String message = "Libro El Poder ";
        try
        {
            client.publish(topic,message.getBytes(),0,false);

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }
    public void LibroElDespertar(View view)
    {
        String topic = topicStr;
        String message = "Libro El Despertar ";
        try
        {
            client.publish(topic,message.getBytes(),0,false);

        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

    }

}
