package enumExercise.case5;

import enumExercise.case3.INumberEnum;

/**
 * 组织枚举
 * 可以将类型相近的枚举通过接口或类组织起来。
 *
 * 但是一般用接口方式进行组织。
 *
 * 原因是：Java接口在编译时会自动为enum类型加上public static修饰符；
 *         Java类在编译时会自动为 enum 类型加上static修饰符。
 *
 * 看出差异了吗？没错，就是说，在类中组织 enum，如果你不给它修饰为 public，那么只能在本包中进行访问。
 */
public interface Plant {

    enum Vegetable implements INumberEnum {
        POTATO(0, "土豆"),
        TOMATO(0, "西红柿");

        Vegetable(int number, String description) {
            this.code = number;
            this.description = description;
        }

        private int code;
        private String description;

        @Override
        public int getCode() {
            return 0;
        }

        @Override
        public String getDescription() {
            return null;
        }
    }

    enum Fruit implements INumberEnum {
        APPLE(0, "苹果"),
        ORANGE(0, "桔子"),
        BANANA(0, "香蕉");

        Fruit(int number, String description) {
            this.code = number;
            this.description = description;
        }

        private int code;
        private String description;

        @Override
        public int getCode() {
            return 0;
        }

        @Override
        public String getDescription() {
            return null;
        }
    }
}
