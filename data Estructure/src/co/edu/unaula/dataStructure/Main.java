package co.edu.unaula.dataStructure;

import co.edu.unaula.dataStructure.lists.CirculList;
import co.edu.unaula.dataStructure.lists.DoubleList;
import co.edu.unaula.dataStructure.lists.SimpleList;
import co.edu.unaula.dataStructure.queues.Queues;
import co.edu.unaula.dataStructure.recursion.RecursiveFactorial;
import co.edu.unaula.dataStructure.recursion.RecursivePotency;
import co.edu.unaula.dataStructure.stacks.Stacks;
import co.edu.unaula.dataStructure.trees.Trees;
import co.edu.unaula.dataStructure.utilities.Topics;

import java.util.Scanner;

import static co.edu.unaula.dataStructure.utilities.Direction.ADDFINAL;
import static co.edu.unaula.dataStructure.utilities.Direction.ADDSTARD;
import static co.edu.unaula.dataStructure.utilities.Topics.*;

public class Main {

    private static Scanner read = new Scanner(System.in);
    private static String optionMenuSecundary, confirmation, massage, addData, printList, confirmPrint, confirAdd;
    private static boolean existRoot = false;
    private static final String ONE = "1";
    private static final String TWO = "2";
    private static final String THREE = "3";
    private static final String FOUR = "4";
    private static final String FIVE = "5";
    private static final String SIX = "6";
    private static final String SEVEN = "7";
    private static final String EIGHT = "8";
    private static SimpleList simpleList = new SimpleList();
    private static DoubleList doubleList = new DoubleList();
    private static CirculList circulList = new CirculList();
    private static Stacks stacks = new Stacks();
    private static Queues queues = new Queues();
    private static RecursiveFactorial factorial = new RecursiveFactorial();
    private static RecursivePotency potency = new RecursivePotency();
    private static Trees trees;

    public static void main(String[] args) {
        showMenu();
    }

    private static boolean validateEmpty(Topics topics){
        switch (topics){
            case LISTSIMPLE:
                return simpleList.listEmpty();

            case LISTDOUBLE:
                return doubleList.listEmpty();

            case LISTCIRCUL:
                return circulList.listEmpty();

            case STACKS:
                return stacks.stackEmpty();

            case QUEUES:
                return queues.queuesEmpty();

            case TREES:
                return trees == null;
        }
        return true;
    }

    private static void validateDelete(Topics topics) {
        if (validateEmpty(topics)) {
            return;
        }

        do {
            System.out.println("Esta seguro que desea eliminar?\n1. si\n2. no");
            confirmation = read.nextLine();
            if (confirmation.equals(ONE)){
                deleteLastNode(topics);
            }
            else if (confirmation.equals(TWO)){
                secondaryMenu();
            }
            else{
                System.out.println("Elegiste una opcion invalida");
                confirmation = THREE;
            }
        } while (confirmation == THREE);


    }

    private static void deleteLastNode(Topics topics){

        massage = "Solo queda un nodo: ";
        confirmation = "\nEstas seguro que quires eliminar \n1. si\n2. no";

        switch (topics){
            case LISTSIMPLE:
                if (simpleList.validateLastNode()){

                    massage = massage + simpleList.getSingleNode() + confirmation;
                    validateConfirmDelete(massage);

                }
                break;

            case LISTDOUBLE:
                if (doubleList.validateLastNode()){

                    massage = massage + doubleList.getSingleNode() + confirmation;
                    validateConfirmDelete(massage);

                }
                break;

            case LISTCIRCUL:
                if (circulList.validateLastNode()){

                    massage = massage + circulList.getSingleNode() + confirmation;
                    validateConfirmDelete(massage);

                }
                break;

            case STACKS:
                if (stacks.validateLastNode()){
                    massage = massage + stacks.getSingleNode() + confirmation;
                    validateConfirmDelete(massage);
                }
                break;

            case QUEUES:

                if (queues.validateLastNode()){
                    massage = massage + queues.getSingleNode() + confirmation;
                    validateConfirmDelete(massage);
                }
                break;
        }
    }

    private static void validateConfirmDelete(String massage ){

        do {
            System.out.println(massage);
            confirmation = read.nextLine();
            if (confirmation.equals(ONE)){
                break;
            }
            else if (confirmation.equals(TWO)){
                secondaryMenu();
            }else{
                System.out.println("La opcion no es valida");
                confirmation = THREE;
            }
        } while (confirmation == THREE);

    }

    public static void showMenu(){

        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Listas simples\n2. Listas dobles\n3. Listas circulares\n4. Pilas\n5. Colas\n6. Recursividad\n" +
                "7. Arboles binarios\n8. Salir");
        optionMenuSecundary = read.nextLine();
        secondaryMenu();
    }

    private static void secondaryMenu(){

        switch (optionMenuSecundary){

            case ONE:
                System.out.println("Menu listas simples");
                System.out.println("1. Crear/Agragar\n2. Eliminar Node\n3. Imprimir Lista\n4. Regresar al menu principal");
                simpleList(read.nextLine());
                break;

            case TWO:

                System.out.println("Menu listas dobles");
                System.out.println("1. Crear/Agragar\n2. Eliminar Node\n3. Imprimir Lista\n4. Regresar al menu principal");
                doubleList(read.nextLine());

                break;

            case THREE:

                System.out.println("Menu listas circulares");
                System.out.println("1. Crear/Agragar\n2. Eliminar Node\n3. Imprimir Lista\n4. Regresar al menu principal");
                cirList(read.nextLine());
                break;

            case FOUR:
                System.out.println("Menu Pilas");
                System.out.println("1. Apilar\n2. Desapilar\n3. Imprimir la pila\n4. Regresar al menu principal");
                stacks(read.nextLine());
                break;

            case FIVE:
                System.out.println("Menu Colas");
                System.out.println("1. Encolar\n2. Desencolar\n3. Imprimir cola\n4. Regrasar el menu principal");
                queues(read.nextLine());
                break;

            case SIX:
                System.out.println("Menu Recursividad");
                System.out.println("1. Calcular factorial\n2. Calcular Potencias\n3. Regresar al menu principal");
                recursion(read.nextLine());
                break;

            case SEVEN:
                System.out.println("Menu Arboles Binarios");
                System.out.println("1. Crear\n2. Eliminar rama\n3. Imprimir\n4. Regresar al menu principal");
                trees(read.nextLine());
                break;

            case EIGHT:

                System.out.println("Gracias por utilizar el programa");
                System.exit(0);
                break;

            default:

                System.out.println("aun no esta programada");
                showMenu();
                break;
        }

    }

    private static void simpleList (String option){

        try {

            switch (option){

                case ONE:

                    System.out.println("Ingrese el dato que desea agregar");
                    simpleList.addNodes(read.nextLine());
                    System.out.println(simpleList.getMassage());
                    do {
                        System.out.println("Desea seguir ingresando datos?\n1.si\n2.no");
                        confirmation = read.nextLine();
                        if (confirmation.equals(ONE)){
                            System.out.println("Ingrese el dato que desea agregar");
                            simpleList.addNodes(read.nextLine());
                            System.out.println(simpleList.getMassage());
                        } else if (confirmation.equals(TWO)){
                            secondaryMenu();
                        }
                        else {
                            System.out.println("La opcion no es valida");
                            confirmation = ONE;
                        }

                    } while (confirmation.equals(ONE));


                    break;

                case TWO:

                    validateDelete(LISTSIMPLE);
                    simpleList.deleteNode();
                    System.out.println(simpleList.getMassage());

                    break;

                case THREE:

                    System.out.println(simpleList.printList());


                    break;


                case FOUR:

                    showMenu();

                    break;

                default:

                    System.out.println("Elegiste una opcion incorrecta");


                    break;
            }
            secondaryMenu();
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private static void doubleList (String option){

        try {

            switch (option){

                case ONE:

                    do {

                        if (validateEmpty(LISTDOUBLE)){
                            System.out.println("Ingrese el dato que desea agregar");
                            addData = read.nextLine();
                            doubleList.addNodes(addData,ADDFINAL);
                            System.out.println(doubleList.getMassage());
                        }
                        else{
                            System.out.println("Ingrese el dato que desea agregar");
                            addData = read.nextLine();
                            System.out.println("Hacia que lado desea agregar el dato?\n1. Al inicio\n2. Al final");
                            confirAdd = read.nextLine();
                            if (confirAdd.equals(ONE)){
                                doubleList.addNodes(addData, ADDSTARD);
                                System.out.println(doubleList.getMassage());
                            } else if (confirAdd.equals(TWO)){
                                doubleList.addNodes(addData,ADDFINAL);
                                System.out.println(doubleList.getMassage());
                            }else {
                                System.out.println("Opcion no valida");
                            }
                        }

                        do {
                            System.out.println("Desea seguir agragando datos?\n1. si\n2. no");
                            confirmation = read.nextLine();

                            if (confirmation.equals(ONE)){
                                break;
                            }
                            else if (confirmation.equals(TWO)){
                                secondaryMenu();
                            }
                            else {
                                System.out.println("La opcion no es valida");
                            }

                        } while (confirmation != ONE && confirmation != TWO);


                    } while (confirmation.equals(ONE));

                    break;

                case TWO:
                    validateDelete(LISTDOUBLE);
                    doubleList.deleteNode();
                    System.out.println(doubleList.getMassage());

                    break;


                case THREE:
                     if (validateEmpty(LISTDOUBLE)){
                            System.out.println("No se ha creado ninguna lista\n");
                           break;
                     }
                    validatePrint(LISTDOUBLE);

                    break;

                case FOUR:

                    showMenu();

                    break;

                default:

                    System.out.println("Elegiste una opcion incorrecta");


                    break;
            }
            secondaryMenu();
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private static void cirList (String option){

        try {

            switch (option){
                case ONE:

                    do {

                        if (validateEmpty(LISTCIRCUL)){
                            System.out.println("Ingrese el dato que desea agregar");
                            addData = read.nextLine();
                            circulList.addNodes(addData,ADDFINAL);
                            System.out.println(circulList.getMassage());
                        }
                        else {
                            System.out.println("Ingrese el dato que desea agregar");
                            addData = read.nextLine();
                            System.out.println("Hacia donde desea ingresar el dato\n1. Al inicio\n2. Al final");
                            confirAdd = read.nextLine();
                            if (confirAdd.equals(ONE)){
                                circulList.addNodes(addData,ADDSTARD);
                                System.out.println(circulList.getMassage());
                            }else if (confirAdd.equals(TWO)){
                                circulList.addNodes(addData,ADDFINAL);
                                System.out.println(circulList.getMassage());
                            }
                            else {
                                System.out.println("La opcion no es valida");
                            }
                        }

                        do {
                            System.out.println("Desea seguir ingresando datos?\n1. si\n2. no");
                            confirmation = read.nextLine();

                            if (confirmation.equals(ONE)){
                                break;
                            }
                            else if (confirmation.equals(TWO)){
                                secondaryMenu();
                            }
                            else {
                                System.out.println("La opcion no es valida");
                            }
                        } while (confirmation != ONE && confirmation != TWO);

                    } while (confirmation.equals(ONE));


                    break;

                case TWO:

                    validateDelete(LISTCIRCUL);
                    circulList.deleteNode();
                    System.out.println(circulList.getMassage());

                    break;

                case THREE:

                    if (validateEmpty(LISTCIRCUL)){
                        System.out.println("No se a creado ninguna lista");
                        break;
                    }
                    validatePrint(LISTCIRCUL);

                    break;

                case FOUR:

                    showMenu();

                    break;

                default:
                    System.out.println("Elegiste una opcion incorrecta");

                    break;
            }
            secondaryMenu();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static void stacks(String option){
        try {

            switch (option){
                case ONE:
                    System.out.println("Ingrese el dato que desea agregar");
                    stacks.push(read.nextLine());
                    System.out.println(stacks.getMassage());
                    do {
                        System.out.println("Desea seguir ingresando datos?\n1.si\n2.no");
                        confirmation = read.nextLine();
                        if (confirmation.equals(ONE)){
                            System.out.println("Ingrese el dato que desea agregar");
                            stacks.push(read.nextLine());
                            System.out.println(stacks.getMassage());
                        } else if (confirmation.equals(TWO)){
                            break;
                        }
                        else {
                            System.out.println("La opcion no es valida");
                            confirmation = ONE;
                        }

                    } while (confirmation.equals(ONE));

                    break;

                case TWO:
                    validateDelete(STACKS);
                    stacks.unStack();
                    System.out.println(stacks.getMassage());

                    break;

                case THREE:
                    System.out.println(stacks.printStack());

                    break;

                case FOUR:
                    showMenu();
                    break;

                default:
                    System.out.println("Elegiste una opcion incorrecta");

                    break;
            }
            secondaryMenu();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static void queues (String option ){
        try {

            switch (option){
                case ONE:

                    System.out.println("Ingrese el dato que desea agregar");
                    queues.enqueue(read.nextLine());
                    System.out.println(queues.getMassage());
                    do {
                        System.out.println("Desea seguir ingresando datos?\n1.si\n2.no");
                        confirmation = read.nextLine();
                        if (confirmation.equals(ONE)){
                            System.out.println("Ingrese el dato que desea agregar");
                            queues.enqueue(read.nextLine());
                            System.out.println(queues.getMassage());
                        } else if (confirmation.equals(TWO)){
                            break;
                        }
                        else {
                            System.out.println("La opcion no es valida");
                            confirmation = ONE;
                        }

                    } while (confirmation.equals(ONE));

                    break;

                case TWO:

                    validateDelete(QUEUES);
                    queues.dequeue();
                    System.out.println(queues.getMassage());


                    break;

                case THREE:
                    System.out.println(queues.printQueue());

                    break;


                case FOUR:
                    showMenu();
                    break;

                default:
                    System.out.println("Elegiste una opcion icorrecta");

                    break;

            }
            secondaryMenu();


        } catch (Exception ex ){
            ex.printStackTrace();
        }
    }

    private static void recursion(String option){
        try {

            switch (option){
                case ONE:
                    System.out.println("Ingrese el numero al que desea calcular su factorial");
                    factorial.factorial(read.nextLine());
                    System.out.println(factorial.getMassage());

                    break;

                case TWO:
                    System.out.println("Ingrese la base de la potencia");
                    String base = read.nextLine();
                    System.out.println("Ingrese el exponente");
                    String exponent = read.nextLine();
                    potency.potency(base, exponent);
                    System.out.println(potency.getMassage());

                    break;

                case THREE:
                    showMenu();
                    break;

                default:
                    System.out.println("La opcion no es valida");

            }
            secondaryMenu();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static void trees (String option){
        try {

            switch (option){
                case ONE:
                        createRoot();
                        System.out.println("Ingrese el elemento para el arbol");
                        trees.addNode(read.nextLine());
                        System.out.println(trees.getMessage());
                        do {
                            System.out.println("Desea seguir agragarndo elementos?\n1. si\n2. no");
                            confirmation = read.nextLine();
                            if (confirmation.equals(ONE)){
                                System.out.println("Ingrese el elemento para el arbol");
                                trees.addNode(read.nextLine());
                                System.out.println(trees.getMessage());
                            } else  if (confirmation.equals(TWO)){
                                secondaryMenu();
                            }
                            else {
                                System.out.println("La opcion no es valida");
                                confirmation = ONE;
                            }
                        } while (confirmation.equals(ONE));


                    break;

                case TWO:

                    if (validateEmpty(TREES)){
                        System.out.println("No se ha creado ningun arbol");
                        secondaryMenu();
                        break;
                    }
                    System.out.println("Ingrese el elemento que desea eliminar");
                    trees.deleteNodeWithValue(read.nextLine());
                    System.out.println(trees.getMessage());


                    break;

                case THREE:

                    if (validateEmpty(TREES)){
                        System.out.println("No hay ningun arbol para inprimir");
                        secondaryMenu();
                        break;
                    }
                    System.out.println("Eliga el orden en que desea inprimir\n1. Preorder\n2. Inorder\n3. PostOrder");
                    printTree(read.nextLine());

                    break;

                case FOUR:
                    showMenu();
                    break;

                default:
                    System.out.println("la opcion no es valida ");
                    break;
            }
            secondaryMenu();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static void createRoot(){
        try {
            if (existRoot){
                return;
            }
            System.out.println("Ingrese la raiz del arbol");
            trees = new Trees(read.nextLine());
            System.out.println(trees.getMessage());
            if (!trees.getMessage().equals("El dato debe ser numerico")){
                existRoot = true;
            }
            createRoot();
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    private static void printTree(String option){
        try {

            switch (option){
                case ONE:
                    System.out.println("IMPRESION DEL ARBOL EN PREORDER");
                    System.out.println(trees.printPreOrder());

                    break;

                case TWO:
                    System.out.println("IMPRESION DEL ARBOL EN INORDER");
                    trees.printInOrder();
                    System.out.println(trees.getMessage());
                    break;

                case THREE:

                    System.out.println("IMPRESION DEL ARBOL EN POSTORDER");
                    trees.printPostOrder();
                    System.out.println(trees.getMessage());
                    break;

                default:
                    System.out.println("La opcion no es valida");
                    break;

            }

            secondaryMenu();

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static void validatePrint(Topics topics){

        switch (topics){

            case LISTDOUBLE:

                do {
                    System.out.println("Como desea imprimir la lista?\n1.Por el inicio\n2.Por el final");
                    printList = read.nextLine();

                    if (printList.equals(ONE)){
                        System.out.println(doubleList.printListStar() + "\n");
                    }
                    else if (printList.equals(TWO)){
                        System.out.println(doubleList.printListFinal() + "\n");
                    }
                    else {
                        System.out.println("La opcion no es valida");
                        printList = THREE;
                    }
                } while (printList.equals(THREE));

                break;

            case LISTCIRCUL:
                do {
                    System.out.println("Como desea imprimir la lista?\n1.Por el inicio\n2.Por el final");
                    confirmPrint = read.nextLine();

                    if (confirmPrint.equals(ONE)){
                        System.out.println(circulList.printListStar() + "\n");
                    }
                    else if (confirmPrint.equals(TWO)){
                        System.out.println(circulList.printListFinal() + "\n");
                    }
                    else {
                        System.out.println("La opcion no es valida");
                        confirmPrint = THREE;
                    }
                } while (confirmPrint.equals(THREE));

                 break;


        }

    }

}
