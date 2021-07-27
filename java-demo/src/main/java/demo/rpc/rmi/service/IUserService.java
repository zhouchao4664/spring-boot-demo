package demo.rpc.rmi.service;

import demo.rpc.rmi.pojo.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author: zhouchao
 * @Date: 2021/07/27 19:14
 * @Description:
 */
public interface IUserService extends Remote {
    /**
     * 根据id获取用户详情
     *
     * @param id
     * @return
     * @throws RemoteException
     */
    User getByUserId(int id) throws RemoteException;
}
