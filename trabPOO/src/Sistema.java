import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    private List<Musica> colecaoPrincipal;
    private List<Usuario> usuarios;

    Autenticador aut;

    public Sistema() {
        colecaoPrincipal = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public Musica recuperarMusicaiD(int id) {
        for (Musica musica : colecaoPrincipal) {
            if (musica.getId()==id) {
                return musica;
            }
        }
        return null;
    }
    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }


    public void carregarDados() {
        carregarMusicas();
        carregarUsuarios();
        aut = new Autenticador(this);

    }

    private void carregarMusicas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("colecao_principal.bin"))) {
            colecaoPrincipal = (List<Musica>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void carregarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.bin"))) {
            usuarios = (List<Usuario>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void salvarDados() {
        salvarMusicas();
        salvarUsuarios();
    }

    private void salvarMusicas() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("colecao_principal.bin"))) {
            oos.writeObject(colecaoPrincipal);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void salvarUsuarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuarios.bin"))) {
            oos.writeObject(usuarios);
            oos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Musica> getColecaoPrincipal() {
        return colecaoPrincipal;
    }

    public void setColecaoPrincipal(List<Musica> colecaoPrincipal) {
        this.colecaoPrincipal = colecaoPrincipal;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
