package co.edu.unaula.dataStructure.nodes;

public class NodesSimpleList {

    private Object data;
    private NodesSimpleList prompter;

    public NodesSimpleList(Object data) {
        this.data = data;
        this.prompter = null;
    }

    public Object getData() {
        return data;
    }

    public NodesSimpleList getPrompter() {
        return prompter;
    }

    public void setPrompter(NodesSimpleList prompter) {
        this.prompter = prompter;
    }
}
