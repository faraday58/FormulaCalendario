package mx.unam.unica.curso.formulacalendario;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends AppCompatActivity {

    Button btn_ok;
    Button btn_cancel;
    Button btn_siguiente;
    DatePicker dtp_fnacimiento;
    TextInputEditText texti_nombre;
    TextInputEditText texti_telefono;
    TextInputEditText texti_email;
    TextInputEditText texti_descripcion;
    int year;
    int month;
    int day;
    String fecha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ok = (Button)findViewById(R.id.btn_ok);
        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        dtp_fnacimiento = (DatePicker)findViewById(R.id.dtp_fnacimiento);
        btn_siguiente = (Button)findViewById(R.id.btn_siguiente);
        texti_nombre = (TextInputEditText)findViewById(R.id.texti_nombre);
        texti_telefono = (TextInputEditText)findViewById(R.id.texti_telefono);
        texti_email =(TextInputEditText)findViewById(R.id.texti_email);
        texti_descripcion =(TextInputEditText)findViewById(R.id.texti_descripcion);


        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               year = dtp_fnacimiento.getYear();
               month = dtp_fnacimiento.getMonth();
               day = dtp_fnacimiento.getDayOfMonth();
               fecha = day +"/" + month + "/" + year;
                Snackbar.make(view,fecha,Snackbar.LENGTH_LONG).show();

            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                dtp_fnacimiento.init(1985, 10, 02, new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                        Snackbar.make(view,"Reestableciendo fecha"+i +"/" + i1 + "/" + i2,Snackbar.LENGTH_LONG).show();

                    }
                });
            }
        });

        btn_siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDatos = new Intent(view.getContext(),ConfirmaDatos.class);
                intentDatos.putExtra(getResources().getString(R.string.extra_nombre),texti_nombre.getText().toString());
                intentDatos.putExtra(getResources().getString(R.string.extra_telefono),texti_telefono.getText().toString());
                intentDatos.putExtra(getResources().getString(R.string.extra_email),texti_email.getText().toString());
                intentDatos.putExtra(getResources().getString(R.string.extra_descripcion),texti_descripcion.getText().toString());
                intentDatos.putExtra(getResources().getString(R.string.extra_fecha),fecha);
                startActivity(intentDatos);
            }
        });


    }



}
