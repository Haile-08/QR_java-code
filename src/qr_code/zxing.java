package qr_code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

public class zxing extends JFrame {
    JLabel     title          = new JLabel();
    JTextField userfill         = new JTextField();
    JButton    sumit           = new JButton();
    
    zxing(){
        
      title .setText("USER LOGIN");
      title  .setBounds(30,180, 250, 20);
      title  .setFont(new Font("Serif",Font.PLAIN,19));
      add(title);
     
      userfill.setBounds(180, 180, 180, 23);
      add(userfill);
     
      sumit.setText("SUBMIT");
      sumit.setFont(new Font("Serif",Font.PLAIN,19));
      sumit.setBackground(Color.YELLOW);
      sumit.setBounds(180, 340, 110, 35);
      add(sumit);
     
     setTitle("Covid19 Tracer");
     setSize(500,600);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     getContentPane().setBackground(Color.yellow);
     setLayout(null);
     setVisible(true);
     
     
         sumit.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                    try{
                        
                        ByteArrayOutputStream out = QRCode.from(userfill.getText()).to(ImageType.PNG).stream();
                        String f_name = userfill.getText();
                        String path_name = "D:\\";
                        FileOutputStream fout = new FileOutputStream(new File(path_name+(f_name+".PNG" )));
                        fout.write(out.toByteArray());
                        fout.flush();
                        
                        
                    }catch(Exception ex){
                       System.out.println(ex);
                        
                    }
                    dispose();
            }
        });
    }
    
}
