import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public abstract class Musica implements Serializable {
    private int id;
    private String titulo;
    private String duracao; // date - hour
    private List<String> autores;
    private LocalDateTime data;  // date
    private String generoMusical;

    public Musica(int identificador, String titulo, String duracao, List<String> autores, String generoMusical)
    {
        this.id = identificador;
        this.titulo = titulo;
        this.duracao = duracao;
        this.autores = autores;
        this.data = LocalDateTime.now();
        this.generoMusical = generoMusical;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public List<String> getAutores() {
        return autores;
    }


    public LocalDateTime getData() {
        return data;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

}
