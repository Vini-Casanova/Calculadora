import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela implements ActionListener{

  JFrame frame = new JFrame("Calculadora");
  JTextField areaTexto = new JTextField();
  ImageIcon image = new ImageIcon("./imgs/calculator.png");
  JButton[] numBotoes = new JButton[10];
  JButton[] funcBotoes = new JButton[6];
  JButton soma,subtracao,multiplicacao,divisao,delete,igual;
  JPanel panel;

  double numero1=0;
  double numero2=0;
  double result =0;

  char operador;

  public Tela() {

    areaTexto.setBounds(50,35,300,50);
    areaTexto.setFont(new Font("Arial", Font.BOLD,30));

    soma =new JButton("+");
    subtracao =new JButton("-");
    multiplicacao =new JButton("*");
    divisao =new JButton("/");
    delete =new JButton("Del");
    igual =new JButton("=");

    funcBotoes[0] = soma;
    funcBotoes[1] = subtracao;
    funcBotoes[2] = multiplicacao;
    funcBotoes[3] = divisao;
    funcBotoes[4] = delete;
    funcBotoes[5] = igual;

    for(int i=0;i<6;i++){
      funcBotoes[i].addActionListener(this);
      funcBotoes[i].setForeground(Color.white);
      funcBotoes[i].setBackground(Color.DARK_GRAY);
      funcBotoes[i].setFont(new Font("Arial", Font.BOLD,30));
      funcBotoes[i].setFocusable(false);
    }

    for (int i=0;i<10;i++){
      numBotoes[i] = new JButton(String.format("%s",i));
      numBotoes[i].setForeground(Color.white);
      numBotoes[i].setBackground(Color.DARK_GRAY);
      numBotoes[i].addActionListener(this);
      numBotoes[i].setFont(new Font("Arial", Font.BOLD,30));
      numBotoes[i].setFocusable(false);
    }

    panel = new JPanel();
    panel.setBounds(25,100,350,350);
    panel.setLayout(new GridLayout(4,4));

    for (int i = 1; i <  10; i++) {
      panel.add(numBotoes[i]);
      if(i==3){
        panel.add(soma);
      }else if(i==6){
        panel.add(subtracao);
      }
    }
    panel.add(multiplicacao);
    panel.add(divisao);
    panel.add(igual);
    panel.add(delete);

    frame.add(panel);
    frame.add(areaTexto);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setIconImage(image.getImage());
    frame.setSize(420,600);
    frame.setLayout(null);
    frame.setResizable(false);
    frame.setVisible(true);
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    for (int i = 0; i <10; i++) {
      if(e.getSource()==numBotoes[i]){
        areaTexto.setText(areaTexto.getText().concat(String.valueOf(i)));
      }
    }
		if(e.getSource()==soma) {
			numero1 = Double.parseDouble(areaTexto.getText());
			operador ='+';
			areaTexto.setText("");
		}
		if(e.getSource()==subtracao) {
			numero1 = Double.parseDouble(areaTexto.getText());
			operador ='-';
			areaTexto.setText("");
		}
		if(e.getSource()==multiplicacao) {
			numero1 = Double.parseDouble(areaTexto.getText());
			operador ='*';
			areaTexto.setText("");
		}
		if(e.getSource()==divisao) {
			numero1 = Double.parseDouble(areaTexto.getText());
			operador ='/';
			areaTexto.setText("");
		}
		if(e.getSource()==igual) {
			numero2=Double.parseDouble(areaTexto.getText());

			switch(operador) {
			case'+':
				result=numero1+numero2;
				break;
			case'-':
				result=numero1-numero2;
				break;
			case'*':
				result=numero1*numero2;
				break;
			case'/':
				result=numero1/numero2;
				break;
			}
			areaTexto.setText(String.valueOf(result));
			numero1=result;
		}
		if(e.getSource()==delete) {
			String string = areaTexto.getText();
			areaTexto.setText("");
			for(int i=0;i<string.length()-1;i++) {
				areaTexto.setText(areaTexto.getText()+string.charAt(i));
			}
		}
  }
}
