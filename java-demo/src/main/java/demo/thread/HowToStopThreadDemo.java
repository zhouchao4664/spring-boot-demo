package demo.thread;

/**
 * 2019/3/17
 * zhouchao
 */
public class HowToStopThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        StoppableAction action = new StoppableAction();

        Thread thread = new Thread(action);

        thread.start();

        action.stop();

        thread.join();
    }

    private static class StoppableAction implements Runnable{

        private boolean stopped;
        @Override
        public void run() {
            if (stopped){
                System.out.println("Action 终止。。。");
                return;
            }

            //TODO

            System.out.println("Action 执行");
        }

        public void stop(){
            this.stopped = true;
        }
    }


}
