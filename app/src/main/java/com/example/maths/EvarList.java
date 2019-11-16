package com.example.maths;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EvarList extends AppCompatActivity implements AdapterView.OnItemLongClickListener ,View.OnCreateContextMenuListener {

    ListView lv;
    int num1,num2;
    boolean OP;
    Integer arr[] = new Integer[20];
    int pos;
    TextView tv1,tv2;
    int sum=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evar_list);

        lv = findViewById(R.id.lv);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        Intent p2= getIntent();
        num1 = p2.getIntExtra("FN",-1);
        num2 = p2.getIntExtra("MM",-1);
        OP = p2.getBooleanExtra("OP",true);


        if(OP==true){
            for(int i=0;i<arr.length;i++){
                    arr[i]=num1;
                    num1 = num1+num2;
            }
        }
        else{
            for(int i=0;i<arr.length;i++){
                arr[i]=num1;
                num1 = num1*num2;
            }
        }

        ArrayAdapter<Integer> adp = new ArrayAdapter<Integer>(this,R.layout.support_simple_spinner_dropdown_item,arr);
        lv.setAdapter(adp);
        lv.setOnCreateContextMenuListener(this);
        lv.setOnItemLongClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        pos = position;
        return false;
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Choose an Operation");
        menu.add("index");
        menu.add("sum");

    }

    public boolean onContextItemSelected(MenuItem item){
        String c = item.getTitle().toString();
        sum=0;
        if(c.equals("index")){
            tv1.setText((pos+1)+"");
            tv2.setText("index:");
        }
        else{
            for(int i=0;i<=pos;i++){
                sum=sum+arr[i];
            }
            tv2.setText("sum:");
            tv1.setText(sum+"");
        }

        return true;


    }

    public void cred(View view) {
       Intent p1= new Intent(this,Creds.class);
       startActivity(p1);
    }

    public void Back(View view) {
        finish();
    }
}
