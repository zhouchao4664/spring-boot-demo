package demo.base.multiinterface;

public interface InterfaceA {

    default void print(){
        System.out.println("print InterfaceA");
    }
}
