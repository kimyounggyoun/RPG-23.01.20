package _RPG;

import java.util.ArrayList;

public class Element_List {
	
	ArrayList<Element> elementlist = new ArrayList<Element>();

	static Element_List instance = new Element_List();
	 Element_List(){
		 init();
	 }
	void init() {
		elementlist.add(new Water());
		elementlist.add(new Ground());
		elementlist.add(new Air());
	}
}
