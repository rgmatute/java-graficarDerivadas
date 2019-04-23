package controller;

import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;

public class DerivadaController {

    //Constructor
    public DerivadaController() {

    }

    public static String Derivar(String funcion) {
        String derivada = "";
        funcion = funcion.replace("raíz", "sqrt");
        DJep derivar = new DJep();
        derivar.addStandardFunctions();
        derivar.addStandardConstants();
        derivar.addComplex();
        derivar.setAllowUndeclared(true);
        derivar.setAllowAssignment(true);
        derivar.setImplicitMul(true); //permite 2x en vez de 2*x
        derivar.addStandardDiffRules();

        try {
            Node node = derivar.parse(funcion);
            Node diff = derivar.differentiate(node, "x");
            Node sim = derivar.simplify(diff);
            derivada = derivar.toString(sim);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        //System.out.println(simplificarX(derivada));
        return simplificarX(derivada);
    }

    private static String simplificarX(String result) {
        result = result.replace("*", "*");
        result = result.replace(".0", "");
        result = result.replace("x*x*x*x", "(x^4)");
        result = result.replace("x*x*x*x*x", "(x^5)");
        result = result.replace("x*x*x", "(x^3)");
        result = result.replace("x*x", "(x^2)");
        //result = result.replace("((x-2y)(x-2y))", "(x-2y)^2");
        return result;
    }

    public void opcionales(String derivar) {
        JEP miEvaluadorDerivadas = new JEP();
        miEvaluadorDerivadas.addStandardFunctions();  //agrega las funciones matematicas comunes
        miEvaluadorDerivadas.addStandardConstants();
        miEvaluadorDerivadas.addComplex();
        miEvaluadorDerivadas.addFunction("sen", new org.nfunk.jep.function.Sine());//habilitar 'sen'
        miEvaluadorDerivadas.addVariable("x", 0);
        miEvaluadorDerivadas.setImplicitMul(true); //permite 2x en vez de 2*x

        DJep miEvaluador2 = new DJep();
        miEvaluador2.addStandardFunctions();  //agrega las funciones matematicas comunes
        miEvaluador2.addStandardConstants();
        miEvaluador2.addComplex();
        miEvaluador2.addFunction("sen", new org.nfunk.jep.function.Sine());//habilitar 'sen'
        miEvaluador2.addVariable("x", 0);
        miEvaluador2.setImplicitMul(true); //permite 2x en vez de 2*x
        miEvaluador2.setAllowUndeclared(true);
        miEvaluador2.setAllowAssignment(true);
        miEvaluador2.addStandardDiffRules();
    }

}
