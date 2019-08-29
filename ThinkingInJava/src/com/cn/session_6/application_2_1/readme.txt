继承：
     先打印父类构造器，再打印子类构造器，再打印子孙类构造器



                                  session5-application_4-expand                expand

Art的静态代码块                   静态变量b=1                                     A
Drawing的静态代码块               静态代码块被执行！                              B
Cartoon的静态代码块               实例变量a=1                                     C
Art的代码块                       代码块执行！
Art constructor                   构造方法执行！
Drawing的代码块                   display()A被调用!
Drawing constructor
Cartoon的代码块
Cartoon constructor
Cartoon的display()方法!

①：被子类重写的方法，只执行重写的方法，不执行父类被重写的方法。即不执行父类A方法，只执行子类A方法。
②：父类的静态代码，构造代码块，无参（带参）构造方法在子类执行时都要执行。
注意：执行完静态代码块之后，先执行完父类的代码块和构造器，再执行衍生类的代码块和构造器。
