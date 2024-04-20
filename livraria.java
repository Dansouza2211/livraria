import java.util.ArrayList;
import java.util.Scanner;

class Livro {
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public Livro(int id, String titulo, String autor, int anoPublicacao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }
}

class Livraria {
    private ArrayList<Livro> livros;

    public Livraria() {
        livros = new ArrayList<>();
    }

    public void cadastrarLivro(int id, String titulo, String autor, int anoPublicacao) {
        Livro livro = new Livro(id, titulo, autor, anoPublicacao);
        livros.add(livro);
    }

    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro.getId() + " - " + livro.getTitulo());
        }
    }

    public void detalharLivro(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                System.out.println("Detalhes do livro:");
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Ano de Publicação: " + livro.getAnoPublicacao());
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }
}

class Sistema {
    private Livraria livraria;
    private Scanner scanner;

    public Sistema() {
        livraria = new Livraria();
        scanner = new Scanner(System.in);
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Detalhar livro");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha
            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    listarLivros();
                    break;
                case 3:
                    detalharLivro();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    private void cadastrarLivro() {
        System.out.println("\nCadastro de Livro:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ano de Publicação: ");
        int anoPublicacao = scanner.nextInt();
        livraria.cadastrarLivro(id, titulo, autor, anoPublicacao);
        System.out.println("Livro cadastrado com sucesso.");
    }

    private void listarLivros() {
        System.out.println("\nLista de Livros:");
        livraria.listarLivros();
    }

    private void detalharLivro() {
        System.out.println("\nDetalhar Livro:");
        System.out.print("ID do livro: ");
        int id = scanner.nextInt();
        livraria.detalharLivro(id);
    }
}

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.menu();
    }
}
