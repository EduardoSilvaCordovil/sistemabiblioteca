package entidade;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateEmprestimo;

    @Temporal(TemporalType.DATE)
    private Date dateDevolucao;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "publicacao_id")
    private Publicacao publicacao;
    
    public Emprestimo() {      
    }

    public Emprestimo(Long id, Date dateEmprestimo, Date dateDevolucao, Aluno aluno, Publicacao publicacao) {
        this.id = id;
        this.dateEmprestimo = dateEmprestimo;
        this.dateDevolucao = dateDevolucao;
        this.aluno = aluno;
        this.publicacao = publicacao;
    }

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
