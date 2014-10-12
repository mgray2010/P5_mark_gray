package Tests;  

import static org.junit.Assert.*;  
import java.util.Iterator;  

import org.junit.Test;  

import FList.MyList;  
import LApp.Entity;  
import LApp.Main;  

public     class   TestCases {
	

	@Test
	public void addNodesToListTest() {
		MyList myList = new MyList();
		Main.addArray(myList, Entity.entArray1);
		boolean pass = true;
		Entity[] ent = Entity.entArray1;
		boolean entityPresent;
		for (Iterator i = myList.iterator(); i.hasNext();) {
			Entity e = (Entity) i.next();
			entityPresent = false;
			for (int j=0; j < ent.length; j++) {
				if (ent[j] == e) {
					entityPresent = true;
				}
			}
			if (!entityPresent) {
				pass = false;
			}
		}
		if (pass) {
			System.out.println("Test: Add nodes to new list - Passed");
		} else {
			fail("Test: Add nodes to new list - Failed");
		}
		
		pass = true;
		Main.addArray(myList, Entity.entArray2);
		ent = Entity.entArray2;
		for (int j=0; j<ent.length; j++) {
			entityPresent = false;
			for (Iterator i = myList.iterator(); i.hasNext();) {
				Entity x = (Entity) i.next();
				if (ent[j] == x) {
					entityPresent = true;
					break;
				}
			}
			if (!entityPresent) {
				pass = false;
			}
		}
		if (pass) {
			System.out.println("Test: Augment list by adding nodes - Passed");
		} else {
			fail("Test: Augment list by adding nodes - Failed");
		}
	}

	
	@Test
	public void removeNodesTest() {
		MyList myList = new MyList();
		Main.addArray(myList, Entity.entArray1);
		Main.addArray(myList, Entity.entArray2);
		Entity[] ent2 = Entity.entArray2;
		for (Iterator i = myList.iterator(); i.hasNext();) {
			Entity x = (Entity) i.next();
			for (int j = 0; j < ent2.length; j++) {
				if (ent2[j] == x) {
					i.remove();
					break;
				}
			}
		}
		myList.print(System.out);
		boolean pass = true;
		boolean entityPresent;
		Entity[] ent = Entity.entArray1;
		for (int j=0; j<ent.length; j++) {
			entityPresent = false;
			for (Iterator i = myList.iterator(); i.hasNext();) {
				Entity x = (Entity) i.next();
				if (ent[j] == x) {
					entityPresent = true;
					break;
				}
			}
			if (!entityPresent) {
				pass = false;
			}
		}
		for (int j=0; j<ent2.length; j++) {
			entityPresent = false;
			for (Iterator i = myList.iterator(); i.hasNext();) {
				Entity x = (Entity) i.next();
				if (ent2[j] == x) {
					entityPresent = true;
					break;
				}
			}
			if (entityPresent) {
				pass = false;
			}
		}
		if (pass) {
			System.out.println("Test: Remove nodes from List - Passed");
		} else {
			fail("Test: Remove nodes from List - Failed");
		}
	}


}
