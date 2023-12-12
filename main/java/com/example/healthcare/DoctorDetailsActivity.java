package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

   private String[][] doctor_details1 =
            {
                    {"Doctor Name:V.N.Kale","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"},
                    {"Doctor Name:Ajit Kumar","Hospital Address:Pimpri","Experience:9yrs","Mobile Number:9898989988","900"},
                    {"Doctor Name:Mahesh Apate","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"},
                    {"Doctor Name:Prasad Kale","Hospital Address:Warje","Experience:7yrs","Mobile Number:9898989988","700"},
                    {"Doctor Name:V.N.Kale","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"}
            };

    private String[][] doctor_details2 =
            {
                    {"Doctor Name:V.N.Kale","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"},
                    {"Doctor Name:Ajit Kumar","Hospital Address:Pimpri","Experience:9yrs","Mobile Number:9898989988","900"},
                    {"Doctor Name:Mahesh Apte","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"},
                    {"Doctor Name:Prasad Kale","Hospital Address:Warje","Experience:7yrs","Mobile Number:9898989988","700"},
                    {"Doctor Name:V.N.Kale","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"}
            };

    private String[][] doctor_details3 =
            {
                    {"Doctor Name:V.N.Kale","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"},
                    {"Doctor Name:Ajit Kumar","Hospital Address:Pimpri","Experience:9yrs","Mobile Number:9898989988","900"},
                    {"Doctor Name:Mahesh Apte","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"},
                    {"Doctor Name:Prasad Kale","Hospital Address:Warje","Experience:7yrs","Mobile Number:9898989988","700"},
                    {"Doctor Name:V.N.Kale","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"}
            };

    private String[][] doctor_details4 =
            {
                    {"Doctor Name:V.N.Kale","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"},
                    {"Doctor Name:Ajit Kumar","Hospital Address:Pimpri","Experience:9yrs","Mobile Number:9898989988","900"},
                    {"Doctor Name:Mahesh Apte","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"},
                    {"Doctor Name:Prasad Kale","Hospital Address:Warje","Experience:7yrs","Mobile Number:9898989988","700"},
                    {"Doctor Name:V.N.Kale","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"}
            };

    private String[][] doctor_details5 =
            {
                    {"Doctor Name:V.N.Kale","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"},
                    {"Doctor Name:Ajit Kumar","Hospital Address:Pimpri","Experience:9yrs","Mobile Number:9898989988","900"},
                    {"Doctor Name:Mahesh Apte","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"},
                    {"Doctor Name:Prasad Kale","Hospital Address:Warje","Experience:7yrs","Mobile Number:9898989988","700"},
                    {"Doctor Name:V.N.Kale","Hospital Address:Kothrud","Experience:10yrs","Mobile Number:9898989988","500"}
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewDDTitle);
        btn=findViewById(R.id.buttonBMGoToCart);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);


        if(title.compareTo("Family Physician")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent( DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });

        list=new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item = new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Fees:"+doctor_details[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
        );
        ListView lst=findViewById(R.id.listViewBM);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}