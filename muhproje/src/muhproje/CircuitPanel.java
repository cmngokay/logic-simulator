
package muhproje;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

    
public class CircuitPanel extends JPanel {
    
    public static int distance;
    public Circuit ckt;
    
    public CircuitPanel() {
        this.setPreferredSize(new Dimension(1920,1080));
        this.distance = 10;
    }
    
    public CircuitPanel(Circuit ckt) {
        this.setPreferredSize(new Dimension(1920,1080));
        this.distance = 10;
        this.ckt = ckt; 
    }
    
    boolean paintPoint (Graphics g)    {    
        Color c = g.getColor();
        if ( ckt.pointFlag )    g.setColor(Color.RED);
        else    g.setColor(Color.BLUE);
        
        try {
            Coordinate cd = new Coordinate(MainFrame.mouseMove);
            g.fillRect(cd.x-3, cd.y-3, 6, 6);
            g.setColor(c);
            return true;
        }catch(Exception e) {            
            e.printStackTrace();
            g.setColor(c);
            return false;
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.DARK_GRAY);
        int height = this.getPreferredSize().height;
        int width = this.getPreferredSize().width;
        
        for ( int i = 0; i < height; i+= 10 )    {
            for ( int j = 0; j < width; j+= 10 ) {
                g.drawLine(j, i, j, i);
            }
        }
        
        g.setColor ( Color.BLACK);
        ckt.drawCircuit(g);
        
        if ( MainFrame.mode == ModeEnum.drawing )   {
            if ( MainFrame.currentDev == DeviceEnum.wire )  {
                paintPoint(g);
            }
            else    {
                g.setColor(Color.blue);
                paintTemp(g);
            }
        }
        
 
    }
    
    private boolean paintTemp(Graphics g)  {   
        
        g.setColor(Color.blue);
        try {
            if ( MainFrame.mode == ModeEnum.drawing )
                if ( ckt != null )  {
                    Device temp = ckt.getTemp();
                    
                    if ( temp != null ) {
                   
                        temp.draw(g); // Seçilen kapının draw metodu tetikleniyor !
                    }
                    else if ( ckt.getTempSource() != null ) 
                        
                        ckt.getTempSource().draw(g); //Kaynak sınıfının draw metodu tetikleniyor!
                }
            return true;
        }catch (Exception e)    {          
            return false;
        }
    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g); 
    }

}
