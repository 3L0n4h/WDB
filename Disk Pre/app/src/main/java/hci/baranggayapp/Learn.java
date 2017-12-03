package hci.baranggayapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;


public class Learn extends Fragment {
    private FragmentActivity mc;
    public static Learn newInstance() {
        Learn fragment = new Learn();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_learn, container, false);



        Button btn_fire = (Button) view.findViewById(R.id.btn_fire);
        Button btn_quake = (Button) view.findViewById(R.id.btn_eq);
        Button btn_tsunami = (Button) view.findViewById(R.id.btn_tsunami);
        Button btn_flood = (Button) view.findViewById(R.id.btn_flood);

        btn_fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), lrn_fire.class);
                view.getContext().startActivity(Intent);}
        });
        btn_quake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), lrn_quake.class);
                view.getContext().startActivity(Intent);}
        });

        btn_tsunami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), lrn_tsunami.class);
                view.getContext().startActivity(Intent);}
        });

        btn_flood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), lrn_flood.class);
                view.getContext().startActivity(Intent);}
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }


}
