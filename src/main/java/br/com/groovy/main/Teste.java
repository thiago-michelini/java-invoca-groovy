package br.com.groovy.main;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import br.com.groovy.iface.Resultado;
import br.com.groovy.model.POJOGroovy;
import groovy.lang.Binding;
import groovy.lang.GroovyShell;

public class Teste {
	private StringBuilder sb = new StringBuilder();

	public Teste() {
		POJOGroovy gclass = new POJOGroovy();
		System.out.println(gclass);
		gclass.invocaJava();
		try (InputStream input = getClass().getClassLoader().getResourceAsStream("script.groovy")) {
			BufferedReader br = new BufferedReader(new InputStreamReader(input));
			String linha = null;
			while ((linha = br.readLine()) != null)
				sb.append(linha).append("\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Teste t = new Teste();
		
		Binding bind = new Binding();
		bind.setVariable("json", "{'nome':'Thiago MM','idade':19,'nascimento':'1985-06-02'}");
		GroovyShell sh = new GroovyShell(bind);
		
		Object result = sh.evaluate(t.sb.toString());
		
		System.out.println(result.getClass());
		System.out.println("chamando metodo da classe Groovy:");
		Resultado resultado = (Resultado) result;
		System.out.println(resultado.getResultado());
	}
	
}
