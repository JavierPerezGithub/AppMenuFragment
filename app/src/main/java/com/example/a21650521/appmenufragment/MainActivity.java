package com.example.a21650521.appmenufragment;

import android.app.Dialog;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ConstraintLayout cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cl = (ConstraintLayout)findViewById(R.id.clContenedor);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu1){
            Fragmento1 frag = new Fragmento1();
            visualizar(frag);
            crearDialogo(getResources().getString(R.string.acFrag1)).show();
        }
        else if(item.getItemId() == R.id.menu2){
            Fragmento2 frag = new Fragmento2();
            visualizar(frag);
            crearDialogo(getResources().getString(R.string.acFrag2)).show();
        }
        return(true);
    }

    public void visualizar(Fragment f){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.clContenedor, f);
        ft.commit();
    }
    private Dialog crearDialogo(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(msg);

        return builder.create();
    }


}
