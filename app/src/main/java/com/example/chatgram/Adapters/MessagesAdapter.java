package com.example.chatgram.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chatgram.Models.Message;
import com.example.chatgram.R;
import com.example.chatgram.databinding.ItemRecieveBinding;
import com.example.chatgram.databinding.ItemSentBinding;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MessagesAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList<Message> messages;

    final int ITEM_SENT = 1;
    final int ITEM_RECEIVE =2;

    public MessagesAdapter(Context context, ArrayList<Message> messages){

        this.context = context;
        this.messages=messages;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType== ITEM_SENT){

            View view= LayoutInflater.from(context).inflate(R.layout.item_sent, parent ,false);

            return new SentViewHolder(view);
        }
        else{

            View view = LayoutInflater.from(context).inflate(R.layout.item_recieve, parent ,false);
            return new RecieverView(view);
        }

    }

    @Override
    public int getItemViewType(int position) {

        Message message=messages.get(position);
        if (FirebaseAuth.getInstance().getUid().equals(message.getSenderId())){
            return ITEM_SENT;
        }
        else {
            return ITEM_RECEIVE;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public class SentViewHolder extends RecyclerView.ViewHolder{

        ItemSentBinding binding;


        public SentViewHolder(@NonNull View itemView) {
            super(itemView);
            binding =  ItemSentBinding.bind(itemView);
        }
    }

    public class RecieverView extends RecyclerView.ViewHolder{

        ItemRecieveBinding binding;

        public RecieverView(@NonNull View itemView) {
            super(itemView);
            binding= ItemRecieveBinding.bind(itemView);
        }
    }
}
