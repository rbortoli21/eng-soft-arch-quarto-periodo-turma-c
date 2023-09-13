package org.fag.bortoli;

import jakarta.ws.rs.*;


@Path("/calcular")
public class Calculator {
    @POST
    @Produces("text/plain")
    @Consumes("application/x-www-form-urlencoded")
    public String calcular(@FormParam("expressao") String expressao) {
        try {
            double resultado = eval(expressao);
            return String.valueOf(resultado);
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    private double eval(String expressao) {
        // Implemente a lógica para calcular a expressão aqui
        // Exemplo: você pode usar uma biblioteca de avaliação de expressões matemáticas.
        // Neste exemplo, estamos apenas retornando um valor fixo para fins de demonstração.
        return 42.0;
    }
}
