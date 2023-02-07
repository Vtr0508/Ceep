package br.com.alura.notas.webclient

import android.util.Log
import br.com.alura.notas.model.Nota
import kotlin.math.log

private const val TAG = "NotaWebClient"
private val notaService = RetrofitInicializador().notaService

class NotaWebClient {

    suspend fun buscaTodas(): List<Nota>? {
        return try {
            val notasResposta = notaService.buscaTodas()

            notasResposta.map { notaResposta ->
                notaResposta.nota
            }
        } catch (e: Exception) {
            Log.i(TAG, "buscaTodas: ", e)
            null

        }

    }

    suspend fun salva(nota: Nota): Boolean {
        try {
            val resposta = notaService.salva(
                nota.id, NotaRequisicao(
                    titulo = nota.titulo,
                    descricao = nota.descricao,
                    imagem = nota.imagem

                )
            )
            return resposta.isSuccessful

        } catch (e: Exception) {
            Log.i(TAG, "salva: erro ao salvar nota ", e)
        }
        return false

    }

    suspend fun remove(id: String): Boolean {
        try {
            notaService.remove(id)
            return true
        } catch (e: Exception) {
            Log.i(TAG, "remove: Falha ao salvar nota")
        }
        return false
    }
}