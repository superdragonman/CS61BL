public class TriangleDrawer {
    public static void main(String[] args) {
        drawTriangle();
    }

    public static void drawTriangle(){
        int size = 5;
        int row = 1;
        while (row <= size){
            int col = 1;
            while(col <= row){
                System.out.print("*");
                col++;
            }
            System.out.println();
            row++;
        }
    }
}
