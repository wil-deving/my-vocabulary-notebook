package com.gmail.wil.myvocabularynotebook.Utils

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun createDialog(context: Context, title: String, message: String, onClickPositive: () -> Unit) : AlertDialog {
    val alertDialog = AlertDialog.Builder(context)
    alertDialog.setTitle(title)
    alertDialog.setMessage(message)
    //prohibimos que al hacer click en cualquier lugar de la pantalla el dialogo desaparezca
    alertDialog.setCancelable(false)
    alertDialog.setPositiveButton("Aceptar") { dialogInterface, i ->
        onClickPositive()
    }
    //el botonnext neutral se ubica a la izquierda, esto por reglas de diseño
    alertDialog.setNeutralButton("Cancelar"){ dialogInterface, i ->
        // Toast.makeText(this, "Click en cancelar", Toast.LENGTH_SHORT).show()
    }
    return alertDialog.create()
}