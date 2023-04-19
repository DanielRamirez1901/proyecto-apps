package com.example.interfaces_pr.viewholders


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.interfaces_pr.databinding.FormatPublicacionBinding

class CursoViewHolder(root: View): RecyclerView.ViewHolder(root) {

    private val binding = FormatPublicacionBinding.bind(root)
    val perfilCurso = binding.perfilIconImg
    val imagePublic = binding.imageCurso
    val title = binding.nameCursoLabel
    val description = binding.descipctionLabel
}