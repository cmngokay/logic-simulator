package muhproje;

import java.awt.*;

        
public class Wire 
{
    private boolean state,wdState;
    private Coordinate start, end, mid;
    private Device inRef, outRef;
    
    public Wire()
    {
        start = new Coordinate(0,0);
        end = new Coordinate(0,0);
        mid = new Coordinate(0,0);
        this.state = false;
        this.wdState = false;
        this.inRef = null;
        this.outRef = null;
      
    }

    public Wire(Coordinate start, Coordinate end, Device inRef, Device outRef) {
        //Wire doğru eklendiğinde bu yapıcı metot tetiklenir !
        this.start = start;
        this.end = end;
        this.inRef = inRef;
        this.inRef.addOutWire(this);
        this.outRef = outRef;
        this.mid = new Coordinate ((start.x+end.x)/2, (start.y+end.y)/2);
        this.state = false;
     
    }    
  

    public void setState(boolean state) {
        //RUN durumunda tetikleniyor! Bağlantının durum değeri alınıyor.
        this.state = state;
    }

    
    public void draw(Graphics g)
    {
        //state:bağlantının durumu (true/false).
        //bağlantı true ve durum run olduğunda geçişin '1' olduğu kabul edilir.
        //iletim var durumunu temsilen kablolar kırmızı şekilde çizilir.
        Color c = g.getColor();
        if ( state && MainFrame.mode == ModeEnum.run )    g.setColor(Color.red);
        g.drawLine(start.x, start.y, mid.x, start.y);
        g.drawLine(mid.x, start.y, mid.x, end.y);
        g.drawLine(mid.x, end.y, end.x, end.y);
        g.setColor(c);
    }

   
    
}