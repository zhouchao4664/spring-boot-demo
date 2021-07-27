package demo.rpc.rmi.server;

import demo.rpc.rmi.service.IUserService;
import demo.rpc.rmi.service.UserServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Author: zhouchao
 * @Date: 2021/07/27 19:18
 * @Description:
 */
public class RMIServer {
    public static void main(String[] args)  {
        try {
            Registry registry = LocateRegistry.createRegistry(9999);
            IUserService userService = new UserServiceImpl();
            registry.rebind("userService",userService);
            System.out.println("---RMI服务端启动成功----");
            while (true){
                Thread.sleep(1000);
            }
        } catch (RemoteException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
