package ApA4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;

public class Q1 {
//	You wanted to open a library, so you have bought N books and K racks (having N/K
//	slots). All these books are currently just lying on the floor. Fortunately, you 
//	have the titles,
//	ISBNs, and barcodes of the books on the bills you have received. You want to now arrange
//	these books on the racks based on the book titles, just like words in the pages of a
//	dictionary.
//	However, sometimes, the titles of the books may match; you plan to use their ISBN for
//	sorting in such cases. If ISBNs also match, you think of using their barcodes. Write a
//	program to create the required data from the bills you have, sort the data as you 
//	have planned,
//	and identify the appropriate slot for any book you pick from the floor for placing 
//	it as per the
//	plan.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hi,Let's open a library\n");
		System.out.println("Enter the number of books(n) : \n");
		int n = sc.nextInt();
		System.out.println("Enter the number of racks(k)(should be a multiple of n) : \n");
		int k = sc.nextInt();
		int slots = n/k;
		int[][] unsorted = new int[n][3];
		System.out.println("Now enter data for these "+ n + " books : \n");
		ArrayList<library<String,Integer,Integer>> unsortedlib = new ArrayList<library<String,Integer,Integer>>();
		for(int i =0;i<n;i++){
			String title ;
			Integer isbn;
			Integer barcode;
			//library<String> o2 = new library(title,isbn,barcode);
			System.out.println("Enter the title of book : \n");
			title = sc.nextLine ();
			title = sc.nextLine ();
			System.out.println("Enter the ISBN of this book : \n");
			isbn = sc.nextInt();
			System.out.println("Enter the barcode of this book: \n");
			barcode = sc.nextInt();
			
			library<String,Integer,Integer> o1 = new library(title,isbn,barcode);
			unsortedlib.add(o1);
			//System.out.println(unsortedlib.size());
			//System.out.println(unsortedlib);
			
		}Collections.sort(unsortedlib, new titlesort()
                .thenComparing(new isbnsort())
                .thenComparing(new barcodesort()));
		//System.out.println(unsortedlib.size());
		System.out.println("Books sorted :)");
		while(true) {
			System.out.println("1. search for a book \n 2. Print all books ");
			int s = sc.nextInt();
			if(s==1) {
				System.out.println("Enter title : ");
				String tt = sc.nextLine();
				 tt = sc.nextLine();
				 int kcheck = 0 ;
				 int slotc = 1;
				 for(int i =0;i<n;i++) {
					 library<String,Integer,Integer> print = unsortedlib.get(i);
						if(tt.equals(print.gettitle())) {
							System.out.println("[ "+ print.gettitle()+" "+ print.getisbn()+" "+
									print.getbarcode()+ " ]\n");
							System.out.println("Book is in slot "+ slotc + " of rack "+ kcheck);
						}
						kcheck++;
						if(kcheck==k) {
							slotc++;
							kcheck=kcheck-k;
						}
					}
				 
				
			}
			if(s==2) {
				int kcheck = 0 ;
				int slotc = 1;
				for(int i =0;i<n;i++) {
					
					if(kcheck==0) {
						System.out.println("Books in slot " + slotc + " ");
					}
					library<String,Integer,Integer> print = unsortedlib.get(i);
					System.out.println("[ "+ print.gettitle()+" "+ print.getisbn()+" "+
					print.getbarcode()+ " ]\n");
					kcheck++;
					if(kcheck==k) {
						slotc++;
						kcheck=kcheck-k;
					}
				}
			}
		}
		
		
		

	}

}
 class titlesort implements Comparator<library<String,Integer,Integer>> {
    public int compare(library<String,Integer,Integer> o1, library<String,Integer,Integer> o2) {
        return o1.gettitle().compareTo(o2.gettitle());
    }
}
 
 class isbnsort implements Comparator<library<String,Integer,Integer>> {
    public int compare(library<String,Integer,Integer> o1, library<String,Integer,Integer> o2) {
        return o1.getisbn().compareTo(o2.getisbn());
    }
}
 
 class barcodesort implements Comparator<library<String,Integer,Integer>> {
    public int compare(library<String,Integer,Integer> o1, library<String,Integer,Integer> o2) {
    	return o1.getbarcode().compareTo(o2.getbarcode());
    }
}
 class library<T,U,V>{
	 private T title;
	 private U ISBN;
	 private V barcode;
	 
	 public library(T title,U ISBN,V barcode) {
		 this.title = title;
		 this.ISBN = ISBN;
		 this.barcode = barcode;
		 
	 }

	public V getbarcode() {
		return this.barcode;
	}

	public U getisbn() {
		return this.ISBN;
	}

	public T gettitle() {
		return this.title;
	}	
}
