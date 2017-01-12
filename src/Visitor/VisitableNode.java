package Visitor;

import com.scalified.tree.multinode.ArrayMultiTreeNode;

/**
 * Created by a on 12/01/17.
 */
public class VisitableNode<T> extends ArrayMultiTreeNode<T> implements Visitable {

    public VisitableNode(T data) {
        super(data);
    }

    @Override
    public String accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
