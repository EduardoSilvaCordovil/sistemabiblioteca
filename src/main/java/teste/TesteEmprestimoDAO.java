package teste;

import dao.AlunoDAO;
import java.util.Date;
import entidade.Aluno;
import dao.EmprestimoDAO;
import dao.PublicacaoDAO;
import entidade.Emprestimo;
import entidade.Publicacao;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TesteEmprestimoDAO {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemabiblioteca");
        EntityManager em = emf.createEntityManager();

        AlunoDAO alunoDAO = new AlunoDAO(em);
        PublicacaoDAO publicacaoDAO = new PublicacaoDAO(em);
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);

        // FALTA FAZER UM MÉTODO PARA EXIBIR O BANCO DE DADOS
        
        Aluno aluno = new Aluno();
        aluno.setNome("Carla Moraes");
        aluno.setMatriculaAluno(38537);
        aluno = alunoDAO.salvar(aluno);

        Publicacao publicacao = new Publicacao();
        publicacao.setAno(2018);
        publicacao.setTipo("Livro");
        publicacao.setAutor("Pedro Domingos");
        publicacao.setTitulo("The Master Algorithm");
        publicacao.setCodigoPub(67867);
        publicacao = publicacaoDAO.salvar(publicacao);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setAluno(aluno);
        emprestimo.setPublicacao(publicacao);
        emprestimo.setDateEmprestimo(new Date());
        emprestimo = emprestimoDAO.salvar(emprestimo);
        System.out.println("Empréstimo criado com ID: " + emprestimo.getId());

        Emprestimo emprestimoConsultado = emprestimoDAO.consultar(emprestimo.getId());
        System.out.println("Detalhes do Empréstimo: Aluno: " + aluno.getId() + " " + emprestimoConsultado.getAluno().getNome()
                + ", Publicação: " + emprestimoConsultado.getPublicacao().getTitulo());

        emprestimoConsultado.setDateDevolucao(new Date());
        emprestimoDAO.atualizar(emprestimoConsultado);
        System.out.println("Empréstimo atualizado com sucesso.");

        // PARA DELETAR APAGUE "/**/"
        
        /*emprestimoDAO.deletar(emprestimoConsultado);
        emprestimoDAO.deletar(emprestimo);
        System.out.println("Empréstimo deletado com sucesso.");

        alunoDAO.deletar(aluno);
        System.out.println("Apagando o ID = " + aluno.getId() + " - " + aluno.getNome());

        publicacaoDAO.deletar(publicacao);
        System.out.println("Publicação delatada com sucesso.");*/

        em.close();
        emf.close();
    }
}
