import java.io.Console;

public class App{
    public static void main(String[] args) throws Exception {
        Console console = System.console();
        new Tela();

        boolean loop = true;
        do{
            System.out.println("Escolha a operação que deseja realizar: \n 1- Soma \n 2- Subtração \n 3- Multiplicação \n 4- Divisão \n 5- Sair do programa ");
            int escolha =  Integer.parseInt(console.readLine("Digite aqui: "));
            new Calculations(escolha);
            if(escolha == 5){
                loop = false;
            }
            System.out.println("=============================================================");


        }while(loop != false);

    }

}
