package com.example.pocketlibrary.ViewModel;

import android.text.method.MultiTapKeyListener;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pocketlibrary.Model.BookModel;
import com.example.pocketlibrary.View.Book;

public class BookViewModel extends MutableLiveData {
    private MutableLiveData<BookModel> mBookModel = new MutableLiveData<>();

    public MutableLiveData<BookModel> getBook(){return mBookModel;}

    public void setmBookModel(BookModel bookModel){mBookModel.setValue(bookModel);}

}
