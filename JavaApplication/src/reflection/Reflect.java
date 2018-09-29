package reflection;

/**
 * Created by admin on 2018/6/14.
 */
public class Reflect {

    public static void main(String[] args) {

        Class<Reflect> c1 = Reflect.class;
        System.out.println(c1.getName());

        Reflect r1 = new Reflect() ;
        Class<Reflect> c2 = (Class<Reflect>) r1.getClass() ;
        System.out.println(c2.getName());

        try {
            Class<Reflect> c3 = (Class<Reflect>) Class.forName("reflection.Reflect");
            System.out.println(c3.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
