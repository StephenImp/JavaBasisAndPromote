package threadLocal.demo3;

public class Student {

	private int age = 0; // 年龄

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + "]";
	}

}
