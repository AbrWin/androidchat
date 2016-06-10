package com.abrsoftware.androidchat.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.abrsoftware.androidchat.R;
import com.abrsoftware.androidchat.domain.useCases.LoginView;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ViewLogin extends Fragment implements LoginView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    @Bind(R.id.btnLogin)
    public Button btnLogin;
    @Bind(R.id.btnRegister)
    public Button btnRegister;
    @Bind(R.id.inputMail)
    public Button inputMail;
    @Bind(R.id.inputPass)
    public Button inputPass;


    public ViewLogin() {
    }

    public static ViewLogin newInstance(String param1, String param2) {
        ViewLogin fragment = new ViewLogin();
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
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.layout_login, container, false);
        ButterKnife.bind(rootview);
        return rootview;
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
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void enableInputs() {

    }

    @Override
    public void disableInputs() {

    }

    @Override
    public void showProgresBar() {

    }

    @Override
    public void hiddenProgresBar() {

    }

    @Override
    public void handSingOut() {

    }

    @Override
    public void handSingI() {

    }

    @Override
    public void navigateToMainScreen() {

    }

    @Override
    public void loginError(String error) {

    }

    @Override
    public void newUserSucces() {

    }

    @Override
    public void newUserError() {

    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
