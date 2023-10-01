package entidade;

import javax.persistence.*;

@Entity
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    private int ano;
    private String tipo;
    private String autor;
    private String titulo;
    private int codigoPub;

    public Publicacao() {
    }

    public Publicacao(Long id, int ano, String tipo, String autor, String titulo, int codigoPub) {
        this.id = id;
        this.ano = ano;
        this.tipo = tipo;
        this.autor = autor;
        this.titulo = titulo;
        this.codigoPub = codigoPub;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCodigoPub() {
        return codigoPub;
    }

    public void setCodigoPub(int codigoPub) {
        this.codigoPub = codigoPub;
    }

}
