package com.example.campusbu.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.campusbu.R
import com.example.campusbu.ViewHolders.CourseViewHolder
import com.example.campusbu.model.cursoAtri
import java.util.Calendar

interface OnItemClickListener {
    fun onItemClick(coursePublications: cursoAtri)
}
class CursoAdapter(): RecyclerView.Adapter<CourseViewHolder>() {

    private var cursos:ArrayList<cursoAtri> = arrayListOf()
    var listener: OnItemClickListener? = null

    init{
        cursos.add(cursoAtri(R.drawable.futbol_icon,R.drawable.baloncestobanner,"Stephen Kury","Este es el contenido de la publicacion hecha por mi 1123123123123123"))
        cursos.add(cursoAtri(R.drawable.foto_perfil,R.drawable.baloncestobanner,"Stephen Kury 2","Este es el contenido de la publicacion hecha por mi 1123123123123123"))
        cursos.add(cursoAtri(R.drawable.futbol_icon,R.drawable.baloncestobanner,"Stephen Kury 3","Este es el contenido de la publicacion hecha por mi 1123123123123123"))
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.format_publicacion,parent,false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.perfilCurso.setImageResource(cursos[position].perfilCurso)
        holder.imagePublic.setImageResource(cursos[position].imagePublic)
        holder.title.text = cursos[position].title
        holder.description.text = cursos[position].descriptionCurso

        holder.itemView.setOnClickListener{
            listener?.onItemClick(cursos[position])
        }
    }

    override fun getItemCount(): Int {
        return cursos.size
    }

}