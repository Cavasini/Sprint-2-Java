package br.com.healththechsolutions.vrvita.controller;

import br.com.healththechsolutions.vrvita.dao.ProfissionalDAO;
import br.com.healththechsolutions.vrvita.model.Profissional;

public class ControllerProfissional {

    private ProfissionalDAO profissionalDAO;

    public ControllerProfissional(ProfissionalDAO profissionalDAO) {
        this.profissionalDAO = profissionalDAO;
    }

    public void adicionarProfissional(String nome, String especialidade) {
        Profissional profissional = new Profissional(nome, especialidade);
        profissionalDAO.salvar(profissional);
        
    }

    public Profissional obterOuCriarProfissional(String nome, String especialidade) {
        Profissional profissional = profissionalDAO.buscarPorNomeEEspecialidade(nome, especialidade);
        if (profissional == null) {
            profissional = new Profissional(nome, especialidade);
            profissionalDAO.salvar(profissional);
        }
        return profissional;
    }
    

}
