Feito por Guilherme de Araujo Pereira

fun main() {
    //Declaração de variaveis
    var Number1:Float?
    var Number2:Float?
    var Menu:Int
    var Result:Float? = null
    var cont:Boolean = false

    //Menu para escolher as opções
   // while(cont == false){
        println("Bem Vindo ao Menu da calculadora")
        println("--------------------------------")
        println("Escolha uma das opções para fazer a operação que desejas")
        println("Opção 1: Operação de Soma")
        println("Opção 2: Operação de Subtração")
        println("Opção 3: Operação de Multiplicação")
        println("Opção 4: Operação de Divisão")
        println("Opção 0: Sair do Programa")
 	
	//Entrada dos numeros para que sejam feitas as operações
        Menu = 1
        println("Insira os numeros que desejas fazer a Operação")
        Number1 = 12.0f
        println("Numero inserido: " + Number1)
        println("Insira o segundo Numero")
        Number2 = 20.0f
        println("Segundo numero inserido: " + Number2)
	
	//Tomada de decisão para controle de operações
        when(Menu){
            1 -> {Result = Soma(Number1,Number2)}
            2 -> {Result = Subtração(Number1,Number2)}
            3 -> {Result = Multiplicação(Number1,Number2)}
            4 -> {Result = Divisão(Number1,Number2)}
            0 -> {println("Saindo.........")}
            else -> {println("Escolha uma das Opções")
            	 	 cont = true}
        }
        println("O resultado é: " + Result)
    
 //   }
}

//Funções da Calculadora como Soma,Subtração,Multiplicação,Divisão
private fun Soma(Numero1:Float?, Numero2:Float):Float?{
    return Numero1?.plus(Numero2)
}
private fun Subtração(Numero1:Float?, Numero2:Float):Float?{
    return Numero1?.minus(Numero2)
}
private fun Multiplicação(Numero1:Float?, Numero2:Float):Float?{
    return Numero1?.times(Numero2)
}
private fun Divisão(Numero1:Float?, Numero2:Float):Float?{
    return Numero1?.div(Numero2)
}
