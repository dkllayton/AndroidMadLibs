package com.schoolgroup.androidmadlibs;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int index;
    private ArrayList<Word> words;
    private String madLib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        index = 0;
        words = new ArrayList<>();
        madLib = getResources().getString(R.string.mad_lib1);

        parse();
    }

    public void submit() {
        // Get text from text input
        String text = null;
        words.get(index).setValue(text);
        index++;
    }

    public void viewMadLib() {
        TextView textView = null;

        int i = 0;
        String finalMadLib = "";
        String[] words = madLib.split(" ");
        for (String word : words) {
            if (word.startsWith("$") && word.endsWith("$")) {
                finalMadLib += this.words.get(i);
                i++;
            } else {
                finalMadLib += word;
            }
        }

        textView.setText(finalMadLib);
    }

    public void parse() {
        String[] words = madLib.split(" ");
        for (String word : words) {
            if (word.startsWith("$") && word.endsWith("$")) {
                WordType type = null;
                if (word.equals(getResources().getString(R.string.noun))) {
                    type = WordType.NOUN;
                } else if (word.equals(getResources().getString(R.string.proper_noun))) {
                    type = WordType.PROPER_NOUN;
                } else if (word.equals(getResources().getString(R.string.verb))) {
                    type = WordType.VERB;
                } else if (word.equals(getResources().getString(R.string.adjective))) {
                    type = WordType.ADJECTIVE;
                }
                this.words.add(new Word(type));
            }
        }
    }
}
