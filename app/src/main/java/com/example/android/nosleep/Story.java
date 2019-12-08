package com.example.android.nosleep;

import android.util.Log;

public class Story {
    private String mtitle;
    private String mauthor;
    private String mreadTime;

    //Constructor to initialize the data
    public Story(String dataTitle,String dataAuthor,String dataReadTime){
        mtitle = dataTitle;
        mauthor = dataAuthor;
        mreadTime = dataReadTime;
        Log.d("In the story",mtitle);
    }

    //Getter functions


    public String getTitle() {
        return mtitle;
    }

    public String getAuthor(){
        return mauthor;
    }

    public String getReadTime() {
        return mreadTime;
    }
}
