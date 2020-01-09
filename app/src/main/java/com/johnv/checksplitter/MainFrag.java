package com.johnv.checksplitter;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import static com.johnv.checksplitter.GlobalVariables.checkTotal;
import static com.johnv.checksplitter.GlobalVariables.tipPerc;
import static com.johnv.checksplitter.GlobalVariables.numOfPpl;
import static com.johnv.checksplitter.GlobalVariables.finalTotal;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MainFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFrag newInstance(String param1, String param2) {
        MainFrag fragment = new MainFrag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        final EditText numOfPplText = view.findViewById(R.id.numOfPeople_editText);
        final EditText checkTotalText = view.findViewById(R.id.checkTotal_editText);
        final EditText tipPercText = view.findViewById(R.id.tipPercent_editText);
        final CheckBox splitEvenCB = view.findViewById(R.id.splitEven_checkBox);
        Button clear = view.findViewById(R.id.clear_button);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(splitEvenCB.isChecked())
                    splitEvenCB.toggle();
                numOfPplText.setText("");
                checkTotalText.setText("");
                tipPercText.setText("");
            }
        });

        Button splitCheck = view.findViewById(R.id.splitCheck_button);
        splitCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numOfPpl = Integer.valueOf(numOfPplText.getText().toString());
                checkTotal = Double.valueOf(checkTotalText.getText().toString());
                tipPerc = Double.valueOf(tipPercText.getText().toString());
                if(splitEvenCB.isChecked()) {
                    finalTotal = (checkTotal + (checkTotal * (tipPerc / 100))) / numOfPpl;
                    GrandTotalFrag grandTotalFrag = new GrandTotalFrag();
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.ContentMain, grandTotalFrag).addToBackStack(null).commit();
                }
                else {

                }
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
