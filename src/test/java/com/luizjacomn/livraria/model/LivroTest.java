package com.luizjacomn.livraria.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;

public class LivroTest {

	private Livro livro;

	@Test
	public void deveTestarConstrutorComCampoPreco() {
		livro = new Livro("50");
		assertEquals(BigDecimal.valueOf(50).setScale(2, BigDecimal.ROUND_HALF_EVEN), livro.getPreco());
		livro = new Livro(100);
		assertEquals(BigDecimal.valueOf(100).setScale(2, BigDecimal.ROUND_HALF_EVEN), livro.getPreco());
		livro = new Livro(150.0);
		assertEquals(BigDecimal.valueOf(150).setScale(2, BigDecimal.ROUND_HALF_EVEN), livro.getPreco());
		livro = new Livro(new BigDecimal("200"));
		assertEquals(BigDecimal.valueOf(200).setScale(2, BigDecimal.ROUND_HALF_EVEN), livro.getPreco());
	}

	@Test(expected = IllegalArgumentException.class)
	public void deveLancarExcecaoParaTipoNaoReconhecido() {
		livro = new Livro(new Date());
	}

}