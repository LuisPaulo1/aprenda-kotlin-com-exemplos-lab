// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun desmatricular(usuario: Usuario) {
        inscritos.remove(usuario)
    }

    fun estaMatriculado(usuario: Usuario): Boolean {
        return inscritos.contains(usuario)
    }

    fun totalMatriculados(): Int {
        return inscritos.size
    }

}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 60)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos com Kotlin", 120)
    val conteudo3 = ConteudoEducacional("Desenvolvimento Web com Kotlin", 180)
    val conteudo4 = ConteudoEducacional("Banco de Dados com Kotlin", 140)

    val formacao = Formacao("Especialista Kotlin", Nivel.AVANCADO, mutableListOf(conteudo1, conteudo2, conteudo3, conteudo4))

    val usuario1 = Usuario()
    val usuario2 = Usuario()
    val usuario3 = Usuario()

    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    formacao.matricular(usuario3)

    println("Usuário 1 está matriculado? ${if(formacao.estaMatriculado(usuario1)) "Sim" else "Não"}")
    println("Usuário 2 está matriculado? ${if(formacao.estaMatriculado(usuario2)) "Sim" else "Não"}")
    println("Usuário 3 está matriculado? ${if(formacao.estaMatriculado(usuario3)) "Sim" else "Não"}")

    println("Total de matriculados: ${formacao.totalMatriculados()}")

    formacao.desmatricular(usuario2)

    println("Usuário 2 está matriculado? ${if(formacao.estaMatriculado(usuario2)) "Sim" else "Não"}")

    println("Total de matriculados: ${formacao.totalMatriculados()}")

}