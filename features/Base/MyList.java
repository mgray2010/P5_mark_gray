import java.io.PrintStream;
import src.javaEntity;
import java.util.Iterator;

public class MyList implements Iterable {

    MyNode head;

    public MyList() {
        head = null;
    }

    public void insert(Entity elem) {
        insert(new MyNode(elem));
    }

    void insert(MyNode n) {
        n.right = head;
        head = n;
        n.left = null;
        if (n.right != null) {
            n.right.left = n;
        }
    }

    public Iterator iterator() {
        return new MyIterator(this);
    }

    public void print(PrintStream out) {
        for (Iterator eIterator = iterator(); 
		eIterator.hasNext();) {
            Entity e = (Entity) eIterator.next();
            out.println(e);
        }
    }
}
