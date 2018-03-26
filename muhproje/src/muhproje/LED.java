
package muhproje;


import java.awt.*;

public class LED extends Gate {

    public LED() {
        super(1, DeviceEnum.led, new Coordinate(0,0));
    }
    public LED(Coordinate location) {
        super(1, DeviceEnum.led, new Coordinate(location.x-10,location.y-10));
    }

    @Override
    public void draw(Graphics g) {
        int x = this.getX(), y = this.getY();
        
        Color c = g.getColor();
        g.setColor(Color.gray);
        g.fillRect(x,y+20,20,10);
        if ( this.selected )    g.setColor(Color.blue);
        g.setColor(c);
        g.drawRect(x,y+20,20,10);
        this.setInLeg(new Coordinate(x+10,y+40),0);
        if ( getInput(0) && MainFrame.mode == ModeEnum.run )  {
            g.setColor(Color.red);
            g.drawLine(x+10,y+30,x+10,y+40);         
            g.fillRect(x,y+20,20,10);
        }
        else    {
           
            g.drawLine(x+10,y+30,x+10,y+40);
        }           
        g.setColor(c);
    
        
    }

    @Override
    public void setLocation(Coordinate cd) {
        //çizileceği konum bildirilir.
        super.setLocation(new Coordinate(cd.x-10,cd.y-10));
    }
    
    @Override
    public int isOnInLeg(Coordinate c) {
       
        return super.isOnInLeg(c); 
    }

    @Override
    public boolean isOnOutLeg(Coordinate c) {
        
        return false;
    }

    @Override
    public int isOnInLeg(int x, int y) {         
        return super.isOnInLeg(x, y); 
    }

    @Override
    public boolean isOnOutLeg(int x, int y) {
         //Maus ile ledin çıkış konumuna gelindiğinde konum değeri döndürülür.
        return super.isOnOutLeg(x, y); 
    }

    @Override
    public boolean isOnDevice(int x, int y) {
        //maus ile ledin üzerindeyken konum bilgisi döndürülür.
        if ( x >= this.getX() && x <= this.getX()+20 )  {
            if ( y >= this.getY() && y <= this.getY()+40 )  {
                return true;
            }
        }
        else if ( x == this.getX()+10 && y >= this.getY()+40 && y <= this.getY()+10 )  return true;
        return false;
    }

    @Override
    public void generateOutput() {
         //RUN durumunda led çalıştırır.
        super.generateOutput();
    }
    
    
}
