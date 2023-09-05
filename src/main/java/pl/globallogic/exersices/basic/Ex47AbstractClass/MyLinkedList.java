package pl.globallogic.exersices.basic.Ex47AbstractClass;

public class MyLinkedList implements NodeList{
    private ListItems root;

    public MyLinkedList(ListItems root) {
        this.root = root;
    }

    public ListItems getRoot() {
        return root;
    }

    public boolean addItem(ListItems newItem) {
        if (newItem == null) {
            return false;
        }

        if (root == null) {
            root = newItem;
            return true;
        }

        ListItems currentItem = root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison == 0) {
                return false;
            } else if (comparison < 0) {
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    currentItem.setNext(newItem);
                    return true;
                }
            } else {
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                } else {
                    newItem.setNext(root);
                    root.setPrevious(newItem);
                    root = newItem;
                }
                return true;
            }
        }
        return false;
    }

    public boolean removeItem(ListItems item) {
        if (item == null) {
            return false;
        }

        ListItems currentItem = root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                if (currentItem == root) {
                    root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0) {
                currentItem = currentItem.next();

            } else {
                return false;
            }
        }
        return false;
    }

    public void traverse(ListItems root) {
        if (root != null) {
            System.out.println("The list is empty");
        } else {
            ListItems currentItem = root;
            while (currentItem != null) {
                System.out.println(currentItem.getValue());
                currentItem = currentItem.next();
            }
        }
    }
}
