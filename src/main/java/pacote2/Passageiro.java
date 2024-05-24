package pacote2;

import java.util.ArrayList;
import java.util.Scanner;

// Classe Passageiro
public class Passageiro extends Usuario {
    protected String nome, email, endereco, telefone, senha;
    public Passageiro(){
        super ("", "", "", "", "");
    }
    
    public Passageiro( String nome, String email, String endereco, String telefone, String senha ) {
        super(nome, email, endereco, telefone, senha);
    }    

    // Método para validar as informações inseridas pelo usuário passageiro:
    public void solicitarDadosPassageiro() {
        Scanner entrada = new Scanner(System.in);
        boolean camposPreenchidos = false;
    
        // Validação do nome(Não pode estar em branco):
        while (camposPreenchidos == false) {
            System.out.print("\nNome: ");
            String nome = entrada.nextLine();
            if (nome.isEmpty()) {
                System.out.println("[ERROR] Campo obrigatório! Digite novamente.");
            } else {
                setNome(nome);
                camposPreenchidos = true;
            }
        }
        camposPreenchidos = false;
        
    // Validação do email(Não pode estar em brancoe deve possuir o @ e .com):
        while (camposPreenchidos == false) {
            System.out.print("Email: ");
            String email = entrada.nextLine();
            if (email.isEmpty()) {
                System.out.println("[ERROR] Campo obrigatório! Digite novamente.");
            } else if (!email.contains("@") || !email.contains(".com")) {
                System.out.println("[ERROR] E-mail inválido! Deve conter o caractere '@' e '.com'. Digite novamente.");
            } else {
                setEmail(email);
                camposPreenchidos = true;
            }
        }
        camposPreenchidos = false;

    // Validação do telefone(Não pode estar em branco e deve possuir 9 caractéres):
        while (camposPreenchidos == false) {
            System.out.print("Telefone: ");
            String telefone = entrada.nextLine();
            if (telefone.isEmpty()) {
                System.out.println("[ERROR] Campo obrigatório! Digite novamente.");
            } else if (telefone.length() != 9) {
                System.out.println("[ERROR] O campo deve conter 9 caracteres.");
            } else {
                setTelefone(telefone);
                camposPreenchidos = true;
            }
        }
        camposPreenchidos = false;

    // Validação do endereço(Não pode estar em branco):
        while (camposPreenchidos == false) {
            System.out.print("Endereço: ");
            String endereco = entrada.nextLine();
            if (endereco.isEmpty()) {
                System.out.println("[ERROR] Campo obrigatório! Digite novamente.");
            } else {
                setEndereco(endereco);
                camposPreenchidos = true;
            }
        }
        camposPreenchidos = false;

    // Validação do senha(Não pode estar em branco e deve possuir 5 caractéres):
        while (camposPreenchidos == false) {
            System.out.print("Senha: ");
            String senha = entrada.nextLine();
            if (senha.isEmpty()) {
                System.out.println("[ERROR] Campo obrigatório! Digite novamente.");
            } else if (senha.length() != 5) {
                System.out.println("[ERROR] O campo deve conter 5 caracteres.");
            } else {
                setSenha(senha);
                camposPreenchidos = true;
            }
        }
    }
}
