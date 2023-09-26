package teste;

import dao.DAOFachada;
import java.util.Date;
import entidade.Aluno;
import dao.EmprestimoDAO;
import entidade.Emprestimo;
import entidade.Publicacao;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class TesteEmprestimoDAO {

    public static void main(String[] args) {

        //DAOFachada<Emprestimo> dao = new DAOFachada<Emprestimo>(Emprestimo.class);
        Aluno p = new Aluno();
        p.setNome("ANA ANTONIA");
        p.setMatriculaAluno(123456789);
        DAOFachada<Aluno> dao = new DAOFachada<Aluno>(Aluno.class);

        Publicacao pub = new Publicacao();
        pub.setAno(2001);
        pub.setAutor("edu");
        pub.setTitulo("nada");
        

        Emprestimo emprestimo = new Emprestimo();

        emprestimo.setDateEmprestimo(new Date());
        emprestimo.setDateDevolucao(new Date());

        Aluno aluno1 = new Aluno();
        aluno1.setNome("João");
        aluno1.setMatriculaAluno(12345);

        Publicacao publicacao1 = new Publicacao();
        publicacao1.setAno(2021);
        publicacao1.setTipo("Livro");
        publicacao1.setAutor("José Silva");
        publicacao1.setTitulo("Aventuras no Mundo da Programação");
        publicacao1.setCodigoPub(67890);

        emprestimo.setAluno(aluno1);
        emprestimo.setPublicacao(publicacao1);

        //emprestimoDAO.save(emprestimo);

        dao.getEntityManager().close();
    }
}
