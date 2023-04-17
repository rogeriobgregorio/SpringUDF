package br.edu.fateczl.SpringUDF.persistence;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.SpringUDF.model.Funcionario;

public interface IFuncionarioDependenteDao {

	List<Funcionario> buscarFuncionariosDependentes() throws ClassNotFoundException, SQLException;

	Double buscarSomaSalarios(int codigo) throws ClassNotFoundException, SQLException;

}
