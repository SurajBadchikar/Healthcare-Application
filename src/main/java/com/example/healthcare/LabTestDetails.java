package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetails extends AppCompatActivity {
    TextView tvPackageName,tvTotalCost;
    EditText edDetails;
    Button btnAddToCart,btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName=findViewById(R.id.textViewBMDPackageName);
        tvTotalCost=findViewById(R.id.textViewBMDTotalCost);
        edDetails=findViewById(R.id.editTextBMDTextMultiLine);
        btnAddToCart=findViewById(R.id.buttonBMDAddToCart);
        btnBack=findViewById(R.id.buttonBMDBack);

        edDetails.setKeyListener(null);

        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost:"+intent.getStringExtra("text3")+"/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetails.this,LabTestActivity.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs",Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username","").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra( "text3").toString());


                Database db = new Database (getApplicationContext(),"healthcare",null,1);
                if (db.checkcart(username, product) ==1){
                    Toast.makeText (getApplicationContext(),"Product Already Added", Toast.LENGTH_SHORT).show();
                }else {
                   db.addcart(username,product,price,"lab");
                    Toast.makeText(getApplicationContext(),"Added to Cart", Toast.LENGTH_SHORT).show();
                    startActivity (new Intent(LabTestDetails.this,LabTestActivity.class));
                }
            }
        });
    }
}