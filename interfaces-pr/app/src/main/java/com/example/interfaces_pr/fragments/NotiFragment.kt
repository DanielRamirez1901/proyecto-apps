package com.example.interfaces_pr.fragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.interfaces_pr.adapter.NotificationAdapter
import com.example.interfaces_pr.databinding.ListItemNotificationBinding

class NotiFragment : Fragment() {
    private lateinit var binding: ListItemNotificationBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        binding = ListItemNotificationBinding.inflate(inflater, container, false)
        return binding.root





    }
}
