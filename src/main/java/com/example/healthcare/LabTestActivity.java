package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages=
            {
                    {"Package1:Full Body Checkup","","","","600"},
                    {"Package2:Blood Glucose Fasting","","","","800"},
                    {"Package3:Covid-19","","","","1000"},
                    {"Package4:Thyroid Checking","","","","600"},
                    {"Package5:Sugar and Blood Pressure","","","","900"},


            };

    private String[] package_details={
            "Blood Glucose Fasting\n"+
                    "Complete Hemogram\n"+
                    "HBA1C\n"+
                    "Iron Studies\n"+
                    "Kidney Function Test\n"+
                    "Liver Function Test",
            "Blood Glucose Fasting",
            "Covid-19",
            "Thyroid Checking",
            "Complete Hemogram\n"+
                    "HBA1C\n"+
                    "Iron Studies\n"+
                    "Kidney Function Test\n"+
                    "Liver Function Test"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart=findViewById(R.id.buttonBMGoToCart);
        btnBack=findViewById(R.id.buttonBMBack);
        listview=findViewById(R.id.listViewBM);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,HomeActivity.class));
            }
        });

        list=new ArrayList();
        for(int i=0;i<packages.length;i++){
           item=new HashMap<String,String>();
           item.put("line1",packages[i][0]);
           item.put("line2",packages[i][1]);
           item.put("line3",packages[i][2]);
           item.put("line4",packages[i][3]);
           item.put("line5","Total Cost: "+packages[i][4]+"/-");
           list.add(item);
        }

        sa=new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listview.setAdapter(sa);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(LabTestActivity.this,LabTestDetails.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,CartLabActivity.class));
            }
        });
    }
}