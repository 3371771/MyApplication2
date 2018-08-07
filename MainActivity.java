package com.example.kiselev.myapplication;


import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager verticalManager;
    private LinearLayoutManager horizontalManager;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =  findViewById(R.id.rec);

        verticalManager = new LinearLayoutManager(this);
        horizontalManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(verticalManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
        adapter.addAll(ModelItem.getFakeItems());

    }

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
        private ArrayList<ModelItem> items = new ArrayList<>();

        public void addAll(List<ModelItem> fakeItems) {
            int pos = getItemCount();
            this.items.addAll(fakeItems);
            notifyItemRangeInserted(pos, this.items.size());
        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_card, parent,false);
            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
            holder.bind(items.get(position));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView image;


        RecyclerViewHolder(View itemVie) {
            super(itemVie);
            title = itemVie.findViewById(R.id.title);
            image = itemVie.findViewById(R.id.image);
        }

        public void bind (ModelItem modelItem) {
            System.out.println(modelItem.getImgID());
            image.setImageResource(modelItem.getImgID());
            title.setText(modelItem.getAuthor());


        }
    }
}
