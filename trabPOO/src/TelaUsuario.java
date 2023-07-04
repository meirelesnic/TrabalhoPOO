import java.util.List;
import java.util.Scanner;

public class TelaUsuario {

    private Usuario user;

    private Sistema sis;

    public TelaUsuario(Usuario user, Sistema sis){
        this.user = user;
        this.sis = sis;
    }

    public  void iniciar(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Exibindo opções para Usuario Comum:");
        System.out.println("1. Vizualizar Coleçao Particular");
        System.out.println("2. Adicionar Musica a colecao Particular");
        System.out.println("3. Remover Musica da colecao Particular");
        System.out.println("4. Remover-se do sistema");
        System.out.println("Exibindo opções para Funcionario:");
        System.out.println("5. Cadastrar Musica");
        System.out.println("6. Recuperar Musica");
        System.out.println("7. Atualizar musica");
        System.out.println("8. Remover Musica");
        System.out.println("9. Adicionar usuario");
        System.out.println("10. Buscar usuario");
        System.out.println("11. Remover usuario");
        System.out.println("12. Sair");
        String opcao = teclado.next();

        switch (opcao) {
            case "1" -> {
                try {
                    user.carregarColecaoParticular();
                    for(Integer id : user.getColecaoParticular()){
                        if(sis.recuperarMusicaiD(id) instanceof Cancao){
                            System.out.println("Identificador: "  + sis.recuperarMusicaiD(id).getId() +"  Titulo: " + sis.recuperarMusicaiD(id).getTitulo()+"  Duração: " + sis.recuperarMusicaiD(id).getDuracao() + " Autores: " + sis.recuperarMusicaiD(id).getAutores() + "  Data Cadastro: " + sis.recuperarMusicaiD(id).getData()+"  Genero: " + sis.recuperarMusicaiD(id).getGeneroMusical() + " Letra: " + ((Cancao) sis.recuperarMusicaiD(id)).getLetra());
                        } else {
                            System.out.println("Identificador: "  + sis.recuperarMusicaiD(id).getId() +"  Titulo: " + sis.recuperarMusicaiD(id).getTitulo()+"  Duração: " + sis.recuperarMusicaiD(id).getDuracao() + " Autores: " + sis.recuperarMusicaiD(id).getAutores() + "  Data Cadastro: " + sis.recuperarMusicaiD(id).getData()+"  Genero: " + sis.recuperarMusicaiD(id).getGeneroMusical() + " Letra: " + ((MusicaInstrumental) sis.recuperarMusicaiD(id)).getPartitura());
                        }                }
                }catch (Exception e) {
                    System.out.println("Coleção vazia");
                }
                System.out.println("Retornar(1)");
                teclado.nextInt();
                iniciar();
            }
            case "2" -> {
                for(Musica musica : sis.getColecaoPrincipal()){
                    if(musica instanceof Cancao){
                        System.out.println("Identificador: "  + musica.getId() +"  Titulo: " + musica.getTitulo()+"  Duração: " + musica.getDuracao() + " Autores: " + musica.getAutores() + "  Data Cadastro: " + musica.getData()+"  Genero: " + musica.getGeneroMusical() + " Letra: " + ((Cancao) musica).getLetra());
                    } else {
                        System.out.println("Identificador: "  + musica.getId() +"  Titulo: " + musica.getTitulo()+"  Duração: " + musica.getDuracao() + " Autores: " + musica.getAutores() + "Data Cadastro: " + musica.getData()+"  Genero: " + musica.getGeneroMusical() + " Partitura: " + ((MusicaInstrumental) musica).getPartitura());
                    }
                }
                System.out.println("Deseja adicionar qual musica a sua coleção particular? Passe o id");
                int id = teclado.nextInt();
                user.adicionarMusicaColecaoParticular(id);
                user.salvarColecaoParticular();
                System.out.println("Musica adicionada!Retornar(1)");
                teclado.nextInt();
                iniciar();
            }
            case "3" -> {
                try {
                    System.out.println("id da musica a ser removida da sua coleção:");
                    int id = teclado.nextInt();
                    user.removerMusicaColecaoParticular(id);
                    user.salvarColecaoParticular();
                    System.out.println("Musica removida!");
                }catch (Exception e){
                    System.out.println("Esta musica nao está na sua coleção");
                }
                System.out.println("Retornar(1)");
                teclado.nextInt();
                iniciar();
            }
            case "4" -> {
                user.removerUsuario(user.getIdentificador(), sis.getUsuarios());
                sis.salvarDados();
            }
            case "5" -> {
                System.out.println("Deseja cadastrar uma canção(1) ou uma música instrumental(2):");
                int escolha = teclado.nextInt();
                if (escolha == 1) {
                    System.out.println("Título da canção a ser cadastrada:");
                    teclado.nextLine();
                    String titulo = teclado.nextLine();
                    System.out.println("Duração da canção a ser cadastrada em minutos e segundos:");
                    String duracao = teclado.nextLine();
                    System.out.println("Autores da canção a ser cadastrada separados por vírgula:");
                    List<String> autores = List.of(teclado.nextLine().split(","));
                    System.out.println("Gênero musical da canção:");
                    String genero = teclado.nextLine();
                    System.out.println("Letra da canção:");
                    String letra = teclado.nextLine();
                    Cancao cancao = new Cancao(sis.getColecaoPrincipal().size(), titulo, duracao, autores, genero, letra);
                    user.cadastrarMusica(cancao, sis.getColecaoPrincipal());
                    sis.salvarDados();
                    System.out.println("Música cadastrada com sucesso! Retornar (1)");
                    teclado.nextInt();
                    iniciar();
                } else if (escolha == 2) {
                    System.out.println("Título da música instrumental a ser cadastrada:");
                    teclado.nextLine();
                    String titulo = teclado.nextLine();
                    System.out.println("Duração da música instrumental a ser cadastrada em minutos e segundos:");
                    String duracao = teclado.nextLine();
                    System.out.println("Autores da música instrumental a ser cadastrada separados por vírgula:");
                    List<String> autores = List.of(teclado.nextLine().split(","));
                    System.out.println("Gênero musical da música instrumental:");
                    String genero = teclado.nextLine();
                    System.out.println("Partitura da música instrumental:");
                    String partitura = teclado.nextLine();
                    MusicaInstrumental musicaInstrumental = new MusicaInstrumental(sis.getColecaoPrincipal().size(), titulo, duracao, autores, genero, partitura);
                    user.cadastrarMusica(musicaInstrumental, sis.getColecaoPrincipal());
                    sis.salvarDados();
                    System.out.println("Música instrumental cadastrada com sucesso! Retornar (1)");
                    teclado.nextInt();
                    iniciar();
                } else {
                    System.out.println("Opção inválida!");
                    iniciar();
                }
            }
            case "6" -> {
                System.out.println("Titulo da musica a ser buscada:");
                teclado.nextLine();
                String titulo = teclado.nextLine();
                Musica musica= user.recuperarMusica(titulo,sis.getColecaoPrincipal());
                if(musica instanceof Cancao){
                    System.out.println("Titulo: " + musica.getTitulo()+"  Duração: " + musica.getDuracao() + " Autores: " + musica.getAutores() + "  Data Cadastro: " + musica.getData()+"  Genero: " + musica.getGeneroMusical() + " Letra: " + ((Cancao) musica).getLetra());
                } else {
                    System.out.println("Titulo: " + musica.getTitulo()+"  Duração: " + musica.getDuracao() + " Autores: " + musica.getAutores() + "Data Cadastro: " + musica.getData()+"  Genero: " + musica.getGeneroMusical() + " Partitura: " + ((MusicaInstrumental) musica).getPartitura());
                }
                System.out.println("Retornar(1)");
                teclado.nextInt();
                iniciar();
            }
            case "7" -> {
                System.out.println("ID da música a ser atualizada:");
                int id = teclado.nextInt();
                Musica musica = sis.recuperarMusicaiD(id);
                if (musica != null) {
                    System.out.println("Música encontrada:");
                    if (musica instanceof Cancao) {
                        System.out.println("Identificador: " + musica.getId() + "  Título: " + musica.getTitulo() + "  Duração: " + musica.getDuracao() + " Autores: " + musica.getAutores() + "  Data Cadastro: " + musica.getData() + "  Gênero: " + musica.getGeneroMusical() + " Letra: " + ((Cancao) musica).getLetra());
                    } else {
                        System.out.println("Identificador: " + musica.getId() + "  Título: " + musica.getTitulo() + "  Duração: " + musica.getDuracao() + " Autores: " + musica.getAutores() + "Data Cadastro: " + musica.getData() + "  Gênero: " + musica.getGeneroMusical() + " Partitura: " + ((MusicaInstrumental) musica).getPartitura());
                    }

                    System.out.println("Selecione o atributo a ser atualizado:");
                    System.out.println("1. Título");
                    System.out.println("2. Duração");
                    System.out.println("3. Autores");
                    System.out.println("4. Gênero");
                    System.out.println("5. Letra (apenas para canções)");
                    System.out.println("6. Partitura (apenas para músicas instrumentais)");
                    int atributo = teclado.nextInt();
                    teclado.nextLine(); // Limpar o buffer do teclado

                    switch (atributo) {
                        case 1 -> {
                            System.out.println("Novo título:");
                            String novoTitulo = teclado.nextLine();
                            musica.setTitulo(novoTitulo);
                        }
                        case 2 -> {
                            System.out.println("Nova duração:");
                            String novaDuracao = teclado.nextLine();
                            musica.setDuracao(novaDuracao);
                        }
                        case 3 -> {
                            System.out.println("Novos autores (separados por vírgula):");
                            String novaListaAutores = teclado.nextLine();
                            List<String> novosAutores = List.of(novaListaAutores.split(","));
                            musica.setAutores(novosAutores);
                        }
                        case 4 -> {
                            System.out.println("Novo gênero:");
                            String novoGenero = teclado.nextLine();
                            musica.setGeneroMusical(novoGenero);
                        }
                        case 5 -> {
                            if (musica instanceof Cancao) {
                                System.out.println("Nova letra:");
                                String novaLetra = teclado.nextLine();
                                ((Cancao) musica).setLetra(novaLetra);
                            } else {
                                System.out.println("A música selecionada não é uma canção. Operação inválida.");
                            }
                        }
                        case 6 -> {
                            if (musica instanceof MusicaInstrumental) {
                                System.out.println("Nova partitura:");
                                String novaPartitura = teclado.nextLine();
                                ((MusicaInstrumental) musica).setPartitura(novaPartitura);
                            } else {
                                System.out.println("A música selecionada não é uma música instrumental. Operação inválida.");
                            }
                        }
                        default -> {
                            System.out.println("Opção inválida!");
                        }
                    }

                    sis.salvarDados();
                    System.out.println("Música atualizada com sucesso!");
                } else {
                    System.out.println("Música não encontrada na coleção.");
                }

                System.out.println("Retornar(1)");
                teclado.nextInt();
                iniciar();
            }

            case "8" -> {
                System.out.println("id da musica a ser removida:");
                int id = teclado.nextInt();
                user.removerMusica(id,sis.getColecaoPrincipal());
                sis.salvarDados();
                System.out.println("Musica removida com sucesso!!");
                System.out.println("Retornar(1)");
                teclado.nextInt();
                iniciar();
            }
            case "9" -> {
                System.out.println("Nome do usuario a ser adicionado:");
                teclado.nextLine();
                String nome = teclado.nextLine();
                System.out.println("Login para o usuario a ser adicionado:");
                String login = teclado.nextLine();
                System.out.println("Senha para o usuario a ser adicionado:");
                String senha = teclado.nextLine();
                Usuario usuario = new Usuario(nome, sis.getUsuarios().size(),login,senha);
                user.adicionarUsuario(usuario, sis.getUsuarios());
                sis.salvarDados();
                System.out.println("Usuario cadastrado com sucesso!!");
                System.out.println("Retornar(1)");
                teclado.nextInt();
                iniciar();
            }
            case "10" -> {
                try {
                    System.out.println("Nome do usuario a ser procurado:");
                    teclado.nextLine();
                    String nome = teclado.nextLine();
                    Usuario usu = user.buscarUsuario(nome,sis.getUsuarios());
                    System.out.println("Nome: " + usu.getNome()+"  Login: " + usu.getLogin() + " Identificador: " + usu.getIdentificador());
                    System.out.println("Retornar(1)");
                    teclado.nextInt();
                } catch (Exception e){
                    System.out.println("Nome inválido");
                    System.out.println("Retornar(1)");
                    teclado.nextInt();
                }

                iniciar();
            }
            case "11" -> {
                try {
                    System.out.println("ID do usuario a ser removido:");
                    int id = teclado.nextInt();
                    user.removerUsuario(id,sis.getUsuarios());
                    System.out.println("Usuario removido. Retornar(1)");
                    sis.salvarDados();
                    teclado.nextInt();
                } catch (Exception e){
                    System.out.println("ID inválido");
                    System.out.println("Retornar(1)");
                    teclado.nextInt();
                }
                iniciar();
            }
            case "12" -> {
                sair();
            }
            default -> {
                System.out.println("Opção invalida!");
                iniciar();
            }
        }
    }


    public  void sair(){
        System.out.println("Volte sempre!");
        try{
            sis.salvarDados();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        sis.salvarDados();
        System.exit(0);
    }

}
