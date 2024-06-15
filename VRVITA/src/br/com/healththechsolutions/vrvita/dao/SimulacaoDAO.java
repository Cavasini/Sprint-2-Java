package br.com.healththechsolutions.vrvita.dao;

import br.com.healththechsolutions.vrvita.model.Simulacao;
import java.util.ArrayList;
import java.util.List;

public class SimulacaoDAO {

    private List<Simulacao> simulacoes = new ArrayList<>();

    public void salvar(Simulacao simulacao) {
        simulacao.setId(simulacoes.size() == 0 ? 1 : simulacoes.size() + 1);
        simulacao.getProfissional().adicionarSimulacao(simulacao);
        simulacoes.add(simulacao);
    }

    public List<Simulacao> getSimulacoes() {
        return simulacoes;
    }

    public List<Simulacao> buscarPorNome(String nome) {
        List<Simulacao> simulacoesEcontradas = new ArrayList<>();
        for (Simulacao simulacao : simulacoes) {
            if (simulacao.getProfissional().getNome().toUpperCase().contains(nome.toUpperCase())) {
                simulacoesEcontradas.add(simulacao);
            }
        }
        return simulacoesEcontradas;
    }
    
}
