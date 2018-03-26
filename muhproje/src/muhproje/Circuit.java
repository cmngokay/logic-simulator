
package muhproje;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.util.ArrayList;


public class Circuit{
    
    public boolean pointFlag;//giriş/çıkış kontrolünde kullanılıyor !
    public ArrayList<Device> device;
    public ArrayList<Source> source;
    public Device temp;
    public Source tempSource;
    public ArrayList<Wire> wire;
    public int countD, countS, countW;  //count = number of gates, countS = number of source
    public Coordinate start, end;//bağlantıların giriş ve çıkış adresleri tutuluyor.
    
    public Circuit() {

        device = new ArrayList<Device> ();
        source = new ArrayList<Source>();
        wire = new ArrayList<Wire>();
        countD = 0;
        countS = 0;
        countW = 0;
    }
    
    public Circuit ( Circuit ckt )  {
        this.device = ckt.device;
        this.source = ckt.source;

        this.countD = ckt.countD;
        this.countS = ckt.countS;
        this.countW = ckt.countW;
    }
    public void drawCircuit ( Graphics g)   {

        countD = device.size();
        for ( int i = 0; i < countD; i++ )  {
            g.setColor(Color.BLACK);
            device.get(i).draw(g);

        }

        countS = source.size();
        for ( int i = 0; i < countS; i++ )  {
            g.setColor(Color.BLACK);
            source.get(i).draw(g);
        }
        
        countW = wire.size();
        for ( int i = 0; i < countW; i++ )  {
            g.setColor(Color.BLACK);
            wire.get(i).draw(g);
        }
        g.setColor(Color.BLUE);
        drawTempWire(g);
    }
    
    public boolean addWire (Coordinate startingPoint, Device startDevice, Coordinate endingPoint, Device endingDevice ){
        //Maus hareketiyle gelen giriş/çıkış konumlarına bağlantı ekleniyor.
        //kapıların çıkıştan girişe ve kaynaktan girişe bağlantıya izin verilir.
        if ( startDevice == null || endingDevice == null )  {
  
            return false;
        }
        if ( startDevice.isOnOutLeg(startingPoint) )    {
            if ( endingDevice.isOnOutLeg(endingPoint) ) {
     
                start = null;
                end = null;
                return false;
            }
            else    {
                int indx = endingDevice.isOnInLeg(endingPoint);
                if (indx < -1)  {
                    
                    return false;
                }
                if ( endingDevice.setInRef(indx, startDevice) == false )    {
                  
                    return false;
                }
                startDevice.addOutRef(endingDevice);
                wire.add(new Wire(startingPoint, endingPoint, startDevice, endingDevice));
              
            }
        }
        else if ( endingDevice.isOnOutLeg(endingPoint) )    {
            if ( startDevice.isOnOutLeg(startingPoint) ) {
            
                start = null;
                end = null;
                return false;
            }
            else    {
                int indx = startDevice.isOnInLeg(startingPoint);
                if (indx < -1)  {
                
                    return false;
                }
                if ( startDevice.setInRef(indx, endingDevice) == false )    {
                 
                    return false;
                }
                endingDevice.addOutRef(startDevice);
                wire.add(new Wire(endingPoint, startingPoint, endingDevice, startDevice));
              
            }
        }
        return false;
    }
    
    public void drawTempWire (Graphics g) {
        //CircuitPanel sınıfının @pointComponent'i sürekli tetikliyor.
        try {

            int midx = (start.x+end.x)/2;
            midx = (midx+5);
            midx-= midx%10;


            g.drawLine(start.x, start.y, midx, start.y);
            g.drawLine(midx, start.y, midx, end.y);
            g.drawLine(midx, end.y, end.x, end.y);
        }   catch(Exception e)  {

        }
    }
    
    public void setTemp ( MouseEvent evt, int inputCount )   {
        //panelde maus ile seçilen kapı tetiklenir.
        try {
            Coordinate cd = new Coordinate(evt);
            switch ( MainFrame.currentDev ) {
                case and:
                    if ( temp == null || temp.getType() != DeviceEnum.and ) temp = new AND(inputCount, cd);                 
                    else    temp.setLocation(cd);
                    break;
                case or:
                    if ( temp == null || temp.getType() != DeviceEnum.or ) temp = new OR(inputCount, cd);
                    else    temp.setLocation(cd);
                    break;
                case not:
                    if ( temp == null || temp.getType() != DeviceEnum.not ) temp = new NOT(inputCount, cd);
                    else    temp.setLocation(cd);
                    break;                
                case led:
                    if ( temp == null || temp.getType() != DeviceEnum.led ) temp = new LED(cd);
                    else    temp.setLocation(cd);
                    break;
                case source:
                    temp = null;
                   setTempSource (cd);
                    break;
            }

        } catch (Exception e)   {
            
            e.printStackTrace();
            temp = null;
        }
        System.gc();
    }
    
    public void setTempSource ( Coordinate cd ) {
        try {
            tempSource = new Source(cd);
        }   catch(Exception e)  {
            e.printStackTrace();
        }
    }
    
    public Device getTemp() {
        return temp;
    }
    
    public Source getTempSource()   {
       //KAYNAK butonu tetiklendiğinde döndürülüyor !
        return tempSource;
    }
    
    public void placeTemp ()    {
        //device ve source tutulur.
        try {
            if ( temp != null ) {
                device.add(temp);
                countD++;
                temp = null;
            }
            else if ( tempSource != null )  {
                source.add(tempSource);
                countS++;
                tempSource = null;
            }
        }   catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    public Device searchForDevice (Coordinate cd)   {       
       //Maus ile kapılara gelindiğinde bu metot ile kapı döndürülüyor.
        for ( int i = 0; i < countD; i++ )            
            if ( device.get(i).isOnDevice(cd.x, cd.y) ){              
                 return device.get(i);
            }                
       
        return searchForSource(cd);
    }
    
    
    public Source searchForSource (Coordinate cd)   {
        //Maus kaynak üzerine geldiğinde bu metot ile kaynak döndürülüyor! (tetikleniyor)!
        for ( int i = 0; i < countS; i++ )
            if ( source.get(i).isOnDevice(cd.x, cd.y)){
             
                 return source.get(i);
            }               
  
        return null;
    }
    
    public Wire searchForWire (Coordinate cd)   {
       //Panelde giriş/çıkışlar dışında wire çekmeye çalışıldığında null değeri döndürülür.
       //Böylelikle boş alanda wire kullanımına izin verilmez !
        return null;
    }    
 
    
    public void clear() {    
        device = new ArrayList<Device> ();
        source = new ArrayList<Source>();
        wire = new ArrayList<Wire>();
        countD = 0;
        countS = 0;
        countW = 0;
    }
   
  
}
