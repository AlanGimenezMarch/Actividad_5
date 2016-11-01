package com.example.alan_.actividad_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    private String[] nombres = {"Pepe", "Juan", "Andrés", "María", "Amparo"};
    String nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.listview);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres);

        list.setAdapter(adaptador);
        registerForContextMenu(list);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();

        AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
        nombre = list.getAdapter().getItem(info.position).toString();
        menu.setHeaderTitle(nombre);
        inflater.inflate(R.menu.menu_ctx_etiqueta, menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.CtxLblOpc1:
                Toast.makeText(getApplicationContext(), nombre+": Opción mostrar", Toast.LENGTH_LONG).show();
                return true;
            case R.id.CtxLblOpc2:
                Toast.makeText(getApplicationContext(), nombre+": Opción eliminar", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

}
