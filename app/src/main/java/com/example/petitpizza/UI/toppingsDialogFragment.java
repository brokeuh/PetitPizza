package com.example.petitpizza.UI;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import androidx.fragment.app.DialogFragment;
import com.example.petitpizza.R;
import java.util.ArrayList;

public class toppingsDialogFragment extends DialogFragment {

    private ArrayList selectedItems;

    String [] toppings = {"Onion", "Cheese", "Bacon", "Pineapple", "Tuna", "Mushrooms", "Peperoni"};
    private DialogInterface.OnClickListener itemSelectListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

        }
    };
    private DialogInterface.OnClickListener toppingListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(getActivity(), "You picked " + selectedItems, Toast.LENGTH_LONG ).show();
        }
    };

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        selectedItems = new ArrayList();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        builder.setTitle(R.string.str_btn_toppings)

                .setMultiChoiceItems(toppings, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which,
                                                boolean isChecked) {
                                if (isChecked) {
                                    selectedItems.add(toppings[which]);
                                } else if (selectedItems.contains(which)) {
                                    selectedItems.remove(toppings[which]);;
                                }
                            }
                        });

        builder.setNegativeButton(android.R.string.cancel, null);

        builder.setPositiveButton(android.R.string.ok, toppingListener);


        return builder.create();
    }


}
