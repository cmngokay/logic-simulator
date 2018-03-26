package muhproje;


import java.awt.*;

public class AND extends Gate
{
    
    
    public AND(int inputCount)
    {
        super(inputCount, DeviceEnum.and,new Coordinate(0,0));
      
    }
    
    public AND(int inputCount,Coordinate location){
        super(inputCount,DeviceEnum.and, new Coordinate(location.x-20,location.y-30));
      
    }
    
    @Override
    public void draw(Graphics g)
    {
        
        int x = this.getX(), y = this.getY();
        Color c = g.getColor();
        if ( this.selected )    g.setColor(Color.BLUE);
        g.drawArc(x,y+5,50,50,0,-90);
        g.drawArc(x,y+5,50,50,0,90);
        g.drawLine(x,y+5,x+25,y+5);
        g.drawLine(x,y+55,x+25,y+55);
        g.drawLine(x,y+5,x,y+55);
        
        if ( this.getOutput()  && MainFrame.mode == ModeEnum.run ) g.setColor(Color.red);
        g.fillOval(x+48,y+28,4,4);
        this.setOutLeg(new Coordinate(x+50,y+30));
        g.setColor(c);
        
        int i = this.getInputCount();
        
        if(i == 2)
        {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+18, 4, 4);
            this.setInLeg(new Coordinate(x,y+20), 0);
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+38, 4, 4);
            this.setInLeg(new Coordinate(x,y+40), 1);
        }
        
        else if(i == 3)
        {
            if ( this.getInput(0) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+18, 4, 4);
            this.setInLeg(new Coordinate(x,y+20), 0);
            
            if ( this.getInput(1) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+28, 4, 4);
            this.setInLeg(new Coordinate(x,y+30), 1);
            
            if ( this.getInput(2) && MainFrame.mode == ModeEnum.run)  g.setColor(Color.red);
            else    g.setColor(c);
            g.fillOval(x-2, y+38, 4, 4);
            this.setInLeg(new Coordinate(x,y+40), 2);
        }
     
       
    }

    @Override
    public void setLocation(Coordinate cd) {
        //çizileceği konum bildirilir.
        super.setLocation(new Coordinate(cd.x-20,cd.y-30));
      
    }
    
    
    @Override
    public int isOnInLeg(int x, int y)  { 
   //Maus ile kapının giriş konumuna gelindiğinde konum değeri döndürülür.
        return super.isOnInLeg(x, y);
    }
    
    @Override
    public boolean isOnOutLeg(int x,int y)  {
       //Maus ile kapının çıkış konumuna gelindiğinde konum değeri döndürülür.
        return super.isOnOutLeg(x, y);
    }
    
    @Override
    public boolean isOnDevice(int x,int y)  {
        //maus ile kapının üzerindeyken konum bilgisi döndürülür.
        int lx = this.getX(), ly = this.getY();
     
        return (lx <= x && x <= lx+50 && ly+5 <= y && y <= ly+55);
       
    }
    

  
    @Override
    public void generateOutput()    {
        //RUN durumunda and kapısının değerlerini çalıştırır.
        int count = 0;
        for(count=0; count < this.inputCount; count++)
        {
            if(!this.input[count])
            {
                this.output = false;
                break;
            }
        }
        if(count == this.inputCount)
            this.output = true;
        
        int l = outRef.size();
        for ( int i = 0; i < l; i++ )   {
            outRef.get(i).setInput();
        }
    
    }

  
}
