import java.util.List;

public class Cancao extends Musica {
    private String letra;

    public Cancao(int identificador, String titulo, String duracao, List<String> autores,
                  String generoMusical, String letra) {
        super(identificador, titulo, duracao, autores, generoMusical);
        this.letra = letra;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
}
