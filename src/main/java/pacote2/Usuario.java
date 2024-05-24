
package pacote2;

import java.util.ArrayList;

// Classe Usuario
public class Usuario {
    protected String nome, email, endereco, telefone, senha;
    protected int x, y;
    
    private ArrayList<Viagem> ArrayViagensPendentes = new ArrayList<>();
    private ArrayList<Viagem> ArrayViagensConfirmadas = new ArrayList<>();
     
     
    
    private ArrayList<Viagem> ArrayViagensRecusadas = new ArrayList<>();
    
    
    // Constutor com parâmetros:
    public Usuario( String nome, String email, String endereco, String telefone, String senha ) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.senha = senha;
    }    

        
    
   // Métodos Setters para obter os valores inseridos pelo usuário passageiro:
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    
    
    
    
    // Métodos Getters para mostrar os valores inseridos pelo usuário passageiro:
    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getSenha() {
        return senha;
    }
    
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    
    public ArrayList<Viagem> getArrayViagensPendentes(){
        return ArrayViagensPendentes;
    }
    
    public ArrayList<Viagem> getArrayViagensConfirmadas(){
        return ArrayViagensConfirmadas;
    }
    public ArrayList<Viagem> getArrayViagensRecusadas(){
        return ArrayViagensRecusadas;
    }
    
    
}
