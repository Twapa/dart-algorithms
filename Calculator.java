//importing built in awt packages

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Creating the main class
public class Calculator extends Frame implements ActionListener,WindowListener {

    //Variable declaration and object instatiation
    private TextField textfield;
    Button button[];
    Button addition, subtraction, multiplication, division, Equals, clear,squared;
    double number1,number2,result;
    char Operator;



    //Constructor to setup GUI components
    public Calculator() {


        //windowListener
        addWindowListener(this);
        //Frame specifications

        setSize(400, 500);
        setVisible(true);

        //Font object
        Font font = new Font("cambria", Font.BOLD, 18);
        Font font2 = new Font("cambria", Font.BOLD, 22);







        //a Panel that will hold the textField

        Panel panelDisplay = new Panel(new FlowLayout());
        textfield = new TextField(20);
        textfield.setPreferredSize(new Dimension(1,100));
        textfield.setEditable(false);
        textfield.setFont(font2);
        panelDisplay.add(textfield);


        //Panel that will hold buttons
        Panel panelButtons = new Panel(new GridLayout(4,4,4,4));
        Panel pane = new Panel(new GridLayout(1,2,1,1));




        //Button instatiation
        //first row of the panel containing buttons
        button = new Button[11];
        button[0] = new Button("7");// a 7
        panelButtons.add(button[0]);
        button[1] = new Button("8");// an 8
        panelButtons.add(button[1]);
        button[2] = new Button("9");
        panelButtons.add(button[2]);
        multiplication = new Button("X");
        panelButtons.add(multiplication);

        //second row
        button[3] = new Button("4");
        panelButtons.add(button[3]);
        button[4] = new Button("5");
        panelButtons.add(button[4]);
        button[5] = new Button("6");
        panelButtons.add(button[5]);
        subtraction = new Button("-");
        panelButtons.add(subtraction);

        //third row
        button[6] = new Button("1");
        panelButtons.add(button[6]);
        button[7] = new Button("2");
        panelButtons.add(button[7]);
        button[8] = new Button("3");
        panelButtons.add(button[8]);
        addition = new Button("+");
        panelButtons.add(addition);

        //fourth row

        clear = new Button("C");
        panelButtons.add(clear);

        button[9] = new Button("0");
        panelButtons.add(button[9]);

        squared = new Button("");
        panelButtons.add(squared);

        division = new Button("/");
        panelButtons.add(division);





        //Final row containing an equal sign only
        Equals = new Button("=");
        pane.add(Equals);
        pane.setPreferredSize(new Dimension(10,50));

        // set fonts of addition,clear,subtraction,division,Equals and multiplication buttons
        addition.setFont(font);
        subtraction.setFont(font);
        division.setFont(font);
        Equals.setFont(font);
        clear.setFont(font);
        multiplication.setFont(font);
        squared.setFont(font);



        //Adds action listener to buttons and sets fonts for each button b
        textfield.addActionListener(this);
        for (int i = 0; i < 10; i++) {
            button[i].addActionListener(this);
            button[i].setFont(font);
        }

        //adding buttons to listen to the action,setting Fonts for operators and a
        addition.addActionListener(this);

        subtraction.addActionListener(this);
        multiplication.addActionListener(this);
        division.addActionListener(this);
        Equals.addActionListener(this);
        Equals.setBackground(Color.gray);//setting Background colour
        clear.addActionListener(this);
        squared.addActionListener(this);




        // sets panels  to BorderLayout, thus north,south and center
        setLayout(new BorderLayout());
        add(pane , BorderLayout.SOUTH);
        add(panelDisplay, BorderLayout.NORTH);
        add(panelButtons, BorderLayout.CENTER);
        setVisible(true);
    }


    // a method that has actions to be performed
    public void actionPerformed(ActionEvent e)
    {

        String str= e.getActionCommand();//grub string from textField
        char ch=str.charAt(0);//we grub character from string

        if ( Character.isDigit(ch)) {//and check if digit
            textfield.setText(textfield.getText() + str );

        }  //otherwise we check if its operator is operator
        else if(str.equals("+")){
            number1=Double.parseDouble(textfield.getText());
            Operator='+';
            textfield.setText("");
        }
        else if(str.equals("-")){
            number1=Double.parseDouble(textfield.getText());
            Operator='-';
            textfield.setText("");
        }
        else if(str.equals("X")){
            number1=Double.parseDouble(textfield.getText());
            Operator='*';
            textfield.setText("");
        } else if(str.equals("/")){

            number1=Double.parseDouble(textfield.getText());
            Operator='/';
            textfield.setText("");
        }else if(str.equals("C")){
            textfield.setText("");
            //number1 = number2=0;
        }
        else if(str.equals("sq")){
            textfield.setText("");
        }


        // grubs equals sign from textField
        if (str.equals("=")) {
            number2 = Double.parseDouble(textfield.getText());
                if (Operator == '+')// adds numbers
                    result = number1 + number2;
                else if (Operator == '-')//subtracts numbers
                    result = number1 - number2;
                else if (Operator == '*')//multiplies numbers
                    result = number1 * number2;
                else if (Operator == '/')//divides numbers
                    result = number1 / number2;
                textfield.setText(" " + result);

            }

        }


//The seven autogenerated abstract WindowListener Methods
    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
    System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
    //main method
    public static void main (String arg[])
    {
        new Calculator();
    }
}
