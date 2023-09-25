package teste;

import java.util.Date;
import entidade.Aluno;
import dao.EmprestimoDAO;
import entidade.Emprestimo;
import entidade.Publicacao;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TesteEmprestimoDAO {

    public static void main(String[] args) {
        
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

        // Incluir empréstimo
        Emprestimo emprestimo = new Emprestimo();
        // Preencha os campos do empréstimo
        emprestimoDAO.incluirEmprestimo(emprestimo);
        System.out.println("Empréstimo incluído com sucesso!");

        // Alterar empréstimo
        emprestimo.setDateDevolucao(new Date());
        emprestimoDAO.alterarEmprestimo(emprestimo);
        System.out.println("Empréstimo alterado com sucesso!");

        // Deletar empréstimo
        emprestimoDAO.deletarEmprestimo(emprestimo.getId());
        System.out.println("Empréstimo deletado com sucesso!");

        // Consultar empréstimo
        Emprestimo emprestimoConsultado = emprestimoDAO.consultarEmprestimo(emprestimo.getId());
        System.out.println("Empréstimo consultado: " + emprestimoConsultado);

    }
}
