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
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.interfaces_pr.databinding.PerfilfragmentBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
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

        downloadSubcollectionData()

        imagePickerLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                val bitmap =
                    BitmapFactory.decodeStream(requireContext().contentResolver.openInputStream(uri))
                binding.perfilEditImg.setImageBitmap(bitmap)
            }
        }

        verifyUserId()

        binding.editIMG.setOnClickListener {
            imagePickerLauncher.launch("image/*") //falta que suba a base de datos
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

                // Obtén el ID único de Firebase del usuario actual
                val userId = FirebaseAuth.getInstance().currentUser?.uid

                // Verifica que el ID de usuario no sea nulo
                if (userId != null) {
                    // Obtén una referencia al documento del usuario utilizando su ID único
                    val userDocument = FirebaseFirestore.getInstance().collection("users").document(userId)

                    // Actualiza el atributo "fecha" del documento del usuario con la nueva fecha seleccionada
                    userDocument.update("fecha", selectedDate)
                        .addOnSuccessListener {
                            // La actualización se realizó exitosamente en la base de datos
                            Toast.makeText(requireContext(), "Fecha guardada correctamente", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener { e ->
                            // Ocurrió un error al realizar la actualización en la base de datos
                            Toast.makeText(requireContext(), "Error al guardar la fecha: ${e.message}", Toast.LENGTH_SHORT).show()
                        }
                }
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

            // Obtén el ID único de Firebase del usuario actual
            val userId = FirebaseAuth.getInstance().currentUser?.uid

            // Verifica que el ID de usuario no sea nulo
            if (userId != null) {
                // Obtén una referencia al documento del usuario utilizando su ID único
                val userDocument = FirebaseFirestore.getInstance().collection("users").document(userId)

                // Actualiza el atributo "telefono" del documento del usuario con el nuevo número de teléfono
                userDocument.update("telefono", number)
                    .addOnSuccessListener {
                        // La actualización se realizó exitosamente en la base de datos
                        Toast.makeText(requireContext(), "Información guardada correctamente", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener { e ->
                        // Ocurrió un error al realizar la actualización en la base de datos
                        Toast.makeText(requireContext(), "Error al guardar la información: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
            }
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
            // Obtén el ID único de Firebase del usuario actual
            val userId = FirebaseAuth.getInstance().currentUser?.uid

            // Verifica que el ID de usuario no sea nulo
            if (userId != null) {
                // Obtén una referencia al documento del usuario utilizando su ID único
                val userDocument = FirebaseFirestore.getInstance().collection("users").document(userId)

                // Actualiza el atributo "telefono" del documento del usuario con el nuevo número de teléfono
                userDocument.update("description", newText)
                    .addOnSuccessListener {
                        // La actualización se realizó exitosamente en la base de datos
                        Toast.makeText(requireContext(), "Información guardada correctamente", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener { e ->
                        // Ocurrió un error al realizar la actualización en la base de datos
                        Toast.makeText(requireContext(), "Error al guardar la información: ${e.message}", Toast.LENGTH_SHORT).show()
                    }
            }
        }
        builder.setNegativeButton("Cancelar", null)
        builder.show()
    }

    private fun downloadSubcollectionData() {
        // Obtén el ID único de Firebase del usuario actual
        val userId = FirebaseAuth.getInstance().currentUser?.uid

        // Verifica que el ID de usuario no sea nulo
        if (userId != null) {
            // Obtén una referencia al documento del usuario utilizando su ID único
            val userDocument = FirebaseFirestore.getInstance().collection("users").document(userId)

            userDocument.get()
                .addOnSuccessListener { documentSnapshot ->
                    if (documentSnapshot.exists()) {
                        // Accede a los atributos del documento del usuario
                        val description = documentSnapshot.getString("description")
                        val fecha = documentSnapshot.getString("fecha")
                        val telefono = documentSnapshot.getString("telefono")
                        val intValue = documentSnapshot.getLong("userImg")?.toInt() ?: 0
                        val drawable = ContextCompat.getDrawable(requireContext(), intValue)

                        // Asigna los valores descargados a los labels e ImageView correspondientes en la interfaz de usuario
                        binding.career.text = description
                        binding.descriptionDate.text = fecha
                        binding.celularLabel.text = telefono
                        binding.perfilEditImg.setImageDrawable(drawable)

                        // Realiza las operaciones necesarias con los atributos descargados
                        // ...
                    } else {
                        // El documento del usuario no existe
                        Toast.makeText(requireContext(), "El documento del usuario no existe", Toast.LENGTH_SHORT).show()
                    }
                }
                .addOnFailureListener { e ->
                    // Ocurrió un error al descargar el documento del usuario
                    Toast.makeText(requireContext(), "Error al descargar el documento del usuario: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }


}
