package com.example.projet2019;

import com.example.projet2019.model.Magic;
import com.squareup.picasso.Picasso;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CelluleJava> {

    public interface OnItemClickListener {
        void onItemClick(Magic item);
    }

    private List<Magic> cards;
    private final OnItemClickListener listener;


    // construsteur //
    public MyAdapter(List<Magic> items, OnItemClickListener listener) {
        this.cards = items;
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        View vbis = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    public class CelluleJava extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView image;
        public View layout;


        //Constructeur
        public CelluleJava(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            image = v.findViewById(R.id.icon);
            image = (ImageView) itemView.findViewById(R.id.image);

        }

    }

    public void add(int position, Magic item) {
        cards.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        cards.remove(position);
        notifyItemRemoved(position);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(CelluleJava holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Magic currentMagicCard = cards.get(position);
        final String name = currentMagicCard.getName();

        holder.txtHeader.setText(name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(currentMagicCard);
            }


        });
        holder.txtFooter.setText("Footer " + name);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return cards.size();
    }
}


