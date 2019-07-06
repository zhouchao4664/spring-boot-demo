package demo.pattern.observer.AskAndAnswer;

import java.util.Observable;

/**
 * 2019/3/22
 * zhouchao
 *
 * 观察者模式
 */
public class Platform extends Observable {

    private String name = "咕泡社区";
    private static Platform platform = null;

    private Platform() {
    }

    public static Platform getInstance() {
        if (null == platform) {
            platform = new Platform();
        }
        return platform;
    }

    public String getName() {
        return this.name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUserName() + "在" + this.getName() + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }

}
