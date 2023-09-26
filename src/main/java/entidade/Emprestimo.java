package entidade;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "EMPRESTIMO")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateEmprestimo;

    @Temporal(TemporalType.DATE)
    private Date dateDevolucao;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "pub_id")
    private Publicacao publicacao;

    // Getters and setters
    public Emprestimo(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateEmprestimo() {
        return dateEmprestimo;
    }

    public void setDateEmprestimo(Date dateEmprestimo) {
        this.dateEmprestimo = dateEmprestimo;
    }

    public Date getDateDevolucao() {
        return dateDevolucao;
    }

    public void setDateDevolucao(Date dateDevolucao) {
        this.dateDevolucao = dateDevolucao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }
    
}