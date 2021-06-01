package com.example.helpapa;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.helpapa.model.Item;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;



public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    public ArrayList<Item> item_list;


    public CustomAdapter(ArrayList<Item> arrayList) {

        item_list = arrayList;
    }

    @Override
    public CustomAdapter.@NotNull ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, null);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {

        final int pos = position;

        holder.item_name.setText(item_list.get(position).getItemName());

        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                deleteItemFromList(v, pos);


            }
        });

    }

    @Override
    public int getItemCount() {
        return item_list.size();
    }

    // confirmação de dialog.
    private void deleteItemFromList(View v, final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setMessage("Tem certeza que deseja deletar esse item?")
                .setCancelable(false)
                .setPositiveButton("Confirmar",
                        (dialog, id) -> {

                            item_list.remove(position);
                            notifyDataSetChanged();


                        })
                .setNegativeButton("Cancelar", (dialog, id) -> {


                });

        builder.show();

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView item_name;
        public ImageButton btn_delete;


        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            item_name = (TextView) itemLayoutView.findViewById(R.id.txt_Name);
            btn_delete = (ImageButton) itemLayoutView.findViewById(R.id.btn_delete_unit);

        }
    }
}
