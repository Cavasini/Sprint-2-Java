package br.com.healththechsolutions.vrvita;

import br.com.healththechsolutions.vrvita.controller.ControllerSimulacao;
import br.com.healththechsolutions.vrvita.view.MenuInterface;

public class Main {

    public static void main(String[] args) {
        MenuInterface menu = new MenuInterface();
        menu.CriarSimulacoes();
        menu.setVisible(true);
    }
}


