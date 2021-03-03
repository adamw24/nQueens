import java.util.Scanner;

public class nQueens {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("nQueens Recursion Problem:");
        System.out.println("Place N Queens on a NxN chess board such that no Queens attack each other.");
        System.out.print("Input N: ");
        try{
            int size = in.nextInt();
            if (size >=4){
                int[][] b = new int[size][size];
                findQueens(0, b);
                printBoard(b);   
            }else{
                System.out.println("Oops, your input is too small.");
            }
        }catch(Exception e){
            System.out.println("Oops, your input is not an integer.");
        }
       in.close();
    }


    public static void printBoard(int[][] b){
        for(int i = 0; i<b.length; i++){
            for(int j = 0; j<b.length; j++){
                if(b[i][j] == -1){
                    System.out.print("X ");
                }else if(b[i][j] ==0 ){
                    System.out.print("0 ");
                }else{
                    System.out.print("- ");
                }
            }
            System.out.println("");
        }
    }
    public static boolean findQueens(int size, int[][] b){
        if (size >= b.length){
            return true;
        }
        for(int i = 0; i<b.length; i++){
            if(b[size][i] == 0){
                updateBoard(size, i, b, true);
                if (findQueens(size+1, b)){
                    return true;
                }
                updateBoard(size,i,b,false);
            }
        }
        return false;
    }

    private static void updateBoard(int c, int i, int[][] board, boolean b){
        int s = b ? 1:-1;
        for(int j = 0; j<board.length; j++){
            board[c][j] += s;
            board[j][i] += s;
            if (c-j>=0){
                if(i-j>=0){
                    board[c-j][i-j] += s;
                }
                if (i+j<board.length){
                    board[c-j][i+j] += s;
                }
            }
            if (c+j<board.length){
                if(i-j>=0){
                    board[c+j][i-j] += s;
                }
                if (i+j<board.length){
                    board[c+j][i+j] += s;
                }
            }
        }
        board[c][i] = b? -1:0;
    }
}