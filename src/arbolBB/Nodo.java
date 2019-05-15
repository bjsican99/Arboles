/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolBB;

/**crea la estructura de los datos
 * un dato privado tipo entero
 * nodo izquierdo y derecho
 * asigna los valores obtenidos con lo de las estructuras
 * @author
 */
public class Nodo {
    private int dato;
    private Nodo izq,der;

    public Nodo(int dato, Nodo izq, Nodo der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    /*
    los get debuelven el valor que contiene la estructura
    y los set establecen los datos a la estructura, creando un nuevo nodo
    */
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
 
}
