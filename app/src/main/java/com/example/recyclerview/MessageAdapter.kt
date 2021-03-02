package com.example.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview.databinding.ItemMessageBinding

// onClickListener as lambda,
// (Message) will be provided by where it is called, then will be received by the provider of the lambda
// Unit, meaning the lambda doesn't return any value
class MessageAdapter(
    private val messageList: List<Message>,
    private val onClickListener: (Message) -> Unit
) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    private var viewHolderCount = 0
    private var onBindViewHolderCount = 0

    // Initialize your ViewHolder here
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        Log.d("MessageAdapter", "ViewHolderCalled: ${++viewHolderCount} times")
        val binding = ItemMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MessageViewHolder(binding)
    }

    // Called called by RecyclerView to display the data at the specified position.
    // This method is used to update the contents of the itemView to reflect the item at the given position.
    // For more info https://stackoverflow.com/a/37524217/5938872
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        Log.d("MessageAdapter", "OnBindViewHolderCalled: ${++onBindViewHolderCount} times, Position: $position")
        val message = messageList[position]
        holder.bind(message)
    }

    // Provide the size of your list
    override fun getItemCount(): Int = messageList.size

    // inner class ViewHolder to set the data on your respective Views
    inner class MessageViewHolder(private val binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                // Call the lambda here and provide the Message object
                // we can specify the Message object clicked by referring to messageList[adapterPosition]
                // where adapterPosition is provided in the ViewHolder class
                onClickListener(messageList[adapterPosition])
            }
        }

        // Display necessary data to your Item layout
        fun bind(message: Message) {
            Glide.with(binding.root).load(message.image).into(binding.ivProfile)
            binding.tvName.text = message.sender
            binding.tvDate.text = message.dateSent
            binding.tvMessage.text = message.lastMessageSent
        }
    }
}
