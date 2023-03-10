package Polynomial;

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
}
