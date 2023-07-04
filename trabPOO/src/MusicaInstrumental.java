import java.io.File;
import java.util.List;

public class MusicaInstrumental extends Musica{
    private String imagemPartitura;

    public MusicaInstrumental(int identificador, String titulo, String duracao, List<String> autores,
                  String generoMusical, String imagemPartitura) {
        super(identificador, titulo, duracao, autores, generoMusical);
        this.imagemPartitura = imagemPartitura;
    }

    public String getPartitura() {
        return imagemPartitura;
    }

    public void setPartitura(String imagemPartitura) {
        this.imagemPartitura = imagemPartitura;
    }
}
