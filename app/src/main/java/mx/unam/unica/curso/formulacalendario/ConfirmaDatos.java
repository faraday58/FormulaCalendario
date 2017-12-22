package mx.unam.unica.curso.formulacalendario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmaDatos extends AppCompatActivity {

   TextView textv_nombre;
   TextView textv_fecha;
   TextView textv_telefono;
   TextView textv_email;
   TextView textv_descripcion;
   Button btn_editar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirma_datos);
        Bundle variables = getIntent().getExtras();
        String nombre = variables.getString(getResources().getString(R.string.extra_nombre));
        String telefono = variables.getString(getResources().getString(R.string.extra_telefono));
        String email = variables.getString(getResources().getString(R.string.extra_email));
        String fecha = variables.getString(getResources().getString(R.string.extra_fecha));
        String descripcion = variables.getString(getResources().getString(R.string.extra_descripcion));

        textv_nombre = (TextView)findViewById(R.id.textv_nombre);
        textv_telefono =(TextView)findViewById(R.id.textv_telefono);
        textv_email =(TextView)findViewById(R.id.textv_email);
        textv_fecha = (TextView)findViewById(R.id.textv_fecha);
        textv_descripcion = (TextView)findViewById(R.id.textv_descripcion);
        btn_editar = (Button)findViewById(R.id.btn_editar);

        textv_nombre.setText(textv_nombre.getText().toString() + " " + nombre);
        textv_telefono.setText(textv_telefono.getText().toString() + " " + telefono);
        textv_email.setText(textv_email.getText().toString() + " " + email);
        textv_fecha.setText(textv_fecha.getText().toString() + " " + fecha);
        textv_descripcion.setText(textv_descripcion.getText().toString() + " " + descripcion);


        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent = new Intent(view.getContext(),MainActivity.class);
                startActivity(miIntent);
                finish();
            }
        });

    }

}
