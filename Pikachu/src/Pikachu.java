import java.util.ArrayList;

public class Pikachu {

	public static void main(String[] args) {
		System.out.println("   Pikachu welcomes you to the world of Pokemon!");
		System.out.println("             (\\__/)");
		System.out.println("             (o^-^)");
		System.out.println("           z(_(\")(\")");
	}
/*	Traveler[] party1 = {frodo, sam, gimli};
	for (int i = 0; i < party1.length; i++) {
		party1[i].travel(50);
		System.out.println(party1[i].getName() + " has traveled " + party1[i].getDistanceTraveled() + " miles.");
	}
	
	System.out.println();
	System.out.println("\n\n\nPART 2:  \n");

	String[] dwarfNames = {"Fili", "Kili", "Dori", "Ori", "Nori", "Balin", "Dwalin", 
			               "Oin", "Gloin", "Bifur", "Bofur", "Bombur", "Thorin"};

	// Make a new ArrayList to hold a 2nd party of Travelers called party2:
	ArrayList<Traveler> party2 = new ArrayList<Traveler>();
	
	// Call the createParty method and pass it party2 and the dwarfNames array.
	createParty(party2, dwarfNames);
	
	// Finally, call the allTravel method passing it party2 and 100 (representing
	// the 100 miles that party2 has traveled together.  
	allTravel(party2, 100);	
			
}


// The createParty method accepts an ArrayList of Travelers and a String[] of 
// dwarf names. This method will always add a new Hobbit named "Bilbo" and a      
// new Wizard named "Gandalf" whose color is "Grey" to the ArrayList.
// Then it uses a loop to add all the dwarves from the String array to the party.
public static void createParty(ArrayList<Traveler> party, String[] dwarfNames)
{	
	party.add(new Hobbit("Bilbo"));
	party.add(new Wizard("Gandalf", "Grey"));
	for (int i = 0; i < dwarfNames.length; i++) {
		party.add(new Dwarf(dwarfNames[i]));
	}
}

// The allTravel method accepts an ArrayList of Travelers and an integer number 
// of miles to travel, then builds and returns a String reporting how far each 
// member of party has gone. builds a String that says how far each member of the 
// party has traveled.
//Ex.  Bilbo has traveled 100 miles
//     Gandalf the grey has traveled 300 miles
//     fili has traveled 100 miles
//     kili has traveled 100 miles
public static String allTravel(ArrayList<Traveler> party, int miles)
{
	String result = "";
	for (int i = 0; i < party.size(); i++) {
		party.get(i).travel(miles);
		result += party.get(i) + " has traveled " + party.get(i).getDistanceTraveled() + " miles\n";
	}
	return result;
}
}
*/
}
