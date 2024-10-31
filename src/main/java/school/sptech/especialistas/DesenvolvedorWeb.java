package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorWeb extends Desenvolvedor {
    private String backend;
    private String frontend;
    private String sgbd;
    private Integer horasMentoria;

    public String getBackend() {
        return backend;
    }

    public void setBackend(String backend) {
        this.backend = backend;
    }

    public String getFrontend() {
        return frontend;
    }

    public void setFrontend(String frontend) {
        this.frontend = frontend;
    }

    public String getSgbd() {
        return sgbd;
    }

    public void setSgbd(String sgbd) {
        this.sgbd = sgbd;
    }

    public Integer getHorasMentoria() {
        return horasMentoria;
    }

    public void setHorasMentoria(Integer horasMentoria) {
        this.horasMentoria = horasMentoria;
    }

    public DesenvolvedorWeb(String nome, Integer qtdHoras, Double valorHora, String backend, String frontend, String sgbd, int horasMentoria) {
        super(nome, qtdHoras, valorHora);
        this.backend = backend;
        this.frontend = frontend;
        this.sgbd = sgbd;
        this.horasMentoria = horasMentoria;
    }

    public DesenvolvedorWeb(String backend, String frontend, String sgbd, int horasMentoria) {
        this.backend = backend;
        this.frontend = frontend;
        this.sgbd = sgbd;
        this.horasMentoria = horasMentoria;
    }

    public DesenvolvedorWeb() {
    }

    @Override
    public Double calcularSalario() {
        return qtdHoras * valorHora + horasMentoria * 300; // Exemplo de cálculo
    }

    public boolean isFullstack() {
        if (backend != null && frontend != null && sgbd != null) {
            return true;
        } else return false;
    }
}

