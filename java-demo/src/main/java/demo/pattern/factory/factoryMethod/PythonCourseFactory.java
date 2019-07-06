package demo.pattern.factory.factoryMethod;

import demo.pattern.factory.ICourse;
import demo.pattern.factory.PythonCourse;

/**
 * 2019/3/13
 * zhouchao
 */
public class PythonCourseFactory implements ICourseFactory {
    @Override
    public ICourse create() {
        return new PythonCourse();
    }
}
