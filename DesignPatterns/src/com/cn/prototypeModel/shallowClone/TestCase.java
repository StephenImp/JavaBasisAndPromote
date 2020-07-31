package com.cn.prototypeModel.shallowClone;

import java.util.ArrayList;
import java.util.List;

public class TestCase {

    /**
     * hobbies的引用地址是相同的，意味着复制的不是值，而是引用的地址。这
     * 样的话，如果我们修改任意一个对象的属性值，
     * 则 concretePrototype 和 concretePrototypeClone的hobbies值都会改变，这就是我们常说的浅克隆。
     * 浅克隆只是完整复制了值类型数据，没有赋值引用对象。换言之，所有的引用对象仍然指向原来的对象，
     * 显然这不是我们想要的结果
     * @param args
     */
    public static void main(String[] args) {

        //创建一个具体的需要克隆的对象
        ConcretePrototypeA concretePrototypeA = new ConcretePrototypeA();
        //填充属性，方便测试
        concretePrototypeA.setAge(18);
        concretePrototypeA.setName("prototype");
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        concretePrototypeA.setHobbies(list);
        System.out.println(concretePrototypeA);
        System.out.println();

        //创建Client对象，准备开始克隆
        Client client = new Client(concretePrototypeA);
        ConcretePrototypeA copyConcretePrototypeA = (ConcretePrototypeA) client.startClone(concretePrototypeA);
        System.out.println(copyConcretePrototypeA);

        System.out.println("克隆对象中的引用类型地址值:"+copyConcretePrototypeA.getHobbies());
        System.out.println("原对象中的引用类型地址值:"+concretePrototypeA.getHobbies());
        System.out.println("对象地址比较:"+(copyConcretePrototypeA.getHobbies()==concretePrototypeA.getHobbies()));

    }

}
