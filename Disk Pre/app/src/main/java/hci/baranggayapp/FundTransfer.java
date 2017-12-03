package hci.baranggayapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class FundTransfer extends AppCompatActivity {
    Button transfer = (Button)findViewById(R.id.btn_transfer);
    EditText account = (EditText)findViewById(R.id.editText_acctNo);
    EditText amount = (EditText)findViewById(R.id.editText_amount);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_transfer);

        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog pd = new ProgressDialog(FundTransfer.this);
                pd.setMessage("loading");
                pd.show();
            }
        });
    }
}
