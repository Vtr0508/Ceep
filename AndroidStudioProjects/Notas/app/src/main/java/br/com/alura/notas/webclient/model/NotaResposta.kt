package br.com.alura.notas.webclient.model

import br.com.alura.notas.model.Nota
import java.util.UUID

class NotaResposta(
    val id: String?,
    val titulo: String?,
    val descricao: String?,
    val imagem: String?
) {

    val nota: Nota get() = Nota(
        id = id ?: UUID.randomUUID().toString(),
        titulo ?: "",
        descricao ?: "",
        imagem ?: ""
    )
}