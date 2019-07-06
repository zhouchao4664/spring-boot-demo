package demo.pattern.factory.simpleFactory;

import demo.pattern.factory.ICourse;
import demo.pattern.factory.PythonCourse;

/**
 * 2019/3/13
 * zhouchao
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        CourseFactory courseFactory = new CourseFactory();
        ICourse course = courseFactory.create(PythonCourse.class);
        course.record();
    }
}
