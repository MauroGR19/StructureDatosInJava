package co.edu.unaula.dataStructure.nodes;

public class NodesStacks {

    private Object data;
    private NodesStacks nextElem;

    public NodesStacks(Object data) {
        this.data = data;
        this.nextElem = null;
    }

    public Object getData() {
        return data;
    }
    
    public NodesStacks getNextElem() {
        return nextElem;
    }

    public void setNextElem(NodesStacks nextElem) {
        this.nextElem = nextElem;
    }
}
