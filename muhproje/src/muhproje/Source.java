
package muhproje;

import java.awt.Color;
import java.awt.Graphics;

public class Source extends Gate  {

    boolean flag;

    
    public Source(int locationX, int locationY) {
        super(0, DeviceEnum.source, new Coordinate(locationX-10, locationY-10));
        flag = false;
    }

    public Source(Coordinate location) {
        super(0, DeviceEnum.source, new Coordinate(location.x-10,location.y-10));
        flag = false;
    }
    
    @Override
    public void draw(Graphics g) {
        int x = this.getX(), y = this.getY();
        Color c= g.getColor();
        if ( this.selected )    g.setColor(Color.BLUE);
        g.drawRect(x,y,20,20);
        String s = "0";
        if ( this.getOutput() && MainFrame.mode == ModeEnum.run )   {
            s = "1";
            g.setColor(Color.red);
        }       

        g.drawLine(x+20,y+10,x+30,y+10);    
        g.setColor(Color.black);
        g.drawString(s,x+7, y+16);
        g.setColor(c);
        this.setOutLeg(new Coordinate(x+30,y+10));
    }

    @Override
    public boolean isOnOutLeg(Coordinate c) {
        //Maus ile kapının çıkış konumuna gelindiğinde konum değeri döndürülür.
        return super.isOnOutLeg(c);
    }
    
    @Override
    public int isOnInLeg(int x, int y) {
        return -1;
    }


    @Override
    public boolean isOnDevice(int x, int y) {
        //maus ile kaynağın üzerindeyken konum bilgisi döndürülür.
        if ( x >= this.getX() && x <= this.getX()+20 )  {
            if ( y >= this.getY() && y <= this.getY()+20 )
                return true;
        }
        else if ( x == this.getX()+30 && y >= this.getY() && y <= this.getY()+10 )  return true;
        return false;
    }

   

    public void toggleOutput() {
        //çıkış değeri bildirilir.
        setOutput(!this.getOutput());
    }

    @Override
    public void generateOutput() {
        //run durumunda kaynak değeri hesaplanır.
        int l = outRef.size();
        for ( int i = 0; i < l; i++ )   {
            outRef.get(i).setInput();
        }
    }
    
}
