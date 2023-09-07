//this is simple Calculator and developed in java language by Naresh Saini.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener, KeyListener{
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[14];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton, perButton,recproButton,sqrButton,cubButton,rootButton;
	JPanel panel;
	
	Font myFont = new Font("Arial",Font.PLAIN,15);
	double num1 =0, num2=0, result =0;
	char operator;
	
	
	Calculator(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,450);
		frame.setLayout(null);
		
		
		textfield = new JTextField();
		textfield.setBounds(20,20,245,40);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		textfield.addKeyListener(this);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("del");
		clrButton = new JButton("C");
		negButton = new JButton("+/-");
		perButton = new JButton("%");
		recproButton = new JButton("1/x");
		rootButton = new JButton("\u221A");
		sqrButton = new JButton("x\u00B2");
		cubButton = new JButton("x\u00B3");
		
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		functionButtons[9] = perButton;
		functionButtons[10] = recproButton;
		functionButtons[11] = cubButton;
		functionButtons[12] = sqrButton;
		functionButtons[13] = rootButton;
		
		for(int i=0; i<14;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		for(int i=0; i<10;i++) {
			numberButtons[i]= new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);

		}
				
		panel = new JPanel();
		panel.setBounds(20,80,245,310);
		panel.setLayout(new GridLayout(6,4,5,5));
		
		panel.add(recproButton);
		panel.add(perButton);
		panel.add(clrButton);
		panel.add(delButton);
		
		panel.add(rootButton);
		panel.add(sqrButton);
		panel.add(cubButton);
		panel.add(divButton);
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		
		panel.add(negButton);
		panel.add(numberButtons[0]);
		panel.add(decButton);
		panel.add(equButton);
		
		frame.add(panel);
		frame.add(textfield);		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource()==perButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '%';
			textfield.setText("");
		}
		
		if(e.getSource()==equButton) {
			num2= Double.parseDouble(textfield.getText());
			switch(operator) {
			case '+':
				result = num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '/':
				result = num1/num2;
				break;
			case '%':
				result = num2 * (num1/100);
				break;
			}
			textfield.setText(String.valueOf(result));
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i =0; i< string.length()-1;i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
			
		}
		if(e.getSource()==recproButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp = 1/temp;
			textfield.setText(String.valueOf(temp));
			
		}
		if(e.getSource()==sqrButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp = temp*temp;
			textfield.setText(String.valueOf(temp));
			
		}
		if(e.getSource()==cubButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp = temp*temp*temp;
			textfield.setText(String.valueOf(temp));
			
		}
		if(e.getSource()==rootButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp = Math.sqrt(temp);
			textfield.setText(String.valueOf(temp));
			
		}
		
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char keyChar = e.getKeyChar();
		if(Character.isDigit(keyChar)) {
			textfield.setText(textfield.getText() + keyChar);
			
		}else if(keyChar == '.') {
			textfield.setText(textfield.getText() + ".");
		}else if(keyChar == '+' || keyChar == '-' || keyChar == '*' || keyChar == '/'|| keyChar == '%') {
			num1 = Double.parseDouble(textfield.getText());
			operator = keyChar;
			textfield.setText("");
		}
		
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		 int keyCode = e.getKeyCode();
		    if (keyCode == KeyEvent.VK_BACK_SPACE) {
		        String currentText = textfield.getText();
		        if (!currentText.isEmpty()) {
		            textfield.setText(currentText.substring(0, currentText.length() - 1));
		        }
		        // Consume the Backspace key event to prevent the default sound
		        e.consume();
		    }
		    else if(keyCode == KeyEvent.VK_ENTER) {
				num2= Double.parseDouble(textfield.getText());
				switch(operator) {
				case '+':
					result = num1+num2;
					break;
				case '-':
					result = num1-num2;
					break;
				case '*':
					result = num1*num2;
					break;
				case '/':
					result = num1/num2;
					break;
				case '%':
					result = num2 * (num1/100);
					break;
				}
				textfield.setText(String.valueOf(result));
			}	
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
