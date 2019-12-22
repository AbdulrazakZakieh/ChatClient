package clientInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Member extends Remote{
    
  public void receiveText(String message) throws RemoteException;
  public int getID()throws RemoteException;   
  public String getMemberName()throws RemoteException;
}

