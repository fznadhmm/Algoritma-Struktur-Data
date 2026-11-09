package StackInfix;

public class CharStack {
    private String[] storage = new String[100];
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(String element) {
        if (size < storage.length) {
            storage[size] = element;
            size++;
        }
    }

    public String pop() {
        if (isEmpty()) {
            return "";
        }
        size--;
        return storage[size];
    }

    public String peek() {
        if (isEmpty()) {
            return "";
        }
        return storage[size - 1];
    }
}