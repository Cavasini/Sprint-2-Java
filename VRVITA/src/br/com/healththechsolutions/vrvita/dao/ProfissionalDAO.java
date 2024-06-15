package br.com.healththechsolutions.vrvita.dao;

import br.com.healththechsolutions.vrvita.model.Profissional;
import br.com.healththechsolutions.vrvita.model.Simulacao;
import java.util.ArrayList;
import java.util.List;

public class ProfissionalDAO {

    private List<Profissional> profissionais = new ArrayList<>();

    public void salvar(Profissional profissional) {
        profissional.setId(profissionais.size() == 0 ? 1 : profissionais.size()+1); 
        profissionais.add(profissional);
    }
   

    public Profissional buscarPorNomeEEspecialidade(String nome, String especialidade) {
        for (Profissional profissional : profissionais) {
            if (profissional.getNome().toUpperCase().equals(nome.toUpperCase()) && profissional.getEspecialidade().toUpperCase().equals(especialidade.toUpperCase())) {
                return profissional;
            }
        }

        return null;
    }

}
