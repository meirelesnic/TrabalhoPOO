import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable{
    private String nome;
    private int identificador;
    private String login;
    private String senha;
    private List<Integer> colecaoParticular;

    public Usuario(String nome, int identificador, String login, String senha) {
        this.nome = nome;
        this.identificador = identificador;
        this.login = login;
        this.senha = senha;
        colecaoParticular = new ArrayList<>();
    }

    public void cadastrarMusica(Musica musica, List<Musica> colecaoPrincipal) {
        colecaoPrincipal.add(musica);
    }

    public Musica recuperarMusica(String titulo, List<Musica> colecaoPrincipal) {
        for (Musica musica : colecaoPrincipal) {
            if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                return musica;
            }
        }
        return null;
    }

    public void atualizarMusica(Musica musicaAtualizada, List<Musica> colecaoPrincipal) {
        for (int i = 0; i < colecaoPrincipal.size(); i++) {
            Musica musica = colecaoPrincipal.get(i);
            if (musica.getId() == musicaAtualizada.getId()) {
                colecaoPrincipal.set(i, musicaAtualizada);
                break;
            }
        }
    }

    public void removerMusica(int identificador, List<Musica> colecaoPrincipal) {
        for (int i = 0; i < colecaoPrincipal.size(); i++) {
            Musica musica = colecaoPrincipal.get(i);
            if (musica.getId() == identificador) {
                colecaoPrincipal.remove(i);
                break;
            }
        }
    }

    public void adicionarUsuario(Usuario usuario, List<Usuario> usuarios) {
        usuarios.add(usuario);
    }

    public Usuario buscarUsuario(String nome, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario buscarUsuarioId(int id, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdentificador()==id) {
                return usuario;
            }
        }
        return null;
    }

    public void removerUsuario(int identificador, List<Usuario> usuarios) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getIdentificador() == identificador) {
                usuarios.remove(i);
                break;
            }
        }
    }

    // Método para carregar a coleção particular do usuário
    public void carregarColecaoParticular() {
        String nomeArquivo = "colecao_particular_" + getIdentificador() + ".bin";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            colecaoParticular = (List<Integer>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para salvar a coleção particular do usuário
    public void salvarColecaoParticular() {
        String nomeArquivo = "colecao_particular_" + getIdentificador() + ".bin";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(colecaoParticular);
        } catch (IOException e) {
            // Tratar exceção ou informar que não foi possível salvar a coleção particular
        }
    }


    public void adicionarMusicaColecaoParticular(int identificador) {
        colecaoParticular.add(identificador);
    }

    public void removerMusicaColecaoParticular(int identificador) {
        colecaoParticular.remove(Integer.valueOf(identificador));
    }

    public List<Integer> getColecaoParticular() {
        return colecaoParticular;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



}
