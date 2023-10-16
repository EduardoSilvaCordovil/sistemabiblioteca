# sistemabiblioteca
 Repositório utilizado para as atividades de Aplicação de Banco de Dados
 
 Professor : Claudio Martins

 Alunos: **[Marcelo Faro](https://github.com/farosv)** e Eduardo Cordovil

 # Comandos SQL:
 ```sql
CREATE TABLE EMPRESTIMO (
  id INT PRIMARY KEY,
  dateEmprestimo DATE,
  dateDevolucao DATE,
  aluno_id INT,
  publicacao_id INT,
  FOREIGN KEY (aluno_id) REFERENCES ALUNO (id),
  FOREIGN KEY (publicacao_id) REFERENCES PUBLICACAO (id)
);


CREATE TABLE PUBLICACAO (
  id INT PRIMARY KEY AUTO_INCREMENT,
  ano INT,
  tipo VARCHAR(100),
  autor VARCHAR(100),
  titulo VARCHAR(100),
  codigoPub INT
);

CREATE TABLE ALUNO (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(100),
  matriculaAluno INT
);

CREATE SEQUENCE ALN_SEQ;
```
# persistence.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.2" xmlns="http://xmlns.jcp.org/xml/ns/persistence" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_2.xsd">
    <persistence-unit name="sistemabiblioteca" transaction-type="RESOURCE_LOCAL">
        <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
        <class>entidade.Emprestimo</class>
        <class>entidade.Publicacao</class>
        <class>entidade.Aluno</class>
        <properties>
            <property name="jaka.persistence.jdbc.url" value="jdbc:h2:~/bdbiblioteca"/>
       <!-- <property name="jaka.persistence.jdbc.url" value="jdbc:h2:mem:bdbiblioteca"/>         
            <property name="jaka.persistence.jdbc.url" value="jdbc:h2:tcp://localhost/~/bdbiblioteca"/> -->  
            <property name="javax.persistence.jdbc.user" value="sa"/>
            <property name="javax.persistence.jdbc.driver" value="org.h2.Driver"/>
            <property name="javax.persistence.jdbc.password" value=""/>
            <property name="javax.persistence.schema-generation.database.action" value="none"/>
            <property name="eclipselink.ddl-generation.output-mode" value="database"/>
            <property name="eclipselink.sequence-connection-pool" value="true"/>
            <property name="eclipselink.ddl-generation" value="none"/>
        </properties>
    </persistence-unit>
</persistence>

```

# Como executar o projeto:

O projeto é composto pelas pastas:

**dao**:
DAOGenerico;
AlunoDAO;
EmprestimoDAO;
PublicacaoDAO.

**entidade**:
Aluno;
Emprestimo;
Publicacao.

**teste:**
TesteEmprestimoDAO

# dao
A classe **DAOGenerico** é responsável pelos métodos incluir, alterar, deletar e consultar dados de objetos Empréstimos.
```java
public class DAOGenerico<T> {

    private final EntityManager em;
    private final Class<T> entityClass;

    public DAOGenerico(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    public T findById(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public DAOGenerico(Class<T> entityClass) {
        this.entityClass = entityClass;
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemabiblioteca");
        EntityManager entityManager = factory.createEntityManager();
        this.em = entityManager;
    }

    public EntityManager getEntityManager() {
        return this.em;
    }

    public T salvar(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return entity;
    }

    public T consultar(Long id) {
        return em.find(entityClass, id);
    }

    public T atualizar(T entity) {
        try {
            em.getTransaction().begin();
            entity = em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
        return entity;
    }

    public void deletar(T entity) {
        try {
            em.getTransaction().begin();
            getEntityManager().remove(getEntityManager().merge(entity));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
    
    public T exibirLista(T entity) {
        return entity;
    }
   
}
```
# teste
A classe **TesteEmprestimoDAO** é responsável por incluir, alterar, deletar e consultar dados de objetos Empréstimos.
Para deletar um aluno, basta apagar "/**/"
```java
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
```
