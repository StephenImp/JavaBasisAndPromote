package enumExercise.case8;

import enumExercise.case2.ErrorCodeEn;

import java.util.EnumSet;

/**
 * EnumSet 是枚举类型的高性能 Set 实现。
 * 它要求放入它的枚举常量必须属于同一枚举类型。
 */
public class EnumSetDemo {

    public static void main(String[] args) {
        System.out.println("EnumSet展示");
        EnumSet<ErrorCodeEn> errSet = EnumSet.allOf(ErrorCodeEn.class);
        for (ErrorCodeEn e : errSet) {
            System.out.println(e.name() + " : " + e.ordinal());
        }
    }
}
