
package muhproje;


import java.awt.*;

public class NOT extends Gate {

    public NOT(int inputCount) {
        super(inputCount, DeviceEnum.not, new Coordinate(0,0));
    }
    public NOT(int inputCount, Coordinate location) {
        super(inputCount, DeviceEnum.not, new Coordinate(location.x-10, location.y-15));       
    }

    @Override
    public void draw(Graphics g) {
        int x = this.getX(), y = this.getY();
        
        Color c = g.getColor();
        if ( this.selected )    g.setColor(Color.BLUE);
        g.drawLine(x, y+5, x, y+35);
        g.drawLine(x, y+5, x+20, y+20);
        g.drawLine(x+20, y+20, x, y+35);
        g.drawOval(x+20, y+16, 8, 8);
        
        if ( this.getInput(0) && MainFrame.mode == ModeEnum.run )  g.setColor(Color.red);
        else    g.setColor(c);
        g.fillOval(x-2,y+18,4,4);
        this.setInLeg(new Coordinate(x,y+20),0);
        
        if ( this.getOutput() && MainFrame.mode == ModeEnum.run )  g.setColor(Color.red);
        else    g.setColor(c);
        g.fillOval(x+28,y+18,4,4);
        this.setOutLeg(new Coordinate(x+30,y+20));
    }

    @Override
    public void setLocation(Coordinate cd) {
        cd.x-= 10;
        cd.y-= 15;
        cd = new Coordinate(cd.x,cd.y);        
        super.setLocation(cd);
    }

    
    @Override
    public int isOnInLeg(Coordinate c) {
        return super.isOnInLeg(c); 
    }

    @Override
    public boolean isOnOutLeg(Coordinate c) {
        return super.isOnOutLeg(c); 
    }

    @Override
    public int isOnInLeg(int x, int y) {
         //Maus ile kapının giriş konumuna gelindiğinde konum değeri döndürülür.
        return super.isOnInLeg(x, y);
    }

    @Override
    public boolean isOnOutLeg(int x, int y) {
        //Maus ile kapının çıkış konumuna gelindiğinde konum değeri döndürülür.
        return super.isOnOutLeg(x, y); 
    }

    @Override
    public boolean isOnDevice(int x, int y) {
        //maus ile kapının üzerindeyken konum bilgisi döndürülür.
        return (x >= this.getX() && x <= this.getX()+30 && y >= this.getY()+10 && y <= this.getY()+20);

    }

  

  

    @Override
    public void generateOutput() {
        //run durumunda not kapısının değeri oluşturulur.
        this.output = !this.input[0];
        
        int l = outRef.size();
        for ( int i = 0; i < l; i++ )   {
            outRef.get(i).setInput();
        }
    }
    
    
}
