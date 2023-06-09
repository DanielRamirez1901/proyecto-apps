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
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.interfaces_pr.databinding.PerfilfragmentBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import java.io.File
import java.util.Locale

class PerfilFragment(private val username: String) : Fragment() {

    private lateinit var imagePickerLauncher: ActivityResultLauncher<String>
    lateinit var binding: PerfilfragmentBinding
    private lateinit var storage: FirebaseStorage
    private lateinit var storageRef: StorageReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PerfilfragmentBinding.inflate(inflater, container, false)
        binding.name.text = username
        downloadSubcollectionData()

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
        imagePickerLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            if (uri != null) {
                val bitmap = BitmapFactory.decodeStream(requireContext().contentResolver.openInputStream(uri))
                binding.perfilEditImg.setImageBitmap(bitmap)

                // Subir la imagen a Firebase Storage
                val storageRef = FirebaseStorage.getInstance().reference
                val userId = FirebaseAuth.getInstance().currentUser?.uid // Obtener el ID único del usuario actual
                val imageRef = storageRef.child("images/${userId}/profile.jpg") // Ruta de almacenamiento en Firebase Storage
                val uploadTask = imageRef.putFile(uri)

                uploadTask.continueWithTask { task ->
                    if (!task.isSuccessful) {
                        task.exception?.let { throw it }
                    }
                    imageRef.downloadUrl
                }.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val downloadUri = task.result

                        // Obtener el ID único de Firebase del usuario actual
                        val userId = FirebaseAuth.getInstance().currentUser?.uid

                        // Verificar que el ID de usuario no sea nulo
                        if (userId != null) {
                            // Obtener una referencia al documento del usuario utilizando su ID único
                            val userDocument = FirebaseFirestore.getInstance().collection("users").document(userId)

                            // Actualizar el atributo "userImg" del documento del usuario con la URL de descarga de la imagen
                            userDocument.update("userImg", downloadUri.toString())
                                .addOnSuccessListener {
                                    // La actualización se realizó exitosamente en la base de datos
                                    Toast.makeText(requireContext(), "Imagen subida correctamente", Toast.LENGTH_SHORT).show()
                                }
                                .addOnFailureListener { e ->
                                    // Ocurrió un error al realizar la actualización en la base de datos
                                    Toast.makeText(requireContext(), "Error al subir la imagen: ${e.message}", Toast.LENGTH_SHORT).show()
                                }
                        }
                    } else {
                        // Ocurrió un error al obtener la URL de descarga de la imagen
                        Toast.makeText(requireContext(), "Error al obtener la URL de descarga de la imagen", Toast.LENGTH_SHORT).show()
                    }
                }
            }
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
        storage = FirebaseStorage.getInstance()
        storageRef = storage.reference
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

                        // Obten la referencia a la imagen en Firebase Storage
                        val imageRef = storageRef.child("images/${userId}/profile.jpg")

                        // Descarga la imagen en un archivo local temporal
                        val localFile = File.createTempFile("images", "jpg")
                        imageRef.getFile(localFile).addOnSuccessListener {
                            // La imagen se descargó exitosamente, ahora puedes cargarla en el ImageView
                            val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                            binding.perfilEditImg.setImageBitmap(bitmap)
                        }.addOnFailureListener {
                            // Ocurrió un error al descargar la imagen
                            // Maneja el error según tus necesidades
                        }
                        // Asigna los valores descargados a los labels e ImageView correspondientes en la interfaz de usuario
                        binding.career.text = description
                        binding.descriptionDate.text = fecha
                        binding.celularLabel.text = telefono

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