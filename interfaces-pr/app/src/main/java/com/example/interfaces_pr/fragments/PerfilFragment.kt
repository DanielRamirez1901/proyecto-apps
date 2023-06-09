package com.example.interfaces_pr.fragments

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.graphics.BitmapFactory
import android.icu.util.Calendar
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.interfaces_pr.databinding.PerfilfragmentBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.auth.User
import java.util.Locale

class PerfilFragment(private val username: String) : Fragment() {
    private lateinit var imagePickerLauncher: ActivityResultLauncher<String>
    lateinit var binding: PerfilfragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PerfilfragmentBinding.inflate(inflater, container, false)
        binding.name.text = username

        imagePickerLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                val bitmap = BitmapFactory.decodeStream(requireContext().contentResolver.openInputStream(uri))
                binding.perfilEditImg.setImageBitmap(bitmap)
            }
        }

        verifyUserId()

        binding.editIMG.setOnClickListener {
            imagePickerLauncher.launch("image/*")
        }
        binding.editNacimientoButton.setOnClickListener {
            showDatePickerDialog()
        }
        binding.editTelefonoButton.setOnClickListener {
            showEditDialog()
        }
        binding.career.setOnClickListener {
            showEditDialog2()
        }
        return binding.root
    }
    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = formatDate(selectedYear, selectedMonth, selectedDay)
                binding.descriptionDate.text = selectedDate
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun formatDate(year: Int, month: Int, day: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        val dateFormat = java.text.SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }
    private fun verifyUserId() {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val userId = currentUser?.uid
        val database = FirebaseDatabase.getInstance().reference

        if (userId != null) {
            database.child("users").child(userId).addListenerForSingleValueEvent(object :
                ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val user = dataSnapshot.getValue(User::class.java)
                    if (user != null) {
                        // Comparar el ID del usuario actual con el ID almacenado en Firebase
                        if (userId == username) {
                            // El ID del usuario actual coincide con el ID almacenado en Firebase
                            // Mostrar el botón editIMG
                            binding.editIMG.visibility = View.VISIBLE
                        } else {
                            // El ID del usuario actual no coincide con el ID almacenado en Firebase
                            // Ocultar el botón editIMG
                            binding.editIMG.visibility = View.GONE
                        }
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {
                    // Manejar el error de la consulta a la base de datos, si es necesario
                }
            })
        }
    }
    private fun showEditDialog() {
        val builder = AlertDialog.Builder(requireContext())
        val editText = EditText(requireContext())
        editText.inputType = android.text.InputType.TYPE_CLASS_NUMBER
        builder.setView(editText)
        builder.setTitle("Editar número")
        builder.setPositiveButton("Aceptar") { _, _ ->
            val number = editText.text.toString()
            binding.celularLabel.text = number
        }
        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }
    private fun showEditDialog2() {
        val builder = AlertDialog.Builder(requireContext())
        val editText = EditText(requireContext())
        builder.setView(editText)
        builder.setTitle("Editar Descripción")
        builder.setPositiveButton("Aceptar") { _, _ ->
            val newText = editText.text.toString()
            binding.career.text = newText
        }
        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }

}
