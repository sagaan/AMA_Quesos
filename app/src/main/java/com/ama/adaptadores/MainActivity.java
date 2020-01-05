package com.ama.adaptadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);
        final Quesos[] listQuesos = {
                new Quesos(getResources().getStringArray(R.array.nombres)[0], getResources().getStringArray(R.array.descripcion)[0]),
                new Quesos(getResources().getStringArray(R.array.nombres)[1], getResources().getStringArray(R.array.descripcion)[1]),
                new Quesos(getResources().getStringArray(R.array.nombres)[2], getResources().getStringArray(R.array.descripcion)[2]),
                new Quesos(getResources().getStringArray(R.array.nombres)[3], getResources().getStringArray(R.array.descripcion)[3]),
                new Quesos(getResources().getStringArray(R.array.nombres)[4], getResources().getStringArray(R.array.descripcion)[4]),
                new Quesos(getResources().getStringArray(R.array.nombres)[5], getResources().getStringArray(R.array.descripcion)[5])
        };
        ArrayAdapter<Quesos> quesosAdapter = new ArrayAdapter<Quesos>(this, 0, listQuesos){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                ViewHolder viewHolder = new ViewHolder();
                Quesos queso = listQuesos[position];

                if(convertView == null){
                    convertView = getLayoutInflater().inflate(R.layout.item, null, false);
                }

                viewHolder.txtNombre = (TextView) convertView.findViewById(R.id.txtQuesos);
                viewHolder.txtDescripcion = (TextView) convertView.findViewById(R.id.txtDescripcion);

                convertView.setTag(viewHolder);

                TextView txtQueso = ((ViewHolder)convertView.getTag()).txtNombre;
                TextView txtDescripcion = ((ViewHolder)convertView.getTag()).txtDescripcion;

                txtQueso.setText(queso.nombre);
                txtDescripcion.setText(queso.descripcion);

                return convertView;
            }
        };

        /*ListView listQuesos = new ListView(this);
        setContentView(listQuesos);
        listQuesos.setAdapter(quesosAdapter);*/

        GridView gridQuesos = new GridView(this);
        setContentView(gridQuesos);
        gridQuesos.setNumColumns(2);
        gridQuesos.setColumnWidth(60);
        gridQuesos.setVerticalSpacing(20);
        gridQuesos.setHorizontalSpacing(20);
        gridQuesos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "Aplastastes el queso " + getResources().getStringArray(R.array.nombres)[position];

                Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_SHORT).show();
            }
        });

        gridQuesos.setAdapter(quesosAdapter);

    }
}
