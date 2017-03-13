/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Excepciones.ListaVaciaException;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author j4v13
 */
public class CalculadoraForm extends JFrame {
    
    private JTextField txtExpresion;
    private JTextField txtResultado;
    private Controlador controlador;
    
    public CalculadoraForm() {
        super("Calculadora científica");
        super.setSize(220, 300);
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        controlador = new Controlador();
        JPanel pnlAux = new JPanel();
        pnlAux.setLayout(new BoxLayout(pnlAux, BoxLayout.PAGE_AXIS));
        txtExpresion = new JTextField();
        txtResultado = new JTextField();
        txtExpresion.setEditable(false);
        txtResultado.setEditable(false);
        pnlAux.add(txtExpresion);
        pnlAux.add(txtResultado);
        super.add(pnlAux, BorderLayout.NORTH);
        super.add(pnlBotones(), BorderLayout.CENTER);
        super.setVisible(true);
    }
    
     private JPanel pnlBotones() {
        JPanel pnlBotones = new JPanel();
        pnlBotones.setLayout(new GridLayout(5,4));
        JButton btnAC = new JButton("AC");
        JButton btnOp = new JButton("(");
        JButton btnCl = new JButton(")");
        JButton btnCircun = new JButton("^");
        JButton btnEntre = new JButton("/");
        JButton btnPor = new JButton("*");
        JButton btnMas = new JButton("+");
        JButton btnMenos = new JButton("-");
        JButton btnIgual = new JButton("=");
        JButton btn9 = new JButton("9");
        JButton btn8 = new JButton("8");
        JButton btn7 = new JButton("7");     
        JButton btn6 = new JButton("6");
        JButton btn5 = new JButton("5");
        JButton btn4 = new JButton("4");        
        JButton btn3 = new JButton("3");        
        JButton btn2 = new JButton("2");
        JButton btn1 = new JButton("1");
        JButton btn0 = new JButton("0");   
        JButton btnDel = new JButton("<");
        btnAC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText("");
            }
        });        
        btnOp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"(");
            }
        });        
        btnCl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+")");
            }
        });        
        btnCircun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"^");
            }
        });        
        btnEntre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"/");
            }
        });
        btnPor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"*");
            }
        });        
        btnMas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"+");
            }
        });        
        btnMenos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"-");
            }
        });
        btnIgual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    txtResultado.setText(controlador.resolver(txtExpresion.getText()));
                } catch (ListaVaciaException ex) {
                    Logger.getLogger(CalculadoraForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"9");
            }
        });
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"8");
            }
        });
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"7");
            }
        });
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"6");
            }
        });
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"5");
            }
        });
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"4");
            }
        });
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"3");
            }
        });
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"2");
            }
        });
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"1");
            }
        });
        btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                txtExpresion.setText(txtExpresion.getText()+"0");
            }
        });
        btnDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    txtExpresion.setText(txtExpresion.getText().substring
                    (0, txtExpresion.getText().length()-1));
                } catch (Exception ex) {
                    
                }
            }
        });
        pnlBotones.add(btnAC);
        pnlBotones.add(btnOp);
        pnlBotones.add(btnCl);
        pnlBotones.add(btnCircun);
        pnlBotones.add(btn7);
        pnlBotones.add(btn8);
        pnlBotones.add(btn9);
        pnlBotones.add(btnEntre);
        pnlBotones.add(btn4);
        pnlBotones.add(btn5);
        pnlBotones.add(btn6);
        pnlBotones.add(btnPor);
        pnlBotones.add(btn1);
        pnlBotones.add(btn2);
        pnlBotones.add(btn3);
        pnlBotones.add(btnMenos);
        pnlBotones.add(btn0);
        pnlBotones.add(btnDel);
        pnlBotones.add(btnIgual);
        pnlBotones.add(btnMas);
        return pnlBotones;
    }
}
