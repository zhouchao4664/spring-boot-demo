package demo.pattern.factory.factoryMethod;

import demo.pattern.factory.ICourse;
import demo.pattern.factory.JavaCourse;

/**
 * 2019/3/13
 * zhouchao
 */
public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new JavaCourse();
    }
}
