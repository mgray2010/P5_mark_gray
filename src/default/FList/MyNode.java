package FList;  

import LApp.Entity;  

public     class   MyNode {
	

    Entity elem;

	
    MyNode right;

	
	
	public MyNode  (Entity elem) {
        this.elem = elem;
        right = null;
    
		left = null;
	
		deleted = false;
	}

	

    public String toString() {
        return elem.toString();
    }

	
	
	MyNode left;

	
	boolean deleted;


}
