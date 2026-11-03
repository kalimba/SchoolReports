
package schoolreports;

import com.itextpdf.text.Image;
//import java.util.Date;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.pdf.PdfWriter;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.Element;
//import static com.itextpdf.text.Font.FontFamily.TIMES_ROMAN;
import com.itextpdf.text.FontFactory;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import java.awt.*;
//import java.awt.event.KeyEvent;
//import java.io.FileOutputStream;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
//import net.proteanit.sql.DbUtils;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.text.*;
import net.proteanit.sql.DbUtils;

import java.io.FileOutputStream;
//import java.text.DecimalFormat;
 
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
//import com.itextpdf.text.Font.FontFamily;
//import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Phrase;
import static com.itextpdf.text.Rectangle.LEFT;
import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.sql.PreparedStatement;
//import static javax.swing.border.TitledBorder.TOP;

/**
 *
 * @author Kalimba
 */
public class Report extends javax.swing.JFrame {

    static String classidreport;
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    public Report() {
        initComponents();
        conn=mysqlconnection.ConnectDb();
        //studentlist6(jtblreport);
        //getclassid();
    }
   
   private void studentlist6(JTable jtablename6){
     try {   
      String sql= "SELECT students.Studentid,students.First_Name,students.Last_Name,`report`.`Tot-T.J` As `T.J` ,`report`.`Tot-Exam` As Exam ,`report`.`Total` As Total ,`report`.`Percentage` As Percentage, `report`.`Place` As Place, `report`.`BehaviorsMarks` As Behaviors FROM students,report WHERE `students`.`Classid`='"+classidreport+"' and `students`.`Studentid`=`report`.`Studentid` ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
      jtablename6.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e){
      JOptionPane.showMessageDialog(null,e+"studentlis444");  
     }
      }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblreport = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jtblreport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtblreport);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 784, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );

        jButton1.setText("REPORT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:       
       studentlist6(jtblreport); 
    }//GEN-LAST:event_formComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String classnm="", level="";
        try{ 
          String sql= "select Year from classes where Classid='"+classidreport+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();        
        if(rs.next()){ 
          classnm=rs.getString("Year"); 
          //level=rs.getString("level");
        } }catch(Exception e){}        
        int b=0;
        try{
             String sql2="SELECT COUNT(*) As nberofcourses FROM courses where Classid='"+classidreport+"'";
                pst=conn.prepareStatement(sql2);
                rs=pst.executeQuery();
                if(rs.next())
                  { b=rs.getInt("nberofcourses"); 
                  } 
            }catch(Exception e){}
        String[] coursename=new String[b];
        int[] courseid=new int[b];       
         try{  int i=0;
          String sql= "select CourseName, Courseid from courses where Classid='"+classidreport+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();        
        while(rs.next()){ 
          coursename[i] =rs.getString("CourseName"); 
          courseid[i]=rs.getInt("Courseid");
          i++;
        }        }catch(Exception e){}
         int n=0;
        try{
             String sql2="SELECT COUNT(*) As nberofstudents FROM students where Classid='"+classidreport+"'";
                pst=conn.prepareStatement(sql2);
                rs=pst.executeQuery();
                if(rs.next())
                  { n=rs.getInt("nberofstudents"); 
                  } 
            }catch(Exception e){}
         int[] studentid=new int[n]; 
         String[] firstnm=new String[n];
         String[] lastnm=new String[n];
         try{  int i=0;
          String sql= "select Studentid, First_Name, Last_Name from students where Classid='"+classidreport+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();        
        while(rs.next()){ 
          studentid[i]=rs.getInt("Studentid");
          firstnm[i] =rs.getString("First_Name"); 
          lastnm[i] =rs.getString("Last_Name"); 
          i++;
        }   }catch(Exception e){}
         int st=0;
         while(st<n)
         {
         String[] tj=new String[b];
         String[] exam=new String[b];
         String[] tot=new String[b];
         int k=0;
         while(k<b){
         try{  
          String sql= "select `T.J`, `Exam`, `Total` from `marks_report` where Courseid='"+courseid[k]+"' and Classid='"+classidreport+"' and Studentid='"+studentid[st]+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();        
        if(rs.next()){ 
          tj[k]=rs.getString("T.J");
          exam[k] =rs.getString("Exam"); 
         tot[k] =rs.getString("Total"); 
          k++;
        }   }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
         }
         String position="";
         String percentage="";
         String displine="";
         String tottj="";
         String totexam="";
         String totAll="" ;      
         
         try{
             String sql= "select `Tot-T.J`, `Tot-Exam`, `Total`, Percentage, Place, BehaviorsMarks from `report` where Classid='"+classidreport+"' and Studentid='"+studentid[st]+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();        
        if(rs.next()){ 
           position=rs.getString("Place");
           percentage=rs.getString("Percentage");
           displine=rs.getString("BehaviorsMarks");
           tottj=rs.getString("Tot-T.J");
           totexam=rs.getString("Tot-Exam");
           totAll=rs.getString("Total");         
        } }catch(Exception e){}
                 
        
   try{ 
        Document document=new Document();
        PdfWriter.getInstance(document, new FileOutputStream("Report"+studentid[st]+".pdf"));      
        document.open();  
        Paragraph pspace= new Paragraph("  ",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
        document.add(pspace); 
        PdfPTable table=new PdfPTable(1);
        table.setWidthPercentage(100f);
        table.setSpacingBefore(50);
        PdfPCell cell=new PdfPCell(new Paragraph("Title"));            
        cell.setPadding(5f);
        cell.setMinimumHeight(480f);
      
        
        
        PdfPTable tabletop=new PdfPTable(1);
        PdfPCell celltop=new PdfPCell(new Paragraph("SCHOOLREPORT")); 
        celltop.setMinimumHeight(190f);
         celltop.setPaddingLeft(3f);
         Paragraph ptop1= new Paragraph("SCHOOL  REPORT",FontFactory.getFont(FontFactory.TIMES_BOLD,14,Font.BOLD,BaseColor.BLACK ));
         ptop1.setIndentationLeft(190f);         
         Paragraph ptop2= new Paragraph("REPUBLIC OF RWANDA",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
        ptop2.setSpacingBefore(-13);
         Image image =Image.getInstance("logoVisible.png");
        image.setWidthPercentage(15);
        
        Paragraph ptop3b= new Paragraph("NAMES  "+lastnm[st].toUpperCase()+"  "+firstnm[st].toUpperCase(),FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
        Paragraph ptop4b= new Paragraph("ACADEMIC YEAR  2017",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
        Paragraph ptop5b= new Paragraph("CLASS  "+classnm+"  ID  "+studentid[st],FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
         Paragraph ptop6b= new Paragraph("LOWER  LEVER",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
        ptop3b.setIndentationLeft(350f);
        ptop3b.setSpacingBefore(-15);
        ptop4b.setIndentationLeft(350f);
        ptop4b.setSpacingBefore(4);
        ptop5b.setIndentationLeft(350f);
        ptop5b.setSpacingBefore(4);
        ptop6b.setIndentationLeft(350f);
        ptop6b.setSpacingBefore(4);
        
        Paragraph ptop3= new Paragraph("MIMISTRY OF EDUCATION",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
        Paragraph ptop4= new Paragraph("NORTHERN  PROVENCE",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
        Paragraph ptop5= new Paragraph("GICUMBI  DISTRICT",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
        Paragraph ptop6= new Paragraph("SECTOR  MUTETE",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
        Paragraph ptop7= new Paragraph("NAME OF SCHOOL G.S GASEKE",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
        celltop.addElement(ptop1);
        celltop.addElement(ptop2);
        celltop.addElement(image);
        celltop.addElement(ptop3b);
        celltop.addElement(ptop4b);
        celltop.addElement(ptop5b);
        celltop.addElement(ptop6b);
        ptop3.setSpacingBefore(-40);
        celltop.addElement(ptop3);
        celltop.addElement(ptop4);
        celltop.addElement(ptop5);
        celltop.addElement(ptop6);
        celltop.addElement(ptop7);
        tabletop.addCell(celltop);         
        tabletop.setWidthPercentage(100f); 
        cell.addElement(tabletop);
         
        PdfPTable tablecenter=new PdfPTable(19); 
        tablecenter.setWidthPercentage(100f);        
        //cellcenter.setMinimumHeight(300f);
        tablecenter.setSpacingBefore(5f);
        PdfPCell cellT0=new PdfPCell(new Paragraph("SUBJECT"));        
        cellT0.setColspan(3); 
        tablecenter.addCell(cellT0);
        PdfPCell cellT1=new PdfPCell(new Paragraph("max"));        
        cellT1.setColspan(3); 
        tablecenter.addCell(cellT1);        
        PdfPCell cellT2=new PdfPCell(new Paragraph("1st  Term"));
        cellT2.setColspan(3); 
        tablecenter.addCell(cellT2);
        PdfPCell cellT3=new PdfPCell(new Paragraph("2st term"));
        cellT3.setColspan(3); 
        tablecenter.addCell(cellT3);
        PdfPCell cellT4=new PdfPCell(new Paragraph("3st term"));
        cellT4.setColspan(3); 
        tablecenter.addCell(cellT4);
        PdfPCell cellT5=new PdfPCell(new Paragraph("Total Year"));
        cellT5.setColspan(4); 
        tablecenter.addCell(cellT5);        
        //secomd row
        PdfPCell cellR2=new PdfPCell(new Paragraph("",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.BOLD,BaseColor.BLACK )));          
        cellR2.setColspan(3); 
        tablecenter.addCell(cellR2);
        tablecenter.addCell(new Paragraph("TEST",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ))); 
        tablecenter.addCell(new Paragraph("EX.",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.BOLD,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph("TOT.",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.BOLD,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph("TEST",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ))); 
        tablecenter.addCell(new Paragraph("EX.",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.BOLD,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph("TOT.",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.BOLD,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph("TEST",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ))); 
        tablecenter.addCell(new Paragraph("EX.",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.BOLD,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph("TOT.",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.BOLD,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph("TEST",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ))); 
        tablecenter.addCell(new Paragraph("EX.",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.BOLD,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph("TOT.",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.BOLD,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph("TEST",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ))); 
        tablecenter.addCell(new Paragraph("EX.",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.BOLD,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph("TOT.",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.BOLD,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph("%",FontFactory.getFont(FontFactory.TIMES_BOLD,9,Font.BOLD,BaseColor.BLACK )));        
         
           int r=0;
        while(r<b)
        {PdfPCell cellR3=new PdfPCell(new Paragraph(coursename[r]));        
        cellR3.setColspan(3); 
        tablecenter.addCell(cellR3);
        int i=1;
        tablecenter.addCell(new Paragraph("50",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph("50",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph("100",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
        while(i<=3)
        {   if(i==1){
         tablecenter.addCell(new Paragraph(tj[r],FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
         tablecenter.addCell(new Paragraph(exam[r],FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
         tablecenter.addCell(new Paragraph(tot[r],FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
                    }
        else{
        tablecenter.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
        }
        i++;}
       
        tablecenter.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
         tablecenter.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
         tablecenter.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));      
        
        r++;
        }
        PdfPCell cellR3=new PdfPCell(new Paragraph("Total"));        
        cellR3.setColspan(3); 
        tablecenter.addCell(cellR3);
        int i=1;
        tablecenter.addCell(new Paragraph("150",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph("150",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
        tablecenter.addCell(new Paragraph("300",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
        while(i<=3)
        {   if(i==1){
         tablecenter.addCell(new Paragraph(tottj,FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.BOLD,BaseColor.BLACK )));
         tablecenter.addCell(new Paragraph(totexam,FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.BOLD,BaseColor.BLACK )));
         tablecenter.addCell(new Paragraph(totAll,FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.BOLD,BaseColor.BLACK )));
        }else{
         tablecenter.addCell(new Paragraph("",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
         tablecenter.addCell(new Paragraph("",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
         tablecenter.addCell(new Paragraph("",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
        }
        i++;}
         
         tablecenter.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
         tablecenter.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
         tablecenter.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
         tablecenter.addCell(new Paragraph(" ",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
       
        
        
        
         PdfPCell cellperc1=new PdfPCell(new Paragraph("Percentage"));        
        cellperc1.setColspan(3); 
        tablecenter.addCell(cellperc1);
        PdfPCell cellperc2=new PdfPCell(new Paragraph(""));        
        cellperc2.setColspan(3); 
        tablecenter.addCell(cellperc2);        
        PdfPCell cellperc3=new PdfPCell(new Paragraph(percentage+"%",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD,BaseColor.BLACK )));
        cellperc3.setColspan(3); 
        cellperc3.setHorizontalAlignment(Element.ALIGN_RIGHT);
        tablecenter.addCell(cellperc3);
        PdfPCell cellperc4=new PdfPCell(new Paragraph("%",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD,BaseColor.BLACK )));
        cellperc4.setColspan(3); 
        cellperc4.setHorizontalAlignment(Element.ALIGN_RIGHT);
        tablecenter.addCell(cellperc4);
        PdfPCell cellperc5=new PdfPCell(new Paragraph("%",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD,BaseColor.BLACK )));
        cellperc5.setColspan(3); 
        cellperc5.setHorizontalAlignment(Element.ALIGN_RIGHT);
        tablecenter.addCell(cellperc5);
        PdfPCell cellperc6=new PdfPCell(new Paragraph("%",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD,BaseColor.BLACK )));
        cellperc6.setColspan(4); 
        cellperc6.setHorizontalAlignment(Element.ALIGN_RIGHT);
        tablecenter.addCell(cellperc6); 
        
        PdfPCell cellpos1=new PdfPCell(new Paragraph("Position"));        
        cellpos1.setColspan(3); 
        tablecenter.addCell(cellpos1);
        PdfPCell cellpos2=new PdfPCell(new Paragraph(""));        
        cellpos2.setColspan(3); 
        tablecenter.addCell(cellpos2);        
        PdfPCell cellpos3=new PdfPCell(new Paragraph(position+" out of "+n,FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD,BaseColor.BLACK )));
        cellpos3.setColspan(3);
        cellpos3.setHorizontalAlignment(Element.ALIGN_CENTER);
        tablecenter.addCell(cellpos3);
        PdfPCell cellpos4=new PdfPCell(new Paragraph("  out of  ",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD,BaseColor.BLACK )));
        cellpos4.setColspan(3); 
        cellpos4.setHorizontalAlignment(Element.ALIGN_CENTER);
        tablecenter.addCell(cellpos4);
        PdfPCell cellpos5=new PdfPCell(new Paragraph("  out of  ",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD,BaseColor.BLACK )));
        cellpos5.setColspan(3); 
        cellpos5.setHorizontalAlignment(Element.ALIGN_CENTER);
        tablecenter.addCell(cellpos5);
        PdfPCell cellpos6=new PdfPCell(new Paragraph("  out of  ",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,Font.BOLD,BaseColor.BLACK )));
        cellpos6.setColspan(4); 
        cellpos6.setHorizontalAlignment(Element.ALIGN_CENTER);
        tablecenter.addCell(cellpos6);
        
        PdfPCell celldisp1=new PdfPCell(new Paragraph("Discipline"));        
        celldisp1.setColspan(3); 
        tablecenter.addCell(celldisp1);
        PdfPCell celldisp2=new PdfPCell(new Paragraph("50",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));        
        celldisp2.setColspan(3); 
        celldisp2.setHorizontalAlignment(Element.ALIGN_RIGHT);
        tablecenter.addCell(celldisp2);        
        PdfPCell celldisp3=new PdfPCell(new Paragraph(displine,FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
        celldisp3.setColspan(3);
        celldisp3.setHorizontalAlignment(Element.ALIGN_RIGHT);
        tablecenter.addCell(celldisp3);
        PdfPCell celldisp4=new PdfPCell(new Paragraph("",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
        celldisp4.setColspan(3);         
        tablecenter.addCell(celldisp4);
        PdfPCell celldisp5=new PdfPCell(new Paragraph("",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));
        celldisp5.setColspan(3); 
        tablecenter.addCell(celldisp5);
        PdfPCell celldisp6=new PdfPCell(new Paragraph("",FontFactory.getFont(FontFactory.TIMES_ROMAN,9,BaseColor.BLACK )));       
        celldisp6.setColspan(4); 
        tablecenter.addCell(celldisp6); 
        
        PdfPCell cellTeach1=new PdfPCell(new Paragraph("Classteacher's signature",FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.BOLD,BaseColor.BLACK )));       
        cellTeach1.setColspan(3);
        cellTeach1.setMinimumHeight(25f);
        tablecenter.addCell(cellTeach1);
        PdfPCell cellTeach2=new PdfPCell(new Paragraph(""));        
        cellTeach2.setColspan(3); 
        cellTeach2.setMinimumHeight(25f);
        tablecenter.addCell(cellTeach2);        
        PdfPCell cellTeach3=new PdfPCell(new Paragraph(""));
        cellTeach3.setColspan(3);
        cellTeach3.setMinimumHeight(25f);
        tablecenter.addCell(cellTeach3);
        PdfPCell cellTeach4=new PdfPCell(new Paragraph(""));
        cellTeach4.setColspan(3); 
        cellTeach4.setMinimumHeight(25f);
        tablecenter.addCell(cellTeach4);
        PdfPCell cellTeach5=new PdfPCell(new Paragraph(""));
        cellTeach5.setColspan(3);
        cellTeach5.setMinimumHeight(25f);
        tablecenter.addCell(cellTeach5);
        PdfPCell cellTeach6=new PdfPCell(new Paragraph(""));
        cellTeach6.setColspan(4);
        cellTeach6.setMinimumHeight(25f);
        tablecenter.addCell(cellTeach6);
        
        PdfPCell cellparent1=new PdfPCell(new Paragraph("Parent's signature",FontFactory.getFont(FontFactory.TIMES_ROMAN,8,Font.BOLD,BaseColor.BLACK )));      
        cellparent1.setColspan(3);
        cellparent1.setMinimumHeight(25f);
        tablecenter.addCell(cellparent1);
        PdfPCell cellparent2=new PdfPCell(new Paragraph(""));        
        cellparent2.setColspan(3); 
        cellparent2.setMinimumHeight(25f);
        tablecenter.addCell(cellparent2);        
        PdfPCell cellparent3=new PdfPCell(new Paragraph(""));
        cellparent3.setColspan(3);
        cellparent3.setMinimumHeight(25f);
        tablecenter.addCell(cellparent3);
        PdfPCell cellparent4=new PdfPCell(new Paragraph(""));
        cellparent4.setColspan(3); 
        cellparent4.setMinimumHeight(25f);
        tablecenter.addCell(cellparent4);
        PdfPCell cellparent5=new PdfPCell(new Paragraph(""));
        cellparent5.setColspan(3); 
        cellparent5.setMinimumHeight(25f);
        tablecenter.addCell(cellparent5);
        PdfPCell cellparent6=new PdfPCell(new Paragraph(""));        
        cellparent6.setColspan(4); 
        cellparent6.setMinimumHeight(25f);
        tablecenter.addCell(cellparent6);
        
        cell.addElement(tablecenter);
         
        PdfPTable tablebottom=new PdfPTable(1);
        tablebottom.setSpacingBefore(5f);
        tablebottom.setWidthPercentage(100f); 
        PdfPCell cellbottom=new PdfPCell(new Paragraph("END OF YEAR EVALUATION AND DECISIOMkkkk",FontFactory.getFont(FontFactory.TIMES_ROMAN,10,Font.BOLD,BaseColor.BLACK )));
        cellbottom.setMinimumHeight(80f);
        //cellbottom.setHorizontalAlignment(Element.ALIGN_CENTER); 
        
        Paragraph p1= new Paragraph("END OF YEAR EVALUATION AND DECISIOM",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
        p1.setIndentationLeft(180); 
        p1.setSpacingAfter(30f);
        Paragraph p2= new Paragraph("Promoted: [    ]",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
        Paragraph p2b= new Paragraph("Headteacher's Signature",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
        p2.setIndentationLeft(20);
        p2b.setIndentationLeft(300);        
        Paragraph p3= new Paragraph("Repeated: [    ]",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
         p3.setIndentationLeft(20);
         Paragraph p3b= new Paragraph("and School Stamp",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
         p3b.setIndentationLeft(300);         
        Paragraph p4= new Paragraph("Observation:",FontFactory.getFont(FontFactory.TIMES_BOLD,8,Font.BOLD,BaseColor.BLACK ));
        p4.setIndentationLeft(20);        
        p3.setAlignment(LEFT);
        p2.setAlignment(LEFT);
         p4.setSpacingAfter(15f);
       // p1.setAlignment(TOP);
        cellbottom.addElement(p1);        
        cellbottom.addElement(p2);
        cellbottom.addElement(p2b);        
        cellbottom.addElement(p3);
        cellbottom.addElement(p3b);
        cellbottom.addElement(p4);
        
        tablebottom.addCell(cellbottom);      
        cell.addElement(tablebottom);         
          
        table.addCell(cell);        
        document.add(table);       
        document.close(); 
        
      }
      catch(Exception e) { 
         JOptionPane.showMessageDialog(null, e);
       }  st++; }  JOptionPane.showMessageDialog(null,"Report saved");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtblreport;
    // End of variables declaration//GEN-END:variables
}
