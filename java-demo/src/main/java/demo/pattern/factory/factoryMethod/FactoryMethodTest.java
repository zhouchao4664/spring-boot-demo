package demo.pattern.factory.factoryMethod;

import demo.pattern.factory.ICourse;

/**
 * 2019/3/13
 * zhouchao
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        ICourseFactory courseFactory = new JavaCourseFactory();
        ICourse course = courseFactory.create();
        course.record();
    }
}
