package demo.rxjava;


import rx.Observable;
import rx.Observer;
import rx.functions.Action0;
import rx.functions.Func0;

/**
 * @Author zhouchao
 * @Date 2020/8/31 22:15
 * @Description ReactiveX Java 响应式变成框架，核心是观察者模式，
 **/

public class RxJavaDemo {

    public static void main(String[] args) {

        final String[] datas = new String[]{"吃饭", "睡觉", "打豆豆"};

        final Action0 onCompleted = new Action0() {
            @Override
            public void call() {
                System.out.println("On completed");
            }
        };

        //被观察者
        Observable<String> observable = Observable.defer(new Func0<Observable<String>>() {
            @Override
            public Observable<String> call() {
                Observable observable1 = Observable.from(datas);
                return observable1.doOnCompleted(onCompleted);
            }
        });

        //观察者
        Observer observer = new Observer() {
            @Override
            public void onCompleted() {
                System.out.println("Observer: onCompleted");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Observer: onError");
            }

            @Override
            public void onNext(Object o) {
                System.out.println("on next: "+ o);
            }
        };
        observable.subscribe(observer);
    }
}
