package br.com.groovy.model

import br.com.groovy.main.POJOJava

class POJOGroovy {

	String nome
	Integer idade
	Date dtNascimento
	String email
	
	String toString() {
		"Olá, eu sou uma objeto Groovy"
	}
	
	void invocaJava() {
		def jclass = new POJOJava()
		println jclass
	}
	
}
