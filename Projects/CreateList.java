import java.util.ArrayList;
import java.util.Scanner;

public class CreateList {
	public static void main(String [] args) {
		ArrayList<String> list = new ArrayList<String>();
		MakeList makelist = new MakeList();
		list = makelist.makeList();
		for (int i=0; i<list.size(); i++) {
			System.out.println((i+1) + ". " + list.get(i));
		}


	}
}

class MakeList {
	private String item;
	private boolean prompt = true;

	ArrayList<String> list = new ArrayList<String>();
	Scanner scanner = new Scanner(System.in);

	public void setItem (String i){
		i = i.trim();
			if ((i.equals(null)) || (i.equals(""))) {
				System.out.println("\nNo item name entered!");
				item = "";
			} else {
				item = i;
				prompt = false;
			}

	}

	public String getItem () {
		return item;
	}

	public void setPrompt (String p){
		p = p.toLowerCase().trim();
		if ((p.equals("yes")) || (p.equals("y"))) {
			prompt = true;
		} else if ((p.equals("no")) || (p.equals("n"))){
			prompt = false;
		} else {
			prompt = false;
		}
	}

	public boolean getPrompt(){
		return prompt;
	}

	public ArrayList<String> makeList () {
		while(prompt){
			if (list.size() == 0){
				System.out.println("\nWould you like to create a list? yes/no");
				String myp = scanner.nextLine();
				setPrompt(myp);
			} else {
				System.out.println("\nWould you like to add to your list? yes/no");
				String myp = scanner.nextLine();
				setPrompt(myp);
			}
			if (prompt){
				System.out.println("\nWhat item would you like to add?");
				String i = scanner.nextLine();
				setItem(i);
				if(!(getItem().equals(""))) {
					list.add(getItem());
				} 
				prompt = true;
			}

			if (!prompt) {
				if(list.size() == 0) {
					System.out.println("\nNo list created");
				} else {
					System.out.print("\nSee your list below: \n");
				}
			}
		}

		return list;
	}
}



