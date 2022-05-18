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
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pocketlibrary.Model.BookModel;
import com.example.pocketlibrary.R;
import com.example.pocketlibrary.View.ActualNews;
import com.example.pocketlibrary.View.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BooksRVAdapter extends RecyclerView.Adapter<BooksRVAdapter.ViewHolder> {
    private ArrayList<BookModel> bookModelArrayList;
    private Context context;
    private BookViewModel BVM = new BookViewModel();
    private static BookModel model;

    public BooksRVAdapter(ArrayList<BookModel> bookModelArrayList, Context context) {
        this.bookModelArrayList = bookModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public BooksRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BooksRVAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_news, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BookModel bookModel = bookModelArrayList.get(position);
        holder.nameTV.setText(bookModel.getName());

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
        private ImageView imageIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTV = itemView.findViewById(R.id.tv_text_news);
            imageIV = itemView.findViewById(R.id.img_book_news);
        }
    }
}
