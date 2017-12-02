package hci.baranggayapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Donate.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Donate#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Donate extends Fragment {
    public static Donate newInstance() {
        Donate fragment = new Donate();
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
        View view = inflater.inflate(R.layout.fragment_donate, container, false);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }
}
