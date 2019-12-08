package com.example.android.nosleep;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class NewActivity extends Fragment {

    private DatabaseReference mDatabase;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View layout = inflater.inflate(R.layout.activity_new,container,false);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        final ArrayList<Story> newStoryList = new ArrayList<>();
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map<String,Object> allVal =(HashMap<String, Object>)dataSnapshot.child("new").getValue();
                Set<String> key = allVal.keySet();
                for(String child : key){
                    Log.d("MESSAGE NEW ACTIVITY",child);
                    Log.d("TOP ACTIVITY TITLE",dataSnapshot.child("new").child(child).child("Title").getValue().toString());
                    newStoryList.add(new Story(dataSnapshot.child("new").child(child).child("Title").getValue().toString(),dataSnapshot.child("new").child(child).child("Author").getValue().toString(),dataSnapshot.child("new").child(child).child("Readtime").getValue().toString()));
                }
                Log.d("NEWTEST","" + newStoryList.size());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        StoryAdapter<Story> storyAdapter =new StoryAdapter<>(getActivity(), newStoryList);
        ListView listView = (ListView) layout.findViewById(R.id.newStories);
        listView.setAdapter(storyAdapter);

        return layout;
    }
}
