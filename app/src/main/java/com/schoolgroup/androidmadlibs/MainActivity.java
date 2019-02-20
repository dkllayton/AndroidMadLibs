package com.schoolgroup.androidmadlibs;

import android.content.res.Resources;
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

    public void parse(String madLib) {
        String[] words = madLib.split(" ");
        for (String word : words) {
            if (word.startsWith("$") && word.endsWith("$")) {
                if (word.equals(getResources().getString(R.string.noun))) {

                } else if (word.equals(getResources().getString(R.string.proper_noun))) {

                }
            }
        }
    }
}
