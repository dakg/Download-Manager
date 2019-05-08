
package downloadManagerUI;

import download.manager.DownloadManager;
import java.awt.Color;
import java.net.URL;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;


public class window3 extends javax.swing.JFrame {

    private URL url3;
    String loc ;
    int fs;
    public static int sr_no=0;
    public float fs_in_mb;
    float fs_in_kb;
    public float speed;
    public float percent;
    float timeleft;
    public float download;
    private window3 w3;
    public int stop=0;
    Thread t;
    DownloadManager dm;
    
    public window3(URL url3 ,String loc ) {
        setTitle(window2.getFileName());
        initComponents();
        this.loc=loc;
        DownloadManager obj=new DownloadManager(url3, loc ,this);
        t = new Thread(obj);
        t.start();
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        url = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        filesize = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        downloadedfield = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        speedfield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        timeleftfield = new javax.swing.JTextField();
        jProgressBar = new javax.swing.JProgressBar();
        pause = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        resume = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Url");

        url.setEditable(false);
        url.setBackground(new java.awt.Color(235, 235, 235));
        url.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        url.setAutoscrolls(false);
        url.setBorder(null);
        url.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setText("File Size");

        filesize.setEditable(false);
        filesize.setBackground(new java.awt.Color(234, 234, 234));
        filesize.setBorder(null);

        jLabel3.setText("Downloaded");

        downloadedfield.setEditable(false);
        downloadedfield.setBackground(new java.awt.Color(234, 234, 234));
        downloadedfield.setBorder(null);

        jLabel4.setText("Speed");

        speedfield.setEditable(false);
        speedfield.setBackground(new java.awt.Color(234, 234, 234));
        speedfield.setBorder(null);

        jLabel5.setText("Time left");

        timeleftfield.setEditable(false);
        timeleftfield.setBackground(new java.awt.Color(234, 234, 234));
        timeleftfield.setBorder(null);

        jProgressBar.setForeground(new java.awt.Color(153, 0, 153));

        pause.setText("Pause");
        pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseActionPerformed(evt);
            }
        });

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        resume.setText("Resume");
        resume.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resumeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(63, 63, 63)
                        .addComponent(url)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(pause)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(resume)
                        .addGap(18, 18, 18)
                        .addComponent(cancel)
                        .addGap(88, 88, 88))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(timeleftfield)
                                    .addComponent(speedfield, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(filesize, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(downloadedfield, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(210, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(filesize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(downloadedfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(speedfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeleftfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pause)
                    .addComponent(cancel)
                    .addComponent(resume))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseActionPerformed
    
        dm.status="Paused";
        dm.di.setValueAt("Paused", 0, 3);
        t.suspend();
    }//GEN-LAST:event_pauseActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        
        dm.status="Cancelled";
        dm.di.setValueAt("Cancelled", 0, 3);
        w3.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void resumeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resumeMouseClicked
        
        dm.status="Downloading";
        dm.di.setValueAt("Downloading", 0, 3);
        t.resume();
    }//GEN-LAST:event_resumeMouseClicked

    public void setfileinfo2(URL ur3,int fs3, String stringurl3 )
    {
        url3 = ur3;
        fs = fs3;
        fs_in_kb = (float)(fs3/1024.00);
        fs_in_mb = (float)(fs3/1048576.00);
        filesize.setText(String.format("%.2f",fs_in_mb) + " MB");
        url.setText(stringurl3);
        
    }
 
    public void updateinfo(int downloaded , long elapsedtime) 
    {
        this.download=downloaded/(float)1048576.00;
        
        percent = (float)downloaded/fs * 100;
        speed = (float)(downloaded * 1.00/ elapsedtime * 1.00)  ; 
        timeleft = (float)((fs_in_kb - (downloaded/1024)) / speed) ;
        float down = (float)((downloaded)/1048576.00);
        downloadedfield.setText(String.format("%.2f",down) + "/" + String.format("%.2f",fs_in_mb) + "MB");
        speedfield.setText(String.format("%.3f",speed) + "KB/s" );
        timeleftfield.setText(String.format("%.2f",timeleft) + "sec");
        jProgressBar.setValue((int)percent);
    }
    
    public void window3call(final window3 w3) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(window3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(window3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(window3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(window3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        this.w3=w3;
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                w3.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JTextField downloadedfield;
    private javax.swing.JTextField filesize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar;
    private javax.swing.JButton pause;
    private javax.swing.JButton resume;
    private javax.swing.JTextField speedfield;
    private javax.swing.JTextField timeleftfield;
    private javax.swing.JTextField url;
    // End of variables declaration//GEN-END:variables
}
