package com.example.a2starter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a2starter.Database.iceCreamDatabase;
import com.example.a2starter.Repository.iceCreamRepository;

public class MainActivity extends AppCompatActivity {
    Button order;
    Button restock;
    String no_of_ice_crm;
    int no_of_ice_cream;

    iceCreamRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView total_price=(TextView) findViewById(R.id.total_cost);

        //get the edit text
        EditText editText=(EditText) findViewById(R.id.numberof_icecream);
        //store the edit text in to a string

        order=(Button) findViewById(R.id.place_order_button);
        restock=(Button) findViewById(R.id.restock_button);
        TextView left=(TextView) findViewById(R.id.ice_cream_left);

        //database
        iceCreamDatabase database;



        repository=new iceCreamRepository(MainActivity.this);

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                no_of_ice_crm= editText.getText().toString();

                if (no_of_ice_crm.matches("")){
                    Toast.makeText(getApplicationContext(),"no order",Toast.LENGTH_SHORT).show();
                    return;
                }

                no_of_ice_cream=Integer.parseInt(no_of_ice_crm);


                if (no_of_ice_cream <=0){
                    Toast.makeText(getApplicationContext(),"Order aleast one icecream",Toast.LENGTH_SHORT).show();
                }
                else if(no_of_ice_cream >10){
                    Toast.makeText(getApplicationContext(),"You can Not order More than 10 Ice cream",Toast.LENGTH_SHORT).show();
                }
                else {
                     int ice_cream_left=10-no_of_ice_cream;
                    left.setText(Integer.toString(ice_cream_left));
                    total_price.setText("Total Price:"+Integer.toString(acb(no_of_ice_cream)));


                }
            }
        });

        //on clicklistener  restock
        restock.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                left.setText(Integer.toString(restock()));
            }
        });
    }
//fuction to calculate price
    int acb(int no){
        int price=5*no;
        return price;
    }

    //restock dummy function
    int restock(){
      return  10;
    }

}