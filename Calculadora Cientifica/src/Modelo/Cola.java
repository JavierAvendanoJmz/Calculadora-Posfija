/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Excepciones.ListaVaciaException;
import Excepciones.TopeInvalidoException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author j4v13
 */
public class Cola<T> {
    
    private Lista<T> lista;
    private int tope;
    
    public boolean isEmpty() {
        return lista.getInicio()==null;
    }
    
    public void pop() throws ListaVaciaException {  
        lista.pop();   
    }
    
    public T front() {
        return lista.getInicio().getDato();
    }
    
    public Nodo<T> front(Boolean b) {
        return lista.getInicio();
    }
    
    public void pushBack(T t) {
        if (tope == 0 || lista.getSize() < tope) {
            Nodo n = new Nodo(t);
            lista.agregarAdelante(n);
        }
    }
    
    public void pushBack(Nodo<T> n) {
        if (tope == 0 || lista.getSize() < tope) {
            lista.agregarAdelante(n);
        }
    }

    @Override
    public String toString() {
        return lista.toString();
    }

    public Cola(int tope) throws TopeInvalidoException {
        if (tope < 1) throw new TopeInvalidoException();
        this.tope = tope;
        lista = new Lista<T>();
    }

    public Cola() {
        this.tope = 0;
        lista = new Lista<T>();        
    }
}
