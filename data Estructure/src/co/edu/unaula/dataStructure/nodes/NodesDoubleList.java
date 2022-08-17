package co.edu.unaula.dataStructure.nodes;

public class NodesDoubleList {

    private Object data;
    private NodesDoubleList previousElem, nextElem;

    public NodesDoubleList(Object data) {
        this.data = data;
        this.previousElem = null;
        this.nextElem = null;
    }

    public Object getData() {
        return data;
    }

    public NodesDoubleList getPreviousElem() {
        return previousElem;
    }

    public void setPreviousElem(NodesDoubleList previousElem) {
        this.previousElem = previousElem;
    }

    public NodesDoubleList getNextElem() {
        return nextElem;
    }

    public void setNextElem(NodesDoubleList nextElem) {
        this.nextElem = nextElem;
    }
}
