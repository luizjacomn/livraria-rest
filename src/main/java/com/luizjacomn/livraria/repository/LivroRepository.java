package com.luizjacomn.livraria.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.luizjacomn.livraria.model.Livro;

public class LivroRepository {

	private Map<Long, Livro> dataset = new HashMap<>();
	
	{
		Livro l1 = new Livro("Ana Terra", "ISBN-4841", "Romance", 50, "Euclides da Cunha");
		Livro l2 = new Livro("Memorial de Maria Moura", "ISBN-5594", "Romance", 100, "Raquel de Queiroz");
		Livro l3 = new Livro("Iracema", "ISBN-5686", "Romance", 79.99, "José de Alencar");
		dataset.put(l1.getId(), l1);
		dataset.put(l2.getId(), l2);
		dataset.put(l3.getId(), l3);
	}
	
	public List<Livro> getLivros() {
		return new ArrayList<>(dataset.values());
	}
}