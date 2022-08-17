package co.edu.unaula.dataStructure.lists;

import co.edu.unaula.dataStructure.nodes.NodesDoubleList;
import co.edu.unaula.dataStructure.utilities.Direction;

public class DoubleList {


    // To Draw





    private NodesDoubleList tail, head, newNode;
    private String massage, previousElem, nextElem ;

    public DoubleList(){
        tail = null;
        head = null;
    }

    public String getMassage() {
        return massage;
    }

    public boolean listEmpty(){
        return head == null && tail == null;
    }

    private boolean dataEmpty(Object data){
        return data == null || data.equals("");
    }

    public boolean validateLastNode(){
        return head == tail && head!= null;
    }

    public String getSingleNode(){
        return head.getData().toString();
    }

    private void createList(){
        head = newNode;
        tail = newNode;
    }

    private void deleteList(){
        head = null;
        tail = null;
    }

    private DoubleList addStart(Object data){

        try {
            newNode = new NodesDoubleList(data);
            if (listEmpty()){
                createList();
                massage = "La lista ha sido creada y el dato ha sigo agragado";
            }
            else{
                newNode.setNextElem(tail);
                tail.setPreviousElem(newNode);
                tail = newNode;
                massage = "Nodo agragado al inicio";
            }

            return this;

        } catch (Exception ex){
            throw ex;
        }

    }

    private DoubleList addLast(Object data){

        try {
            newNode = new NodesDoubleList(data);
            if (listEmpty()){
                createList();
                massage = "La lista ha sido creada y el dato ha sigo agragado";
            }
            else {
                newNode.setPreviousElem(head);
                head.setNextElem(newNode);
                head = newNode;
                massage = "Nodo agragado al final";
            }

            return this;
        } catch (Exception ex){
            throw ex;
        }


    }

    public DoubleList addNodes(Object data, Direction direction){
        try {

            if (dataEmpty(data)){
                massage = "No ingreso ninguan dato";
                return this;
            }
            switch (direction){
                case ADDSTARD:
                    addStart(data);
                    break;

                case ADDFINAL:
                    addLast(data);
                    break;
            }

            return this;

        } catch (Exception ex){
            throw ex;
        }
    }

    public DoubleList deleteNode(){

        try {
            if (listEmpty()){
                massage = "No has creado ninguna lista";
                return this;
            }

            if (head == tail){
                deleteList();
                massage = "La lista ha sido eliminada";
            }
            else{
                NodesDoubleList currentNode = tail;
                while (currentNode.getNextElem() != head){
                    currentNode = currentNode.getNextElem();
                }
                currentNode.setNextElem(null);
                head = currentNode;
                massage = "Nodo eliminado";
            }
            return this;
        } catch (Exception ex){
            throw ex;
        }
    }

    public String printListStar(){

        NodesDoubleList auxNode;
        auxNode = tail;

        if (!listEmpty()){

            massage = "IMPRESION DE LISTA DOBLES POR EL INICIO\n";
            while (auxNode != null){
                if (auxNode.getPreviousElem() == null){
                    previousElem = "Null";
                }
                else {
                    previousElem = auxNode.getPreviousElem().getData().toString();
                }
                if (auxNode.getNextElem() == null){
                    nextElem =  " Null";
                }
                else {
                    nextElem = auxNode.getNextElem().getData().toString();
                }
                massage +=  previousElem + " -> " + auxNode.getData() + " -> " + nextElem + "\n";
                auxNode = auxNode.getNextElem();
            }

        } else {
            massage = "No has creado ninguan lista";
        }

        return massage;

    }

    public String printListFinal(){

        NodesDoubleList auxNode;
        auxNode = head;

        if (!listEmpty()){
            massage = "INPRESION DE LA LISTA DOBLE POR EL FINAL\n";

            while (auxNode != null){
                if (auxNode.getNextElem() == null){
                    previousElem =  " Null";
                }
                else {
                    previousElem = auxNode.getNextElem().getData().toString();
                }
                if (auxNode.getPreviousElem() == null){
                    nextElem = "Null";
                }
                else {
                    nextElem = auxNode.getPreviousElem().getData().toString();
                }
                massage +=  previousElem + " -> " + auxNode.getData() + " -> " + nextElem + "\n";
                auxNode = auxNode.getPreviousElem();
            }

        } else {
            massage = "No has creado una lista";
        }

        return  massage;
    }

}
