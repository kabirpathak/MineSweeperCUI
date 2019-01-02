package kabirMineSweeper;

public class User {
static int displayVal[][] = new int[5][5];
static int a[][] = new int[5][5];
	public static void main(String[] args) {
		
		
		
		for(int i = 0;i < 5;i ++) {
			for(int j= 0;j < 5;j++) {
				a[i][j] = (int)(Math.random()*3);
				displayVal[i][j] = 0;
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		AroundDisplay ab = new AroundDisplay();//ab.initialDisplayVal();
		ab.aroundDisplay(a, 2, 2, 5, 5);
		displayDisplay();
	}
	
	public static void displayDisplay() {
		for(int i=0;i < 5;i++) {
			System.out.println();
			for(int j = 0;j < 5;j++) {
				System.out.print(displayVal[i][j]);
			}
		}
	}
}
