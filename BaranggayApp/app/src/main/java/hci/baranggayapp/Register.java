package hci.baranggayapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Button btnSubmit;
    EditText txtFirst;
    EditText txtSecond;
    EditText txtThird;
    SQLiteDatabase db;
    String holder="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        db = openOrCreateDatabase("SampleDB", Context.MODE_PRIVATE, null);

        db.execSQL("DELETE FROM tbl_contact");
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_contact(contactNum1 VARCHAR,contactNum2 VARCHAR,contactNum3 VARCHAR)");

        String count = "SELECT count(*) FROM tbl_contact";
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);
        if (icount > 0) {
            Intent intent = new Intent(this, Main.class);
            startActivity(intent);
        } else {
            btnSubmit = (Button) findViewById(R.id.btnSubmit);
            txtFirst = (EditText) findViewById(R.id.txtFirstNum);
            txtSecond = (EditText) findViewById(R.id.txtSecondNum);
            txtThird = (EditText) findViewById(R.id.txtThirdNum);

            btnSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (txtFirst.getText().toString().trim().length() == 0 || txtSecond.getText().toString().trim().length() == 0 || txtThird.getText().toString().trim().length() == 0) {
                        showMessage("Error", "Please enter all values");
                    } else {
                            db.execSQL("INSERT INTO tbl_contact VALUES('" + txtFirst.getText().toString() + "','" + txtSecond.getText().toString() + "','" + txtThird.getText().toString()+"');");
                            Cursor c=db.rawQuery("SELECT * FROM tbl_contact",null);
                            if(c.moveToFirst()){
                                Intent intent = new Intent(Register.this, Main.class);
                                startActivity(intent);
                            }
                        }

                }
            });

        }
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();

    }

}
