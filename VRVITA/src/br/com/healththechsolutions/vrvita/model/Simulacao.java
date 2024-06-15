
package br.com.healththechsolutions.vrvita.model;

import java.time.LocalDate;

public class Simulacao {
    private int id;
    private Profissional profissional;
    private int procedimentoRealizado;
    private int tempoExecucao;
    private LocalDate data;
    private String nivelDesempenho;

    public Simulacao(Profissional profissional ,int procedimentoRealizado, int tempoExecucao, LocalDate data, String nivelDesempenho) {
        this.profissional = profissional;
        this.procedimentoRealizado = procedimentoRealizado;
        this.tempoExecucao = tempoExecucao;
        this.data = data;
        this.nivelDesempenho = nivelDesempenho;
    }

    public int getId() {
        return id;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public int getProcedimentoRealizado() {
        return procedimentoRealizado;
    }

    public int getTempoExecucao() {
        return tempoExecucao;
    }

    public LocalDate getData() {
        return data;
    }

    public String getNivelDesempenho() {
        return nivelDesempenho;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
