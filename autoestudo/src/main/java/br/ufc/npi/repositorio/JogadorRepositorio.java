package br.ufc.npi.repositorio;

import org.springframework.stereotype.Repository;

import br.ufc.npi.bean.Jogador;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;;

@Repository
@Transactional
public interface JogadorRepositorio extends JpaRepository<Jogador, Integer>{
	public Jogador findByNome(String nome);
	
	@Query("from Jogador j where j.time is null")
	public List<Jogador> buscarJogadoresSemTime();
}
