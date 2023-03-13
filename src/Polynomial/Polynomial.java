package Polynomial;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Polynomial {
    private Node headNode;

    public Polynomial(){
        headNode = null;
    }

    public Polynomial(String poly){
       headNode = null;
       Scanner scanner = new Scanner(poly).useDelimiter("(?=[+-])");
       while (scanner.hasNext()) {
           String tempString = scanner.next();
           int exponent;
           int coefficient;
           if (tempString.contains("x")) {
               if (tempString.contains("^")) {
                   String[] parts = tempString.split("x\\^");
                   coefficient = Integer.parseInt(parts[0]);
                   exponent = Integer.parseInt(parts[1]);
               } else {
                   coefficient = Integer.parseInt(tempString.replace("x",  ""));
                   exponent = 1;
               }
           } else {
               coefficient = Integer.parseInt(tempString);
               exponent = 0;
           }
           Node tempNode = new Node(exponent,coefficient);
           if (headNode == null) {
               headNode = tempNode;
           } else {
               Node currentNode = headNode;
               Node previousNode = null;
               while (currentNode != null && currentNode.getExponent() > tempNode.getExponent()) {
                   previousNode = currentNode;
                   currentNode = currentNode.getNextNode();
               }
               if (currentNode != null && currentNode.getExponent() == exponent) {
                   currentNode.coefficient += coefficient;
               } else {
                   tempNode.setNextNode(currentNode);
                   if (previousNode != null) {
                       previousNode.setNextNode(tempNode);
                   } else {
                       headNode = tempNode;
                   }
               }
           }
       }
    }

    public Polynomial(Polynomial otherPoly) {
        headNode = null;
        Node currentNode = otherPoly.headNode;
        while (currentNode != null) {
            Node tempNode = new Node(currentNode.getExponent(), currentNode.getCoefficient());
            if (headNode == null) {
                headNode = tempNode;
            } else {
                Node lastNode = headNode;
                while (lastNode.getNextNode() != null) {
                    lastNode = lastNode.getNextNode();
                }
                lastNode.setNextNode(tempNode);
            }
            currentNode = currentNode.getNextNode();
        }
    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        Node currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.getCoefficient() != 0) {
                if (currentNode.getExponent() == 0) {
                    stringBuilder.append(currentNode.getCoefficient());
                } else if (currentNode.getExponent() == 1) {
                    if (currentNode.getCoefficient() == 1) {
                        stringBuilder.append("x");
                    } else if (currentNode.getCoefficient() == -1) {
                        stringBuilder.append("-x");
                    } else {
                        stringBuilder.append(currentNode.getCoefficient()).append("x");
                    }
                } else {
                    if (currentNode.getCoefficient() == 1) {
                        stringBuilder.append("x^").append(currentNode.getExponent());
                    } else if (currentNode.getCoefficient() == -1) {
                        stringBuilder.append("-x^").append(currentNode.getExponent());
                    } else {
                        stringBuilder.append(currentNode.getCoefficient()).append("x^").append(currentNode.getExponent());
                    }
                }
                if (currentNode.getNextNode() != null && currentNode.getNextNode().getCoefficient() > 0) {
                    stringBuilder.append("+");
                }
            }
            currentNode = currentNode.getNextNode();
        }
        System.out.println(stringBuilder.toString());
    }
    public static Polynomial add(Polynomial poly1, Polynomial poly2) {
        Node current1 = poly1.headNode;
        Node current2 = poly2.headNode;
        Polynomial result = new Polynomial();
        Node current3 = null;
        while (current1 != null || current2 != null) {
            Node node;
            if (current1 == null) {
                node = new Node(current2.getExponent(), current2.getCoefficient());
                current2 = current2.getNextNode();
            } else if (current2 == null) {
                node = new Node(current1.getExponent(), current1.getCoefficient());
                current1 = current1.getNextNode();
            } else if (current1.getExponent() > current2.getExponent()) {
                node = new Node(current1.getExponent(), current1.getCoefficient());
                current1 = current1.getNextNode();
            } else if (current2.getExponent() > current1.getExponent()) {
                node = new Node(current2.getExponent(), current2.getCoefficient());
                current2 = current2.getNextNode();
            } else {
                node = new Node(current1.getExponent(), current1.getCoefficient() + current2.getCoefficient());
                current1 = current1.getNextNode();
                current2 = current2.getNextNode();
            }
            if (current3 == null) {
                result.headNode = node;
            } else {
                current3.setNextNode(node);
            }
            current3 = node;
        }
        return result;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node currentNode = headNode;
        while (currentNode != null){
            if (currentNode.getCoefficient() != 0){
                if (currentNode.getExponent() == 0){
                    stringBuilder.append(currentNode.getCoefficient());
                } else if (currentNode.getExponent() == 1) {
                    if (currentNode.getCoefficient() == 1){
                        stringBuilder.append("x");
                    } else if (currentNode.getCoefficient() == -1) {
                        stringBuilder.append("-x");
                    } else {
                        stringBuilder.append(currentNode.getCoefficient()).append("x");
                    }
                } else {
                    if (currentNode.getCoefficient() == 1){
                        stringBuilder.append("x").append(currentNode.getExponent());
                    } else if (currentNode.getCoefficient() == -1) {
                        stringBuilder.append("-x").append(currentNode.getExponent());
                    } else {
                        stringBuilder.append(currentNode.getCoefficient()).append("x^").append(currentNode.getExponent());
                    }
                }
                if (currentNode.getNextNode() != null && currentNode.getNextNode().getCoefficient() > 0){
                    stringBuilder.append("+");
                }
            }
            currentNode  = currentNode.getNextNode();
        }
        return stringBuilder.toString();
    }

}
