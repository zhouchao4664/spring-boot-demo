package demo.pattern.factory.simpleFactory;

import demo.pattern.factory.ICourse;

/**
 * 2019/3/13
 * zhouchao
 */
public class CourseFactory {

    public ICourse create(Class clazz) {
        try {
            if (null != clazz) {
                return (ICourse) clazz.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
