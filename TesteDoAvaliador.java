package br.com.caelum.leilao.teste;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.service.Avaliador;
import junit.framework.Assert;

public class TesteDoAvaliador {

	//Para que o teste funcione com o Junit temos que retirar o 'static' e os Argumentos 'String[] args'
	//Apos isso temos que anotar ele com o @Test
	
	@Test
	public void deveEntenderOmaiorLance() {
		
		//Parte 1: Cenario
		Usuario joao = new Usuario("Joao");
		Usuario Jose = new Usuario("jose");
		Usuario pedro = new Usuario("Pedro");
		
		Leilao leilao = new Leilao("Leilao de uma casa nova.");
		
		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(pedro, 300.0));
		leilao.propoe(new Lance(Jose, 400.0));
		
		//Parte 2: açao
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		//Parte 3: vaidação.
		double maiorEsperado = 400.0;
		double menorEsperado = 250.0;
		
		//System.out.println(maiorEsperado == leiloeiro.getMaiorLance());
		Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		
		//System.out.println(menorEsperado == leiloeiro.getMenorLance());
		Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}
}
