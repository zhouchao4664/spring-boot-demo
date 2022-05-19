package demo.base.multiinterface;

public interface InterfaceB {

    default void print(){
        System.out.println("print InterfaceB");
    }
}
