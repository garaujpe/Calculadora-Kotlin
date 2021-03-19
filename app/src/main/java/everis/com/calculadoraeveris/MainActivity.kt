package everis.com.calculadoraeveris

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Calculadora = mutableListOf<Char>()
        val Operacoes = mutableListOf<Char>()
        val Numeros = mutableListOf<String>()

        val Bt_Calcular = Button_Resultado
        val Bt_Apagar = Button_LimparText

        Button_0.setOnClickListener{
            Calculadora.add('0')
            Resultado_View.setText(Resultado_View.getText().toString() + "0")
        }
        Button_1.setOnClickListener{
            Calculadora.add('1')
            Resultado_View.setText(Resultado_View.getText().toString() + "1")
        }
        Button_2.setOnClickListener{
            Calculadora.add('2')
            Resultado_View.setText(Resultado_View.getText().toString() + "2")
        }
        Button_3.setOnClickListener{
            Calculadora.add('3')
            Resultado_View.setText(Resultado_View.getText().toString() + "3")
        }
        Button_4.setOnClickListener{
            Calculadora.add('4')
            Resultado_View.setText(Resultado_View.getText().toString() + "4")
        }
        Button_5.setOnClickListener{
            Calculadora.add('5')
            Resultado_View.setText(Resultado_View.getText().toString() + "5")
        }
        Button_6.setOnClickListener{
            Calculadora.add('6')
            Resultado_View.setText(Resultado_View.getText().toString() + "6")
        }
        Button_7.setOnClickListener{
            Calculadora.add('7')
            Resultado_View.setText(Resultado_View.getText().toString() + "7")
        }
        Button_8.setOnClickListener{
            Calculadora.add('8')
            Resultado_View.setText(Resultado_View.getText().toString() + "8")
        }
        Button_9.setOnClickListener{
            Calculadora.add('9')
            Resultado_View.setText(Resultado_View.getText().toString() + "9")
        }
        Button_Soma.setOnClickListener{
            Operacoes.add('+')
            var Numero:String = ""
            for(i in Calculadora.indices){
                Numero += Calculadora[i]
            }
            Numeros.add(Numero)
            Calculadora.clear()
            Resultado_View.setText(Resultado_View.getText().toString() + "+")
        }
        Button_Subtracao.setOnClickListener{
            Operacoes.add('-')
            var Numero:String = ""
            for(i in Calculadora.indices){
                Numero += Calculadora[i]
            }
            Numeros.add(Numero)
            Calculadora.clear()
            Resultado_View.setText(Resultado_View.getText().toString() + "-")
        }
        Button_Multiplicacao.setOnClickListener{
            Operacoes.add('*')
            var Numero:String = ""
            for(i in Calculadora.indices){
                Numero += Calculadora[i]
            }
            Numeros.add(Numero)
            Calculadora.clear()
            Resultado_View.setText(Resultado_View.getText().toString() + "*")
        }
        Button_Divisao.setOnClickListener{
            Operacoes.add('/')
            var Numero:String = ""
            for(i in Calculadora.indices){
                Numero += Calculadora[i]
            }
            Numeros.add(Numero)
            Calculadora.clear()
            Resultado_View.setText(Resultado_View.getText().toString() + "/")
        }
        Button_Porcentagem.setOnClickListener{
            Operacoes.add('%')
            var Numero:String = ""
            for(i in Calculadora.indices){
                Numero += Calculadora[i]
            }
            Numeros.add(Numero)
            Calculadora.clear()
            Resultado_View.setText(Resultado_View.getText().toString() + "%")
        }
        Bt_Apagar.setOnClickListener{
            Resultado_View.setText("")
            Numeros.clear()
            Operacoes.clear()
            Calculadora.clear()
        }

        Bt_Calcular.setOnClickListener{
            var Resultados:Double = Numeros[0].toDouble()?:0.0
            var Numero:String = ""
            for(i in Calculadora.indices){
                Numero += Calculadora[i]
            }
            var j:Int = 0
            Numeros.add(Numero)

                for (i in 1.. Numeros.size-1) {
                    if (Operacoes[j] == '+') {
                        if(Operacoes.any { it == '%' }){
                            if(Operacoes[j+1] == '%'){
                                Resultados += (Resultados * (Numeros[i].toDouble() / 100))
                            }else{
                                Resultados += Numeros[i].toDouble()
                            }
                        }else{
                            Resultados += Numeros[i].toDouble()
                        }
                    } else if (Operacoes[j] == '-') {
                        if(Operacoes.any { it == '%' }){
                            if(Operacoes[j+1] == '%'){
                                Resultados -= (Resultados * (Numeros[i].toDouble() / 100))
                            }else{
                                Resultados -= Numeros[i].toDouble()
                            }
                        }else{
                            Resultados -= Numeros[i].toDouble()
                        }
                    } else if (Operacoes[j] == '*') {
                        if(Operacoes.any { it == '%' }){
                            if(Operacoes[j+1] == '%'){
                                Resultados *= (Resultados * (Numeros[i].toDouble() / 100))
                            }else{
                                Resultados *= Numeros[i].toDouble()
                            }
                        }else{
                            Resultados *= Numeros[i].toDouble()
                        }
                    } else if (Operacoes[j] == '/') {
                        if(Operacoes.any { it == '%' }){
                            if(Operacoes[j+1] == '%'){
                                Resultados /= (Resultados * (Numeros[i].toDouble() / 100))
                            }else{
                                Resultados /= Numeros[i].toDouble()
                            }
                        }else{
                            Resultados /= Numeros[i].toDouble()
                        }
                    }
                    j++
                }
            Numeros.clear()
            Operacoes.clear()
            Calculadora.clear()

            for(k in 0..Resultados.toString().length-1){
                Calculadora.add(Resultados.toString()[k].toChar())
            }
            Resultado_View.setText("" + Resultados + "")
        }
    }
}
