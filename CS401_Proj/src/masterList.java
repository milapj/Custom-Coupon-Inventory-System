
public class masterList {
	//Declare the Master List Array.
	public String mainArray[];
	int numElements = 0;
	public masterList() {
		mainArray = new String[40]; //Constructor with default size.
	}

	public masterList(int size) {
		mainArray = new String[size]; //Constructor with user input size.		
	}

	public boolean add(String d) { //Method to add elements into the list.
		mainArray[numElements] = d;
		numElements ++;
		return true;
	}
}
