//Assignment Task 04: Rotate Secret
class AssgnTask4{

    //Complete this method so that it gives the Expected Output
    //YOU ONLY HAVE TO SUBMIT THIS METHOD, NO OTHER DRIVER CODE
    //If needed you can create extra helper static methods
public static void rotateSecret(Character [][] board){
int n=board.length;
  int Layers = (n + 1) / 2;

for (int layer = 0; layer < Layers; layer++) {
 int start = layer;
int end   = n-1 - layer;

int rotation = Layers - layer;

    for (int r = 0; r < rotation; r++)
        shiftOnce(start, end, board);
}


}




 public static void shiftOnce(int start, int end, Character[][] a) {

    if (start >= end) {
        return;}
    Character prev = a[start + 1][start];
       Character temp;

    for (int j = start; j <= end; j++) {
     temp = a[start][j];
     a[start][j] = prev;
        
     prev = temp;
    }

       for (int i = start + 1; i <= end; i++) {
        temp = a[i][end];
     a[i][end] = prev;
         prev = temp;

    }

   
    for (int j = end - 1; j >= start; j--) {
    temp = a[end][j];
    a[end][j] = prev;
    
    prev = temp;
    }
 for (int i = end - 1; i > start; i--) {
        temp = a[i][start];

    a[i][start] = prev;
      
        prev = temp;
    } 
}
 


    public static void print(Character[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
  
   }
  
public static void main(String[] args){
        System.out.print("===========Test#1===========\n");
        Character[][] board = {
          {'T','A','U','S'},
          {'A','R','I','.'},
          {'D','T','T','N'},
          {'S','C','F','U'}
        };
        System.out.println("Given Board: ");
        Arr.print2D(board);

        System.out.println("\nExpected Output:");
        Character[][] outputBoard = {
            {'D','A','T','A'},
            {'S','T','R','U'},
            {'C','T','I','S'},
            {'F','U','N','.'}
        };
        System.out.print("DATASTRUCTISFUN.\n");
        Arr.print2D(outputBoard);
        
        System.out.print("\nYour Output:\n");
        rotateSecret( board );
        Arr.print2D(board);
        
        if( Arr.compare2D(outputBoard, board) ) System.out.print("Test 1 Success");
        else System.out.println("Test 1 FAILED");
        
        System.out.print("\n===========Test#2===========\n");

        board = new Character[][]{
          {'O','R','I','R','N','P'},
          {'G','S','A','A','L','R'},
          {'L','M','N','O','N','Y'},
          {'A','H','U','O','O','P'},
          {'T','F','C','T','H','S'},
          {'E','D','Y','O','C','K'}
        };
        System.out.println("Given Board: ");
        Arr.print2D(board);

        System.out.println("\nExpected Output:");
        outputBoard = new Character[][]{
            {'A','L','G','O','R','I'},
            {'T','H','M','S','A','R'},
            {'E','F','U','N','A','N'},
            {'D','C','O','O','L','P'},
            {'Y','T','H','O','N','R'},
            {'O','C','K','S','P','Y'}
        };
        System.out.print("ALGORITHMSAREFUNANDCOOLPYTHONROCKSPY\n");
        Arr.print2D(outputBoard);
        
        System.out.print("\nYour Output:\n");
        rotateSecret( board );
        Arr.print2D(board);
        
        if( Arr.compare2D(outputBoard, board) ) System.out.print("Test 2 Success");
        else System.out.println("Test 2 FAILED");
    }
}

class Arr {
    public static void print2D(Integer[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void print2D(Character[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static boolean compare2D(Character[][] arr1, Character[][] arr2) {
        if (arr1.length != arr2.length) return false;
        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].length != arr2[i].length) return false;
            
            for (int j = 0; j < arr1[i].length; j++) {
                if (!arr1[i][j].equals(arr2[i][j])) return false;
            }
        }
        return true;
    }
}