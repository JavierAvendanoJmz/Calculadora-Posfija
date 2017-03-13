/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.ListaVaciaException;
import Modelo.*;

/**
 *
 * @author j4v13
 */
public class Controlador {
    
    private Pila <Integer>p;
    private Cola <String>q;
    
    private char decode(int i) {
        char c = 0;
        if(i == 6)
            c = '^';
        else if(i == 5)
            c = '/';
        else if(i == 4)
            c = '*';
        else if(i == 3)
            c = '-';
        else if(i == 2)
            c = '+';
        else if(i == 0)
            c = '(';
        else if(i == 10)
            c = ')';
        return c;
    }
    
    private int code(char c) {
        int i = -1;
        if(c == '^')
            i = 6;
        else if(c == '/')
            i = 5;
        else if(c == '*')
            i = 4;
        else if(c == '-')
            i = 3;
        else if(c == '+')
            i = 2;
        else if(c == '(')
            i = 0;
        else if(c == ')')
            i = 10;
        return i;
    }
    
    private void postfija(String expresion) throws ListaVaciaException{
        for (int i = 0; i < expresion.length(); i++) { 
            if(expresion.charAt(i) < '0' || expresion.charAt(i) > '9') {
                if(expresion.charAt(i)=='-' && (i == 0 || ((expresion.charAt(i-1) < '0' || expresion.charAt(i-1) > '9') && expresion.charAt(i-1)!=')'))
                    && (i+1 < expresion.length() && expresion.charAt(i+1) >= '0' && expresion.charAt(i+1) <= '9')){
                    String aux = "-";
                    i++;
                    while(i < expresion.length() && (expresion.charAt(i) >= '0' && expresion.charAt(i) <= '9')) {
                        aux += "" + expresion.charAt(i);
                        i++;
                    }
                    i--;
                    q.pushBack(aux);
                }else if(expresion.charAt(i)=='-' && (i+1 < expresion.length() && expresion.charAt(i+1) == '(')) {
                    String exp = expresion.substring(0, i);                        
                    exp += "-1*";
                    exp += expresion.substring(i+1, expresion.length());
                    expresion = exp;
                    i--;
//                    System.out.println(expresion);
                } else {
                    int operacion = code(expresion.charAt(i));
                    if(p.top(true)==null){
                        p.push(operacion);
                    } else if((p.top()/2) < (operacion/2)){
                        if(operacion!=10) {
                            p.push(operacion);
                        }
                        else {
                            while(p.top() != 0) {
                                q.pushBack(""+decode(p.top()));
                                p.pop();
                            }
                            p.pop();
                        }
                    } else {
                        if(operacion == 0) {
                            p.push(operacion);
                        } else {
                            while(!p.isEmpty() && (operacion/2) <= (p.top()/2)) {
                                q.pushBack(""+decode(p.top()));
                                p.pop();
                            }
                            p.push(operacion);
                        }
                    }
                }
            } else {
                String aux = new String();                
                while(i < expresion.length() && (expresion.charAt(i) >= '0' && expresion.charAt(i) <= '9')) {
                    aux += "" + expresion.charAt(i);
                    i++;
                }
                if(!aux.equals("")){
                    i--;
                    q.pushBack(aux);
                }
            }            
        }
        while(!p.isEmpty()) {
            q.pushBack(""+decode(p.top()));
            p.pop();
        }
        p = new Pila<Integer>();
    }
    
    private Double operar(Double n1, char c, Double n2) {
        if(c=='^')
            return Math.pow(n1, n2);
        else if(c == '/')
            return n1/n2;
        else if(c== '*')
            return n1*n2;
        else if(c== '-')
            return n1-n2;
        else
            return n1+n2;
    }
    
    private String resolver() throws ListaVaciaException {
        
        try {
            Pila<String> resultado = new Pila<String>();
            String s = new String();
            while(!q.isEmpty()) {
                if(q.front().length()>1 || (q.front().charAt(0) >= '0' && q.front().charAt(0) <= '9')){
                    resultado.push(q.front());             
                    q.pop();
                } else {
                    char signo = q.front().charAt(0);
                    q.pop();
                    Double n2 = Double.parseDouble(resultado.top());
                    resultado.pop();
                    Double n1 = Double.parseDouble(resultado.top());
                    resultado.pop();
                    Double r = operar(n1,signo,n2);
                    resultado.push(""+r);
                }
            }
            return resultado.toString();
        } catch (Exception ex) { 
            return "syntax error";
        }
    }
    
    public String resolver(String expresion) throws ListaVaciaException {
        postfija(expresion);
//        System.out.println(q);
        String s = resolver();
        p = new Pila<Integer>();
        q = new Cola<String>();
        return s; 
    }

    public Controlador(){
        p = new Pila<Integer>();
        q = new Cola<String>();
    }        
}