package com.example.admin.assignment2_2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FeedbackDialog extends AppCompatDialogFragment {
    private TextView firstname;
    private TextView lastname;
    private TextView phonenumber;
    private TextView comment;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        final View view =  inflater.inflate(R.layout.feedback_dialog, null);

        builder.setView(view).setTitle("Feedback")
                .setPositiveButton("Submit", null)
                .setNegativeButton("Reset", null);

        AlertDialog feedbackDialog = builder.create();

        feedbackDialog.show();
        Button resetButton = feedbackDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetDialog(view);
            }
        });
        return feedbackDialog;
    }

    public void resetDialog(View view){
        firstname = (TextView) view.findViewById(R.id.firstname);
        lastname = (TextView) view.findViewById(R.id.lastname);
        phonenumber = (TextView) view.findViewById(R.id.phonenumber);
        comment = (TextView) view.findViewById(R.id.comment);

        firstname.setText("");
        lastname.setText("");
        phonenumber.setText("");
        comment.setText("");
    }
}
