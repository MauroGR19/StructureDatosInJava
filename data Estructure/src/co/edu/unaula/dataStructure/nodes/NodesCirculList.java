package co.edu.unaula.dataStructure.nodes;

public class NodesCirculList {

    private Object data;
    private NodesCirculList nextElem, previousElem;

    public NodesCirculList(Object data) {
        this.data = data;
        this.nextElem = null;
        this.previousElem = null;
    }

    public Object getData() {
        return data;
    }

    public NodesCirculList getNextElem() {
        return nextElem;
    }

    public void setNextElem(NodesCirculList nextElem) {
        this.nextElem = nextElem;
    }

    public NodesCirculList getPreviousElem() {
        return previousElem;
    }

    public void setPreviousElem(NodesCirculList previousElem) {
        this.previousElem = previousElem;
    }
}
