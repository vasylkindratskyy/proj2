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

// String representation of node
    public String toString() {
        String tempString = "";
        if (this.coefficient != 0) {
            tempString += "+";

            if (this.coefficient != 1 || this.exponent == 0) {
                tempString += Integer.toString(this.coefficient);
            }
            if (this.exponent > 0) {
                tempString += "x";
            }
            if (this.exponent != 1) {
                tempString += "^" + Integer.toString(this.exponent);
            }
        }
        return tempString;
    }
}