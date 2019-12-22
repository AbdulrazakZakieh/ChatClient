package serverInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import clientInterface.Member;

public interface Room extends Remote {
  public String LOOKUPNAME = "ChatRoom";
   
  public void signIn(Member newMember) throws RemoteException;
  public void sendToAll(Member sender, String message) throws RemoteException;
  public void sendToMember(Member sender, int recieverID, String message) throws RemoteException;
  public void signOut(Member member) throws RemoteException;
}
