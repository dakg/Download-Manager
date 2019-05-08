
package download.manager;

import downloadManagerUI.main_window;
import static downloadManagerUI.main_window.Table;
import downloadManagerUI.window2;
import static downloadManagerUI.window2.getFileName;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import downloadManagerUI.window3;
import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class DownloadManager implements Runnable {

    private URL url;
    private String loc;
    private static final int MAX_BUFFER_SIZE = 1024;
    private int fileSize;
    private int downloaded;
    public static int downloadingStatus;
    private float percent;
    long starttime;
    long currenttime;
    long elapsedtime;
    
    public int count=0,j=0;
    public static String status;
    
    public static final int PAUSED = 0;
    public static final int DOWNLOADING = 1;
    public static final int COMPLETED = 2;
    public static final int CANCELLED = 3;
    public static final int ERROR = 4;
    
    window3 w3;
    public main_window mw;
    public static DefaultTableModel di;
    public static Object tb[];
    public String fname="";
    
    public DownloadManager(URL url,String loc ,window3 w3)
    { 
       this.url = url;
       this.loc = loc;
        downloaded = 0;
        this.w3 = w3;
    }
   
    private String getFileName()
    {
        String fileName=url.getPath();
        return fileName.substring(fileName.lastIndexOf('/')+1);
    }
    
    private void error()
    {
        downloadingStatus = ERROR;
    }
    
    
    public void run()
    {
        RandomAccessFile file=null;
        InputStream istream=null;
        try{
          
            HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
            urlcon.setRequestProperty("Range","bytes="+ downloaded + "-");
            urlcon.connect();
            
            if(urlcon.getResponseCode() / 100 != 2)
            {
                System.out.println("error");
                error();
            }
            
            fileSize = urlcon.getContentLength();
            
            file = new RandomAccessFile(loc,"rw");
            file.seek(downloaded);
            istream = urlcon.getInputStream();
            
            byte buffer[];
            buffer = new byte[MAX_BUFFER_SIZE];
            int i;
            downloadingStatus = DOWNLOADING;
            starttime = System.currentTimeMillis();
            
            
            if(fname == "" || fname == getFileName()){
                fname=getFileName();
                if(j!=0){ j++; }
            }
            
            while ((i = istream.read(buffer, 0, MAX_BUFFER_SIZE)) != -1)
            {
                downloaded = downloaded + i;
                currenttime = System.currentTimeMillis();
                elapsedtime = currenttime - starttime;
             
                tb=new Object[]{w3.sr_no,getFileName(),String.format("%.2f",w3.fs_in_mb),status};
                di=(DefaultTableModel) main_window.Table.getModel();
                
                    if(count==0){
                        di.insertRow(j,tb);
                        count=1;
                    }else{
                        di.setValueAt(tb[0], j, 0);
                        di.setValueAt(tb[1], j, 1);
                        di.setValueAt(tb[2], j, 2);
                        di.setValueAt(tb[3], j, 3);
                    }
                file.write(buffer, 0, i);
                      
                {
                    if(status!="Cancelled"){
                             SwingUtilities.invokeLater(new Runnable() {
                                   public void run() {
                                   w3.updateinfo( downloaded , elapsedtime );
                                   }               
                              });
                    }
                    else{
                        file.close();
                    }
                }
            }
            downloadingStatus = COMPLETED;
            if(downloadingStatus == COMPLETED ){
                file.close();
                status="Completed";
                di.setValueAt("Completed", 0, 5);
                int c=JOptionPane.showConfirmDialog(mw, "You want to open your file now???");
                if(c==0){
                    boolean b=Desktop.isDesktopSupported();
                    if(b==true)
                    {
                        String filepath=window2.loc;
                        File fop=new File(filepath);
                        Desktop.getDesktop().open(fop);
                    }else{
                        System.out.println("Desktop not supported.");
                    }
                }
                w3.setVisible(false);
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }  
}
