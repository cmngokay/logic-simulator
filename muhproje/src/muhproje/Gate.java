package muhproje;


import java.util.ArrayList;

public class Gate extends Device
{

    private Coordinate inLeg[];//Kapıların giriş adresleri tutuluyor.
    private Coordinate outLeg;//Kapıların çıkış adresleri tutuluyor.
    protected ArrayList<Device> outRef;
    protected ArrayList<Wire> outWire;
    protected Device inRef[];
    protected int iCount;//Giriş sayısı
    protected boolean input[];//Giriş değerleri tutulur.
    protected boolean output=false;//Çıkış değerlerini tutar.
    
    public Gate(int inputCount, DeviceEnum de, Coordinate location) {
        super(inputCount, de, location);
        this.input = new boolean[5];
        iCount = 0;
        for ( int i = 0; i < inputCount; i++ )  input[i] = false;
        output = false;
        this.inLeg = new Coordinate[5];
        outRef = new ArrayList();
        outWire = new ArrayList();
        inRef = new Device[5];
        selected = false;
        
        for(int count = 0; count < inputCount; count++) {
            inRef[count] = null;
            input[count] = false;
            Wire w = new Wire();
        }
      
    }       
   
    
    @Override
    public final void setInput()  {
        
       //Run durumundayken çalışır.
       //input dizisine giriş değerleri atılır.
       //çalışan kapının sınıfındaki generateOutput() metodu gerekli çıkışı üretir.
       
        for(int count = 0;count < this.getInputCount();count++)
        {
            this.input[count] = this.inRef[count].getOutput();
            
        }     
     
        this.generateOutput();
        this.setOutWireState();
       
    }    
    
    
    @Override
    public final void setOutput(boolean b)   {       
        //Run modunda çalışır.
        //Kapıların çıkış değerleri output'ta tutulur.        
        this.output = b;
        this.generateOutput();
        this.setOutWireState();       
    }
    
    public final void setOutWireState()  {
        //Run modunda çalışır.Bağlantı üzerindeki değerler tutuluyor.
        int l = outWire.size();
        for ( int i = 0; i < l; i++ )   {
            outWire.get(i).setState(this.getOutput());
        }
        
    }
   
    @Override
    public final boolean getInput(int index) {
        //Kapıların giriş değerleri döndürülür.(i=2 için yani kapı 2 girişlidir.i=3 için kapı 3 girişlidir.)
        //input[0],input[1],input[2] için 0/1 değeri döndürülür.
        //Kapılar kendi sınıflarında bu değeri alarak giriş/çıkışlarını red(1) veya blue(0) olarak çizim yapar.
        return this.input[index];
       
    }
   
    @Override
    public final boolean getOutput() {
        //Kapıların çıkış değerleri döndürülür.
        //Çıkış değerine göre kapı sınıflarında çizim yapılır.
        return this.output;
    }
    
    
    @Override
    public final boolean setInRef(int index, Device d)  {
        //Bağlantı(wire) yapıldığında inRef dizisine bağlantı yapılan bileşen atılır.
        if ( inRef[index] == null ) inRef[index] = d;
        else return false;
        return true;
    }
    
    @Override
    public final void setInLeg (Coordinate c, int i)    {
       //Kapıların giriş adreslerini tutuyor.
        inLeg[i] = c;        
    }
   
    @Override
    public final Coordinate getInLeg(int i) {
        //Maus ile kapıların girişlerine gelindiğinde girişin koordinatlarını döndürür.       
        return inLeg[i];
    }

    @Override
    public final void setOutLeg(Coordinate c) {
       //Kapıların çıkış adresini tutuyor.
        this.outLeg = c;
    }
    
    @Override
    public final Coordinate getOutLeg() {
       //Maus ile kapıların çıkışlarına gelindiğinde çıkışın koordinatlarını döndürür.      
        return outLeg;
    }

   

    @Override
    public final void addOutRef(Device dref) {
        //Bağlantı(wire) yapıldığında outRef listesine bağlantının yapıldığı bileşen eklenir.     
        outRef.add(dref);
    }

    @Override
    public void addOutWire(Wire w) {
        //Bağlantı(wire) yapıldığında outWire listesine bağlantı(wire) eklenir.       
        outWire.add(w);
    }

   
    
  
}
