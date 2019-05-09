package sg.edu.rp.c346.studenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btngetStudent;
    EditText name, gpa;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = findViewById(R.id.btnInsert);
        name = findViewById(R.id.etName);
        gpa = findViewById(R.id.etGPA);
        btngetStudent = findViewById(R.id.btnRetrieve);
        result = findViewById(R.id.Result);
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                String SGPA = gpa.getText().toString();
                Double Dgpa = Double.parseDouble(SGPA);
                db.insertTask(name.getText().toString(), Dgpa);
                db.close();

            }
        });

        btngetStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                ArrayList<String> data = db.getTaskContent();
                db.close();
                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i));
                    txt += i + ". " + data.get(i) + "\n" ;
                }
                result.setText(txt);
            }
        });



    }
}
