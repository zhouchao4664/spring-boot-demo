package demo.pattern.observer.AskAndAnswer;

/**
 * 2019/3/22
 * zhouchao
 *
 * 观察者模式
 */
public class ObserverTest {
    public static void main(String[] args) {
        Platform platform = Platform.getInstance();
        Teacher teacher = new Teacher("Tom");

        Question question = new Question();
        question.setUserName("小明");
        question.setContent("观察者模式适用于那些场景？");
        platform.addObserver(teacher);
        platform.publishQuestion(question);

    }
}
