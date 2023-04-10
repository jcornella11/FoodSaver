package com.example.foodsaver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(Context context, ArrayList<Item> items)
    {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Item item = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, parent, false);
        }

        TextView itemName = (TextView) convertView.findViewById(R.id.itemName);
        TextView itemUPC = (TextView) convertView.findViewById(R.id.textUPC);
        TextView itemPrice = (TextView) convertView.findViewById(R.id.textPrice);
        TextView itemExpirationYear = (TextView) convertView.findViewById(R.id.expirationYear);
        TextView itemExpirationMonth = (TextView) convertView.findViewById(R.id.expirationMonth);
        TextView itemExpirationDay = (TextView) convertView.findViewById(R.id.expirationDay);

        itemName.setText(item.itemName);
        itemUPC.setText(item.UniversalProductCode);
        itemPrice.setText(item.itemPrice);
        itemExpirationYear.setText(item.expirationYear);
        itemExpirationMonth.setText(item.expirationMonth);
        itemExpirationDay.setText(item.expirationDay);

        return convertView;
    }

}
