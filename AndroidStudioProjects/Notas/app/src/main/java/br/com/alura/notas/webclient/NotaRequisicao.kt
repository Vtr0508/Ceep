package br.com.alura.notas.webclient

data class NotaRequisicao(
    val titulo: String,
    val descricao: String,
    val imagem: String? = null
) {

}
