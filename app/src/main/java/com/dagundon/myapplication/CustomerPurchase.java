package com.dagundon.myapplication;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CustomerPurchase extends Fragment{

    private ArrayList<products> product = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_customer_purchase, container, false);
//
        product.clear();
        product.add(new products("ProdCode:1"));
        product.add(new products("ProdCode2"));
        product.add(new products("ProdCode3"));
        product.add(new products("ProdCode4"));
//
        final GridView prodGrid = layout.findViewById(R.id.prod_gridView);
        productAdapter adapter = new productAdapter(getActivity(), R.layout.prod_title_textview, product);
        prodGrid.setAdapter(adapter);

        prodGrid.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TextView prodTitleTextview = view.findViewById(R.id.prod_title_tv);

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setCancelable(true);
                builder.setTitle("Product");
                builder.setMessage("Product: " + prodTitleTextview.getText().toString());

                builder.setPositiveButton("OK", dialogListener);
                builder.show();
                return true;
            }

            private DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    switch (which) {
                        case DialogInterface.BUTTON_POSITIVE:
                            break;
                    }
                }
            };
        });

        return layout;

    }
}
