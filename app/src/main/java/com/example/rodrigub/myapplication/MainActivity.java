package com.example.rodrigub.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button demoButton = (Button) findViewById(R.id.button2);
    }

    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.word1);
        EditText editText2 = (EditText) findViewById(R.id.word2);
        String message = editText.getText().toString();
        String message2 = editText2.getText().toString();

        if (isAnagram(message, message2))
            intent.putExtra(EXTRA_MESSAGE, "True");
        else
            intent.putExtra(EXTRA_MESSAGE, "False");

        startActivity(intent);
    }

    public static boolean isAnagram (String word1, String word2)
    {
        if (word1.length() != word2.length())
            return false;

        HashMap<String, Integer> hash1 = new HashMap<>();
        HashMap <String, Integer> hash2 = new HashMap<>();

        int counter = 0;

        for (char element : word1.toCharArray())
        {
            while (hash1.containsKey(element + "" + counter))
                counter ++;

            hash1.put(element + "" + counter, 1);

            counter = 0;
        }

        for (char element : word2.toCharArray())
        {
            while (hash2.containsKey(element + "" + counter))
                counter ++;

            hash2.put(element + ""+ counter, 2);

            counter = 0;
        }

        hash2.putAll(hash1);

        if (hash2.containsValue(2))
            return false;
        else
            return true;
    }

}