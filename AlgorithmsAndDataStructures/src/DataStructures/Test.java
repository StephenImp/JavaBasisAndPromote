package DataStructures;

/**
 * Created by MOZi on 2018/12/1.
 */
public class Test {

    public static void main(String[] args)

    {
        Float score = new Float(69);

            String level;
            if (score >= 90) {
                level ="A";
            } else if (score >=80 ) {
                level ="B";
            } else if (score >= 70) {
                level ="C";
            }else {
                level ="D";
            }

        System.out.println(level);

    }

}
