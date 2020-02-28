package com.example.petitpizza.UI;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class sauceDialogFragment extends DialogFragment {


    String [] sauces = {"Tomato", "Barbeque sauce", "Bechamel sauce", "Pepper sauce"};

    private DialogInterface.OnClickListener sauceSelectListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getActivity(), "You selected a " + sauces[which] , Toast.LENGTH_LONG).show();
        }
    };
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Pick you sauce topping.");

        builder.setItems(sauces, sauceSelectListener);

        builder.setNegativeButton(android.R.string.cancel, null);



        return builder.create();
    }


}
