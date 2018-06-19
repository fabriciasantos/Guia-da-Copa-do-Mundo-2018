package worldcup;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node x, Node y) {
        if (x.getCost() < y.getCost()) {
            return -1;
        }
        if (x.getCost() > y.getCost()) {
            return 1;
        }
        return 0;
    }
}
