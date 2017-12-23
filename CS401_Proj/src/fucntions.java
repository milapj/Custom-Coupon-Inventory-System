import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.io.File;

// Class with all the functions
public class fucntions {
	masterList list = new masterList();
	int elements = 0;
	// This method reads the data from the text file and adds it to the master list, thus creating a unsorted master list.
	public void read() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("/Users/Milap/Desktop/emp.txt"));
			String str;
			try {
				while((str = in.readLine()) != null) {
				list.add(str);
				elements ++;
				}
			}
			catch (IOException e) {
				System.out.println("ERROR");
			}
		}
		catch( FileNotFoundException ex) {
			System.out.println("File NOt FOund");
		}
	}
	//Outputs the elements of the unsorted master list.
	public void print() {
		
		int i =0;
		while(i < elements) {
			System.out.println(list.mainArray[i]);
			i++;
		}
	}
	//Method for the user to add coupon to the master list manually. This method stores the coupon in the text file as well.
	public void write(String d) throws IOException {
		String temp = "/Users/Milap/Desktop/emp.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(temp,true));
	    writer.write(d);
	    writer.newLine();
	    writer.close();
	}
	//This method sorts the unsorted master list using Bubble Sort Algorithm.
	public void sortList() {
		for(int i = 0; i<elements;i++) {
			for (int j = 0;j<elements;j++) {
				if (j == elements - 1) {
					break;
				}
				String[] temp = list.mainArray[j].split("\\s+");
				String[] temp1 = list.mainArray[j+1].split("\\s+");				
				String tempo1 = list.mainArray[j];
				String tempo2 = list.mainArray[j+1];
				if (Integer.parseInt(temp[1]) > Integer.parseInt(temp1[1])) {
					list.mainArray[j] = tempo2;
					list.mainArray[j+1] = tempo1;
				}
			}
		}
	}
	// Linear Search method
	public String linearSearch(String name, String id) {
		boolean found = false;
		int count = 0;
		for (int i = 0; i<elements;i++) {
			String tmp[] = list.mainArray[i].split("\\s+");
			if (tmp[0].equals(name) && tmp[1].equals(id)) {
				found = true;
				count = i;
			}
		}
		if (found) {
				return "Coupon Found: " + count + " By Linear Search";
		}
		else {
				return "Coupon Not Found";
		}
	}
	//Binary Search Method;
	public String binarySearch(String name, String id) {
		boolean found = false;
		int count = 0;
		String x = list.mainArray[elements/2];
		String[] tmp_1 = x.split("\\s+");
		int y = Integer.parseInt(tmp_1[1]);
		System.out.println(y);
		if (Integer.parseInt(id) > y) {
			for (int i = elements/2; i<elements;i++) {
				String tmp[] = list.mainArray[i].split("\\s+");
				if (tmp[0].equals(name) && tmp[1].equals(id)) {
					found = true;
					count = i- elements/2;
				}
			}
		}
		if (Integer.parseInt(id) < y) {
			for (int i = 0; i<elements/2;i++){
				String tmp[] = list.mainArray[i].split("\\s+");
				if (tmp[0].equals(name) && tmp[1].equals(id)) {
					found = true;
					count = i;
				}
			}
		}
		if (found) {
			return "Coupon Found: " + count + " By Binary Search";
		}
		else {
			return "Coupon Not Found " + count;
		}
	}
	
	public String[] sendArray() {
		return list.mainArray;
	}
	//Method to sort the master list according to prices from low to high.
	public void listPriceL2H() {
		String[] one;
		String[] two;
		String tmp_2;
		String tmp_3;
		int x,y,a,b;
		int xy;
		int ab;
		for (int i = 0; i<elements;i++) {
			for (int j=0;j<elements;j++) {
				if (j == elements - 1) {
					break;
				}
				one = list.mainArray[j].split("\\s+");
				two = list.mainArray[j+1].split("\\s+");
				tmp_2 = list.mainArray[j];
				tmp_3 = list.mainArray[j+1];
				x = Integer.parseInt(one[3]);
				y = Integer.parseInt(one[4]);
				a = Integer.parseInt(two[3]);
				b = Integer.parseInt(two[4]);
				xy = x -((x*y)/100);
				ab = a - ((a*b)/100);
				if (xy > ab) {
					list.mainArray[j] = tmp_3;
					list.mainArray[j+1] = tmp_2;
					//list.mainArray[j+1].replace((list.mainArray[j+1].split("\\s+"))[3],String.valueOf(ab));
				} 
 			}
 			one = list.mainArray[i].split("\\s+");
			x = Integer.parseInt(one[3]);
			y = Integer.parseInt(one[4]);
			xy = x -((x*y)/100);	
 			//list.mainArray[i].replace((list.mainArray[i].split("\\s+"))[3],String.valueOf(xy));
 			list.mainArray[i] = list.mainArray[i] +" DiscountedRate: " + String.valueOf(xy);
 			
		}
	}
	// Method to sort the master list according to the expiry dates of the coupon.
	public void ExpirtySort() {
		String one[];
		String two[];
		String tmp_1;
		String tmp_2;
		for (int i = 0; i<elements;i++) {
			for (int j =0; j<elements;j++) {
				if (j == elements - 1) {
					break;
				}
				one = list.mainArray[j].split("\\s+");
				two = list.mainArray[j+1].split("\\s+");
				tmp_1 = list.mainArray[j];
				tmp_2 = list.mainArray[j+1];
				int x = Integer.parseInt(one[5]);
				int y = Integer.parseInt(two[5]);
				if (x > y) {
					list.mainArray[j] = tmp_2;
					list.mainArray[j+1] = tmp_1;
				}
				
			}
		}
	}
}
