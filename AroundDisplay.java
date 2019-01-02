package kabirMineSweeper;

public class AroundDisplay {
static int temp[], inverseTemp[];

                                         //today i have completed what i wanted to complete. 
															//now tommorrow i will modify code and make it such that it shows 
															//those that are around 0
//static int alength = 5, abreadth = 5;

	
static void aroundDisplay(int[][] A, int a, int b, int alength, int abreadth) {
	
	
		
	
	firstClass.displayVal[a][b] = 1;
	

	 
	
	  if(((a != 0) && (a != alength-1)) && ((b != 0) && (b != abreadth-1))) {
			//System.out.println("Length = " + alength + " breadth = " + breadth + " a is = " + a + " b is + " + b);

		for(int i = a-1;i <= a+1;i++) {
			for(int j = b-1;j <= b+1;j++) {
				
					
				if((A[i][j] == 0) && (firstClass.displayVal[i][j] == 0)) {
						if(i == a && j == b) {
							firstClass.displayVal[i][j] = 1;
						}else {
						firstClass.displayVal[i][j] = 1;
						aroundDisplay(A, i, j, alength, abreadth);
						}
				}
			}
		}
	}
	
	else if(a == 0 && ((b != 0) && (b != (abreadth-1)))) {
		
		for(int i = a; i <= a+1;i++) {
			for(int j = b-1;j <= b+1;j++) {
				
				
				if((A[i][j] == 0) && (firstClass.displayVal[i][j] == 0)) {
					if(i == a && j == b) {
						firstClass.displayVal[i][j] = 1;
					}else {
					firstClass.displayVal[i][j] = 1;
					aroundDisplay(A, i, j, alength, abreadth);
					}
				}
			}
		}
	}
	
	else if(a == alength-1 && (b != 0 && b!=abreadth-1)) {

		for(int i = a-1;i <= a;i++) {
			for(int j = b-1;j <= b+1;j++) {
				
				if((A[i][j] == 0) && (firstClass.displayVal[i][j] == 0)){
					if(i == a && j == b) {
						firstClass.displayVal[i][j] = 1;
					}else {
					firstClass.displayVal[i][j] = 1;
					aroundDisplay(A, i, j, alength, abreadth);
					}
				}
			}
		}
	}
	
	else if((a != 0) && (a != alength-1) && b==0) {

		for(int i = a-1;i <= a+1;i++) {
			for(int j = b;j <= b+1;j++) {
				
				if(A[i][j] == 0 && firstClass.displayVal[i][j] == 0) {
					if(i == a && j == b) {
						firstClass.displayVal[i][j] = 1;
					}else {
					firstClass.displayVal[i][j] = 1;
					aroundDisplay(A, i, j, alength, abreadth);
					}
				}
			}
		}
	}
	
	else if(((a != 0) && (a != alength-1)) && b== (abreadth-1)) {
			for(int i = a-1;i <= a+1;i++) {
				for(int j = b-1;j <= b;j++) {
					
					if(A[i][j] == 0 && firstClass.displayVal[i][j] == 0) {
						if(i == a && j == b) {
							firstClass.displayVal[i][j] = 1;
						}else {
						firstClass.displayVal[i][j] = 1;
						aroundDisplay(A, i, j, alength, abreadth);
						}
					}
				}
			}
		}
		

			//for the corners..
	 else if(a == 0 && b== 0) {

				for(int i = a;i <= a+1;i++) {
					for(int j = b;j <= b+1;j++) {
						
						if(A[i][j] == 0 && firstClass.displayVal[i][j] == 0) {
							if(i == a && j == b) {
								firstClass.displayVal[i][j] = 1;
							}else {
							firstClass.displayVal[i][j] = 1;
							aroundDisplay(A, i, j, alength, abreadth);
							}
						}
					}
				}
			}
			
			else if((a == 0) && (b == (abreadth-1))) {
				for(int i = a;i <= a+1;i++) {
					for(int j = b-1;j <= b;j++) {
						
						if(A[i][j] == 0 && firstClass.displayVal[i][j] == 0) {
							if(i == a && j == b) {
								firstClass.displayVal[i][j] = 1;
							}else {
							firstClass.displayVal[i][j] = 1;
							aroundDisplay(A, i, j, alength, abreadth);
							}
						}
					}
				}
			}
			
			else if((a == alength-1) && (b== 0)) {

				for(int i = a-1;i <= a;i++) {
					for(int j = b;j <= b+1;j++) {
						if(A[i][j] == 0 && firstClass.displayVal[i][j] == 0) {
							if(i == a && j == b) {
								firstClass.displayVal[i][j] = 1;
							}else {
							firstClass.displayVal[i][j] = 1;
							aroundDisplay(A, i, j, alength, abreadth);
							}
						}
					}
				}
			}
			
		else  if((a == alength-1) && b == (abreadth-1)) {

				for(int i = a-1;i <= a;i++) {
					for(int j = b-1;j <= b;j++) {
						if(A[i][j] == 0 && firstClass.displayVal[i][j] == 0) {
							if(i == a && j == b) {
								firstClass.displayVal[i][j] = 1;
							}else {
							firstClass.displayVal[i][j] = 1;
							aroundDisplay(A, i, j, alength, abreadth);
							}
						}
					}
				}
			}
	 
	
}



public void displayOnAround(int i, int j, int length, int breadth) {
	Boolean bb = false;
	//System.out.println("length is : " + length + "\nBreadth is : " + breadth);
	int count = 0;
	if((i != 0 && i != length-1) && (j != 0 && j != breadth-1)) {
		//System.out.println("here 0");
		//System.out.println("for (" + i + "," + j + ")");
		for(int a = i-1;a <=i+1;a++) {
			for(int b = j-1;b <= j+1;b++) {
				
					firstClass.displayVal[a][b] = 1;
					
			}
			
		}
	}else {
		if(i == 0 && (j != 0 && j != breadth-1)) {
			//System.out.println("here 1");
			//System.out.println("for (" + i + "," + j + ")");
			for(int a = i;a <= i+1;a++) {
				for(int b = j-1;b <= j+1;b++) {
					
						firstClass.displayVal[a][b] = 1;
						
				
				}
			}
		}
		else if(i == (length-1) && (j != 0 && j != breadth-1)) {
			//System.out.println("here 2");
			//System.out.println("for (" + i + "," + j + ")");
			for(int a = i-1;a <= i;a++) {
				for(int b = j-1;b <= j+1;b++) {
					
						firstClass.displayVal[a][b] = 1;
						
				}
			}
		}
		else if(j == 0 && (i != 0 && i != length-1)) {
			//System.out.println("here 3");
			//System.out.println("for (" + i + "," + j + ")");
			for(int a = i-1;a <= i+1;a++) {
				for(int b= j;b <= j+1;b++) {
					
						firstClass.displayVal[a][b] = 1;
										}
			}
		}
		
		else if(j == breadth-1 && (i != 0 && i != breadth-1)) {
			//System.out.println("here 4");
			//System.out.println("for (" + i + "," + j + ")");
			for(int a = i-1;a <= i+1;a++) {
				for(int b = j-1;b <= j;b++) {
					
						firstClass.displayVal[a][b] = 1;
					
				}
			}
		}
		else if(i == 0 && j == 0) {
			//System.out.println("here 5");
			//System.out.println("for (" + i + "," + j + ")");
			for(int a = i;a <= i+1;a++) {
				for(int b = j;b <= j+1;b++) {
					
						firstClass.displayVal[a][b] = 1;
						
				}
					
			}
		}
		else if(i == 0 && j == breadth-1) {
			//System.out.println("here 6");
			//System.out.println("for (" + i + "," + j + ")");
			for(int a = i;a <= i+1;a++) {
				for(int b = j-1;b <= j;b++) {
					
						firstClass.displayVal[a][b] = 1;
						
				
				}
			}
		}
		else if(i == length-1 && j == 0) {
			//System.out.println("here 7");
			//System.out.println("for (" + i + "," + j + ")");
			for(int a = i-1;a <= i;a++) {
				for(int b = j;b <= j+1;b++) {
					
						firstClass.displayVal[a][b] = 1;
				
				
				}
			}
		}
		else if(i == length-1 && j == breadth-1) {
			//System.out.println("here 8");
			//System.out.println("for (" + i + "," + j + ")");
			for(int a = i-1;a <= i;a++) {
				for(int b = j-1;b <= j;b++) {
				
						firstClass.displayVal[a][b] = 1;
					
				
				}
			}
		}
	}
	
}


}
