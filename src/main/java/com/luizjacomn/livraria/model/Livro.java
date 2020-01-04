package com.luizjacomn.livraria.model;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement(name = "livro")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Livro {

	@XmlAttribute
	private Long id;
	
	@XmlElement
	private String titulo;
	
	@XmlElement
	private String isbn;
	
	@XmlElement
	private String genero;
	
	@XmlElement
	private BigDecimal preco;
	
	@XmlElement
	private List<Autor> autores = new ArrayList<>();

	public Livro(String titulo, String isbn, String genero, Object preco, String... autores) {
		this(preco);
		this.titulo = titulo;
		this.isbn = isbn;
		this.genero = genero;
		this.autores = preencherAutores(autores);
	}

	public Livro(Object preco) {
		this.id = new SecureRandom().nextLong();
		if (preco instanceof String) {
			this.preco = new BigDecimal((String) preco).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		} else if (preco instanceof Integer) {
			this.preco = new BigDecimal((Integer) preco).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		} else if (preco instanceof Double) {
			this.preco = new BigDecimal((Double) preco).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		} else if (preco instanceof BigDecimal) {
			this.preco = ((BigDecimal) preco).setScale(2, BigDecimal.ROUND_HALF_EVEN);
		} else {
			throw new IllegalArgumentException(
					"O campo preço não aceita este tipo de valor: " + preco.getClass().getSimpleName());
		}
	}
	
	public void addAutor(Autor autor) {
		autores.add(autor);
	}
	
	public void removeAutor(Autor autor) {
		autores.remove(autor);
	}
	
	private List<Autor> preencherAutores(String[] autores) {
		return Stream.of(autores).map(Autor::new).collect(Collectors.toList());
	}
}