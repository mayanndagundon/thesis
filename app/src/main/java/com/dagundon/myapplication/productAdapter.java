package com.dagundon.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

    public class productAdapter extends ArrayAdapter<products> {

        private static final String TAG = "productAdapter";
        private Context context;
        private int itemLayoutResource;
        private ArrayList<products> products = new ArrayList<>();

        public productAdapter(@NonNull Context context, int resource, @NonNull List<products> memes) {
            super(context, resource, memes);

            this.context = context;
            this.itemLayoutResource = resource;
            this.products.addAll(memes);
        }

        @Nullable
        @Override
        public products getItem(int position) {
            return this.products.get(position);
        }

        @Override
        public int getCount() {
            return this.products.size();
        }

        @Override
        public int getPosition(@Nullable products item) {
            return this.products.indexOf(item);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            products prods = getItem(position);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View prodItemLayout = inflater.inflate(itemLayoutResource, parent, false);

            TextView prodTitle = prodItemLayout.findViewById(R.id.prod_title_tv);

            if (prods.getName() != null) {
                String litsi = prods.getName();
                Log.d(TAG, litsi);
                prodTitle.setText(litsi);
            }
            return prodItemLayout;

        }
    }
