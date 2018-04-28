package com.example.admin.filmsclient.presentation.ui.auth;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.filmsclient.R;
import com.example.admin.filmsclient.presentation.ui.core.BaseFragment;

import butterknife.BindView;

public class AuthFragment extends BaseFragment {

    @BindView(R.id.button_confirm)
    Button buttonConfirm;

    @BindView(R.id.text_view_guest_button)
    TextView textViewGuestButton;

    @BindView(R.id.login)
    TextInputEditText editTextLogin;

    @BindView(R.id.password)
    TextInputEditText editTextPassword;

    private OnFragmentInteractionListener mListener;

    public static AuthFragment newInstance() {
        AuthFragment fragment = new AuthFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_auth;
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
        mListener = null;
        super.onDetach();
    }

    public interface OnFragmentInteractionListener {
    }
}
