package com.example.nutrimeter.ui.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.nutrimeter.R;
import com.example.nutrimeter.common.ViewModelProviderFactory;

import javax.inject.Inject;

public class ResetPasswordDialog extends DialogFragment {

    AuthViewModel viewModel;
    @Inject
    ViewModelProviderFactory providerFactory;

    private EditText mEmailField;
    private String mUserEmail;

    Button sendBtn;

    public ResetPasswordDialog() { }

    // Defines the listener interface
    public interface PasswordResetDialogListener {
        void onFinishEditDialog(String userEmail);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel =  new ViewModelProvider(getActivity(), providerFactory).get(AuthViewModel.class);
        return inflater.inflate(R.layout.dialog_reset_password_email_password_auth, container);
    }

    @Override
    public void onResume() {
        super.onResume();

        // Show soft keyboard automatically and request focus to field
        mEmailField = getDialog().findViewById(R.id.textInputEditText_signIn_restartPassword_email);
        mUserEmail = ResetPasswordDialogArgs.fromBundle(getArguments()).getEmail();
        mEmailField.setText(mUserEmail);
        mEmailField.requestFocus();

        getDialog().getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        sendBtn = getDialog().findViewById(R.id.btn_singIn_resetPassword_send);
        sendBtn.setOnClickListener(v -> {
            if (validateEmailForm()){
                viewModel.resetPassword(mUserEmail);
                dismiss();
            }
        });
    }

    private boolean validateEmailForm() {
        boolean isValid = true;

        String email = mEmailField.getText().toString();
        if (email.isEmpty()) {
            mEmailField.setError(getString(R.string.auth_error_email_empty));
            isValid = false;
        } else {
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                mEmailField.setError(getString(R.string.auth_error_email_invalid));
                isValid = false;
            } else {
                mEmailField.setError(null);
                isValid = true;
            }
        }
        return isValid;
    }
}
