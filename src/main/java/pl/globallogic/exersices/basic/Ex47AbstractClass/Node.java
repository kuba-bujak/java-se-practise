package pl.globallogic.exersices.basic.Ex47AbstractClass;

public class Node extends ListItems {

    public Node(Object object) {
        super(object);
    }

    @Override
    ListItems next() {
        return this.rightLink;
    }

    @Override
    ListItems setNext(ListItems item) {
        this.rightLink = item;
        return this.rightLink;
    }

    @Override
    ListItems previous() {
        return this.leftLink;
    }

    @Override
    ListItems setPrevious(ListItems item) {
        this.leftLink = item;
        return this.leftLink;
    }

    @Override
    int compareTo(ListItems item) {
        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        }
        return -1;
    }
}
