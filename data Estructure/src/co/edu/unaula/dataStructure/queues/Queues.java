package co.edu.unaula.dataStructure.queues;

import co.edu.unaula.dataStructure.nodes.NodesQueues;

public class Queues {

    // cat




    private final int ZERO = 0, ONE = 1;
    private NodesQueues firstElem, lastElem, newNode;
    private int size;
    private String massage;

    public Queues() {
        this.firstElem = null;
        this.lastElem = null;
        this.size = ZERO;
    }

    public String getSingleNode(){
        return lastElem.getData().toString();
    }

    public String getMassage() {
        return massage;
    }

    public boolean queuesEmpty(){
        return size == ZERO;
    }

    public boolean validateLastNode(){
        return size == ONE;
    }

    private boolean dataEmpty(Object data){
        return data == null || data.equals("");
    }

    private int increaseSize(){
        return size++;
    }

    private int decreaseSise(){
        return size--;
    }

    public Queues enqueue (Object data){
        try {
            if (dataEmpty(data)){
                massage = "No ingreso ningun dato";
                return this;
            }
            newNode = new NodesQueues(data);
            if (queuesEmpty()){
                firstElem = newNode;
            }
            else {
                lastElem.setNextElem(newNode);
            }
            lastElem = newNode;
            increaseSize();
            massage = "Encolado exitoso";
            return this;
        } catch (Exception ex){
            throw ex;
        }
    }

    public Queues dequeue (){
        try {
            if (!queuesEmpty()){
                firstElem = firstElem.getNextElem();
                decreaseSise();
                massage = "Desencolado exitoso";
            }
            else{
                massage = "No has crado ninguna cola";
            }

            return this;

        } catch (Exception ex){
            throw ex;
        }
    }

    public String printQueue(){

        massage = "IMPRESION DE LA COLA\n";
        NodesQueues auxNode = firstElem;

        if (!queuesEmpty()){
            for (int i = ZERO; i < size; i++) {

                massage += "\n" + auxNode.getData().toString();
                auxNode = auxNode.getNextElem();

            }
        }
        else {
            massage = "No has credo ninguna cola";
        }

        return massage;
    }
}
