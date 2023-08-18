package demo.rpc.rmi.client;

import demo.rpc.rmi.pojo.User;
import demo.rpc.rmi.service.IUserService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Author: zhouchao
 * @Date: 2021/07/27 19:25
 * @Description:
 */
public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",9999);
            IUserService userService = (IUserService) registry.lookup("userService");
            User user = userService.getByUserId(1);
            System.out.println(user);
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
