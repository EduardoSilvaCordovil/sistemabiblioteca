package entidade;

import javax.persistence.*;

@Entity
//@SequenceGenerator(name = "ALN_SEQ", sequenceName = "ALN_SEQ", allocationSize = 1)
@SequenceGenerator(name = "ALN_SEQ_GENERATOR", sequenceName = "ALN_SEQ", allocationSize = 1)
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALN_SEQ")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "matriculaAluno")
    private int matriculaAluno;

    public Aluno() {       
    }
    
    public Aluno(Long id, String nome, int matriculaAluno) {
        this.id = id;
        this.nome = nome;
        this.matriculaAluno = matriculaAluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(int matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

}
