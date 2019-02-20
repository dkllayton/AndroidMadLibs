package com.schoolgroup.androidmadlibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Word> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        words.add(new Word(WordType.NOUN));
    }

    public void submit() {
        // Get text from text input
        String text = null;

    }
}
