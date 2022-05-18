package com.example.pocketlibrary.View;

import static com.example.pocketlibrary.View.MainActivity.navCo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pocketlibrary.R;
import com.example.pocketlibrary.ViewModel.BookViewModel;
import com.example.pocketlibrary.ViewModel.BooksRVAdapter;
import com.example.pocketlibrary.databinding.ActivityBookBinding;
import com.squareup.picasso.Picasso;

public class Book extends Fragment {
    private ActivityBookBinding binding;
    private BookViewModel BVM = new BookViewModel();

    public Book() {
        // Required empty public constructor
    }

    public static Book newInstance() {
        return new Book();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_book, container, false);
        binding = ActivityBookBinding.bind(view);
        BVM.setmBookModel(BooksRVAdapter.getModel());
        binding.back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_book_to_actualNews);
            }
        });
        binding.buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navCo.navigate(R.id.mapsActivity);
                MainActivity.navigation.setVisibility(View.GONE);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        BVM.getBook().observe(getViewLifecycleOwner(), bookModel -> {
            Picasso.with(getContext()).load(bookModel.getImgUri()).into(binding.imageView2);
            binding.textDescription.setText(bookModel.getDescription());
        });
    }
}