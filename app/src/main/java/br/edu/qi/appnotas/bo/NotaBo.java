package br.edu.qi.appnotas.bo;

import br.edu.qi.appnotas.model.Nota;

public class NotaBo {

    private Nota nota;

    public NotaBo(Nota nota) {
        this.nota = nota;
    }

    public double total() {
        return (this.nota.getNota1() + this.nota.getNota2()) / 2;
    }
}
