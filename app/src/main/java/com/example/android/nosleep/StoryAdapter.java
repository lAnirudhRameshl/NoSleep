package com.example.android.nosleep;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;



public class StoryAdapter<T> extends ArrayAdapter {

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listStoryView = convertView;

        if(listStoryView == null)
            listStoryView = LayoutInflater.from(getContext()).inflate(R.layout.layout_stories,parent,false);

        final Story presentStory =(Story) getItem(position);

        Log.d("ADAPTER",presentStory.getAuthor());

        TextView title = (TextView)listStoryView.findViewById(R.id.title);

        title.setText(presentStory.getTitle());

        TextView author =  (TextView) listStoryView.findViewById(R.id.story);

        author.setText(presentStory.getAuthor());

        TextView readTime = (TextView)listStoryView.findViewById(R.id.readTime);

        readTime.setText(presentStory.getReadTime());

        return listStoryView;
    }

    public StoryAdapter(Activity context, ArrayList<Story> arrayList)
    {
        super(context,0,arrayList);
    }
}
