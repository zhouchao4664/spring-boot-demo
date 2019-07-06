package demo.pattern.template;

/**
 * 2019/3/16
 * zhouchao
 */
public abstract class NetWorkCourse {

    protected final void createCourse() {

        //提交预习资料
        this.postPreResource();

        //制作PPT
        this.createPPT();

        //直播
        this.liveVideo();

        //提交课件、课堂笔记
        this.postNote();

        //提交源码
        this.postSource();
        
        //不止作业，有些课是没有作业，有些课是有作业
        //如果有作业的话，检查作业，如果没有，完成了
        if (needWork()){
            this.checkWork();
        }
    }

    protected boolean needWork() {
        return false;
    }

    abstract void checkWork();

    final void postSource() {
    }

    final void postNote() {
    }

    final void liveVideo() {
    }

    final void createPPT() {
    }

    final void postPreResource() {
    }
}
