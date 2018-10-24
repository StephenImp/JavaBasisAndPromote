反射获取类的三种方式：
1.Class<Reflect> c1 = Reflect.class;
2.Class<Reflect> c2 = (Class<Reflect>) r1.getClass() ;
3.Class<Reflect> c3 = (Class<Reflect>) Class.forName("xxx.xxx");

eg:Reflect

反射的用处

①获取成员方法
public Method getDeclaredMethod(String name,Class<?>...parameterTypes)//得到该类的所有方法，但是不包括父类的方法。
public Method getMethod(String name,Class<?>...parameterTypes)//获得该类的所有public方法，包括父类的。

eg:Person

②获取成员变量
public Field getDeclaredFiled(String name)//获得该类所有的成员变量，但不包括父类的。
public Filed getFiled(String name)//获得该类的所有的public变量，包括其父类的。

③获取构造方法
public Constructor getDeclaredConstructor(Class<?>...parameterTypes)//获取该类的所有构造方法，不包括父类的。
public Constructor getConstructor(Class<?>...parameterTypes)//获取该类的所有public修饰的构造方法，包括父类的。

④通过反射了解集合泛型的本质
eg:GenericEssence
