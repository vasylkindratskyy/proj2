package Polynomial;

public class Node {
//  Initialize Variables-------------------------------------------------
    private int exponent;
    int coefficient;
    private Node nextNode;

//  Constructors---------------------------------------------------------
    public Node(int exponent, int coefficient){
        this.exponent = exponent;
        this.coefficient = coefficient;
        this.nextNode = null;
    }

    public Node(int exponent, int coefficient, Node nextNode){
        this.exponent = exponent;
        this.coefficient = coefficient;
        this.nextNode = nextNode;
    }
// Setters-----------------------------------------------------------
    public void setExponent (int exponent){this.exponent = exponent;}

    public void setCoefficient (int coefficient){this.coefficient = coefficient;}

    public void setNextNode (Node nextNode){this.nextNode = nextNode;}

// Getters-----------------------------------------------------------
    public int getExponent (){return this.exponent;}

    public int getCoefficient (){return this.coefficient;}

    public Node getNextNode (){return this.nextNode;}
}
