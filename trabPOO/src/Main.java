import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Sistema sis = new Sistema();

        sis.carregarDados();

        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite seu login: ");

        String login = teclado.nextLine();

        System.out.println("Digite sua Senha: ");

        String senha = teclado.nextLine();

        Usuario user = sis.aut.realizarLogin(login,senha);

        if(user == null){
            System.out.println("Usuario Inexistente. Digite seu nome para cadastro: ");
            String nome = teclado.nextLine();
            System.out.println("Digite seu login: ");
            login = teclado.nextLine();
            System.out.println("Digite sua Senha: ");
            senha = teclado.nextLine();
            Usuario usuario = new Usuario(nome,sis.getUsuarios().size(),login,senha);
            sis.aut.salvarCredencias(usuario);
            sis.adicionarUsuario(usuario);
            sis.salvarDados();
            System.out.println("Usuario cadastrado com sucesso");
            TelaUsuario telaUsuario = new TelaUsuario(usuario, sis);
            telaUsuario.iniciar();

        } else {
            System.out.println("Usuario logado com sucesso");
            TelaUsuario telaUsuario = new TelaUsuario(user, sis);
            telaUsuario.iniciar();
        }

    }
}