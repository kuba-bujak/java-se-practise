package pl.globallogic.exersices.basic.Ex47AbstractClass;

public abstract class ListItems {
    protected ListItems rightLink = null;
    protected ListItems leftLink = null;
    protected Object value;

    public ListItems(Object object) {
        this.value = object;
    }

    abstract ListItems next();
    abstract ListItems setNext(ListItems item);
    abstract ListItems previous();
    abstract ListItems setPrevious(ListItems item);
    abstract int compareTo(ListItems item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
