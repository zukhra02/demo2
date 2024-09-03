package org.example.demo2.model;


import lombok.Data;

@Data

public class Movie {
    private long Id;
    private String Title;
    private String Director;
    private String Year;
    private String Genre;
    private String Language;
    private int Revenue;
    private boolean Agelimitation;

}
