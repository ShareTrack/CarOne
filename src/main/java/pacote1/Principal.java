
package pacote1;

import java.util.ArrayList;
import java.util.Scanner;
import pacote2.Motorista;
import pacote2.Passageiro;
import pacote2.Usuario;
import pacote2.Viagem;

public class Principal {
    
    private static Scanner entrada = new Scanner(System.in);
    private static boolean cadastroEfetuado = false;
    private static boolean loginEfetuado = false;
    private static Usuario usuarioAtivo;
    private static boolean finalizar = false;
    
    private static ArrayList<Passageiro> ArrayPassageiros = new ArrayList<>();
    private static ArrayList<Motorista> ArrayMotoristas = new ArrayList<>();
    private static ArrayList<Viagem> ArrayViagens = new ArrayList<>();
    private static ArrayList<Viagem> ArrayViagensDisponiveis = new ArrayList<>();
    private static ArrayList<Viagem> ArrayViagensAvaliadas = new ArrayList<>();
     
    private static boolean Vaceita = false;
    

    static void menuPrincipal() {
        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("\nSeja Bem-Vindo(a) ao ShareTrack");
        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        System.out.print("Menu Principal:\n");
        System.out.println("\n[1] - Cadastrar Novo Usuário");

        // Desbloqueia as funcionalidades se o cadastro for efetuado:
        if (cadastroEfetuado) {
            System.out.println("[2] - Login");
            
            if (loginEfetuado) {
                if(usuarioAtivo.getArrayViagensPendentes().isEmpty() == false){
                    for(Viagem u: usuarioAtivo.getArrayViagensPendentes()){
                        
                        System.out.println("Nome: " + u.getPassageiro().getNome());
                        System.out.println("X: " + u.getPassageiro().getX());
                        System.out.println("Y: " + u.getPassageiro().getY());
                        System.out.println("Vc deseja aceitar esse viagem? ");
                        int aceita = entrada.nextInt();
                        entrada.nextLine();
                        
                        if(aceita == 1){
                            u.getPassageiro().getArrayViagensConfirmadas().add(u);
                            Vaceita = true;
                        } else if(aceita == 0){
                            u.getPassageiro().getArrayViagensRecusadas().add(u);
                            Vaceita = false;
                            }    
                     }

                if (Vaceita == true){
                    usuarioAtivo.getArrayViagensPendentes().remove(0);
                } else{
                    usuarioAtivo.getArrayViagensPendentes().remove(0);
                    }
                  
                } else if (usuarioAtivo.getArrayViagensConfirmadas().isEmpty() == false){
                    System.out.println("Sua Viagem foi confirmada");
                    
                    
                } else if (usuarioAtivo.getArrayViagensRecusadas().isEmpty() == false){
                    System.out.println("Sua Viagem foi Rescusada");
                    usuarioAtivo.getArrayViagensRecusadas().remove(0);
                }
                
                System.out.println("[3] - Cadastrar Viagem");
                System.out.println("[4] - Buscar Carona");
                System.out.println("[5] - Avaliar Viagem");
            } else {
                System.out.println("[3] - Cadastrar Viagem (Bloqueado)");
                System.out.println("[4] - Buscar Carona (Bloqueado)");
                System.out.println("[5] - Avaliar Viagem (Bloqueado)");
            }
        } else {
            System.out.println("[2] - Login (Bloqueado)");
            System.out.println("[3] - Cadastrar Viagem (Bloqueado)");
            System.out.println("[4] - Buscar Carona (Bloqueado)");
            System.out.println("[5] - Avaliar Viagem (Bloqueado)");
        }
        
        System.out.println("[6] - Sair do Programa");
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }
    
    // Função opção do usuário:
    static int opcaoUsuario() {
        int valorOpcao;
        
        // Validação da opção do usuário(apenas números entre 1 e 6):
        while (true) {
            System.out.print("Informe sua Opção: ");
            
            // Validação onde o número inseiro será um inteiro:
            try {
                valorOpcao = Integer.parseInt(entrada.nextLine());
                if (valorOpcao < 1 || valorOpcao > 6) {
                    System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("\n[ERROR] Opção inválida! Digite novamente");
                    System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                } else {
                    break; // Sai do loop se a opção for válida
                }
            } catch (NumberFormatException e) {
                System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("\n[ERROR] Opção inválida! Digite um número");
                System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            }
        }
        return valorOpcao;
        }
    
    // Função da opção 1:
    static void informaDados() {
        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.print("\nTipo Conta: \n");
        System.out.print("\n[1] - Passageiro \n[2] - Motorista");
        System.out.print("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.print("\nInforme a opção: ");
        
        while (true) {
            try {
                int tipoConta = Integer.parseInt(entrada.nextLine());
                // entrada.nextLine(); Consumir o resto da linha:
                switch (tipoConta) {
                    case 1:
                        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.print("\nVocê escolheu o tipo [Passageiro]");
                        System.out.print("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.print("\nInforme os seguintes dados: \n");

                        Passageiro passageiro1 = new Passageiro();
                        passageiro1.solicitarDadosPassageiro();
                        ArrayPassageiros.add(passageiro1);
                        System.out.print("\nCadastro efetuado com sucesso!\n");
                        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.print("\nAgora clique na opção 2 [Login]\n");
                        cadastroEfetuado = true;
                        return;
                    case 2:
                        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.print("\nVocê escolheu o tipo [Motorista]\n");
                        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.print("\nInforme os seguintes dados: \n");

                        Motorista motorista1 = new Motorista();
                        motorista1.solicitarDadosMotorista();
                        System.out.print("\nCadastro efetuado com sucesso!\n");
                        ArrayMotoristas.add(motorista1);
                        cadastroEfetuado = true;
                        return;
                    default:
                        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.println("\n[ERROR] Opção inválida! Digite Novamente");
                        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.print("\nInforme a opção: ");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                System.out.println("\n[ERROR] Opção inválida! Digite um número");
                System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                entrada.next(); // Descartar a entrada inválida
            }
        }
    }
    
    // Função da opção 2.
    static void loginUsuario() {
        
        boolean camposPreenchidos = false;
        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        System.out.print("Escolha o tipo de login:\n");
        System.out.print("\n[1] Logar como Passageiro");
        System.out.print("\n[2] Logar como Motorista\n");
        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        System.out.print("Informe sua opção: ");
        int tipoOpcao = entrada.nextInt();
        entrada.nextLine(); 

        // Inicializando variável:
        String email = "";

        // Validação do email(não pode estar em branco e deve possuir '@' e '.com'):
        while (camposPreenchidos == false) {
            System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
            System.out.print("Informe os seguintes dados:\n");
            System.out.print("\nE-mail: ");
            email = entrada.nextLine();
            if (email.isEmpty()) {
                System.out.println("[ERROR] Campo obrigatório! Digite novamente.");
            } else if (!email.contains("@") || !email.endsWith(".com")) {
                System.out.println("[ERROR] E-mail inválido! Deve conter o caractere '@' e terminar com '.com'. Digite novamente.");
            } else {
                camposPreenchidos = true;
            }
        }
        camposPreenchidos = false;

        // Inicializando variável:
        String senha = "";

        // Validação da senha (não pode estar em branco e deve ter pelo menos 5 caracteres):
        while (camposPreenchidos == false) {
            System.out.print("Senha: ");
            senha = entrada.nextLine();
            if (senha.isEmpty()) {
                System.out.println("[ERROR] Campo obrigatório! Digite novamente.");
            } else if (senha.length() < 5) {
                System.out.println("[ERROR] Senha inválida! A senha deve ter pelo menos 5 caracteres. Digite novamente.");
            } else {
                camposPreenchidos = true;
            }
        }

        // Mudando o estado da variável, validando o login do usuário:
        boolean loginRealizado = false;
        switch (tipoOpcao) {
            case 1: {
                // Percorre o ArrayList e verifica se os campos digitados no cadastro conferem no login:
                for (Passageiro passageiro : ArrayPassageiros) {
                    if (passageiro.getEmail().equals(email) && passageiro.getSenha().equals(senha)) {
                        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
                        System.out.println("Você logou como passageiro!");
                        loginEfetuado = true;
                        loginRealizado = true;
                        usuarioAtivo = passageiro;
                        break;
                    }
                }
                break;
            }
            case 2: {
                // Percorre o ArrayList e verifica se os campos digitados no cadastro conferem no login:
                for (Motorista motorista : ArrayMotoristas) {
                    if (motorista.getEmail().equals(email) && motorista.getSenha().equals(senha)) {
                        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
                        System.out.println("Você logou como motorista!");
                        loginEfetuado = true;
                        loginRealizado = true;
                        usuarioAtivo = motorista;
                        break;
                    }
                }
                break;
            }
            default:
                System.out.println("Opção inválida.");
                break;
            }
        if (loginRealizado == false) {
            System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
            System.out.print("[ERROR] E-mail ou senha incorretos. Tente novamente.");
            System.out.print("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.print("\nVolte para a opção 2 [Login]\n");
        }
    }
    
    //Função da opção 3:
       static void CadastroViagem() {
        if (usuarioAtivo instanceof Motorista){
            Viagem novaViagem1 = new Viagem(); 
            novaViagem1.CadastroViagem(); 
            novaViagem1.setMotorista(usuarioAtivo);
            ArrayViagens.add(novaViagem1); 
        }
    } 
    
    //Função Euclidiana
    public static double getDistancia(double destinoX, double destinoY, double partidaX, double partidaY){
        return Math.sqrt(((destinoX - partidaX)*(destinoX - partidaX)) + ((destinoY - partidaY)*(destinoY - partidaY)));
    }
    
    
    //Função 4:
    static void buscaCarona(){
        int usuarioX;
        System.out.print("digite o seu X: ");
        usuarioX = entrada.nextInt();
        
        int usuarioY;
        System.out.print("digite o seu Y: ");
        usuarioY = entrada.nextInt();
        
        int index = 0;
        usuarioAtivo.setX(usuarioX);
        usuarioAtivo.setY(usuarioY);
        
        System.out.print("Quantos passageiros vão entrar? ");
        int passageiros = entrada.nextInt();
        
    for (Viagem viagem : ArrayViagens) {
        // tenho quase certeza que isso aqui ta errado
        if (getDistancia(viagem.getDestinoX(),viagem.getDestinoY(), usuarioX, usuarioY) <= 2 && getDistancia(viagem.getPartidaX(),viagem.getPartidaY(), usuarioX, usuarioY) <= 2 && passageiros <= viagem.getQtdeLugares())  {
            System.out. print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
            System.out.println("Numero Viagem: " + index);
            System.out.println("Partida: " + viagem.getPartida());
            System.out.println("Destino: " + viagem.getDestino());
            System.out.println("Quantidade de lugares: " + viagem.getQtdeLugares());
            ArrayViagensDisponiveis.add(viagem);
            index ++;
            viagem.setPassgeiro(usuarioAtivo);
            System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        }
    }
    System.out. print("Digite o numero da viagem que deseja escolhe(-1 para não aceitar): ");
    int escolha = entrada.nextInt();
    if (escolha > -1 && escolha <= index){
    ArrayViagensDisponiveis.get(escolha).getMotorista().getArrayViagensPendentes().add(ArrayViagensDisponiveis.get(escolha));
        
    }   
    entrada.nextLine();
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

//Função opção 5:
    static void avaliaViagem(){
        usuarioAtivo.getArrayViagensConfirmadas().get(0).setViagemCompleta(true);
        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        System.out.print("Faça a validação da sua viagem:\n");
        System.out.print("\n[1] Muito Bom");
        System.out.print("\n[2] Bom");
        System.out.print("\n[3] Regular");
        System.out.print("\n[4] Ruim");
        System.out.print("\n[5] Péssimo");
        System.out.print("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        
        // Validação da opção do menu de avaliação da viagem:
        while (true){
            System.out.print("Informe sua opção: ");
            int numAvalicao = entrada.nextInt();
            entrada.nextLine(); 
            if(numAvalicao >= 1 && numAvalicao <= 5){
                usuarioAtivo.getArrayViagensConfirmadas().get(0).setAvaliacao(numAvalicao);
                ArrayViagensAvaliadas.add(usuarioAtivo.getArrayViagensConfirmadas().get(0));
                System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
                System.out.print("Obrigada pela avaliação!\n");
                break;
            } else{
                System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
                System.out.print("Opção inválida\n");
                System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
            }
        }
        usuarioAtivo.getArrayViagensConfirmadas().remove(0);
    }

// Programa principal:
    public static void main(String[] args) {
        while (true) {
            if (finalizar == true){
                break;
            }
            menuPrincipal();
            int opcao = opcaoUsuario();
            switch (opcao) {
                case 1: {
                    informaDados();
                    break;
                }
                case 2: {
                    if (cadastroEfetuado) {
                        loginUsuario();
                    } else {
                        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.println("\nEssa funcionalidade está bloqueada. Faça seu cadastro primeiro!");
                    }
                    break;
                }
                case 3: {
                    if (loginEfetuado) {
                        CadastroViagem();
                    } else {
                        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.println("\nEssa funcionalidade está bloqueada. Faça seu cadastro primeiro!");
                    }
                    break;
                }
                case 4: {
                    if (loginEfetuado) {
                        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
                        buscaCarona();
                    } else {
                        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.println("\nEssa funcionalidade está bloqueada. Faça seu cadastro primeiro!");
                    }
                    break;
                }
                case 5: {
                    if (loginEfetuado) {
                        avaliaViagem();
                    } else {
                        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                        System.out.println("\nEssa funcionalidade está bloqueada. Faça seu cadastro primeiro!");
                    }
                    break;
                }
                case 6: {
                    System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.print("\nFim do Programa - Share Track");
                    if (loginEfetuado = true){
                        loginEfetuado = false;
                    }
                    finalizar = true;
            }
        }
            
    }
    }
}
