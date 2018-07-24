import java.util.Scanner;

public class SuDoku {
    
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);
        System.out.println("Enter your 9X9 Sudoku here : ");
        String[] input = new String[9];
        for(int i=0;i<9;i++){
            input[i] = consoleIn.nextLine();
        }
        int[][][] SoDoku = genSuDoku(input);
        System.out.println("----- YOUR INPUT: -----");
        print(SoDoku);
        System.out.println("------ SOLUTION: ------");
        long startTime = System.currentTimeMillis();
        print(solve(SoDoku));
        System.out.println("---------------------");
        System.out.println("SOLVED IN : "+ (System.currentTimeMillis() - startTime +" millisecond(s)"));
    }
    
    static int[][][] genSuDoku(String data[]){
        int out[][][] = new int[9][9][1];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                try{
                    out[i][j][0] = Integer.valueOf(String.valueOf(data[i].charAt(j)));
                }catch(Exception e){
                    System.out.println("Error with input.---------------\n"+e+"\n"+"Will exit now.------------------");
                    System.exit(0);
                }
            }
        }
        return out;
    }
    static int[][][] copyOf(int data[][][]){
        //Copy an array (only element at 0th index of the 3rd dimension)
        int out[][][] = new int[9][9][1];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                out[i][j][0] = data[i][j][0];
            }
        }
        return out;
    }
    static int[][][] solve(int data[][][]){
        while(!solved(data)){
            int maxSols=10, oI=0, oJ=0;
            boolean solvedAny=false;
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(data[i][j][0]==0){
                        data = possibleSols(data,i,j);
                        if(data[i][j][0]!=0){
                            solvedAny = true;
                        }
                        if(data[i][j].length==1 && data[i][j][0]==0){
                            //No possible solution can be found at this point return
                            return data;
                        }else if(data[i][j].length<maxSols){
                            maxSols=data[i][j].length;
                            oI=i;
                            oJ=j;
                        }
                    }
                }
            }
            if(!solvedAny){
                //If not solved any by simple elemination
                //tryOneOf
                data = tryOne(data,oI,oJ);
                return data;
            }
        }
        return data;
    }
    static int[][][] tryOne(int data[][][], int x, int y){
        int[][][] backUp = copyOf(data);        //Create a backup to return if no solution found
        int[] temp = new int[(data[x][y].length-1)];
        for(int i=1;i<data[x][y].length;i++){
            temp[i-1] = data[x][y][i];
        }
        data[x][y] = new int[1];
        for(int i=0;i<temp.length;i++){
            data[x][y][0] = temp[i];
            int[][][] inPut = solve(copyOf(data));  //This way data remains protected
            if(solved(inPut)){
                return inPut;
            }
        }
        return backUp;
    }
    static boolean solved(int data[][][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(data[i][j][0]<1){
                    return false;
                }
            }
        }
        return true;
    }
    static void print(int data[][][]){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(data[i][j][0]+" ");
            }
            System.out.println("");
        }
    }
    static int[][][] possibleSols(int data[][][], int x, int y){
        //Store all the possible solutions of any point in 3rd Dimension of the data
        //data[x][y][0] being the original problem while data[x][y][i] being all possible sols 0<i<data[x][y].length
        int sudokuData = data[x][y][0];
        data[x][y] = new int[1];
        boolean temp[] = new boolean[10];
        for(int i=0;i<9;i++){
            temp[(data[x][i][0])] = true;
            temp[(data[i][y][0])] = true;
            
        }
        int xInt, yInt, xFin, yFin;
        
        if(x<=2){
            xInt=0;xFin=2;
        }else if(x<=5){
            xInt=3;xFin=5;
        }else{
            xInt=6;xFin=8;
        }
        if(y<=2){
            yInt=0;yFin=2;
        }else if(y<=5){
            yInt=3;yFin=5;
        }else{
            yInt=6;yFin=8;
        }
        for(int i=xInt;i<=xFin;i++){
            for(int j=yInt;j<=yFin;j++){
                temp[(data[i][j][0])] = true;
            }
        }
        int count=0;
        for(int i=1;i<10;i++){
            if(!temp[i]){count++;}
        }
        data[x][y] = new int[count+1];
        data[x][y][0] = sudokuData;
        int index=1;
        for(int i=1;i<10;i++){
            if(!temp[i]){
                data[x][y][index]=i;
                index++;
            }
        }
        if(data[x][y].length==2){
            int sol = data[x][y][1];
            data[x][y] = new int[1];
            data[x][y][0] = sol;
            return data;
        }
        return data;
    }
}