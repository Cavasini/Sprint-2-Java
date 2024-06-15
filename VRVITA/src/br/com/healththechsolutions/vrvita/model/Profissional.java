package br.com.healththechsolutions.vrvita.model;

import java.util.ArrayList;
import java.util.List;

public class Profissional {

    private int id;
    private String nome;
    private String especialidade;
    private List<Simulacao> simulacoesRealizadas = new ArrayList();
    
    public Profissional(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Simulacao> getSimulacoesRealizadas() {
        return simulacoesRealizadas;
    }
    
    public void adicionarSimulacao(Simulacao simulacao){
        this.simulacoesRealizadas.add(simulacao);
    }
    
}
