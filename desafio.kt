enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Float, val dificuldade: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val dificuldade: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
        if(!inscritos.contains(usuario)){
        	inscritos.add(usuario)
            println("Usuário ${usuario.nome} se inscreveu no curso de formação $nome")
        }else{
            println("O usuário ${usuario.nome} já está inscrito no curso de formação $nome")
        }
    }
}

val listaDeCursos: MutableList<Formacao> = mutableListOf()
val listaDeCursosRead: List<Formacao> = listaDeCursos


fun cursos(){
    println("Lista dos cursos: ")
    listaDeCursosRead.forEach{
        println("\tCurso: ${it.nome}")
        println("\tDificuldade: ${it.dificuldade}")
        println("\tConteúdos: ")
        it.conteudos.forEach{
            println("\t\t${it.nome}")
            println("\t\tDificuldade: ${it.dificuldade}")
            println("\t\tDuração: ${it.duracao}")
            println()
        }
        println("\tInscritos: ")
        it.inscritos.forEach{
            println("\t\t${it.nome}")
        }
    }
}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
	val usuario1 = Usuario("Daniel")
	val usuario2 = Usuario("Madeira")
	val usuario3 = Usuario("Pedro")
    
    val conteudoKotlin = ConteudoEducacional("1 Introdução", 2.5F, Nivel.BASICO)
    val conteudoKotlin2 = ConteudoEducacional("2 Controle de Fluxo", 2.0F, Nivel.BASICO)
    
    val formacaoKotlin1 = Formacao("Iniciando no Kotlin", listOf(conteudoKotlin, conteudoKotlin2), Nivel.BASICO)
    
    listaDeCursos.add(formacaoKotlin1)
    
    formacaoKotlin1.matricular(usuario1)
    formacaoKotlin1.matricular(usuario2)
    
    cursos()
    //println("Curso de formação ${formacaoKotlin1.nome} \n ${formacaoKotlin1.conteudos.map{it.nome}}")
    
}