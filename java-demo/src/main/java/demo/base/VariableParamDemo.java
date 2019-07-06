package demo.base;

/**
 * 2019/6/25
 * zhouchao
 */
public class VariableParamDemo {

    public static void main(String[] args) {
        test1("name=%s&memo=%s", "Java技术栈", "666");

        test2("name=%s&memo=%s", "Java技术栈");
    }

    private static void test1(String text, Object... params) {
        String result = String.format(text, params);
        System.out.println(result);
    }

    private static void test2(String text, Object... params) {
        String result = String.format(text, params, "666");
        System.out.println(result);
    }

}
