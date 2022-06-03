import java.util.*;
import java.text.SimpleDateFormat;

public class Sistema{
    private User userlist[];
    private int maxUserList=3;
    Scanner sc= new Scanner(System.in);

    public Sistema(){ //Construtor 
        SystemDefault();
    }

    public void init(){
        startMenu();
    }

    private void SystemDefault(){ //Predetermina a criacao de alguns usuários ao iniciar o sistema
        this.userlist=new User[30];
        userlist[1] = new User("andre","202206");
        userlist[2] = new User("renan","202206");
        userlist[3] = new User("thauany","202206");
    }

    private void startMenu(){ //Menu inicial
        System.out.println("========================== BEM-VINDO(A) AO SISTEMA!! ===========================\n \n");
        System.out.println("========== DIGITE '1' SE VOCE JA TEM LOGIN E '2' SE FOR NOVO USUARIO ===========\n \n");
        int opt= Integer.parseInt(sc.nextLine());
        
        if(opt==1){
            try{
                Login();
            }catch (Exception e){
                System.out.println(e);
                startMenu();
            }
            
        }else if(opt==2){
            Register();
        }else{
            System.out.println("ERRO! NAO FOI SELECIONADO UMA OPÇÃO!!\n ");
            startMenu();
        }
    } 

    private void Login()throws Exception{ //Menu de Login
        System.out.println("================= (LOGIN) DIGITE SEU NOME DE USUÁRIO E SENHA ==================\n \n");
        System.out.println("USERNAME: \t");
        String nome = sc.next();
        System.out.println("SENHA: \t");
        String senha = sc.next();
        boolean b=checkUser(nome,senha);
        if(b==false){
            throw new Exception("ERRO! Nome de usuário e/ou senha Invalido(s)!!\n");
        }else{
            sc.close();
            System.out.println(WelcomeMessage(nome));
        }
        
    }

    private void Register(){ //Menu de Registro
        System.out.println("================================== NOVO USUÁRIO =================================\n \n");
        System.out.println(" DIGITE SEU USERNAME: ");
        String nome = sc.nextLine();
        System.out.println("DIGITE SUA SENHA: ");
        String senha = sc.nextLine();
        this.maxUserList++; 
        this.userlist[this.maxUserList]= new User(nome,senha);
        System.out.println("================= BEM VINDO(A) AO SISTEMA " + nome + "! ==================\n \n");
        startMenu();
    }

    private boolean checkUser(String user, String s)throws Exception{ //Checa a existencia do usuário no sistema
        boolean checked=false;
        String Nome="";
        for(int i=1;i<=this.maxUserList;i++){
            Nome=userlist[i].getName();
            if(Nome.equals(user)){
                if(s.equals(userlist[i].getSenha())){
                    checked=true;
                }
            }
        }
        return checked;
    }

    private String WelcomeMessage(String nome){ //Envia a mensagem de boas vindas ao entrar no sistema e altera de acordo com o horario local
        SimpleDateFormat hour = new SimpleDateFormat("HH");
	    Date date = new Date();
	    int Horas = Integer.parseInt(hour.format(date));        
        if(Horas>=06 && Horas<=11){
            return ("Bom dia "+ nome + "! Você se logou ao nosso sistema! \n");
        }else if(Horas>=12 && Horas<=17 ){
            return ("Boa tarde "+ nome + "! Você se logou ao nosso sistema! \n");
        }else if(Horas>=18){
            return ("Boa noite "+ nome + "! Você se logou ao nosso sistema! \n");
        }else{
            return ("Boa madrugada "+ nome + "! Você se logou ao nosso sistema! \n");
        }
    }

}
