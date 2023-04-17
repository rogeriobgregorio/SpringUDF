package br.edu.fateczl.SpringUDF.model;

public class Dependente {
	
	private Funcionario funcionario;
    private String nome;
    private double salario;
    
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
	
	@Override
	public String toString() {
		return "Dependente [funcionario=" + funcionario + ", nome=" + nome + ", salario=" + salario + "]";
	}
    
}
