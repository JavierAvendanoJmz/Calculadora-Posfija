/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Excepciones.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j4v13
 */
public class Pila<T> {
    
    private Lista<T> lista;
    private int tope;
    
    public boolean isEmpty() {
        return lista.getInicio()==null;
    }
    
    public void pop() throws ListaVaciaException {  
            lista.pop();   
    }        
    
    public T top() {
        return lista.getInicio().getDato();
    }
    
    public Nodo<T> top(Boolean b) {
        return lista.getInicio();
    }
    
    public void push(T t) {
        if (tope == 0 || lista.getSize() < tope) {
            Nodo n = new Nodo(t);
            lista.agregarAtras(n);
        }
    }
    
    public void push(Nodo<T> n) {
        if (tope == 0 || lista.getSize() < tope) {
            lista.agregarAtras(n);
        }
    }
    
    @Override
    public String toString() {
        return lista.toString();
    }

    public Pila(int tope) throws TopeInvalidoException {
        if (tope < 1) throw new TopeInvalidoException();
        this.tope = tope;
        lista = new Lista<T>();
    }

    public Pila() {
        this.tope = 0;
        lista = new Lista<T>();        
    }
    
}
