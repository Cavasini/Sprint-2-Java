package br.com.healththechsolutions.vrvita.controller;

import br.com.healththechsolutions.vrvita.dao.SimulacaoDAO;
import br.com.healththechsolutions.vrvita.model.Profissional;
import br.com.healththechsolutions.vrvita.model.Simulacao;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class ControllerSimulacao {

    private SimulacaoDAO simulacaoDAO;
    private ControllerProfissional profissionalController;
    private boolean mostrarDialogo = true;

    public ControllerSimulacao(SimulacaoDAO simulacaoDAO, ControllerProfissional profissionalController) {
        this.simulacaoDAO = simulacaoDAO;
        this.profissionalController = profissionalController;
    }

    public void adicionarSimulacao(String nome, String especialidade, int procedimentoRealizado, int tempoExecucao, LocalDate data) {
        Profissional profissionalEncontrado = profissionalController.obterOuCriarProfissional(nome, especialidade);
        Simulacao simulacao = new Simulacao(profissionalEncontrado, procedimentoRealizado, tempoExecucao, data, CalcularNivelDesempenho(procedimentoRealizado, tempoExecucao));
        simulacaoDAO.salvar(simulacao);
    }

    public String CalcularNivelDesempenho(int procedimentoRealizado, int tempoExecucao) {
        String result;
        if (procedimentoRealizado == 1) {
            result = processarProcedimento1(tempoExecucao);
        } else {
            result = processarProcedimento2(tempoExecucao);
        }
        return result;
    }

    String processarProcedimento1(int tempoExecucao) {
        if (tempoExecucao <= 40) {
            if (mostrarDialogo) {
                JOptionPane.showMessageDialog(null, "Você atingiu o nívelde especialista", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            return "Especialista";
        } else if (tempoExecucao <= 60) {
            if (mostrarDialogo) {
                JOptionPane.showMessageDialog(null, "Necessário mais agilidade no processo, pois a risco eminente ao paciente devido a demora", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            return "Aprimorar";
        } else if (tempoExecucao <= 80) {
            if (mostrarDialogo) {
                JOptionPane.showMessageDialog(null, "Procedimento está colocando em risco a saúde do paciente, necessário maior pericia por parte do cirurgião", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            return "Risco";
        } else {
            if (mostrarDialogo) {
                JOptionPane.showMessageDialog(null, "Necessário mais horas de treinamento, processos acima de 80 minutos podem causar o óbito do paciente", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            return "Perigo";
        }
    }

    String processarProcedimento2(int tempoExecucao) {
        if (tempoExecucao <= 15) {
            if (mostrarDialogo) {
                JOptionPane.showMessageDialog(null, "Você atingiu o nívelde especialista", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            return "Especialista";
        } else if (tempoExecucao <= 30) {
            if (mostrarDialogo) {
                JOptionPane.showMessageDialog(null, "Necessário mais agilidade no processo, pois a risco eminente ao paciente devido a demora", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            return "Aprimorar";
        } else if (tempoExecucao <= 40) {
            if (mostrarDialogo) {
                JOptionPane.showMessageDialog(null, "Procedimento está colocando em risco a saúde do paciente, necessário maior pericia por parte do cirurgião", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            return "Risco";
        } else {
            if (mostrarDialogo) {
                JOptionPane.showMessageDialog(null, "Necessário mais horas de treinamento, nessa situação processos acima de 40minutos podem causar sério risco de  óbito ao paciente", "Resultado", JOptionPane.INFORMATION_MESSAGE);
            }
            return "Risco";
        }
    }

    public void setMostrarDialogo(boolean mostrarDialogo) {
        this.mostrarDialogo = mostrarDialogo;
    }
}
