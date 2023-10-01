package teste;

import dao.PublicacaoDAO;
import entidade.Aluno;
import entidade.Emprestimo;
import entidade.Publicacao;
import java.util.Date;
import dao.EmprestimoDAO;

public class TesteEmprestimoDAO {

    public static void main(String[] args) {

        Emprestimo emp = new Emprestimo();
        emp.setDateEmprestimo(new Date());
        emp.setDateDevolucao(new Date());
        EmprestimoDAO dao = new EmprestimoDAO();
        emp = dao.salvar(emp);

        Aluno aluno1 = new Aluno();
        aluno1.setNome("João");
        aluno1.setMatriculaAluno(12345);

        Publicacao pub = new Publicacao();
        pub.setAno(2021);
        pub.setAutor("José Silva");
        pub.setCodigoPub(67890);
        pub.setId(2L);
        pub.setTipo("Livro");
        pub.setTitulo("Aventuras no Mundo da Programação");
        PublicacaoDAO dao2 = new PublicacaoDAO();
        pub = dao2.salvar(pub);
        System.out.println("SALVO" + pub.getAno() + "|" + pub.getAutor() + "|" + pub.getCodigoPub() + "|" + pub.getId() + "|" + pub.getTipo() + "|" + pub.getTitulo());

    }
}
