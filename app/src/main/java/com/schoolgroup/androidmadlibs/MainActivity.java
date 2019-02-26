package com.schoolgroup.androidmadlibs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private int index;
    private ArrayList<Word> words;
    private String madLib;

    private Button submit;
    private TextView prompt;
    private EditText entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        index = 0;
        words = new ArrayList<>();
        madLib = getResources().getString(R.string.mad_lib1);

        parse();

        submit = findViewById(R.id.button);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { submit(); }
        });
        prompt = findViewById(R.id.textView3);
        prompt.setText("Write " + words.get(0).getType() + ".");
        entry = findViewById(R.id.editText);
        entry.setText(words.get(0).getType());
    }

    public void submit() {
        String text = entry.getText().toString();
        words.get(index).setValue(text);
        index++;
        if (index == words.size() - 1) {
            submit.setText(R.string.finish);
        }
        if (index >= words.size()) {
            viewMadLib();
        } else {
            prompt.setText("Write " + words.get(index).getType() + ".");
            entry.setText(words.get(index).getType());
        }
    }

    public void viewMadLib() {
        int i = 0;
        String finalMadLib = "";
        String[] words = madLib.split(" ");
        for (String word : words) {
            if (word.startsWith("$") && word.endsWith("$")) {
                finalMadLib += this.words.get(i).getValue() + " ";
                i++;
            } else {
                finalMadLib += word + " ";
            }
        }
        prompt.setText(finalMadLib);
        entry.setActivated(false);
        entry.setVisibility(View.INVISIBLE);
        submit.setActivated(false);
        submit.setVisibility(View.INVISIBLE);
    }

    public void parse() {
        String[] words = madLib.split(" ");
        for (String word : words) {
            if (word.startsWith("$") && word.endsWith("$")) {
                String type = word.substring(1, word.length() - 1);
                this.words.add(new Word(type));
            }
        }
    }
}
