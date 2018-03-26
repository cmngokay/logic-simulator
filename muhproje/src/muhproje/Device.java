package muhproje;

import java.awt.*;


public class Device 
{
    protected int inputCount;
    protected Coordinate location;
    protected DeviceEnum type;
    protected boolean selected;
    
    public Device(){}
    public Device(int inputCount,DeviceEnum de,int locationX,int locationY)
    {
        this.inputCount = inputCount;
        this.location = new Coordinate(locationX, locationY);
        this.type = de;
    }
    public Device(int inputCount,DeviceEnum de,Coordinate location) {
        this.inputCount = inputCount;
        this.location = new Coordinate(location);
        this.type = de;
    }
   
    public void setLocation(Coordinate cd)    {
        location = cd;
    }
    
    public final Coordinate getLocation(){
        return location;
    }
    
    public final void setX(int i)    {
        this.location.x = i;
    }
    
    public final void setY(int i)    {
        this.location.y = i;
    }
    
    public final int getInputCount()    {
        return inputCount;
    }
    
    public final int getX()    {
        return location.x;
    }
    
    public final int getY()    {
        return location.y;
    }    
 
    
    public void draw(Graphics g){}
    
    
    public int isOnInLeg(Coordinate c){return isOnInLeg(c.x,c.y);}
    public boolean isOnOutLeg(Coordinate c){return isOnOutLeg(c.x,c.y);}
    
    
    public int isOnInLeg(int x,int y)   {
        int in = this.getInputCount();
  //setInLeg metoduyla inLeg[] dizisine aldığımız giriş adresleri ; getInLeg metoduyla döndürülüyor.
  //Dönen giriş adresleri mausun konumuyla karşılaştırılıyor.Aynı konumdalarsa true olarak döndürülüyor.
        for ( int i = 0; i < in; i++ )  {
            Coordinate c = this.getInLeg(i);
           
            if ( c.x == x && c.y == y ) return i;
        }
        return -1;
    }
    
    
   
    public boolean isOnOutLeg(int x,int y){
        //setOutLeg ile kapıların çıkış adresleri (coordinat)outLeg değişkenine alınıyor.
        //getOutLeg metoduyla outLeg değişkeni döndürülüyor.
        //mausun konumuyla outLeg karşılaştırılıyor.Aynı konumdalarsa true döner.
        Coordinate c = this.getOutLeg();
        return ( c.x == x && c.y == y );
    }
    
    
    public boolean isOnDevice(int x,int y){return false;}
    
    public boolean setInRef(int index, Device dref){return true;}  
    
    
    
    public void addOutRef(Device dref){}
    public void addOutWire(Wire w)  {}   

 
    public final void setType(DeviceEnum de)  {
        this.type = de;
    }    
    public final DeviceEnum getType()    {
        return this.type;
    }
    

    public boolean getInput(int index){return false;}
    public void generateOutput(){}
    public boolean getOutput(){return false;}
    public void setInput(){}  
    public void setInLeg (Coordinate c, int i) {}
    public Coordinate getInLeg(int i) {return null;}
    public void setOutput(boolean b) {}
    public void setOutLeg (Coordinate c) {}
    public Coordinate getOutLeg() {return null;}
}
