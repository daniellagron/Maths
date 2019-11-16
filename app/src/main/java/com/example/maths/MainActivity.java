package com.example.maths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnCreateContextMenuListener{

    TextView n1,n2;
    int num1,num2;
    boolean OP=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = (TextView)findViewById(R.id.num1);
        n2 = (TextView) findViewById(R.id.num2);
    }

    public void math(View view){
        OP=true;
        n2.setHint("Mosif");
    }
    public void geo(View view){
        OP=false;
        n2.setHint("Mahpil");
    }

    //FN = First Number
    //MM = mosif/mahpil
    //OP = geometric / mathmatic
    public void next(View view) {
       if ( n1.getText().length() != 0 && n2.getText().length()!=0){

            num1 = Integer.parseInt(n1.getText().toString());
            num2 = Integer.parseInt(n2.getText().toString());

            Intent p1 = new Intent(this, EvarList.class);
            p1.putExtra("FN", num1);
            p1.putExtra("MM", num2);
            p1.putExtra("OP", OP);
            startActivity(p1);
        }
       else
           Toast.makeText(MainActivity.this, "Please insert numbers", Toast.LENGTH_LONG).show();
    }
}
