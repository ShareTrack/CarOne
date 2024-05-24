package pacote2;

import java.util.Scanner;

// Classe Viagem
public class Viagem {
    protected String partida, destino;
    protected double partidaX, destinoX;
    protected double partidaY, destinoY;
    protected int qtdelugares;
    protected Usuario motorista;
    protected Usuario passageiro;
    protected boolean viagemCompleta;
     protected int avaliacao;

    
    
    // Construtor vazio:
    public Viagem() {
        viagemCompleta = false;
    }
    
    // Métodos Setters para obter os valores inseridos pelo usuário:
    public void setPartida(String partida) {
        this.partida = partida;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public void setLugares(int qtdelugares) {
        this.qtdelugares = qtdelugares;
     
    }
    
    public void setMotorista(Usuario m) {
        this.motorista = m;
     
    }
    
    public void setPassgeiro(Usuario m) {
        this.passageiro = m;
     
    }
    public void setViagemCompleta(boolean m) {
        this.viagemCompleta = m;
     
    }
    
     public void setAvaliacao(int m) {
        this.avaliacao = m;
     
    }
    
    
    
    
    // Métodos Getters para mostrar os valores inseridos pelo usuário:
    public String getPartida() {
        return partida;
    }
    public String getDestino() {
        return destino;
    }
    public int getQtdeLugares() {
        return qtdelugares;
    }
    public double getPartidaX() {
      return partidaX;
    }
    public double getDestinoX() {
      return destinoX;
    }
    public double getPartidaY() {
      return partidaY;
    }
    public double getDestinoY() {
      return destinoY;
    }
    
     public Usuario getMotorista() {
      return motorista;
    }
     
     public Usuario getPassageiro() {
      return passageiro;
    }
    
    
    //Função Euclidiana
    public double getDistancia(){
        
       
        
        
        
        return Math.sqrt(((destinoX - partidaX)*(destinoX - partidaX)) + ((destinoY - partidaY)*(destinoY - partidaY)));
        
        
    }
    
    // Função pegar ponto central;
    public double[] pontoCentral(){
        
        double[] conjuntoCentral = new double[2];
        conjuntoCentral[0] = (partidaX + destinoX)/2;
        conjuntoCentral[1] = (partidaY + destinoY)/2;
        return conjuntoCentral;
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Método para validar as informações inseridas pelo usuário ao cadastrar uma viagem:
    public void CadastroViagem() {
        boolean sucessoCadastro = false;
        Scanner entrada = new Scanner(System.in);
        boolean validacao = false;
        System.out.print("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=---=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        System.out.print("Informe os seguintes dados:\n");
        
        // Validação e atribuição do ponto de partida(Não pode estar em branco):
        while (validacao == false) {
            System.out.print("\nPonto de Partida: ");
            String partida = entrada.nextLine();
            if (partida.isEmpty()) {
                System.out.println("[ERROR] Campo Obrigatório! Digite Novamente.");
            } else {
                this.partida = partida;
                
                validacao = true;
            }
        }
        validacao = false;
        
        // Validação e atribuição do ponto de destino(Não pode estar em branco):
        while (validacao == false) {
            System.out.print("Ponto de Destino: ");
            String destino = entrada.nextLine();
            if (destino.isEmpty()) {
                System.out.println("[ERROR] Campo Obrigatório! Digite Novamente.");
            } else {
                this.destino = destino;
                validacao = true;
            }
        }
        validacao = false; 
        
        // Validação e atribuição da quantidade de lugares(Deve ser um número inteiro).
        while (validacao == false) {
        System.out.print("Quantidade de Lugares: ");
        
        // Validação onde o número inseiro será um inteiro:
        try {
            this.qtdelugares = Integer.parseInt(entrada.nextLine());
            sucessoCadastro = true;
            validacao = true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Entrada inválida! Digite um número inteiro.");
        }

        if (sucessoCadastro) {
            System.out.println("\nViagem cadastrada com sucesso!");
        } else {
            System.out.println("[ERROR] Ao cadastrar a viagem! Tente novamente.");
        }
        
    }
    validacao = false;
        // Validação e atribuição da latitude.
      while (validacao == false) {
          System.out.print("Partida X: ");
              try {
                  this.partidaX = Integer.parseInt(entrada.nextLine());
                  validacao = true;
              } catch (NumberFormatException e) {
                  System.out.println("[ERROR] Entrada inválida! Digite um número inteiro.");
                  
              }
              
              }
            
    validacao = false;


        //Validação e atribuição da longitude.
        while (validacao == false) {
          System.out.print("Partida Y: ");
                try {
                  this.partidaY= Integer.parseInt(entrada.nextLine());
                  validacao = true;
              } catch (NumberFormatException e) {
                  System.out.println("[ERROR] Entrada inválida! Digite um número inteiro.");
                  
              }

       }
        validacao = false;
         //Validação e atribuição da longitude.
        while (validacao == false) {
          System.out.print("Destino X: ");
              try {
                  this.destinoX = Integer.parseInt(entrada.nextLine());
                  validacao = true;
              } catch (NumberFormatException e) {
                  System.out.println("[ERROR] Entrada inválida! Digite um número inteiro.");
                 
              }

       }
        validacao = false;
         //Validação e atribuição da longitude.
        while (validacao == false) {
          System.out.print("Destino Y: ");
              try {
                  this.destinoY = Integer.parseInt(entrada.nextLine());
                  validacao = true;
              } catch (NumberFormatException e) {
                  System.out.println("[ERROR] Entrada inválida! Digite um número inteiro.");
                  validacao = false;
              }

       }

       }
}
