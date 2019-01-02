package kabirMineSweeper;
import java.util.Scanner;
public class firstClass {
static Scanner userInput = new Scanner(System.in);
static int length, breadth, mine, free_elements;
static int A[][];
static int displayVal[][];
static int checkForError = 0;static int z = 0;
static int freeChange;
static int tempStoreArray[];
static int row, column;
static AroundDisplay ad = new AroundDisplay(); //this will help me open the surrounding points with value 0
public static void main(String[] args) {
		
			
		System.out.println("Enter the difficulty level : ");
		System.out.println("1. Easy \n2. Medium \n3.Hard ");
		String ans = userInput.next();
		ans = ans.toLowerCase();
		getlbm(ans);
		System.out.println("Length " + length );
		
		
		
		free_elements = length*breadth-mine;
		tempStoreArray = new int[free_elements];
		for(int i = 0;i < free_elements;i++) {
			tempStoreArray[i] = 1000;
		}
		
		
		A = new int[length][breadth];
		displayVal = new int[length][breadth];
		 
		A = getMines(A);
		freeChange = free_elements;
		int i, j;
		
		for(i = 0;i < length;i++) {
			for(j = 0;j< breadth;j++) {
				if(A[i][j] != -1)
					A[i][j] = getMineNumber(A, i, j);
			}
		}
		
		setDisplay();
		generateTheBoard();
		System.out.println("answer key ^ ");
		//repaintTheBoard(0, 0);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		while(getHiddenCount(displayVal, length , breadth) > getMineCount()) {
			System.out.println("\nHidden segments : " + getHiddenCount(displayVal, length, breadth));
			System.out.println("Mines remaining : " + getMineCount());
			//System.out.println(freeChange);
			if(checkForError == 0) {
			System.out.println();
			System.out.println("Enter x and y : ");
			row = userInput.nextInt();
		    column = userInput.nextInt();
			repaintTheBoard(row, column);
			freeChange--;
			
		}else {
			break;
		}
	}	
			System.out.println("\n\n\n");
			System.out.println("End");
			//printTempStoreArray();
		
	}/*
	public static void printTempStoreArray() {
		for(int i = 0;i < tempStoreArray.length;i++)System.out.println("tempStoreArray[" + i + "] : " + tempStoreArray[i]);
	}*/

	private static  int getHiddenCount(int[][] A, int l, int b) {
		int count = 0;
		for(int i = 0;i < l;i++) {
			for(int j = 0;j < b;j++) {
				if(displayVal[i][j] == 0)count++;
			}
		}
		return count;
	}
	
	private static int getMineCount() {
		int count = 0;
		for(int i = 0;i < length;i++) {
			for(int j = 0;j < breadth;j++) {
				if(A[i][j] == -1)count++;
			}
		}
		return count;
	}

	public static void getlbm(String ans) {
		switch(ans) {
		case "easy":
			length = 5;
			breadth = 5;
			mine = 5;
			
			break;
		case "medium":
			length= 8;
			breadth=8;
			mine = 15;
			break;
			
		case "hard":
			length=10;
			breadth=10;
			mine = 25;
			break;
			
		default:
			System.out.println("The fuck you mad or what");
			break;
		}
		
	}
	public static int[][] getMines(int A[][]) {
		int l = length;
		int b = breadth;
		
		while(mine > 0) {
			int arandom = (int)(Math.random()*length);
			int brandom = (int)(Math.random()*breadth);
			
			if( A[arandom][brandom] != -1) {
				A[arandom][brandom] = -1;
				mine--;
			}
			
			
		}
		
		for(int i = 0;i < length;i++) {
			for(int j = 0;j < length;j++) {
				if(A[i][j] != -1)A[i][j] = 0;
			}
		}
		return A;
	}
	
	public static int getMineNumber(int A[][], int i, int j) {
		
	    return nearbyMines(A, i, j);
	}
	
	public static int nearbyMines(int[][] A,int i, int j) {
		int count = 0;
		if((i != 0 && i != length-1) && (j != 0 && j != breadth-1)) {
			for(int a = i-1;a <=i+1;a++) {
				for(int b = j-1;b <= j+1;b++) {
					if(A[a][b] == -1)count++;
				}
			}
		}else {
			if(i == 0 && (j != 0 && j != breadth-1)) {
				for(int a = i;a <= i+1;a++) {
					for(int b = j-1;b <= j+1;b++) {
						if(A[a][b] == -1)count++;
					}
				}
			}
			else if(i == (length-1) && (j != 0 && j != breadth-1)) {
				for(int a = i-1;a <= i;a++) {
					for(int b = j-1;b <= j+1;b++) {
						if(A[a][b] == -1)count++;
					}
				}
			}
			else if(j == 0 && (i != 0 && i != length-1)) {
				for(int a = i-1;a <= i+1;a++) {
					for(int b= j;b <= j+1;b++) {
						if(A[a][b] == -1)count++;
					}
				}
			}
			
			else if(j == breadth-1 && (i != 0 && i != breadth-1)) {
				for(int a = i-1;a <= i+1;a++) {
					for(int b= j-1;b <= j;b++) {
						if(A[a][b] == -1)count++;
					}
				}
			}
			else if(i == 0 && j == 0) {
				for(int a = i;a <= i+1;a++) {
					for(int b = j;b <= j+1;b++) {
						if(A[a][b] == -1)count++;
					}
				}
			}
			else if(i == 0 && j == breadth-1) {
				for(int a = i;a <= i+1;a++) {
					for(int b = j-1;b <= j;b++) {
						if(A[a][b] == -1)count++;
					}
				}
			}
			else if(i == length-1 && j == 0) {
				for(int a = i-1;a <= i;a++) {
					for(int b = j;b <= j+1;b++) {
						if(A[a][b] == -1)count++;
					}
				}
			}
			else if(i == length-1 && j == breadth-1) {
				for(int a = i-1;a <= i;a++) {
					for(int b = j-1;b <= j;b++) {
						if(A[a][b] == -1)count++;
					}
				}
			}
		}
		
		return count;
		
	}
	
	public static void generateTheBoard() {
		for(int x = 0;x < length;x++) {
			for(int y = 0;y < breadth;y++) {
				if(A[x][y] == -1)System.out.print("*" + " ");
				else
				System.out.print(A[x][y] + " ");
			}
			System.out.println();
		}
	}
	
	public static void repaintTheBoard(int ai, int aj) {
		
		if(checkForError == 0) {
		if(A[ai][aj] == -1) {
			System.out.println("Game Over");
			checkForError++;
		}else {
			
			freeChange--;
			tempStoreArray[z] = 10*ai + aj;
			z++;
			/*
			for(int i =0;i<length;i++) {
					System.out.println();
				for(int j = 0;j < breadth;j++) {
					//if(A[i][j] == -1)System.out.print("*" + " ");
				    if(i == ai && j == aj)System.out.print(A[i][j] + " ");
					
				    else if(storedinTemp(10*i+j)) {
						//System.out.println((10*i + j) + " yes");
						System.out.print(A[i][j] + " ");
						//aroundDisplay(i, j);
					}
					else System.out.print("*" + " ");
					
				}
			}
			*/
			

			
			ad.aroundDisplay(A, row, column, length, breadth);
			
			for(int i = 0;i < length;i++) {
				for(int j = 0;j < breadth;j++) {
					if(firstClass.A[i][j] == 0 && firstClass.displayVal[i][j] == 1) {
						ad.displayOnAround(i, j, length, breadth);
					}
				}
			}
			
			for(int i = 0;i < length;i++) {
				System.out.println();
				for(int j = 0;j < breadth;j++) {
					if(displayVal[i][j] == 1) {
						System.out.print(A[i][j] + " ");
						
						
						
					}
					else System.out.print("*" + " ");
				}
			}
			
			/*
			System.out.println();
			for(int i = 0;i < length;i++) {
				System.out.println();
				for(int j = 0;j < breadth;j++) {
					if(A[i][j] != -1) {
						System.out.print(A[i][j] + " ");
						
						
						
					}
					else System.out.print("*" + " ");
				}
			}
		*/
			
			System.out.println();
			/*
			for(int ii = 0;ii < length;ii++) {
				System.out.println();
				for(int jj = 0;jj < breadth;jj++) {
					System.out.print(displayVal[ii][jj] + " ");
				}
			}
			*/
		}
	}
	}
	public static void storeInTemp(int a) {
		tempStoreArray[z] = a;
		z++;
	}
	public static Boolean storedinTemp(int a) {
		Boolean c = false;
		for(int p = 0;p < tempStoreArray.length;p++) {
			if(tempStoreArray[p] == a)c = true;
			
		}
	return c;
	}
	
	
	
	
	public static void setDisplay() {
		for(int i = 0;i < length;i++) {
			for(int j = 0;j < breadth;j++) {
				displayVal[i][j] = 0;
			}
		}
	}	
	
	public static int getLength() {
		return length;
	}
	
	public static int getWidth() {
		return breadth;
	}
	/*
	public static void aroundDisplay(int i , int j) {
		if((i != 0 && i != length-1) && (j != 0 && j != breadth-1)) {
			for(int a = i-1;a <=i+1;a++) {
				for(int b = j-1;b <= j+1;b++) {
					if(A[a][b] == 0) {
					storeInTemp(10*a + b);
					//aroundDisplay for a, b
					aroundDisplay(a, b);
					}
				}
			}
		}else {
			if(i == 0 && (j != 0 && j != breadth-1)) {
				for(int a = i;a <=i+1;a++) {
					for(int b = j-1;b <=j+1;b++) {
						if(A[a][b] == 0) {
							storeInTemp(10*a+b);
						}
							
					}
				}
			}
			
			else if(i == length-1 && (j != 0 && j != breadth)) {
				for(int a = i-1;a <= i;a++) {
					for(int b = j-1;b <=j+1;b++) {
						if(A[a][b] == 0) {
							storeInTemp(10*a + b);
							aroundDisplay(a, b);
						}
					}
				}
			}
			
			else if(j == breadth-1 && (i != 0 && i != length-1)) {
				for(int a = i-1;a <= i+1;a++) {
					for(int b = j-1;b <= j;b++) {
						if(A[a][b] == 0)
							storeInTemp(10*a + b);
					}
				}
			}
			
			else if(j == 0 && (i != 0 && i != length-1)) {
				for(int a = i-1;a <= i+1;a++) {
					for(int b = j;b <= j+1;b++) {
						if(A[a][b] == 0)
							storeInTemp(10*a + b);
					}
				}
			}
			
			else if(i == 0 && j == 0) {
				for(int a = i;a <= i+1;a++) {
					for(int b = j;b <= j+1;b++) {
						if(A[a][b] == 0)
							storeInTemp(10*a + b);
					}
				}
			}
			
			else if( i == 0 && j == breadth-1) {
				for(int a = i;a <= i+1;a++) {
					for(int b = j-1;b <= j;b++) {
						if(A[a][b] == 0)
							storeInTemp(10*a + b);
					}
				}
			}
			
			else if(i == length-1 && j == 0) {
				for(int a = i-1;a <= i;a++) {													//base condition : check only once .. if 0 add to temp.. else add to inverseTemp.. only check for those who are not members of either.
					for(int b = j-1;b <= j;b++) {
						if(A[a][b] == 0)
							storeInTemp(10*a + b);
					}
				}
			}
			
			
			else if(i == length-1 && j == breadth-1) {
				for(int a = i-1;a <= i;a++) {
					for(int b = j-1;b <= j;b++) {
						if(A[a][b] == 0)
							storeInTemp(10*a + b);
					}
				}
			}
		}
	}*/
	
}
