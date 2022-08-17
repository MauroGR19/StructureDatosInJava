package co.edu.unaula.dataStructure.lists;

import co.edu.unaula.dataStructure.nodes.NodesSimpleList;

public class SimpleList {

    //  To send





    private final int ZERO = 0;
    private final int ONE = 1;
    private NodesSimpleList firstNode,lastNode,newNode;
    private int size;
    private String massage;

    public SimpleList() {
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0;
    }

    public String getMassage() {
        return massage;
    }

    public String getSingleNode(){return firstNode.getData().toString();}

    public boolean listEmpty(){
        return size == ZERO;
    }

    public boolean validateLastNode(){
        return size == ONE;
    }

    private int increase(){
        return size++;
    }

    private int decrease(){
        return size--;
    }

    private boolean dataEmpty(Object data){
        return data == null || data.equals("");
    }

    private void createNewList(){
        firstNode = newNode;
        lastNode = newNode;
    }

    private void deleteList(){
        firstNode = null;
        lastNode = null;
    }

    public SimpleList addNodes(Object data){

        try {

            if (dataEmpty(data)){
                massage = "No ingreso ningun dato";
                return this;
            }
            newNode = new NodesSimpleList(data);

            if (listEmpty()){
                createNewList();
                massage = "La lista ha sigo creada y el dato ha sido agregado";

            }
            else {
                lastNode.setPrompter(newNode);
                lastNode = newNode;
                massage = "Dato agragado";
            }
            increase();

            return this;
        } catch (Exception ex){
            throw ex;
        }

    }

    public SimpleList deleteNode(){
        try {
            if (listEmpty()){
                massage = "No has creado ninguna lista, no puedes eliminar";
                return this;
            }
            if (firstNode == lastNode){
                deleteList();
                massage = "Lista eliminada";
            }
            else {
                NodesSimpleList currentNode = firstNode;

                while (currentNode.getPrompter() != lastNode){
                    currentNode = currentNode.getPrompter();
                }
                currentNode.setPrompter(null);
                lastNode = currentNode;

                massage = "Dato eliminado";

            }
            decrease();
            return this;
        } catch (Exception ex){
            throw ex;
        }

    }

    public String printList(){

        NodesSimpleList auxNode;
        String dataPront = "";

        if (!listEmpty()){
            massage = "IMPRESION DE LA LISTA SIMPLE \n";
            auxNode = firstNode;

            for (int i = ZERO   ; i < size; i++) {
                if (auxNode.getPrompter() == null){
                    dataPront = " Null";
                }
                else {
                    dataPront = auxNode.getPrompter().getData().toString();
                }
                massage += auxNode.getData() + " -> " +  dataPront + "\n";
                auxNode = auxNode.getPrompter();
            }
            return massage;
        } else {
            return massage = "No has creado ninguna lista, no pudes inprimir";
        }

    }
}


