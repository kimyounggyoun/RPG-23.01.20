package _RPG;

import java.util.ArrayList;

public class Element_List {
	
	ArrayList<Element> elementlist = new ArrayList<Element>();

	static Element_List eList = new Element_List();

	void Element_List() {
		elementlist.add(new Water());
		elementlist.add(new Ground());
		elementlist.add(new Air());
	}
}
