package co.edu.unaula.dataStructure.nodes;

public class NodesTrees {

    private double value;
    private NodesTrees father, leftSon, rightSon;

    public NodesTrees(double data) {
        this.value = data;
        this.father = null;
        this.leftSon = null;
        this.rightSon = null;
    }

    public double getValue() {
        return value;
    }

    public NodesTrees getFather() {
        return father;
    }

    public void setFather(NodesTrees father) {
        this.father = father;
    }

    public NodesTrees getLeftSon() {
        return leftSon;
    }

    public void setLeftSon(NodesTrees leftSon) {
        this.leftSon = leftSon;
    }

    public NodesTrees getRightSon() {
        return rightSon;
    }

    public void setRightSon(NodesTrees rightSon) {
        this.rightSon = rightSon;
    }
}
