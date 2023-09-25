package entidade;

import entidade.Aluno;
import entidade.Publicacao;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-09-24T20:48:37", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Emprestimo.class)
public class Emprestimo_ { 

    public static volatile SingularAttribute<Emprestimo, Publicacao> publicacao;
    public static volatile SingularAttribute<Emprestimo, Aluno> aluno;
    public static volatile SingularAttribute<Emprestimo, Date> dateEmprestimo;
    public static volatile SingularAttribute<Emprestimo, Long> id;
    public static volatile SingularAttribute<Emprestimo, Date> dateDevolucao;

}