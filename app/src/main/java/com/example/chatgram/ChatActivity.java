package com.example.chatgram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.chatgram.databinding.ActivityChatBinding;
import com.example.chatgram.databinding.ActivityMainBinding;

public class ChatActivity extends AppCompatActivity {

    ActivityChatBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}