package br.ufc.npi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.npi.bean.Jogador;
import br.ufc.npi.bean.Time;
import br.ufc.npi.repositorio.JogadorRepositorio;
import br.ufc.npi.repositorio.TimeRepositorio;

@Service
public class TimeService {

	@Autowired
	TimeRepositorio timeRepositorio;
	
	@Autowired
	JogadorRepositorio jogadorRepositorio;
	
	public Time salvarTime(String nome){
		Time time = new Time();
		time.setNome(nome);
		timeRepositorio.save(time);
		
		return time;
	}
	
	public List<Time> getTodosTimes(){
		return timeRepositorio.findAll();
	}
	
	public Time getTime(int id){
		return timeRepositorio.findOne(id);
	}
	
	public boolean addJogadorAoTime(Integer idTime, Integer jogadorSemTimeID) {
		
		  Time time = timeRepositorio.findOne(idTime);
		  if(time.getJogadores().size()==7){
		    return false;
		  }else {
		    Jogador jogador = jogadorRepositorio.findOne(jogadorSemTimeID);
		    time.getJogadores().add(jogador);
		    jogador.setTime(time);
		    timeRepositorio.save(time);
		    jogadorRepositorio.save(jogador);
		    return true;
		  }
	}
	
	public void delJogadorDoTime(Integer idTime, Integer idJogador){
		Time time = timeRepositorio.findOne(idTime);
		Jogador jogador = jogadorRepositorio.findOne(idJogador);
		
		time.getJogadores().remove(jogador);
		jogador.setTime(null);
		
		timeRepositorio.save(time);
		jogadorRepositorio.save(jogador);
	}
}
