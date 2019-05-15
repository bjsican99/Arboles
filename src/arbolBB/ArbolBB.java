/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;

import java.util.LinkedList;
import javax.swing.JPanel;

/**
 *
 * @author .
 */

public class ArbolBB {

    private Nodo raiz;
    int num_nodos;
    int alt;

    public ArbolBB() {
        raiz = null;
    }
    
    public boolean agregar(int dato) {
        Nodo nuevo = new Nodo(dato, null, null);
        insertar(nuevo, raiz);
        return true;
    }
    
    //Metodo para insertar un dato en el arbol...no acepta repetidos :)
    public void insertar(Nodo nuevo, Nodo pivote) {
        if (this.raiz == null) {//si no hay nada en la raiz, el nuevo dato pasa a ser la raiz
            raiz = nuevo;
        } else {//compra el nodo con un pivote, si es menor
            if (nuevo.getDato() <= pivote.getDato()) {
                if (pivote.getIzq() == null) {//y si el lado izquierdo esta vacio
                    pivote.setIzq(nuevo);//el sub arbol izquierdo tendra el nodo
                } else {//de lo contrario
                    insertar(nuevo, pivote.getIzq());//se usa la recursividad con el nodo nuevo, y el pivote
                }
            } else {//de lo contrario si es mayou
                if (pivote.getDer() == null) {//y si el sub arbol derecho vacio
                    pivote.setDer(nuevo);//se inserta en el sub arbol derecho
                } else {//de lo contrario usa la recursividad para 
                    insertar(nuevo, pivote.getDer());
                }
            }
        }

    }

    public Nodo getRaiz() {//obtienes la raiz del nodo
        return raiz;
    }

    public void setRaiz(Nodo raiz) {//asigna al nodo raiz
        this.raiz = raiz;
    }

    //Recorrido preorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList preOrden() {
        LinkedList rec = new LinkedList();
        preorden(raiz, rec);
        return rec;
    }
    
    //Metodo para recorrer el arbor postorden
    //Verifica si el nodo auxiliar no esta apuntando null
    //añade el nodo auxiliar a la lista
    //obtiene el nodo del lado izquierdo y lo añade
    //obtiene el nodo del lado derecho y lo añade
    public void preorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            recorrido.add(aux.getDato());
            preorden(aux.getIzq(), recorrido);
            preorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido inorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList inOrden() {
        LinkedList rec = new LinkedList();
        inorden(raiz, rec);
        return rec;
    }
    //Metodo para recorrer el arbor inorden
    //Verifica si el nodo auxiliar no esta apuntando null
    //llama a la funcion inorden, con el nodo auxliar de lado izuierdo con una lista para obtener irlos almacenandolos
    //obtiene el dato auxiliar
    //añade la raiz a la lista.
    //recorre el subarbol derecho, y lo guarda en recorrido
    public void inorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            inorden(aux.getIzq(), recorrido);
            recorrido.add(aux.getDato());
            inorden(aux.getDer(), recorrido);
        }
    }

    //Recorrido postorden, recibe el nodo a empezar (raiz) y una linkedlist para ir guardando el recorrido
    public LinkedList postOrden() {
        LinkedList rec = new LinkedList();
        postorden(raiz, rec);
        return rec;
    }
    
    //Metodo para recorrer el arbor postorden
    //Verifica si el nodo auxiliar no esta apuntando null
    //obtiene el ultimo nodo del lado izquierdo
    //obtiene el nodo del sub arbol derecho
    //se añade a la lista el nodo auxiliar
    public void postorden(Nodo aux, LinkedList recorrido) {
        if (aux != null) {
            postorden(aux.getIzq(), recorrido);
            postorden(aux.getDer(), recorrido);
            recorrido.add(aux.getDato());
        }
    }

    //Metodo para verificar si hay un nodo en el arbol
    //crea un nodo que sera la raiz
    //con un ciclo media vez el auxiliar no sea null se repite
    //si el dato ingresado es el mismo que el dato existente, retorna true
    //si el dato es mayor al dato, aux sera igual al nodo de la rama derecha
    //de lo contrario sera igual al nodo de la rama izquierda
    //de lo contrario retorna false
    public boolean existe(int dato) {
        Nodo aux = raiz;
        while (aux != null) {
            if (dato == aux.getDato()) {
                return true;
            } else if (dato > aux.getDato()) {
                aux = aux.getDer();
            } else {
                aux = aux.getIzq();
            }
        }
        return false;
    }

    
    /*
    obtiene un nivel y una variable entera
    si esta el aux no esta apuntando a null
    altura sera igual al nodo del lado izquierdo, y el nivel se le sumara uno
    altura sera igual a nivel
    algura se volvera a llamar del lado derecho y se le sumara uno al nivel
    */
    private void altura(Nodo aux, int nivel) {
        if (aux != null) {
            altura(aux.getIzq(), nivel + 1);
            alt = nivel;
            altura(aux.getDer(), nivel + 1);
        }
    }

    //Devuleve la altura del arbol
    public int getAltura() {
        altura(raiz, 1);
        return alt;
    }
    
    //retorna el nuevo arbol de forma grafica
    public JPanel getdibujo() {
        return new ArbolExpresionGrafico(this);
    }
}
