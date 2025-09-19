public class TriangleDrawer2 {
    public static void main(String[] args){
        drawTriangle();
    }

    public static void drawTriangle(){
        int size = 5;
        for (int row = 1;row <= size; row++){
            for(int col = 1;col<=row;col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
