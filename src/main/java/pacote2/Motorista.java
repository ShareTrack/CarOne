package pacote2;

import java.util.ArrayList;
import java.util.Scanner;


public class Motorista extends Usuario {
    private String numcnh, fabricante, modelo, cor, placa;
    public Motorista(){
        super ("", "", "", "", "");
    }
    
    // Constutor com parâmetros:
    public Motorista( String numcnh, String fabricante, String modelo, String cor, String placa, String nome, String email, String endereco, String telefone, String senha) {
        super(nome, email, endereco, telefone, senha);
        this.numcnh = numcnh;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
    }

    // Métodos Setters para obter os valores inseridos pelo usuário motorista:
    public void setNomeMotorista(String nome) {
        // Método herdado da class Passageiro:
        setNome(nome);  
    }
    public void setEmailMotorista(String email){
        setEmail(email); 
    }
    public void setTelefoneMotorista(String telefone){
        setTelefone(telefone);
    }
    public void setEnderecoMotorista(String endereco){
        setEndereco(endereco);
    }
    public void setSenhaMotorista(String senha){
        setSenha(senha);
    }
    
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public void setNumCnh(String numcnh){
        this.numcnh = numcnh;
    }
    
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
    public String getEndereco(){
        return endereco;
    }
    public String getTelefone(){
        return telefone;
    }
    public String getFabricante() {
        return fabricante;
    }
    public String getModelo() {
        return modelo;
    }
    public String getCor() {
        return cor;
    }
    public String getPlaca() {
        return placa;
    }
    public String getNumCnh() {
        return numcnh;
    }
    
   
    
    // Método para validar as informações inseridas pelo usuário motorista:
    public void solicitarDadosMotorista() {
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
        } else if (!email.contains("@") || !email.contains(".com")){
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
        camposPreenchidos = false;
        
    // Validação do fabricante(Não pode estar em branco):
        while (camposPreenchidos == false) {
            System.out.print("Fabricante: ");
            String fabricante = entrada.nextLine();
            if (fabricante.isEmpty()) {
                System.out.println("[ERROR] Campo obrigatório! Digite novamente.");
            } else {
                setFabricante(fabricante);
                camposPreenchidos = true;
            }
        }
        camposPreenchidos = false;
        
    // Validação do modelo(Não pode estar em braco):
        while (camposPreenchidos == false) {
            System.out.print("Modelo: ");
            String modelo = entrada.nextLine();
            if (modelo.isEmpty()) {
                System.out.println("[ERROR] Campo obrigatório! Digite novamente.");
            } else {
                setModelo(modelo);
                camposPreenchidos = true;
            }
        }
        camposPreenchidos = false;
        
    // Validação da cor(Não pode estar em branco):
        while (camposPreenchidos == false) {
            System.out.print("Cor: ");
            String cor = entrada.nextLine();
            if (cor.isEmpty()) {
                System.out.println("[ERROR] Campo obrigatório! Digite novamente.");
            } else {
                setCor(cor);
                camposPreenchidos = true;
            }
        }

    // Validação da placa(Não pode estar em branco e deve possuir 7 caractéres):
        boolean placaValida = false;
        while (placaValida == false) {
            System.out.print("Placa: ");
            String placa = entrada.nextLine();
            if (placa.length() != 7) {
                System.out.println("[ERROR] A placa deve conter 7 caracteres! Digite novamente");
            } else {
                placaValida = true;
                setPlaca(placa);
            }
        }
        camposPreenchidos = false;
        
    // Validação do numero de CNH(Não pode estar em branco e deve possuir 9 caractéres):
        while (camposPreenchidos == false) {
            System.out.print("Número da CNH: ");
            String numcnh = entrada.nextLine();
            if (numcnh.isEmpty()) {
                System.out.println("[ERROR] Campo obrigatório! Digite novamente.");
            } else if (numcnh.length() != 9) {
                System.out.println("[ERROR] O campo deve conter 9 caracteres.");
            } else {
                setNumCnh(numcnh);
                camposPreenchidos = true;
            }
        }
        camposPreenchidos = false;
    }
}
 
