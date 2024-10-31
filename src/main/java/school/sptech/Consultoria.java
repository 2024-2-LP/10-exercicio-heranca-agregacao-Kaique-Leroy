package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private int vagas;
    private List<Desenvolvedor> desenvolvedores;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public List<Desenvolvedor> getDesenvolvedores() {
        return desenvolvedores;
    }


    public Consultoria(String nome, int vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria() {
    }

    public void contratar(Desenvolvedor desenvolvedor) {
        if (desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack() && desenvolvedores.size() < vagas) {
            desenvolvedores.add(desenvolvedor);
        }
    }

    public double getTotalSalarios() {
        double totalSalario = 0.0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            totalSalario += desenvolvedor.calcularSalario();
        }
        return totalSalario;
    }

    public int qtdDesenvolvedoresMobile() {
        return (int) desenvolvedores.stream().filter(desenvolvedor -> desenvolvedor instanceof DesenvolvedorMobile).count();
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> resultado = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() >= salario) {
                resultado.add(desenvolvedor);
            }
        }
        return resultado;
    }

    public Desenvolvedor buscarMenorSalario() {
        return desenvolvedores.stream().min((d1, d2) -> Double.compare(d1.calcularSalario(), d2.calcularSalario())).orElse(null);
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> resultado = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if ((desenvolvedor instanceof DesenvolvedorMobile &&
                    (((DesenvolvedorMobile) desenvolvedor).getPlataforma().equalsIgnoreCase(tecnologia) ||
                            ((DesenvolvedorMobile) desenvolvedor).getLinguagem().equalsIgnoreCase(tecnologia))) ||
                    (desenvolvedor instanceof DesenvolvedorWeb &&
                            (((DesenvolvedorWeb) desenvolvedor).getFrontend().equalsIgnoreCase(tecnologia) ||
                                    ((DesenvolvedorWeb) desenvolvedor).getBackend().equalsIgnoreCase(tecnologia) ||
                                    ((DesenvolvedorWeb) desenvolvedor).getSgbd().equalsIgnoreCase(tecnologia)))) {
                resultado.add(desenvolvedor);
            }
        }
        return resultado;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        double total = 0.0;
        for (Desenvolvedor desenvolvedor : buscarPorTecnologia(tecnologia)) {
            total += desenvolvedor.calcularSalario();
        }
        return total;
    }
}
