package client;
import clientInterface.Member;
import serverInterface.Room;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.Remote;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Member_Imp extends javax.swing.JFrame implements Member{
    Room   room; 
    String name;
    int    id;
    //--------------------------------------------------------------------------
    public Member_Imp() throws NotBoundException,RemoteException {
      initComponents();
      //............................
      String serverHost=JOptionPane.showInputDialog("IP of Server Host:");
      int registryPort=Integer.parseInt(JOptionPane.showInputDialog("Port of Server's Registry"));
      //..................localhost............................
      Registry registry = LocateRegistry.getRegistry(serverHost,registryPort);
      room = (Room) registry.lookup(Room.LOOKUPNAME);
      UnicastRemoteObject.exportObject((Remote)this, 0);
      //.............................
      name = JOptionPane.showInputDialog("Your Name:");
      id   = Integer.parseInt(JOptionPane.showInputDialog("Your Phone Number:"));
      room.signIn((Member)this); 
      memberNamejLabel.setText("Chat Room's Member : "+name);
    }
   //---------------------------------------------------------------------------
    @Override
    public void receiveText(String message){
      receivedMessagesJTextArea.append(message + "\n");
    } 
  //---------------------------------------------------------------------------- 
    @Override
    public int getID()throws RemoteException{
     return id;   
    }
  //----------------------------------------------------------------------------
    @Override
     public String getMemberName() throws RemoteException{
      return name;
     }
 //-----------------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        publicMessageJTextField = new javax.swing.JTextField();
        sendToAllJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        receivedMessagesJTextArea = new javax.swing.JTextArea();
        phoneNumberTextField = new javax.swing.JTextField();
        privateMessageTextField = new javax.swing.JTextField();
        sendToMemberButton = new javax.swing.JButton();
        PrivatejLabel = new javax.swing.JLabel();
        phoneNumberjLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        publicjLabel = new javax.swing.JLabel();
        memberNamejLabel = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        sendToAllJButton.setText("SendToAll");
        sendToAllJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToAllJButtonActionPerformed(evt);
            }
        });

        receivedMessagesJTextArea.setEditable(false);
        receivedMessagesJTextArea.setColumns(20);
        receivedMessagesJTextArea.setRows(5);
        receivedMessagesJTextArea.setFocusable(false);
        jScrollPane1.setViewportView(receivedMessagesJTextArea);

        sendToMemberButton.setText("Send");
        sendToMemberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToMemberButtonActionPerformed(evt);
            }
        });

        PrivatejLabel.setText("Private");

        phoneNumberjLabel.setText("Receiver's Phone Number");

        publicjLabel.setText("Public");

        memberNamejLabel.setText(" Chat Room                  ");

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PrivatejLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(phoneNumberjLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(publicMessageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(sendToAllJButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(privateMessageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sendToMemberButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(memberNamejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(206, 206, 206)
                                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(publicjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exitButton)
                    .addComponent(memberNamejLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(publicjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(publicMessageJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendToAllJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PrivatejLabel))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberjLabel)
                    .addComponent(phoneNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(privateMessageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendToMemberButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void sendToAllJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToAllJButtonActionPerformed
        try {
            room.sendToAll(this ,publicMessageJTextField.getText());
        } catch (RemoteException ex) {
            Logger.getLogger(Member_Imp.class.getName()).log(Level.SEVERE, null, ex);
        }
        publicMessageJTextField.setText("");
    }//GEN-LAST:event_sendToAllJButtonActionPerformed
    private void sendToMemberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToMemberButtonActionPerformed
        int recID = Integer.parseInt(phoneNumberTextField.getText());
        String message = privateMessageTextField.getText();
        try {
              room.sendToMember(this, recID, message);
        } catch (RemoteException ex) {
              Logger.getLogger(Member_Imp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendToMemberButtonActionPerformed
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        try {
            room.signOut(this);
        } catch (RemoteException ex) {
            Logger.getLogger(Member_Imp.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            room.signOut(this);
        } catch (RemoteException ex) {
            Logger.getLogger(Member_Imp.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_formWindowClosing
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                      new Member_Imp().setVisible(true);
                    } catch (NotBoundException ex) {
                      Logger.getLogger(Member_Imp.class.getName()).log(Level.SEVERE, null, ex);
                    }catch( RemoteException ex ){
                    Logger.getLogger(Member_Imp.class.getName()).log(Level.SEVERE, null, ex);
                   } 
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PrivatejLabel;
    private javax.swing.JButton exitButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel memberNamejLabel;
    private javax.swing.JTextField phoneNumberTextField;
    private javax.swing.JLabel phoneNumberjLabel;
    private javax.swing.JTextField privateMessageTextField;
    private javax.swing.JTextField publicMessageJTextField;
    private javax.swing.JLabel publicjLabel;
    private javax.swing.JTextArea receivedMessagesJTextArea;
    private javax.swing.JButton sendToAllJButton;
    private javax.swing.JButton sendToMemberButton;
    // End of variables declaration//GEN-END:variables
}
