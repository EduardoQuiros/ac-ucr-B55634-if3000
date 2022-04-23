package ac.ucr.b55634.hw2;
import java.awt.font.FontRenderContext;
import java.util.ArrayList;

public class Test {

    ArrayList<Node> nodeArrayList = new ArrayList();
    Node [] nodos  = new Node[6];
    Node auxOpinion;
    Node aux;

    public Test(){

        for (int i = 0; i < 6; i++) {
            nodeArrayList.add(new Node(""+(i+1)));
            nodos[i]=new Node(""+(i+1));
        }
        for (int i = 0; i < 6; i++){
            if (i==0){
                nodos[i].add(nodos[1]);
                nodos[i].add(nodos[2]);
                nodos[i].add(nodos[3]);
                nodos[i].add(nodos[4]);
            } else if (i==1) {
                nodos[i].add(nodos[5]);
            }else if (i==2){
                nodos[i].add(nodos[3]);
                nodos[i].add(nodos[4]);
            }
        }
    }

    public void SetingNodePositive(int position){

        for (int i = 0; i < 6; i++) {
           // System.out.println("Estamos en Vector nodo: "+nodos[i]);
           // System.out.println("Opinion del nodo en vector: "+nodos[i].getOpinion());
            if (i==(position-1)){
                //System.out.println("Estableciendo opinion");
                nodos[i].opinionPositive();
               // System.out.println(nodos[i].getOpinion());
            }
        }
        System.out.println("Cambiando la opinion del Nodo: "+position);
    }

    public void Testing() {
        int count = 0;

        for (int i = 0; i < 6; i++) {
            System.out.println("Posicion: "+(i+1)+" Opinion: "+nodos[i].getOpinion());

            nodeArrayList.add(i,nodos[i]);


        }
        System.out.println("-------------------------------");
        for (int i = 0; i < 6; i++) {
            System.out.println("ArrayList node: "+nodeArrayList.get(i)
                    + ", node Opinion: "+nodeArrayList.get(i).getOpinion());
        }
        System.out.println("-------------------------------");

        System.out.println("---------WHILE-------------");

            while (count<=5) {

                if (count == 3 || count == 4) {
                    nodeArrayList.get(count).opinionPositive();
                    nodeArrayList.get(count).publish();
                    System.out.println("OPINION "+nodeArrayList.get(count).getOpinion());
                }
                count++;
            }

        for (int i = 0; i < 6; i++) {
            if (nodeArrayList.get(5).getOpinion()==false){
                nodeArrayList.get(i).opinionPositive();
                nodeArrayList.get(i).publish();
                System.out.println("Opinion: "+nodeArrayList.get(i).getOpinion());
            }

        }












        System.out.println("-------------------------------");
        for (int i = 0; i < 6; i++) {
            System.out.println("Posicion: "+(i+1)+" Opinion: "+nodos[i].getOpinion());
        }


    }


}
