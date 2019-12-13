package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Base_Act extends AppCompatActivity {

    private EditText edtIngresarCodigo;
    private EditText edtIngresarNombre;
    private EditText edtIngresarPrecio;

    private Button btnAñadirLibro;
    private Button btnModificarLibros;
    private Button btnEliminarLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_);

        edtIngresarCodigo = (EditText)findViewById(R.id.edtIngresarCodigo);
        edtIngresarNombre = (EditText)findViewById(R.id.edtIngresarNombre);
        edtIngresarPrecio = (EditText)findViewById(R.id.edtIngresarPrecio);

        btnAñadirLibro = (Button) findViewById(R.id.btnAñadirLibro);
        btnModificarLibros = (Button) findViewById(R.id.btnModificarLibros);
        btnEliminarLibros = (Button) findViewById(R.id.btnEliminarLibros);
    }

    public void añadirLibro (View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Biblioteca",null,1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        if(!edtIngresarCodigo.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("codigo",edtIngresarCodigo.getText().toString());
            registro.put("nombre",edtIngresarNombre.getText().toString());
            registro.put("precio",edtIngresarPrecio.getText().toString());


            baseDeDatos.insert("LIBROS",null,registro);
            baseDeDatos.close();

            Toast.makeText(this,"Se ha Ingresado un libro", Toast.LENGTH_LONG).show();
        }
    }

    public void eliminarLibro(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Biblioteca",null,1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();


        String codigo = edtIngresarCodigo.getText().toString();

        baseDeDatos.delete("LIBROS" ,"codigo="+codigo,null);

        baseDeDatos.close();

        Toast.makeText(this,"Se ha eliminado el Libro :"+codigo,Toast.LENGTH_LONG).show();


    }

    public void modificarLibros (View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"Biblioteca",null,1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        String codigo = edtIngresarCodigo.getText().toString();
        ContentValues cont = new ContentValues();
        cont.put("codigo",edtIngresarCodigo.getText().toString());
        cont.put("nombre",edtIngresarNombre.getText().toString());
        cont.put("precio",edtIngresarPrecio.getText().toString());


        if(!edtIngresarCodigo.getText().toString().isEmpty())
        {
            baseDeDatos.update("LIBROS",cont,"codigo="+codigo,null);

            baseDeDatos.close();

            Toast.makeText(this,"Se ha actualizado el libro :"+codigo,Toast.LENGTH_LONG).show();

        }
    }
}
