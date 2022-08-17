package co.edu.unaula.dataStructure.nodes;

public class NodesQueues {

    private Object data;
    private NodesQueues nextElem;

    public NodesQueues(Object data) {
        this.data = data;
        this.nextElem = null;
    }

    public Object getData() {
        return data;
    }

    public NodesQueues getNextElem() {
        return nextElem;
    }

    public void setNextElem(NodesQueues nextElem) {
        this.nextElem = nextElem;
    }
}
