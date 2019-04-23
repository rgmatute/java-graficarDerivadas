package main;

import controller.PrincipalController;
import view.fPrincipal;

public class Main {

    public static void main(String[] args) {
        //sin(raíz(e^x + a) / 2)
        fPrincipal fp = new fPrincipal();
        PrincipalController cp = new PrincipalController(fp);
    }

}
