package com.example.pocketlibrary.Model;

public class Book {
    private String name;
    private String author;
    private String description;
    private String imgUri;

    public Book() {
    }

    public Book(String name, String author, String description, String imgUri){
        this.author = author;
        this.name = name;
        this.description = description;
        this.imgUri = imgUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }
}
