package com.example.pocketlibrary.ViewModel;

import static com.example.pocketlibrary.View.MainActivity.mBookModel;
import static com.example.pocketlibrary.View.MainActivity.navCo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pocketlibrary.Model.BookModel;
import com.example.pocketlibrary.R;
import com.example.pocketlibrary.View.Book;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class BooksRVAdapterSearch extends RecyclerView.Adapter<BooksRVAdapterSearch.ViewHolder>{
    private ArrayList<BookModel> bookModelArrayList;
    private Context context;
    private BookViewModel BVM = new BookViewModel();
    private static BookModel model;

    public BooksRVAdapterSearch(ArrayList<BookModel> bookModelArrayList, Context context) {
        this.bookModelArrayList = bookModelArrayList;
        this.context = context;
        this.GrantBookList = bookModelArrayList;
    }
    private ArrayList<BookModel> GrantBookList;
    private ArrayList<BookModel> mFilteredList;

    public void filter(String charText) {
        bookModelArrayList = GrantBookList;
        charText = charText.toLowerCase(Locale.getDefault());
        if (charText.length() == 0) {//jika string kosong
           mFilteredList = bookModelArrayList;
        } else {//filter dan buat arraybaru dengan filter query model
            ArrayList<BookModel> filteredList = new ArrayList<>();

            for (BookModel wp : bookModelArrayList) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    filteredList.add(wp);
                }
            }
            mFilteredList = filteredList;

        }
        bookModelArrayList = mFilteredList;
        //memperbarui list adapter
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BooksRVAdapterSearch.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BooksRVAdapterSearch.ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_search, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BooksRVAdapterSearch.ViewHolder holder, int position) {
        BookModel bookModel = bookModelArrayList.get(position);
        holder.nameTV.setText(bookModel.getName());
        holder.authorTV.setText(bookModel.getAuthor());
        Picasso.with(context).load(bookModel.getImgUri()).into(holder.imageIV);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                model = bookModel;
                navCo.navigate(R.id.book);
                mBookModel = model;
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookModelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nameTV;
        private TextView authorTV;
        private ImageView imageIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.name_book);
            authorTV = itemView.findViewById(R.id.author);
            imageIV = itemView.findViewById(R.id.img_book_search);
        }
    }
}
