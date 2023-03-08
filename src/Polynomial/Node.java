package Polynomial;

public class Node {
//  Initialize Variables-------------------------------------------------
    private int exponent;
    int coefficient;
    private Node node;

//  Constructors---------------------------------------------------------
    public Node(int exponent, int coefficient){
        this.exponent = exponent;
        this.coefficient = coefficient;
        this.node = null;
    }

    public Node(int exponent, int coefficient, Node node){
        this.exponent = exponent;
        this.coefficient = coefficient;
        this.node = node;
    }
// Setters-----------------------------------------------------------
    public void setExponent (int exponent){this.exponent = exponent;}

    public void setCoefficient (int coefficient){this.coefficient = coefficient;}

    public void setNode (Node node){this.node = node;}

// Getters-----------------------------------------------------------
    public int getExponent (){return this.exponent;}

    public int getCoefficient (){return this.coefficient;}

    public Node getNode (){return this.node;}
}
