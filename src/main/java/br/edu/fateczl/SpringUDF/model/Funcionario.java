package br.edu.fateczl.SpringUDF.model;

import java.util.List;

public class Funcionario {
	
	private int codigo;
    private String nome;
    private double salario;
    private List<Dependente> dependentes;
    
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	public List<Dependente> getDependentes() {
		return dependentes;
	}
	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
	
	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", salario=" + salario + "]";
	}
    
}
