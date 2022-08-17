package co.edu.unaula.dataStructure.trees;

import co.edu.unaula.dataStructure.nodes.NodesTrees;

public class Trees {


    // To ask




    private NodesTrees root;
    private String message;

    public Trees(String root) {
        if (!isNumeric(root)) {
            message = "El dato debe ser numerico";
            return;
        }
        message = "La raiz fue agregada";
        this.root = new NodesTrees(Double.parseDouble(root));
    }

    public String getMessage() {
        return message;
    }

    private boolean isNumeric(String num) {

        try {
            Double.parseDouble(num);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }

    }

    private Trees addNodes(NodesTrees newNode, NodesTrees rootNode) {
        try {

            newNode.setFather(rootNode);

            if (newNode.getValue() < rootNode.getValue()) {

                if (rootNode.getLeftSon() == null) {
                    rootNode.setLeftSon(newNode);
                } else {
                    addNodes(newNode, rootNode.getLeftSon());
                }
            } else {

                if (rootNode.getRightSon() == null) {
                    rootNode.setRightSon(newNode);
                } else {
                    addNodes(newNode, rootNode.getRightSon());
                }
            }

            return this;

        } catch (Exception ex) {
            throw ex;
        }
    }

    private NodesTrees findNode(double value, NodesTrees root) {

        try {
            if (value == root.getValue()) {
                return root;
            } else if (value < root.getValue()) {

                if (root.getLeftSon() != null) {
                    return findNode(value, root.getLeftSon());
                } else {
                    return null;
                }
            } else {
                if (root.getRightSon() != null) {
                    return findNode(value, root.getRightSon());
                } else {
                    return null;
                }
            }
        } catch (Exception ex) {
            throw ex;
        }

    }

    private boolean removeLeaves(NodesTrees node) {
        try {

            if (node.getLeftSon() != null || node.getRightSon() != null) {
                message = "No puede eliminar ramas";
                return false;
            }

            NodesTrees leftChild = node.getFather().getLeftSon();
            NodesTrees rightChild = node.getFather().getRightSon();

            if (leftChild == node) {
                node.getFather().setLeftSon(null);
                return true;
            }
            if (rightChild == node) {
                node.getFather().setRightSon(null);
                return true;
            }
            return false;
        } catch (Exception ex) {
            throw ex;
        }

    }

    private void printPreOrder(NodesTrees root) {

        try {
            message = message + root.getValue() + " ";

            if (root.getLeftSon() != null) {
                printPreOrder(root.getLeftSon());
            }
            if (root.getRightSon() != null) {
                printPreOrder(root.getRightSon());
            }

        } catch (Exception ex) {
            throw ex;
        }
    }

    private void printInOrder(NodesTrees root) {
        try {

            if (root.getLeftSon() != null) {
                printInOrder(root.getLeftSon());
            }
            message = message + root.getValue() + " ";

            if (root.getRightSon() != null) {
                printInOrder(root.getRightSon());
            }

        } catch (Exception ex) {
            throw ex;
        }
    }

    private void printPostOrder(NodesTrees root) {
        try {

            if (root.getLeftSon() != null) {
                printPostOrder(root.getLeftSon());
            }
            if (root.getRightSon() != null) {
                printPostOrder(root.getRightSon());
            }
            message = message + root.getValue() + " ";

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void addNode(String value) {
        try {
            if (!isNumeric(value)){
                message="el dato debe ser numerico";
                return;
            }
            NodesTrees newNode = new NodesTrees(Double.parseDouble(value));
            this.addNodes(newNode, this.root);
            message = "Elemento agregado";
        } catch (Exception ex) {
            throw ex;
        }

    }

    public boolean deleteNodeWithValue(String value) {
        try {

            if (!isNumeric(value)){
                message="el dato debe ser numerico";
                return false;
            }
            if (this.root.getValue() == Double.parseDouble(value)) {
                message = "El nodo raíz no puede ser eliminado";
                return false;
            }
            NodesTrees nodeFind = findNode(Double.parseDouble(value), this.root);
            if (nodeFind == null) {
                message = "El nodo con valor " + value + " no existe";
                return false;
            }
            message = "Nodo eliminado exitosamente";
            return removeLeaves(nodeFind);

        } catch (Exception ex) {
            throw ex;
        }
    }

    public String printPreOrder(){
        message = "";
        printPreOrder(this.root);
        return message;
    }

    public void printInOrder(){
        message = "";
        printInOrder(this.root);
    }

    public void printPostOrder(){
        message = "";
        printPostOrder(this.root);
    }





}
