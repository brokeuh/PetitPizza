package com.example.petitpizza.UI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.petitpizza.R;
import com.google.android.material.snackbar.Snackbar;

public class MainFragment extends Fragment {

    private View rootView;

    private View.OnClickListener sizeListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            new sizeDialogFragment().show(getParentFragmentManager(), "size");
        }
    };
    private View.OnClickListener toppingListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new toppingsDialogFragment().show(getParentFragmentManager(), "Toppings");
        }
    };
    private View.OnClickListener sauceListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new sauceDialogFragment().show(getParentFragmentManager(), "Sauces");
        }
    };
    private View.OnClickListener orderListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Snackbar snackbar = Snackbar.make(rootView.findViewById(R.id.frag_container), "Your "+ sizeListener + " pizza with following toppings " + sauceListener + toppingListener + " is on its way !"  , Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("Confirm", new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            snackbar.show();
        }
    };

    public MainFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button btnSize = rootView.findViewById(R.id.btn_size);
        btnSize.setOnClickListener(sizeListener);

        Button btnToppings = rootView.findViewById(R.id.btn_toppings);
        btnToppings.setOnClickListener(toppingListener);

        Button btnSauce = rootView.findViewById(R.id.btn_sauce);
        btnSauce.setOnClickListener(sauceListener);

        Button btnOrder = rootView.findViewById(R.id.btn_order);
        btnOrder.setOnClickListener(orderListener);


        return rootView;

    }
}
