package day03.utils;

public class Pair<T> {
    private T item1;
    private T item2;

    public Pair(T item1, T item2){
        this.item1 = item1;
        this.item2 = item2;
    }

    public T getItem1() {
        return item1;
    }

    public T getItem2() {
        return item2;
    }
}
