package com.bca.mp_lab_reports.Lab5;
public class AlbumDetail {
    private final int image;
    private final String title;
    private final String description;
    public AlbumDetail(String t, String d, int i){
        this.image = i;
        this.title = t;
        this.description = d;
    }
    public int getImage(){
        return image;
    }
    public  String getTitle(){
        return title;
    }
    public  String getDescription(){
        return description;
    }
}
