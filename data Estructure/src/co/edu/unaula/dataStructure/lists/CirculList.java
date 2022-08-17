package co.edu.unaula.dataStructure.lists;

import co.edu.unaula.dataStructure.nodes.NodesCirculList;
import co.edu.unaula.dataStructure.utilities.Direction;

public class CirculList {

    // To cancel




    private final int ZERO = 0, ONE = 1;
    private NodesCirculList tail, head, newNode;
    private String massage ;
    private int size;

    public CirculList(){
        tail = null;
        head = null;
        size = ZERO;
    }

    public String getMassage() {
        return massage;
    }

    public boolean listEmpty(){
        return size == ZERO;
    }

    private boolean dataEmpty(Object data){
        return data == null || data.equals("");
    }

    public boolean validateLastNode(){
        return size == ONE;
    }

    public String getSingleNode(){
        return head.getData().toString();
    }

    private int increaseSize(){
        return size++;
    }

    private int decreaseSize(){
        return size--;
    }

    private void createList(){
        head = newNode;
        tail = newNode;
    }

    private void deleteList(){
        head = null;
        tail = null;
    }

    private CirculList addStart(Object data){

        try {
            newNode = new NodesCirculList(data);
            if (listEmpty()){
                createList();
                massage = "La lista ha sido creada y el dato ha sigo agragado";
            }
            else{
                newNode.setNextElem(tail);
                tail.setPreviousElem(newNode);
                tail = newNode;
                head.setNextElem(tail);
                massage = "Nodo agragado al inicio";
            }
            increaseSize();
            return this;

        } catch (Exception ex){
            throw ex;
        }

    }

    private CirculList addLast(Object data){

        try {
            newNode = new NodesCirculList(data);
            if (listEmpty()){
                createList();
                massage = "La lista ha sido creada y el dato ha sigo agragado";
            }
            else {
                newNode.setPreviousElem(head);
                head.setNextElem(newNode);
                head = newNode;
                head.setNextElem(tail);
                massage = "Nodo agragado al final";
            }
            increaseSize();
            return this;
        } catch (Exception ex){
            throw ex;
        }


    }

    public CirculList addNodes(Object data, Direction direction){
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

    public CirculList deleteNode(){

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
                NodesCirculList currentNode = tail;
                while (currentNode.getNextElem() != head){
                    currentNode = currentNode.getNextElem();
                }
                currentNode.setNextElem(null);
                head = currentNode;
                massage = "Nodo eliminado";
            }
            decreaseSize();
            return this;
        } catch (Exception ex){
            throw ex;
        }
    }

    public String printListStar(){

        NodesCirculList auxNode;
        auxNode = tail;

        if (!listEmpty()){

            massage = "IMPRESION DE LISTA CIRCULARES POR EL INICIO\n";
            for (int i = ZERO; i < size; i++) {
                if (auxNode.getPreviousElem() == null){
                    massage += "Null -> ";
                }
                else {
                    massage += auxNode.getPreviousElem().getData().toString() + " -> ";
                }
                massage += auxNode.getData() + " -> " + auxNode.getNextElem().getData().toString() + "\n";

                auxNode = auxNode.getNextElem();
            }
        } else {
            massage = "No has creado ninguan lista";
        }

        return massage;

    }

    public String printListFinal(){

        NodesCirculList auxNode;
        auxNode = head;

        if (!listEmpty()){
            massage = "INPRESION DE LA LISTA CIRCULAR POR EL FINAL\n";

            for (int i = ZERO; i < size; i++) {
                massage += auxNode.getNextElem().getData().toString() + " -> " +  auxNode.getData() + " -> ";

                if (auxNode.getPreviousElem() == null){
                    massage += "Null";
                }
                else {
                    massage += auxNode.getPreviousElem().getData().toString() + "\n";
                }
                auxNode = auxNode.getPreviousElem();
            }

        } else {
            massage = "No has creado una lista";
        }

        return  massage;
    }

}
