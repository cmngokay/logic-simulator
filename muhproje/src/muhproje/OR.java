
package muhproje;


import java.awt.*;

public class OR extends Gate    {

    public OR(int inputCount) {
        super(inputCount, DeviceEnum.or, new Coordinate(0,0));
    }
    
    public OR(int inputCount, Coordinate location) {
        super(inputCount, DeviceEnum.or, new Coordinate(location.x-80,location.y-30));

    }

    @Override
    public void draw(Graphics g) {
        int x = this.getX(), y = this.getY();
        Color c = g.getColor();
        if ( this.selected )    g.setColor(Color.BLUE);
        g.drawArc(x,y+5,100,50,0,-90);
        g.drawArc(x,y+5,100,50,0,90);
        g.drawArc(x+40,y+5,20,50,0,-90);
        g.drawArc(x+40,y+5,20,50,0,90);
        
        if ( this.getOutput()&& MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
        else    g.setColor(c);
        g.fillOval(x+98,y+28,4,4);
        this.setOutLeg(new Coordinate(x+100,y+30));
        
        int i = this.getInputCount();
        
        if(i == 2)
        {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+19, 10, 2);
            g.fillOval(x+48, y+18, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+20), 0);
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+39, 10, 2);
            g.fillOval(x+48, y+38, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+40), 1);
        }
        
        else if(i == 3) {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+19, 10, 2);
            g.fillOval(x+48, y+18, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+20), 0);
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+29, 10, 2);
            g.fillOval(x+48, y+28, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+30), 1);
            
            if ( this.getInput(2) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x+50, y+39, 10, 2);
            g.fillOval(x+48, y+38, 4, 4);
            this.setInLeg(new Coordinate(x+50,y+40), 2);
        }
        
       
    }

    @Override
    public void setLocation(Coordinate cd) {
        super.setLocation(new Coordinate(cd.x-80, cd.y-30)); 
        Coordinate c = new Coordinate(cd.x-80, cd.y-30);

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
        if ( x >= this.getX()+50 && x <= this.getX()+100)   {
            if ( y >= this.getY() && y <= this.getY()+60 )
                return true;
        }
        return super.isOnDevice(x, y); 
    }

   

  

    @Override
    public void generateOutput() {
        //Run durumunda or kapısının değeri hesaplanır.
        int count = 0;
        for(count=0; count < this.inputCount; count++)
        {
            if(this.input[count])
            {
                this.output = true;
                break;
            }
        }
        if(count == this.inputCount)
            this.output = false;
        
        int l = outRef.size();
        for ( int i = 0; i < l; i++ )   {
            outRef.get(i).setInput();
        }
    }

    
}
