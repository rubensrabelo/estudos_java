package models;

import com.google.gson.annotations.SerializedName;

import exceptions.ErroDeConversaoDeAnoException;

public class Title implements Comparable<Title> {
    
    @SerializedName("Title")
    private String nome;

    @SerializedName("Year")
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Title(TitleOmdb omdb) {
        this.nome = omdb.title();

        if(omdb.year().length() > 4)
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano!");

        this.anoDeLancamento = Integer.valueOf(omdb.year());
        this.duracaoEmMinutos = Integer.valueOf(omdb.runtime().substring(0, 2));
    }

    public Title(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    @Override
    public int compareTo(Title other) {
        return this.getNome().compareTo(other.getNome());
    }

    @Override
    public String toString() {
        return "Title[nome=" + nome 
            + ", anoDeLancamento=" + anoDeLancamento 
            + ", duração (min)=" + duracaoEmMinutos + "]";
    }
}
