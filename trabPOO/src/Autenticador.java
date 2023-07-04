import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Autenticador {
    private List<Usuario> usuarios;

    public Autenticador(Sistema sis) {
        usuarios = new ArrayList<>();
        usuarios = sis.getUsuarios();
    }

    public Usuario realizarLogin(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }

    public void salvarCredencias(Usuario usuario) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("login.enc"))) {
            String login = usuario.getLogin();
            String senha = usuario.getSenha();
            oos.writeObject(login);
            oos.writeObject(senha);
        } catch (IOException e) {
            System.out.println("Nao foi possivel salvar login e senha!!");
        }
    }
}
