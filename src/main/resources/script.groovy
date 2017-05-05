import com.google.gson.Gson

import br.com.groovy.iface.Resultado

class PessoaGroovy implements Resultado {
	String nome
	Integer idade
	Date nascimento
	
	Object getResultado() {
		"Unindo campos, nome:${nome} | idade:${idade} | nascimento:${nascimento}"
	}
	
	String toString() {
		"PessoaGroovy--->Sou ${nome}, tenho ${idade} anos e nasci em ${nascimento}"
	}
}

def p = new Gson().fromJson(json, PessoaGroovy.class)
println p
p