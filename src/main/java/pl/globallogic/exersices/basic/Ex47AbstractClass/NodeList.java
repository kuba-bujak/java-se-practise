package pl.globallogic.exersices.basic.Ex47AbstractClass;

public interface NodeList {
    ListItems getRoot();
    boolean addItem(ListItems listItem);
    boolean removeItem(ListItems listItem);
    void traverse(ListItems listItem);

}
