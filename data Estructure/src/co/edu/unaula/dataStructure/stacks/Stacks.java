package co.edu.unaula.dataStructure.stacks;

import co.edu.unaula.dataStructure.nodes.NodesStacks;

public class Stacks {

    // To put





    private final int ONE = 1, ZERO = 0;
    private NodesStacks topElem, newNode;
    private String massage;
    private int size;

    public Stacks() {
        this.topElem = null;
        this.size = 0;
    }

    public String getMassage() {
        return massage;
    }

    public String getSingleNode(){
        return topElem.getData().toString();
    }

    public boolean stackEmpty(){
        return size == ZERO;
    }

    public boolean validateLastNode(){
        return size == ONE;
    }

    private boolean dataEmpty(Object data){
        return data.equals("") || data == null;
    }

    private int increaseSize(){
        return size++;
    }

    private int decrease(){
        return size--;
    }

    public Stacks push (Object data){
        try {
           if (dataEmpty(data)){
               massage = "No ingeso ningun dato";
               return this;
           }
           newNode = new NodesStacks(data);
           if (!stackEmpty()){
               newNode.setNextElem(topElem);
           }
           topElem = newNode;
           increaseSize();
           massage = "Apilado exitoso";
           return this;

        } catch (Exception ex){
            throw ex;
        }
    }

    public Stacks unStack(){
        try {
            if (stackEmpty()){
                massage = "No has creado una pila";
                return this;
            }
            else{
                topElem = topElem.getNextElem();
                decrease();
                massage = "Desapilado exitoso";
            }
            return this;
        } catch (Exception ex){
            throw ex;
        }
    }

    public String printStack(){
        massage = "INPRESION DE LA PILA";
        NodesStacks auxNode = topElem;
        if (!stackEmpty()){
            for (int i = ZERO; i < size; i++) {
                massage += "\n" + auxNode.getData().toString();
                auxNode = auxNode.getNextElem();
            }
        }
        else {
            massage = "No has creado ninguna pila";
        }
        return massage;
    }



}
