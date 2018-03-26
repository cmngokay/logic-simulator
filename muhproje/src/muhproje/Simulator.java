
package muhproje;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class Simulator {
 
    public static void main(String[] args) {
        
        final MainFrame mf = new MainFrame();
        mf.setVisible(true);
        mf.addWindowListener(
            new WindowAdapter()
            {
                @Override
                public void windowClosing(WindowEvent we)
                {

                    int i ;
                    i = JOptionPane.showConfirmDialog(null,"Çıkış yapmak istiyor musunuz?");
                    if(i==0)    {
                        System.exit(0);   
                    }
                    if ( i == -1 )  {
                        System.out.println("i == -1");
                    }
                }
            }
        );
    }
}
