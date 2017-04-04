package br.ufc.npi.repositorio;

import org.springframework.stereotype.Repository;

import br.ufc.npi.bean.Time;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;;


@Repository
@Transactional
public interface TimeRepositorio extends JpaRepository<Time, Integer> {
	Time findByNome(String nome);
}
