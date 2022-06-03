public class User{ //Classe usuário
    private String nome;
    private String senha;
     
    public User(String n, String s){
        this.nome=n;
        this.senha=s;   
    }

    public String getName(){
        return this.nome;
    }

    public String getSenha(){
        return this.senha;
    }

}