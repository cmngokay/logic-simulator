
package muhproje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;


public class MainFrame extends JFrame {

   
    public static ModeEnum mode;
    public static DeviceEnum currentDev;
    public static MouseEvent pressed, dragged, click, released, mouseMove;
    public Circuit ckt;
    public Device pressedDevice, releasedDevice;
    public Wire pressedWire, releasedWire;
    public int numberOfInput;
    private Device selectedDevice;
    
    public MainFrame() {
       
        ckt = new Circuit();
        numberOfInput = 2;  
      
        initComponents();
        iconload();     
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        clearButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        runButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        cktPanel = new CircuitPanel(ckt);
        andButton = new javax.swing.JButton();
        orButton = new javax.swing.JButton();
        and3Button = new javax.swing.JButton();
        or3Button = new javax.swing.JButton();
        notButton = new javax.swing.JButton();
        ledButton = new javax.swing.JButton();
        switchButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sayısal Elektronik Simülatör Uygulaması");
        setMinimumSize(new java.awt.Dimension(700, 600));
        setName("mainFrame"); // NOI18N

        jToolBar1.setRollover(true);

        clearButton.setText("Temizle");
        clearButton.setToolTipText("Clear Circuit Diagram");
        clearButton.setFocusable(false);
        clearButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        clearButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(clearButton);
        jToolBar1.add(jSeparator3);

        runButton.setText("Çalıştır");
        runButton.setToolTipText("Simulate");
        runButton.setFocusable(false);
        runButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        runButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(runButton);

        stopButton.setText("Durdur");
        stopButton.setToolTipText("Simulate");
        stopButton.setFocusable(false);
        stopButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        stopButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(stopButton);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        jScrollPane3.setAutoscrolls(true);
        jScrollPane3.setMaximumSize(new java.awt.Dimension(1920, 1080));

        cktPanel.setBackground(new java.awt.Color(253, 254, 238));
        cktPanel.setToolTipText("");
        cktPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cktPanel.setPreferredSize(new java.awt.Dimension(1920, 1080));
        cktPanel.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                circuitPanelComponentAdded(evt);
            }
        });
        cktPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                circuitPanelMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                circuitPanelMouseMoved(evt);
            }
        });
        cktPanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                circuitPanelFocusGained(evt);
            }
        });
        cktPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                circuitPanelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                circuitPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cktPanelMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout cktPanelLayout = new javax.swing.GroupLayout(cktPanel);
        cktPanel.setLayout(cktPanelLayout);
        cktPanelLayout.setHorizontalGroup(
            cktPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1920, Short.MAX_VALUE)
        );
        cktPanelLayout.setVerticalGroup(
            cktPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(cktPanel);

        andButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                andButtonMouseDragged(evt);
            }
        });

        orButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                orButtonMouseDragged(evt);
            }
        });

        and3Button.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                and3ButtonMouseDragged(evt);
            }
        });

        or3Button.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                or3ButtonMouseDragged(evt);
            }
        });

        notButton.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                notButtonMouseDragged(evt);
            }
        });

        ledButton.setText("LED");
        ledButton.setToolTipText("LED");
        ledButton.setFocusable(false);
        ledButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ledButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ledButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ledButtonActionPerformed(evt);
            }
        });

        switchButton.setText("Kaynak");
        switchButton.setToolTipText("Switch");
        switchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchButtonActionPerformed(evt);
            }
        });
        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 1187, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(andButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(and3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(or3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ledButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(switchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1043, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(andButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(orButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(and3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(or3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(notButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ledButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(switchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
   
    
    private void iconload(){ 
        ImageIcon and  = new ImageIcon("and.png");
        ImageIcon or2 = new ImageIcon("or2.png");       
        ImageIcon not = new ImageIcon("not.png");       
        ImageIcon and3 = new ImageIcon("and3.png");
        ImageIcon or3 = new ImageIcon("or3.png");
        andButton.setIcon(and);
        orButton.setIcon(or2);       
        notButton.setIcon(not);       
        and3Button.setIcon(and3);
        or3Button.setIcon(or3);        
     
    }  
    
    
    private void ledButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ledButtonActionPerformed
        // TODO add your handling code here:
        mode = ModeEnum.drawing;
        currentDev = DeviceEnum.led;
        numberOfInput = 1;       
     
    }//GEN-LAST:event_ledButtonActionPerformed

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
     
        if ( mode == ModeEnum.run ) return;
        mode = ModeEnum.run;
   
       
        int l = ckt.source.size();
        for ( int i = 0; i < l; i++ )   {
            Source s = ckt.source.get(i);
            s.setOutput(false);
        }
        cktPanel.repaint();
    }//GEN-LAST:event_runButtonActionPerformed

    private void switchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchButtonActionPerformed
       
        mode = ModeEnum.drawing;
        currentDev = DeviceEnum.source;
       
    }//GEN-LAST:event_switchButtonActionPerformed

    private void circuitPanelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_circuitPanelFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_circuitPanelFocusGained

    private void circuitPanelComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_circuitPanelComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_circuitPanelComponentAdded

    private void circuitPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuitPanelMouseMoved
        
        mouseMove = evt;

        if ( mode == ModeEnum.drawing ) {
            if ( currentDev != DeviceEnum.wire )    {
               ckt.setTemp(mouseMove, numberOfInput);
             //Kapılar seçildiğinde setTemp metoduyla birlikte
             //Hangi kapının çizeleceği ve GİRİŞ sayısı circuit sınıfındaki setTemp() metodu ile tetikleniyor.
            
            }
            else    {
                Coordinate c = new Coordinate(evt);
                Device temp = ckt.searchForDevice(c);
                
                if ( temp != null ) {
                    int indx = temp.isOnInLeg(c);
                    if ( indx > -1 )    ckt.pointFlag = true;
                    else if ( temp.isOnOutLeg(c) )  {
                   
                        ckt.pointFlag = true;
                    }
                    else    ckt.pointFlag = false;
                }
                else    ckt.pointFlag = false;
            }
        }
        else if ( mode == ModeEnum.run )    {
            Coordinate c = new Coordinate(evt);
            Device temp = ckt.searchForSource(c);
            if ( temp != null ) {
                //RUN durumunda Kaynağın üzerine geldiğimizde maus iconunun şekli değişir.
                cktPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            else    {
                //RUN durumunda Kaynağın üzerinde değilken maus iconu defaulttur.
                cktPanel.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        }
        cktPanel.repaint();
        
    }//GEN-LAST:event_circuitPanelMouseMoved

    private void circuitPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuitPanelMouseDragged
       
        dragged = evt;
        ckt.end = new Coordinate(dragged);     
        ckt.setTemp(evt, numberOfInput);
        cktPanel.repaint();
    }//GEN-LAST:event_circuitPanelMouseDragged

    private void circuitPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuitPanelMousePressed
       
        if ( mode == ModeEnum.drawing )  {
            if ( currentDev == DeviceEnum.wire )    {
                Device d = ckt.searchForDevice(new Coordinate(evt));
                if ( d != null )    {
                   //Kapılardan birinin Giriş veya Çıkışını tuttuğumuzda bu kısım çalışır !!
                   //isOnInLeg ile mausun kapıların girişleri üzerinde olduğu kontrol ediliyor.
                   //-1'den büyük bir değer dönüyorsa , maus ile giriş aynı konumdadır.
                    int indx = d.isOnInLeg(new Coordinate(evt));
                    if ( indx > -1 || d.isOnOutLeg(new Coordinate(evt)))    {                       
                        pressed = evt;
                        pressedDevice = d;
                        ckt.start = new Coordinate(pressed);
                    }
                    else {                       
                        pressed = null;
                        pressedDevice = null;
                        pressedWire = null;
                    }
                }
                else    {
                    //Panelde boş bir yere mausu basılı tuttuğumuzda bu kısım çalışır! 
                    //Boş bağlantıya izin verilmemesini sağlar.
                    Wire w = ckt.searchForWire(new Coordinate(evt));
                    if ( w != null )    {                       
                        pressed = evt;
                        pressedWire = w;
                        ckt.start = new Coordinate(pressed);
                    }
                    else {                       
                        pressed = null;
                        ckt.start = null;
                        pressedWire = null;
                    }
                }
            }
        }
    }//GEN-LAST:event_circuitPanelMousePressed

    private void circuitPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circuitPanelMouseClicked
     
        if ( mode == ModeEnum.drawing ) {
            ckt.placeTemp();
            currentDev = DeviceEnum.wire;
            
        }
        else if ( mode == ModeEnum.run )    {
            Source s = ckt.searchForSource(new Coordinate(evt));
            if ( s != null )    s.toggleOutput();
        }
     
        cktPanel.repaint();
    }//GEN-LAST:event_circuitPanelMouseClicked

    private void cktPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cktPanelMouseReleased
  
        dragged = null;
        ckt.end = null; //coordinate
        if ( mode == ModeEnum.drawing )  {
            if ( currentDev == DeviceEnum.wire )    {
                Device d = ckt.searchForDevice(new Coordinate(evt));
                if ( d != null )    {
                    
                    int indx = d.isOnInLeg(new Coordinate(evt));
                    if ( indx > -1 || d.isOnOutLeg(new Coordinate(evt)))    {
                                            
                        released = evt;
                        releasedDevice = d;
                        ckt.addWire(new Coordinate(pressed), pressedDevice, new Coordinate(released), releasedDevice);
                    }
                    else {
                        released = null;
                        releasedDevice = null;
                    }
                }
                else    {
                    Wire w = ckt.searchForWire(new Coordinate(evt));
                    if ( w != null )    {
                        pressed = evt;
                        pressedWire = w;
                    }
                    else {
                        pressed = null;
                        pressedWire = null;
                    }
                }
            }
        }
        cktPanel.repaint();
    }//GEN-LAST:event_cktPanelMouseReleased

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
 
        mode = ModeEnum.drawing;
        currentDev = DeviceEnum.wire;
        
        int l = ckt.source.size();
      
        cktPanel.repaint();
     
    }//GEN-LAST:event_stopButtonActionPerformed

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
     
        int i = JOptionPane.showConfirmDialog(null, "Ekranı temizlemek ister misiniz?");
        if ( i == 0 )   ckt.clear();
        cktPanel.repaint();
    }//GEN-LAST:event_clearButtonActionPerformed

    private void andButtonMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_andButtonMouseDragged
        
        if ( mode == ModeEnum.run ) {
           
            return;
        }
        mode = ModeEnum.drawing;
        currentDev = DeviceEnum.and;
        
      
        numberOfInput = 2;       
       
    }//GEN-LAST:event_andButtonMouseDragged

    private void orButtonMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orButtonMouseDragged
        
         if ( mode == ModeEnum.run ) {
           
            return; // metodu terket.
        }
        mode = ModeEnum.drawing;
        currentDev = DeviceEnum.or;
       
      
        numberOfInput = 2;
    }//GEN-LAST:event_orButtonMouseDragged

    private void and3ButtonMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_and3ButtonMouseDragged
        
         if ( mode == ModeEnum.run ) {
           
            return;
        }
        mode = ModeEnum.drawing;
        currentDev = DeviceEnum.and;
       
       
        numberOfInput = 3; 
    }//GEN-LAST:event_and3ButtonMouseDragged

    private void or3ButtonMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_or3ButtonMouseDragged
        
         if ( mode == ModeEnum.run ) {
           
            return;
        }
        mode = ModeEnum.drawing;
        currentDev = DeviceEnum.or;
       
       
        numberOfInput = 3;
    }//GEN-LAST:event_or3ButtonMouseDragged

    private void notButtonMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notButtonMouseDragged
        
         if ( mode == ModeEnum.run ) {
           
            return;
        }
        mode = ModeEnum.drawing;
        currentDev = DeviceEnum.not;
       
       
        numberOfInput = 1;
    }//GEN-LAST:event_notButtonMouseDragged

    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton and3Button;
    private javax.swing.JButton andButton;
    private javax.swing.JPanel cktPanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton ledButton;
    private javax.swing.JButton notButton;
    private javax.swing.JButton or3Button;
    private javax.swing.JButton orButton;
    private javax.swing.JButton runButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JButton switchButton;
    // End of variables declaration//GEN-END:variables
}
