package notifyObservers.demo;

public class TestThread {

    public static void main(String[] args){
        SimpleObservable doc = new SimpleObservable ();
        SimpleObserver view = new SimpleObserver (doc);
        doc.setData(1);
        doc.setData(2);
        doc.setData(5);
        doc.setData(3);
    }
}
