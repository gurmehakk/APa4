package ApA4;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;



public class Q2 {
	static HashMap<String,colour> cdata =new HashMap<>();
	static HashMap<String,greyscale> gdata =new HashMap<>();
//	An image is a matrix of pixels. You must have seen two types of images: color and
//	grayscale. A color image pixel has three colors: Red, Green, and Blue, but a grayscale image
//	pixel has only one color: Gray. Regardless of the image type, a color always has an 8-bit
//	integer value (0-255) associated with it. You need to implement a program that can input,
//	create, update and display the images (matrices). It should be able to compute their negatives
//	(matrices) as well. NOTE: You need to generalize the computation of negatives, for we only
//	need to subtract the color values from 255, regardless of the image type.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println(" 1. Input matrix 2. Create matrix \n 3. Update matrix\n 4. Display matrix\n 5. Compute negatives\n");
		int inp = sc.nextInt();
		if(inp ==1) {
			System.out.println("Enter name of image: \n");
			String iname = sc.next();
			System.out.println("Enter type of image :\n ");
			System.out.println("1.Coloured 2. Greyscale \n");
			int type = sc.nextInt();
			System.out.println("Enter size of image (A x B) : ");
			int row = sc.nextInt();
			int col = sc.nextInt();
			if(type == 1) {
				int[] rgb = new int[3];
				int[][][] arr = new int[3][row][col];
				
				System.out.println("Enter pixel values in format [r g b] : ");
				for (int i=0; i < arr.length; i++){
		              for (int j=0; j < arr[i].length; j++){
		                  for (int k=0; k < arr[i][j].length; k++) {
		                	  arr[i][j][k] = sc.nextInt();
		                	 }
		                  } System.out.println("again"); 
		              }System.out.println("done\n");
//				for(int i=0;i<row;i++) {
//					for(int j=0;j<col;j++) {
//						int r = sc.nextint();
//						int g = sc.nextint();
//						int b = sc.nextint();
//						rgb[0] = r;
//						rgb[1] = g;
//						rgb[2] = b;
//						arr[i][j] = rgb;
//					}System.out.println("again");
//				}System.out.println("done\n");
				colour c = new colour(row,col,arr);
				cdata.put(iname,c);
//				for (int i=0; i < arr.length; i++){
//		              for (int j=0; j < arr[i].length; j++){
//		                  for (int k=0; k < arr[i][j].length; k++) {
//		                	  System.out.println(arr[i][j][k]);}
//		                  }  
//		              }
			}if(type==2) {
				System.out.println("Enter pixel values : ");
				int[][] garr = new int[row][col];
				for(int i=0;i<row;i++) {
					for(int j=0;j<col;j++) {
						garr[i][j] = sc.nextInt();
					}
				}System.out.println("done\n");
				greyscale g = new greyscale(row,col,garr);
				gdata.put(iname,g);
				
			}
		}if(inp==2) {
			System.out.println("we create a random image matrix for u : ");
			System.out.println("Enter name of image u want : \n");
			String iname = sc.next();
			System.out.println("Enter type of image u want :\n ");
			System.out.println("1.Coloured 2. Greyscale \n");
			int type = sc.nextInt();
			System.out.println("Enter size of image (A x B) : ");
			int row = sc.nextInt();
			int col = sc.nextInt();
			if(type == 1) {
				int[] rgb = new int[3];
				int[][][] arr = new int[3][row][col];
				Random random = new Random();
				System.out.println("Creating \n");
				for(int i=0;i<row;i++) {
					for(int j=0;j<col;j++) {
					    int r =(int) ((Math.random() * (255 - 0)) + 0);
						int g = (int)random.nextInt(256);
						int b = (int)random.nextInt(256);
						rgb[0] = r;
						rgb[1] = g;
						rgb[2] = b;
						arr[i][j] = rgb;
					}
				}System.out.println("done\n");
				colour c = new colour(row,col,arr);
				cdata.put(iname,c);
				
				for (int i=0; i < arr.length; i++){
		              for (int j=0; j < arr[i].length; j++){
		                  for (int k=0; k < arr[i][j].length; k++) {
		                	  System.out.println(arr[i][j][k]);}
		                  }  
		              }
			}if(type==2) {
				System.out.println("creating \n ");
				int[][] garr = new int[row][col];
				Random random = new Random();
				for(int i=0;i<row;i++) {
					for(int j=0;j<col;j++) {
						garr[i][j] = (int)random.nextInt(256);
					}
				}System.out.println("done\n");
				greyscale g = new greyscale(row,col,garr);
				gdata.put(iname,g);
				
			}
			
		}if(inp==3) {
			System.out.println("Enter name of image to modify : \n");
			String iname = sc.next();
			if(cdata.containsKey(iname)) {
				colour p = cdata.get(iname);
				int[][][] mod = p.getarr();
				System.out.println("Enter pixel values in format [r g b] : ");
				for (int i=0; i < mod.length; i++){
		              for (int j=0; j < mod[i].length; j++){
		                  for (int k=0; k < mod[i][j].length; k++) {
		                	  mod[i][j][k] = sc.nextInt();
		                	 }
		                  } System.out.println("again"); 
		              }System.out.println("done\n");
		              colour c = new colour(p.getrow(),p.getcol(),mod);
						cdata.replace(iname,c);
		}if(gdata.containsKey(iname)) {
			greyscale p = gdata.get(iname);
			int[][] garr = p.getarr();
			for(int i=0;i<p.getrow();i++) {
				for(int j=0;j<p.getcol();j++) {
					garr[i][j] = sc.nextInt();
				}
			}System.out.println("done\n");
			greyscale g = new greyscale(p.getrow(),p.getcol(),garr);
			gdata.replace(iname,g);
		}
		}if(inp==4) {
			System.out.println("Enter name of image to display : \n");
			String iname = sc.next();
			if(cdata.containsKey(iname)) {
				colour p = cdata.get(iname);
				int[][][] print = p.getarr();
				for (int a = 0; a<3; a++){
		              for (int b = 0; b<p.getrow(); b++){
		                  for (int j = 0; j<p.getcol(); j++){
		                	  System.out.print(print[a][b][j]);
		                      }System.out.print("  ");
		                  }System.out.println();  
		              }
			}if(gdata.containsKey(iname)) {
				greyscale p = gdata.get(iname);
				int[][] print = p.getarr();
		              for (int b = 0; b<p.getrow(); b++){
		                  for (int j = 0; j<p.getcol(); j++){
		                	  System.out.print(print[b][j]);
		                      }System.out.print("  ");
		                  }System.out.println();  
		              }
			
			
		}if(inp==5) {
			System.out.println("Enter name of image to create and display negatives : \n");
			String iname = sc.next();
			int flag = 0;
			if(cdata.containsKey(iname)) {
				flag = 1;
				colour p = cdata.get(iname);
				int[][][] neg = p.getarr();
				negation<String,int[][][]> n = new negation<String, int[][][]>(iname , neg );
				n.negate(neg, p.getrow(),p.getcol(),flag);
				
			}if(gdata.containsKey(iname)) {
				flag = 2;
				greyscale g = gdata.get(iname);
				int[][] neg = g.getarr();
				negation<String,int[][]> n = new negation<String, int[][]>(iname , neg );
				n.negate(neg, g.getrow(),g.getcol(),flag);
				
				
			}
		}

	 }
	}

}
class colour{

	
	private int row;
	private int col;
	private int[][][] arr;

	public colour(int row, int col, int[][][] arr) {
		this.row = row;
		this.col = col;
		this.arr = arr;
	}
	public int[][][] getarr(){
		return this.arr;
	}
	public int getrow() {
		return row;
	}
	public int getcol() {
		return col;
	}
}
class greyscale{

	private int row;
	private int col;
	private int[][] garr;

	public greyscale(int row, int col, int[][] garr) {
		this.row = row;
		this.col= col;
		this.garr = garr;
	}

	public int getcol() {
		// TODO Auto-generated method stub
		return this.col;
	}

	public int getrow() {
		// TODO Auto-generated method stub
		return this.row;
	}

	public int[][] getarr() {
		// TODO Auto-generated method stub
		return this.garr;
	}
	
}
class negation<T,U>{
	T o1; 
    U o2;
    
    negation(T o1, U o2)
    {
        this.o1 = o1;
        this.o2 = o2;
    }
    public int negval(int a) {
    	return (int) (255-a);
    }
    void negate(U o2,int row,int col,int flag) {
    	if(flag==1) {
    		negcolour((int[][][]) o2, row, col);
    	}if(flag==2) {
    		neggrey((int[][]) o2, row, col);
    	}
    	
    	
    }
    
    
	public void neggrey(int[][] neg, int row, int col) {
		 for(int i=0;i<row;i++) {
				for(int j=0;j<col;j++) {
					neg[i][j]= negval(neg[i][j]);
					System.out.print(neg[i][j]);
				}System.out.println();
			}
		
		
	}
	public void negcolour(int[][][] neg, int row, int col) {
		for (int a = 0; a<3; a++){
            for (int b = 0; b<row; b++){
                for (int j = 0; j<col; j++){
                	neg[a][b][j] = negval(neg[a][b][j]);
              	  System.out.print(neg[a][b][j]);
                    }System.out.print("  ");
                }System.out.println();  
            }
		
	}
    
    
    
    
}




 