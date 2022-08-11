import java.io.Console;

public class Calculations {
  Console console = System.console();

  public Calculations(int opcao) {
    float num1 = Float.parseFloat(console.readLine("Escolha o primeiro numero da operação: "));
    System.out.println();
    float num2 = Float.parseFloat(console.readLine("Escolha o segundo numero da operação: "));
    System.out.println();
    switch (opcao) {
      case 1:
        String soma = "Soma igual a: %s + %s = ".formatted(num1, num2)+(num1+num2);
        System.out.println(soma);
        break;

      case 2:
        String sub = "Subtração igual a: %s - %s = ".formatted(num1, num2)+(num1-num2);
        System.out.println(sub);
        break;

      case 3:
        String mult = "Multiplicação igual a: %s * %s = ".formatted(num1, num2)+(num1*num2);
        System.out.println(mult);
        break;

      case 4:
        String div = "Divisão igual a: %s / %s = ".formatted(num1, num2)+(num1/num2);
        System.out.println(div);
        break;

      case 5:
        System.out.println("Programa sendo finalizado, obrigado por usar");
        break;
    }

  }
}
