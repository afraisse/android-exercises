package fr.android.androidexercises;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BookRecyclerAdapter extends RecyclerView.Adapter<BookRecyclerAdapter.ViewHolder> {

    private List<Book> books;
    private LayoutInflater layoutInflater;


    public BookRecyclerAdapter(Context context, List<Book> books) {
        this.books = books;
        layoutInflater = LayoutInflater.from(context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTxtView;
        public TextView priceTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.nameTxtView = (TextView) itemView.findViewById(R.id.nameTextView);
            this.priceTextView = (TextView) itemView.findViewById(R.id.priceTextView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = layoutInflater.inflate(R.layout.item_book, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nameTxtView.setText(books.get(position).name);
        holder.priceTextView.setText(String.valueOf(books.get(position).price) + "€");
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

}
