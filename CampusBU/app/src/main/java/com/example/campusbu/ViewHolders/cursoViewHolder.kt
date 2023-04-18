package com.example.campusbu.ViewHolders


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.campusbu.databinding.FormatPublicacionBinding

class CourseViewHolder(root: View): RecyclerView.ViewHolder(root) {

    private val binding = FormatPublicacionBinding.bind(root)
    val perfilCurso = binding.perfilIconImg
    val imagePublic = binding.imageCurso
    val title = binding.nameCursoLabel
    val description = binding.descipctionLabel
}