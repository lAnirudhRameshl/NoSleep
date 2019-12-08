package com.example.android.nosleep;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TopActvity extends Fragment {

    private DatabaseReference mDatabase;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.activity_top,container,false);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        final ArrayList<Story> newStoryList = new ArrayList<Story>();
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String,Object> allVal =(HashMap<String, Object>)dataSnapshot.child("top").getValue();
                Set<String> key = allVal.keySet();
                for(String child : key){
                    Log.d("MESSAGE TOP ACTIVITY",child);
                    newStoryList.add(new Story(dataSnapshot.child("top").child(child).child("Title").getValue().toString(),dataSnapshot.child("top").child(child).child("Author").getValue().toString(),dataSnapshot.child("top").child(child).child("Readtime").getValue().toString()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        StoryAdapter<Story> storyAdapter =new StoryAdapter<>(getActivity(),newStoryList);
        ListView listView = (ListView)layout.findViewById(R.id.topStories);
        listView.setAdapter(storyAdapter);

        return layout;
    }
}
