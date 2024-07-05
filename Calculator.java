import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    // Components of the calculator
    TextField tf;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    Button bAdd, bSub, bMul, bDiv, bClr, bEq;
    char operator;
    double num1, num2, result;

    // Constructor to set up components
    Calculator() {
        // Frame settings
        setTitle("AWT Calculator");
        setSize(300, 400);
        setLayout(null);

        // Text field
        tf = new TextField();
        tf.setBounds(50, 50, 200, 50);
        add(tf);

        // Number buttons
        b0 = new Button("0");
        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        
        b0.setBounds(50, 250, 50, 50);
        b1.setBounds(50, 150, 50, 50);
        b2.setBounds(110, 150, 50, 50);
        b3.setBounds(170, 150, 50, 50);
        b4.setBounds(50, 200, 50, 50);
        b5.setBounds(110, 200, 50, 50);
        b6.setBounds(170, 200, 50, 50);
        b7.setBounds(50, 100, 50, 50);
        b8.setBounds(110, 100, 50, 50);
        b9.setBounds(170, 100, 50, 50);

        add(b0);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);

        // Operator buttons
        bAdd = new Button("+");
        bSub = new Button("-");
        bMul = new Button("*");
        bDiv = new Button("/");
        bEq = new Button("=");
        bClr = new Button("C");

        bAdd.setBounds(230, 100, 50, 50);
        bSub.setBounds(230, 150, 50, 50);
        bMul.setBounds(230, 200, 50, 50);
        bDiv.setBounds(230, 250, 50, 50);
        bEq.setBounds(110, 250, 50, 50);
        bClr.setBounds(170, 250, 50, 50);

        add(bAdd);
        add(bSub);
        add(bMul);
        add(bDiv);
        add(bEq);
        add(bClr);

        // Action listeners
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        bAdd.addActionListener(this);
        bSub.addActionListener(this);
        bMul.addActionListener(this);
        bDiv.addActionListener(this);
        bEq.addActionListener(this);
        bClr.addActionListener(this);

        // Window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    // ActionListener implementation
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        // If the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!tf.getText().equals(""))
                tf.setText(tf.getText() + s);
            else
                tf.setText(s);
        } 
        else if (s.charAt(0) == 'C') {
            tf.setText("");
        } 
        else if (s.charAt(0) == '=') {
            num2 = Double.parseDouble(tf.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    try {
                        if (num2 == 0)
                            throw new ArithmeticException("Cannot divide by zero");
                        result = num1 / num2;
                    } catch (ArithmeticException ex) {
                        tf.setText("Error");
                        return;
                    }
                    break;
            }

            tf.setText(String.valueOf(result));
        } 
        else {
            if (!tf.getText().equals(""))
                num1 = Double.parseDouble(tf.getText());

            operator = s.charAt(0);
            tf.setText("");
        }
    }

    // Main method
    public static void main(String[] args) {
        new Calculator();
    }
}
