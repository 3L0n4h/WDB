package hci.baranggayapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class Learn extends Fragment {
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
        Button btn_quake = (Button) getView().findViewById(R.id.btn_eq);
        Button btn_tsunami = (Button) getView().findViewById(R.id.btn_tsunami);
        Button btn_flood = (Button) getView().findViewById(R.id.btn_flood);

        btn_fire.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               lssn_fire.newInstance();
            }
        });

        btn_quake.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                lssn_quake.newInstance();
            }
        });

        btn_tsunami.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                lssn_tsunami.newInstance();
            }
        });
        btn_flood.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                lssn_flood.newInstance();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
}
