package com.example.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.FragmentHomeBinding

class HomeFragment: Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    // Create your list
    private val messageList = listOf(
        Message("Tom Misch", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "1:11 am", "Ello kamusta ka bro?"),
        Message("Taylor Swift", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "4:23 am", "Asa naman ka"),
        Message("Rex Orange County", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "1:11 pm", "I'll be the one, that stays till the end"),
        Message("Matthew Healy", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "8:23 am", "She said.."),
        Message("Avril Lavigne", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "7:11 am", "He is a skater boi"),
        Message("Bruno Mars", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "10:30 am", "Talking to the moon"),
        Message("Phum Viphurit", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "7:11 pm", "Darling I got my trust issues"),
        Message("FKJ", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "11:00 pm", "Skyliiine"),
        Message("Billie Eilish", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "5:09 am", "Call me when the party's over"),
        Message("Justin Bieber", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "8:23 am", "Baby baby baby oh"),
        Message("PREP", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "1:23 pm", "2 miles of the ground"),
        Message("Avril Lavigne", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "7:11 am", "He is a skater boi"),
        Message("Bruno Mars", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "10:30 am", "Talking to the moon"),
        Message("Phum Viphurit", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "7:11 pm", "Darling I got my trust issues"),
        Message("FKJ", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "11:00 pm", "Skyliiine"),
        Message("Billie Eilish", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "5:09 am", "Call me when the party's over"),
        Message("Justin Bieber", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "8:23 am", "Baby baby baby oh"),
        Message("PREP", "https://cdn.vox-cdn.com/thumbor/nDW7YqKV8soKsZSfRorGXJLSH50=/1400x1400/filters:format(jpeg)/cdn.vox-cdn.com/uploads/chorus_asset/file/22147179/1229892934.jpg" , "1:23 pm", "2 miles of the ground"),
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Set layout manager so RecyclerView knows how to display your items
        binding.rv.layoutManager = LinearLayoutManager(context)
        // Set the adapter to your RecyclerView while also passing the list to the constructor
        binding.rv.adapter = MessageAdapter(messageList) {
            Toast.makeText(
                context,
                "${it.sender}'s message was clicked",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}