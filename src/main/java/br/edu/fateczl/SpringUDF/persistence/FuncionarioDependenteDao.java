package br.edu.fateczl.SpringUDF.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.edu.fateczl.SpringUDF.model.Dependente;
import br.edu.fateczl.SpringUDF.model.Funcionario;

@Repository
public class FuncionarioDependenteDao implements IFuncionarioDependenteDao {
	
	@Autowired
	GenericDao gDao;

	public List<Funcionario> buscarFuncionariosDependentes() throws ClassNotFoundException, SQLException {

        List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        try (Connection con = gDao.getConnection();
                PreparedStatement stmt = con.prepareStatement("SELECT * FROM fn_funcionarioDependente()");
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome_funcionario"));
                funcionario.setSalario(rs.getDouble("salario_funcionario"));

                Dependente dependente = new Dependente();
                dependente.setNome(rs.getString("nome_dependente"));
                dependente.setSalario(rs.getDouble("salario_dependente"));
                dependente.setFuncionario(funcionario);

                funcionario.getDependentes().add(dependente);

                if (!funcionarios.contains(funcionario)) {
                    funcionarios.add(funcionario);
                } else {
                    Funcionario f = funcionarios.get(funcionarios.indexOf(funcionario));
                    f.getDependentes().add(dependente);
                }
            }
        }

        return funcionarios;
    }

    public Double buscarSomaSalarios(int codigo) throws ClassNotFoundException, SQLException {

        try (Connection c = gDao.getConnection();
                PreparedStatement stmt = c.prepareStatement("SELECT dbo.fn_somaSalarios(?) AS soma_salarios")) {

            stmt.setInt(1, codigo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("soma_salarios");
                }
            }
        }

        return null;
    }

}
