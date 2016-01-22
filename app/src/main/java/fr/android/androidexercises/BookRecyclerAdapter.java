package fr.android.androidexercises;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public class BookRecyclerAdapter extends RecyclerView.Adapter<BookRecyclerAdapter.ViewHolder> {

    private List<Book> books;
    private LayoutInflater layoutInflater;


    public BookRecyclerAdapter(Context context, List<Book> books) {
        this.books = books;
        layoutInflater = LayoutInflater.from(context);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(BookItemView bookItemView) {
            super(bookItemView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BookItemView v = (BookItemView) layoutInflater.inflate(R.layout.custom_view_item_book, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ((BookItemView) holder.itemView).
                bindView(books.get(position));
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

}
