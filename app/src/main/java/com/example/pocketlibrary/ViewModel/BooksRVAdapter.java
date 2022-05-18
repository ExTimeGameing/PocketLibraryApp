package com.example.pocketlibrary.ViewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pocketlibrary.Model.Book;
import com.example.pocketlibrary.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BooksRVAdapter extends RecyclerView.Adapter<BooksRVAdapter.ViewHolder> {
    private ArrayList<Book> bookArrayList;
    private Context context;

    public BooksRVAdapter(ArrayList<Book> bookArrayList, Context context) {
        this.bookArrayList = bookArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public BooksRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BooksRVAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = bookArrayList.get(position);
        holder.nameTV.setText(book.getName());

        Picasso.with(context).load(book.getImgUri()).into(holder.imageIV); // TODO
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_actualNews_to_book);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTV;
        private ImageView imageIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.tv_text_news);
            imageIV = itemView.findViewById(R.id.img_book_news);
        }
    }
}
