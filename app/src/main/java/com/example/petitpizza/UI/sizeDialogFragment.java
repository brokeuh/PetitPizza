package com.example.petitpizza.UI;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class sizeDialogFragment extends DialogFragment {

    String [] sizes = {"Kids", "Small", "Medium", "Large", "Extra large"};

    private DialogInterface.OnClickListener sizeSelectListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getActivity(), "You selected a " + sizes[which] + " pizza.", Toast.LENGTH_LONG).show();
        }
    };
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Pick you size pizza.");

        builder.setItems(sizes, sizeSelectListener);

        builder.setNegativeButton(android.R.string.cancel, null);



        return builder.create();
    }



}
