package com.luizjacomn.livraria.model;

import java.security.SecureRandom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement(name = "autor")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Autor {

	@XmlAttribute
	private Long id;
	
	@XmlElement
	private String nome;
	
	public Autor(String nome) {
		this.id = new SecureRandom().nextLong();
		this.nome = nome;
	}
}