package com.example.pocketlibrary.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pocketlibrary.Model.BookModel;
import com.example.pocketlibrary.R;
import com.example.pocketlibrary.ViewModel.BooksRVAdapter;
import com.example.pocketlibrary.databinding.FragmentActualNewsBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ActualNews extends Fragment {
    static FragmentActualNewsBinding binding;
    private RecyclerView newsRV;
    private ArrayList<BookModel> bookModelArrayList;
    private BooksRVAdapter booksRVAdapter;
    private FirebaseFirestore db;

    public ActualNews() {
        // Required empty public constructor
    }

    public static ActualNews newInstance() {
        return new ActualNews();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actual_news, container, false);
        binding = FragmentActualNewsBinding.bind(view);
        binding.actualIMG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.chitai-gorod.ru/catalog/bestsell/"));
                startActivity(browserIntent);
            }
        });
        newsRV = binding.container1;
        db = FirebaseFirestore.getInstance();
        bookModelArrayList = new ArrayList<>();
        booksRVAdapter = new BooksRVAdapter(bookModelArrayList, this.getContext());
        newsRV.setHasFixedSize(true);
        newsRV.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL, false));
        newsRV.setAdapter(booksRVAdapter);
        loadrecyclervViewData();
        return binding.getRoot();
    }

    private void loadrecyclervViewData(){
        db.collection("Data").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()){
                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot d : list){
                        BookModel bookModel = d.toObject(BookModel.class);
                        bookModelArrayList.add(bookModel);
                    }
                    booksRVAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(ActualNews.newInstance().getContext(), "No data found in database", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ActualNews.newInstance().getContext(), "Fail to get data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static void getBind(){
        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_actualNews_to_book);
    }
}