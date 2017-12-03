package hci.baranggayapp;

import android.Manifest;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class Report extends Fragment {

    Button btnWLoad;
    Button btnWOLoad;
    SQLiteDatabase db;
    String num1, num2, num3;
    EditText num;
    static final  int REQUEST_LOCATION = 1;
    LocationManager locationManager;
    String strAddress;
    TextView textView;
    public static Report newInstance() {
        Report fragment = new Report();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_report, container, false);

        btnWLoad = (Button) view.findViewById(R.id.btnWLoad);
        locationManager = (LocationManager)getContext().getSystemService(Context.LOCATION_SERVICE);
        btnWLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                db = getContext().openOrCreateDatabase("SampleDB", Context.MODE_PRIVATE, null);
                Cursor c=db.rawQuery("SELECT * FROM tbl_contact",null);
                if(c.moveToFirst()){
                    num1 = c.getString(0).toString();
                    num2 = c.getString(1).toString();
                    num3 = c.getString(2).toString();
                    getLocation();
                    Toast.makeText(getContext(), "Success " +num1+" "+num2+" "+num3,Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    void getLocation() {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }else{
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if(location != null){
                Geocoder gc = new Geocoder(getContext());

                double latti = location.getLatitude();
                double longi = location.getLongitude();

                try {
                    List<Address> list = gc.getFromLocation(latti, longi,1);
                    Address address = list.get(0);
                    StringBuffer str = new StringBuffer();
//                    str.append("I M IN DANGER!!!!! PLEASE SEND HELP IMMEDIATELY. I AM AT ");
                    str.append("I M IN DANGER!!!!! PLEASE SEND HELP IMMEDIATELY. I AM AT " + address.getAddressLine(0));
                    //str.append(address.getLocality() + " ");
                    //str.append(address.getSubAdminArea()+ " ");
                    //str.append(address.getAdminArea() + " ");
                    //str.append(address.getCountryName() + " ");
                    //str.append(address.getCountryCode() + " ");
//                    str.append("THIS MESSAGE IS AUTO-GENERATED BY DISKPREV ANDROID APPLICATION");
                    strAddress = str.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent intent=new Intent(getContext(),Report.class);
                PendingIntent pi= PendingIntent.getActivity(getContext(), 0, intent,0);
                SmsManager sms= SmsManager.getDefault();
                sms.sendTextMessage(num1, null, strAddress, pi,null);
                sms.sendTextMessage(num2, null, strAddress, pi,null);
                sms.sendTextMessage(num3, null, strAddress, pi,null);
                Toast.makeText(getContext(), "Message Sent successfully!" +strAddress,Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case REQUEST_LOCATION:
                getLocation();
                break;
        }
    }
}

