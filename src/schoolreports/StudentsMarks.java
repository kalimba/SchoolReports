/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolreports;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Kalimba
 */
public class StudentsMarks extends javax.swing.JFrame {

   static String username, password;
   String classid="" , courseid="";
   Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    String jt="test_quiz_works";
    String field="Quiz1";

    public StudentsMarks() {
        initComponents();
        conn=mysqlconnection.ConnectDb();
        
           }  
    public void close(){
WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
}
        public void fill_combocoursename(){
        displayuser();
        try{
          String sql= "select CourseName from courses where Classid='"+classid+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        
        while(rs.next()){
           String name=rs.getString("CourseName");
            jcombocoursename.addItem(name);
        }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(null,e+"fill_combocoursenam");
        }}
    public void displayuser()
     {
   String sql1 = "SELECT * FROM classes,teachers WHERE teachers.username='"+username+"' and teachers.password='"+password+"' and classes.Tutiraireid=teachers.Techid"; 
        try{ 
            pst=conn.prepareStatement(sql1);
            rs=pst.executeQuery();
            if(rs.next())
            { classid=rs.getString("Classid");
              
              String x=rs.getString("Year");
            jlblloggedclass.setText("THIS IS "+x+" CLASS");
            }
            }catch(Exception e){
            JOptionPane.showMessageDialog(null,"there is problem");}
            } 
    private void selectedcourseName()   
    {      try{  
        
           String course= (String) jcombocoursename.getSelectedItem();
           course=course.trim();      
           String sql41 = "SELECT Courseid FROM courses where CourseName='"+course+"' and Classid='"+classid+"'"; 
           pst=conn.prepareStatement(sql41);
            rs=pst.executeQuery();
            if(rs.next())
            { courseid=rs.getString("Courseid");
             }
          }catch(Exception e){ JOptionPane.showMessageDialog(null,e+"selectedcourseNam");}
    }
    private void studentlist(JTable jtablename){
     try { 
           selectedcourseName();
     //String sql= "SELECT * FROM courses,classes,students,`"+tblname+"` WHERE students.Classid=`"+classid+"` and `"+tblname+"`.Classid=classes.Classid and courses.Courseid=`"+tblname+"`.Courseid ";
      String sql= "SELECT students.Studentid,students.First_Name,students.Last_Name,`test_quiz_works`.`Quiz1` As Marks FROM students,test_quiz_works WHERE `students`.`Classid`='"+classid+"' and `students`.`Studentid`=`test_quiz_works`.`Studentid` and `test_quiz_works`.`Courseid`='"+courseid+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
     jtablename.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e){
      JOptionPane.showMessageDialog(null,e+"studentlis");  
     }
      }    
    private void studentlist2(JTable jtablename2){
     try { 
           selectedcourseName();
     //String sql= "SELECT * FROM courses,classes,students,`"+tblname+"` WHERE students.Classid=`"+classid+"` and `"+tblname+"`.Classid=classes.Classid and courses.Courseid=`"+tblname+"`.Courseid ";
      String sql= "SELECT students.Studentid,students.First_Name,students.Last_Name,`test_quiz_works`.`Quiz2` As Marks FROM students,test_quiz_works WHERE `students`.`Classid`='"+classid+"' and `students`.`Studentid`=`test_quiz_works`.`Studentid` and `test_quiz_works`.`Courseid`='"+courseid+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
     jtablename2.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e){
      JOptionPane.showMessageDialog(null,e+"studentlis222");  
     }
      } 
        private void studentlist3(JTable jtablename3){
     try { 
           selectedcourseName();
     //String sql= "SELECT * FROM courses,classes,students,`"+tblname+"` WHERE students.Classid=`"+classid+"` and `"+tblname+"`.Classid=classes.Classid and courses.Courseid=`"+tblname+"`.Courseid ";
      String sql= "SELECT students.Studentid,students.First_Name,students.Last_Name,`test_quiz_works`.`Test1` As Marks FROM students,test_quiz_works WHERE `students`.`Classid`='"+classid+"' and `students`.`Studentid`=`test_quiz_works`.`Studentid` and `test_quiz_works`.`Courseid`='"+courseid+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
     jtablename3.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e){
      JOptionPane.showMessageDialog(null,e+"studentlis333");  
     }
      }
      private void studentlist4(JTable jtablename4){
     try { 
           selectedcourseName();
     //String sql= "SELECT * FROM courses,classes,students,`"+tblname+"` WHERE students.Classid=`"+classid+"` and `"+tblname+"`.Classid=classes.Classid and courses.Courseid=`"+tblname+"`.Courseid ";
      String sql= "SELECT students.Studentid,students.First_Name,students.Last_Name,`test_quiz_works`.`Test2` As Marks FROM students,test_quiz_works WHERE `students`.`Classid`='"+classid+"' and `students`.`Studentid`=`test_quiz_works`.`Studentid` and `test_quiz_works`.`Courseid`='"+courseid+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
     jtablename4.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e){
      JOptionPane.showMessageDialog(null,e+"studentlis444");  
     }
      }
         private void studentlist5(JTable jtablename5){
     try { 
           selectedcourseName();
     //String sql= "SELECT * FROM courses,classes,students,`"+tblname+"` WHERE students.Classid=`"+classid+"` and `"+tblname+"`.Classid=classes.Classid and courses.Courseid=`"+tblname+"`.Courseid ";
      String sql= "SELECT students.Studentid,students.First_Name,students.Last_Name,`test_quiz_works`.`Works` As Marks FROM students,test_quiz_works WHERE `students`.`Classid`='"+classid+"' and `students`.`Studentid`=`test_quiz_works`.`Studentid` and `test_quiz_works`.`Courseid`='"+courseid+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
     jtablename5.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e){
      JOptionPane.showMessageDialog(null,e+"studentlis555");  
     }
      }
     private void studentlist6(JTable jtablename6){
     try { 
           selectedcourseName();
     //String sql= "SELECT * FROM courses,classes,students,`"+tblname+"` WHERE students.Classid=`"+classid+"` and `"+tblname+"`.Classid=classes.Classid and courses.Courseid=`"+tblname+"`.Courseid ";
      String sql= "SELECT students.Studentid,students.First_Name,students.Last_Name,`marks_report`.`T.J` As Marks FROM students,marks_report WHERE `students`.`Classid`='"+classid+"' and `students`.`Studentid`=`marks_report`.`Studentid` and `marks_report`.`Courseid`='"+courseid+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
     jtablename6.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e){
      JOptionPane.showMessageDialog(null,e+"studentlis444");  
     }
      }
     private void studentlist7(JTable jtablename7){
     try { 
           selectedcourseName();
     //String sql= "SELECT * FROM courses,classes,students,`"+tblname+"` WHERE students.Classid=`"+classid+"` and `"+tblname+"`.Classid=classes.Classid and courses.Courseid=`"+tblname+"`.Courseid ";
      String sql= "SELECT students.Studentid,students.First_Name,students.Last_Name,`marks_report`.`Exam` As Marks FROM students,marks_report WHERE `students`.`Classid`='"+classid+"' and `students`.`Studentid`=`marks_report`.`Studentid` and `marks_report`.`Courseid`='"+courseid+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
     jtablename7.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e){
      JOptionPane.showMessageDialog(null,e+"studentlis444");  
     }
      }
    private void studentlist9(JTable jtablename9){
     try { 
           selectedcourseName();
     //String sql= "SELECT * FROM courses,classes,students,`"+tblname+"` WHERE students.Classid=`"+classid+"` and `"+tblname+"`.Classid=classes.Classid and courses.Courseid=`"+tblname+"`.Courseid ";
      String sql= "SELECT students.Studentid,students.First_Name,students.Last_Name,`marks_report`.`Total` As Marks FROM students,marks_report WHERE `students`.`Classid`='"+classid+"' and `students`.`Studentid`=`marks_report`.`Studentid` and `marks_report`.`Courseid`='"+courseid+"'";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
     jtablename9.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e){
      JOptionPane.showMessageDialog(null,e+"studentlis444");  
     }
      }
     private void studentlist8(JTable jtablename8) {    
     try { 
           selectedcourseName();
     //String sql= "SELECT * FROM courses,classes,students,`"+tblname+"` WHERE students.Classid=`"+classid+"` and `"+tblname+"`.Classid=classes.Classid and courses.Courseid=`"+tblname+"`.Courseid ";
      String sql= "SELECT students.Studentid,students.First_Name,students.Last_Name,`report`.`BehaviorsMarks` As Marks FROM students,report WHERE `students`.`Classid`='"+classid+"' and `students`.`Studentid`=`report`.`Studentid` ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
     jtablename8.setModel(DbUtils.resultSetToTableModel(rs));
     }
     catch(Exception e){
      JOptionPane.showMessageDialog(null,e+"studentlis444");  
     }
      }    
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtxtmarksinput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jtxtmarksoutof = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jlblresultname = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jcombocoursename = new javax.swing.JComboBox<>();
        jlblmarksln = new javax.swing.JLabel();
        jlblmarksfn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jlblmessage = new javax.swing.JLabel();
        jlblmessage1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblquiz1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtblquiz2 = new javax.swing.JTable();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jtbltest1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbltest2 = new javax.swing.JTable();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtblworks = new javax.swing.JTable();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbltj = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jtblexam = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtbltot = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jtblbehavior = new javax.swing.JTable();
        jlblloggedclass = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenuItem1.setText("jMenuItem1");

        jMenu3.setText("jMenu3");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(100, 100));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setSize(new java.awt.Dimension(0, 0));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setText("Marks");

        jButton2.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setText("First-Name");

        jButton1.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jButton1.setText("SAVE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setText("out of");

        jlblresultname.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jlblresultname.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel5.setText("Result of");

        jcombocoursename.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jcombocoursename.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jcombocoursename.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jcombocoursenamePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jlblmarksln.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlblmarksln.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlblmarksfn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlblmarksfn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setText("Last-Name");

        jlblmessage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlblmessage.setText("Marks Saved to");
        jlblmessage.setToolTipText("");
        jlblmessage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jlblmessage1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jlblmessage1.setToolTipText("");
        jlblmessage1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton3.setFont(new java.awt.Font("Times New Roman", 3, 12)); // NOI18N
        jButton3.setText("REFLESH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("REPORT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 10))); // NOI18N
        jPanel1.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlblresultname, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jlblmessage)
                                .addGap(18, 18, 18)
                                .addComponent(jlblmessage1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtmarksinput, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtmarksoutof, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jlblmarksln, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jlblmarksfn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jcombocoursename, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4)
                                    .addComponent(jButton3))))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblresultname, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jcombocoursename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlblmarksfn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlblmarksln, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtmarksoutof, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtmarksinput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlblmessage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlblmessage, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(6, 6, 6))
        );

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTabbedPane2.setPreferredSize(new java.awt.Dimension(1180, 680));
        jTabbedPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane2MouseClicked(evt);
            }
        });

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1100, 650));
        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jtblquiz1.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblquiz1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblquiz1MouseClicked(evt);
            }
        });
        jtblquiz1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtblquiz1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jtblquiz1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quiz1", jPanel3);

        jtblquiz2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtblquiz2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblquiz2MouseClicked(evt);
            }
        });
        jtblquiz2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtblquiz2KeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(jtblquiz2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Quiz2", jPanel4);

        jTabbedPane2.addTab("QUIZS", jTabbedPane1);

        jTabbedPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane3MouseClicked(evt);
            }
        });

        jtbltest1.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbltest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbltest1MouseClicked(evt);
            }
        });
        jtbltest1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbltest1KeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(jtbltest1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Test1", jPanel5);

        jtbltest2.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbltest2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbltest2MouseClicked(evt);
            }
        });
        jtbltest2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbltest2KeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jtbltest2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("Test2", jPanel6);

        jTabbedPane2.addTab("TESTS", jTabbedPane3);

        jtblworks.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblworks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblworksMouseClicked(evt);
            }
        });
        jtblworks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtblworksKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jtblworks);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Summation of all works", jPanel7);

        jTabbedPane2.addTab("WORKS", jTabbedPane4);

        jtbltj.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbltj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbltjMouseClicked(evt);
            }
        });
        jtbltj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbltjKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(jtbltj);

        jTabbedPane5.addTab("Summation of Quizs, Tests and Works", jScrollPane5);

        jTabbedPane2.addTab("  T.J  ", jTabbedPane5);

        jtblexam.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblexam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblexamMouseClicked(evt);
            }
        });
        jtblexam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtblexamKeyReleased(evt);
            }
        });
        jScrollPane9.setViewportView(jtblexam);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("EXAM", jPanel8);

        jtbltot.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbltot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbltotMouseClicked(evt);
            }
        });
        jtbltot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtbltotKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(jtbltot);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("TOTAL", jPanel9);

        jtblbehavior.setModel(new javax.swing.table.DefaultTableModel(
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
        jtblbehavior.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblbehaviorMouseClicked(evt);
            }
        });
        jtblbehavior.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtblbehaviorKeyReleased(evt);
            }
        });
        jScrollPane10.setViewportView(jtblbehavior);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 817, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("BEHAVIORS", jPanel10);

        jlblloggedclass.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jlblloggedclass.setText(" P1-A CLASS ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jlblloggedclass))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlblloggedclass)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(jlblmessage1.getText().trim().isEmpty())
        {              
        String resultname=jlblresultname.getText();
        resultname=resultname.trim();
     if(!resultname.isEmpty())
     {                             
         String marksinput=jtxtmarksinput.getText().trim();
         String marksoutof=jtxtmarksoutof.getText().trim();
         String fn=jlblmarksfn.getText().trim();
         String ln=jlblmarksln.getText().trim();
         String studentid="";
         try{     
         String sql = "SELECT Studentid FROM students where First_Name='"+fn+"' and Last_Name='"+ln+"' and Classid='"+classid+"' ";
          pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {  studentid=rs.getString("Studentid"); } 
           }catch(Exception e){}
         
         if(!marksinput.isEmpty() && !marksoutof.isEmpty())
         { try{ 
           double marksinputval= Double.parseDouble(marksinput);
           double marksoutofval=Double.parseDouble(marksoutof);
           if(marksoutofval>0 && marksinputval>0 && marksinputval<=marksoutofval){
               
           if(resultname=="Quiz one")
           {
              try{   
                  double quiz=(marksinputval/marksoutofval)*5;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql77="update test_quiz_works set Quiz1='"+quizval+"' where Studentid='"+studentid+"' and Courseid='"+courseid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();
                  JOptionPane.showMessageDialog(null,"saved well.");
                  studentlist(jtblquiz1);
                }catch(Exception e){}    
           }
           else if(resultname=="Quiz two")
           {
                try{
                  double quiz=(marksinputval/marksoutofval)*5;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql77="update test_quiz_works set Quiz2='"+quizval+"' where Studentid='"+studentid+"' and Courseid='"+courseid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();
                  JOptionPane.showMessageDialog(null,"saved well.");  
                  studentlist2(jtblquiz2);       
                }catch(Exception e){}
           }
           else if(resultname=="Test one")
           {
                try{
                  double quiz=(marksinputval/marksoutofval)*15;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql77="update test_quiz_works set Test1='"+quizval+"' where Studentid='"+studentid+"' and Courseid='"+courseid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();
                  JOptionPane.showMessageDialog(null,"saved well."); 
                  studentlist3(jtbltest1);      
                }catch(Exception e){}
           }
           else if(resultname=="Test two")
           {
               try{
                  double quiz=(marksinputval/marksoutofval)*15;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql77="update test_quiz_works set Test2='"+quizval+"' where Studentid='"+studentid+"' and Courseid='"+courseid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();
                  JOptionPane.showMessageDialog(null,"saved well.");
                   studentlist4(jtbltest2);       
                }catch(Exception e){}
           }
           else if(resultname=="Works")
           {
                try{
                  double quiz=(marksinputval/marksoutofval)*10;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql77="update test_quiz_works set Works='"+quizval+"' where Studentid='"+studentid+"' and Courseid='"+courseid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();
                  JOptionPane.showMessageDialog(null,"saved well.");
                  studentlist5(jtblworks);       
                }catch(Exception e){}
           }
           else if(resultname=="T.J")
           {
                try{  JOptionPane.showMessageDialog(null,"Use UPDATE Button if you want to change T.J."); 
                      
                  }catch(Exception e){}
           }
           else if(resultname=="Exam")
           {
               try{
                  double quiz=(marksinputval/marksoutofval)*50;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql77="update marks_report set Exam='"+quizval+"' where Studentid='"+studentid+"' and Courseid='"+courseid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();
                  JOptionPane.showMessageDialog(null,"saved well."); 
                  studentlist7(jtblexam);
                }catch(Exception e){}
           }
           else if(resultname=="Behaviors")
           {    
               try{
                  double quiz=(marksinputval/marksoutofval)*50;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql77="update report set BehaviorsMarks='"+quizval+"' where Studentid='"+studentid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();
                  JOptionPane.showMessageDialog(null,"saved well."); 
                  studentlist8(jtblbehavior);
                }catch(Exception e){}
           }   
           }else JOptionPane.showMessageDialog(null,"Enter correct Marks."); 
         }catch(Exception e) {JOptionPane.showMessageDialog(null,"Enter numerical values."); }            
         }else JOptionPane.showMessageDialog(null,"Enter marks please."); 
     }else JOptionPane.showMessageDialog(null,"Select a student."); 
                }else JOptionPane.showMessageDialog(null,"Use UPDATE Button if you want to change marks");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
       // displayuser();
       // selectedcourseName();
       fill_combocoursename();
       studentlist(jtblquiz1);
       studentlist2(jtblquiz2);
       studentlist3(jtbltest1);
       studentlist4(jtbltest2);
       studentlist5(jtblworks);
       studentlist6(jtbltj);
       studentlist7(jtblexam);
       studentlist8(jtblbehavior);
       studentlist9(jtbltot);
       
        
       
       
    }//GEN-LAST:event_formComponentShown

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        // TODO add your handling code here:
        jlblresultname.setText("");
        jlblmarksfn.setText("");
        jlblmarksln.setText("");
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
        jtxtmarksoutof.setText("");
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jtblquiz2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblquiz2MouseClicked
        // TODO add your handling code here:
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
        jlblresultname.setText("Quiz two");
        String Table_click="";
             try{
        int row=jtblquiz2.getSelectedRow();
        Table_click=(jtblquiz2.getModel().getValueAt(row,0).toString());
        String sql="SELECT * FROM students WHERE Studentid='"+Table_click+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
        }}catch(Exception e) {JOptionPane.showMessageDialog(null, e);}
          try{       selectedcourseName();
      String sql="SELECT Quiz2 FROM test_quiz_works WHERE Studentid='"+Table_click+"' and Courseid='"+courseid+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("Quiz2");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /5");
        }}catch(Exception e) {}           
    }//GEN-LAST:event_jtblquiz2MouseClicked

    private void jtblquiz1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblquiz1MouseClicked
        // TODO add your handling code here:
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
        jlblresultname.setText("Quiz one");
        String Table_click="";
              try{
        int row=jtblquiz1.getSelectedRow();
         Table_click=(jtblquiz1.getModel().getValueAt(row,0).toString());
        String sql="SELECT * FROM students WHERE Studentid='"+Table_click+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
        } }catch(Exception e) {JOptionPane.showMessageDialog(null, e); }
       try{       selectedcourseName();
      String sql="SELECT Quiz1 FROM test_quiz_works WHERE Studentid='"+Table_click+"' and Courseid='"+courseid+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("Quiz1");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /5");
        }}catch(Exception e) {}     
    }//GEN-LAST:event_jtblquiz1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
    }//GEN-LAST:event_jTable2MouseClicked

    private void jtbltest2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbltest2MouseClicked
        // TODO add your handling code here:
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
        jlblresultname.setText("Test two");
        String Table_click="";
         try{
        int row=jtbltest2.getSelectedRow();
        Table_click=(jtbltest2.getModel().getValueAt(row,0).toString());
       String sql="SELECT * FROM students WHERE Studentid='"+Table_click+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
        }} catch(Exception e) {JOptionPane.showMessageDialog(null, e); }
          try{       selectedcourseName();
      String sql="SELECT Test2 FROM test_quiz_works WHERE Studentid='"+Table_click+"' and Courseid='"+courseid+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("Test2");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /15");
        }}catch(Exception e) {}     
    }//GEN-LAST:event_jtbltest2MouseClicked

    private void jtbltjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbltjMouseClicked
        // TODO add your handling code here:
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
        jlblresultname.setText("T.J");
        String Table_click="";
         try{
        int row=jtbltj.getSelectedRow();
        Table_click=(jtbltj.getModel().getValueAt(row,0).toString());
        String sql="SELECT * FROM students WHERE Studentid='"+Table_click+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
        }}catch(Exception e) {JOptionPane.showMessageDialog(null, e);} 
          try{       selectedcourseName();
      String sql="SELECT T.J FROM marks_report WHERE Studentid='"+Table_click+"' and Courseid='"+courseid+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("T.J");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /50");
        }}catch(Exception e) {}   
         
    }//GEN-LAST:event_jtbltjMouseClicked

    private void jTabbedPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane2MouseClicked
        // TODO add your handling code here:
        jlblresultname.setText("");
         jlblmarksfn.setText("");
        jlblmarksln.setText("");
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
        jtxtmarksoutof.setText("");
         
    }//GEN-LAST:event_jTabbedPane2MouseClicked

    private void jTabbedPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane3MouseClicked
        // TODO add your handling code here:
        jlblresultname.setText("");
         jlblmarksfn.setText("");
        jlblmarksln.setText("");
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
        jtxtmarksoutof.setText("");
    }//GEN-LAST:event_jTabbedPane3MouseClicked

    private void jtblworksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblworksMouseClicked
        // TODO add your handling code here:
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
        jlblresultname.setText("Works");
        String Table_click="";
         try{
        int row=jtblworks.getSelectedRow();
        Table_click=(jtblworks.getModel().getValueAt(row,0).toString());
        String sql="SELECT * FROM students WHERE Studentid='"+Table_click+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
        }}catch(Exception e) {JOptionPane.showMessageDialog(null, e);} 
         try{       selectedcourseName();
      String sql="SELECT Works FROM test_quiz_works WHERE Studentid='"+Table_click+"' and Courseid='"+courseid+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("Works");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /10");
        }}catch(Exception e) {}     
    }//GEN-LAST:event_jtblworksMouseClicked

    private void jcombocoursenamePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jcombocoursenamePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
       // jcombocoursename.removeAllItems();
       jlblmarksfn.setText("");
       jlblmarksln.setText("");
       jlblmessage1.setText("");
       jtxtmarksinput.setText("");
       studentlist(jtblquiz1);
       studentlist2(jtblquiz2);
       studentlist3(jtbltest1);
       studentlist4(jtbltest2);
       studentlist5(jtblworks);
       studentlist6(jtbltj);
       studentlist7(jtblexam);
       studentlist8(jtblbehavior);
       studentlist9(jtbltot);
    }//GEN-LAST:event_jcombocoursenamePopupMenuWillBecomeInvisible

    private void jtblquiz1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblquiz1KeyReleased
        // TODO add your handling code here:
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
        jtxtmarksinput.setText("");
     if(evt.getKeyCode()==KeyEvent.VK_DOWN||evt.getKeyCode()==KeyEvent.VK_UP)
        { String Key_Pressed="";
             try{
        int row=jtblquiz1.getSelectedRow();
        Key_Pressed=(jtblquiz1.getModel().getValueAt(row,0).toString());
        String sql="SELECT * FROM students WHERE Studentid='"+Key_Pressed+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
            }}catch(Exception e) {JOptionPane.showMessageDialog(null, e);}
       try{       selectedcourseName();
      String sql="SELECT Quiz1 FROM test_quiz_works WHERE Studentid='"+Key_Pressed+"' and Courseid='"+courseid+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("Quiz1");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /5");
        }}catch(Exception e) {} 
        }
    }//GEN-LAST:event_jtblquiz1KeyReleased

    private void jtblquiz2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblquiz2KeyReleased
        // TODO add your handling code here:
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
          if(evt.getKeyCode()==KeyEvent.VK_DOWN||evt.getKeyCode()==KeyEvent.VK_UP)
        {     String Key_Pressed="";
             try{
        int row=jtblquiz2.getSelectedRow();
        Key_Pressed=(jtblquiz2.getModel().getValueAt(row,0).toString());
        String sql="SELECT * FROM students WHERE Studentid='"+Key_Pressed+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
            }}catch(Exception e) {JOptionPane.showMessageDialog(null, e);}
         try{       selectedcourseName();
      String sql="SELECT Quiz2 FROM test_quiz_works WHERE Studentid='"+Key_Pressed+"' and Courseid='"+courseid+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("Quiz2");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /5");
        }}catch(Exception e) {} 
        }
    }//GEN-LAST:event_jtblquiz2KeyReleased

    private void jtbltest2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbltest2KeyReleased
        // TODO add your handling code here:
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
          if(evt.getKeyCode()==KeyEvent.VK_DOWN||evt.getKeyCode()==KeyEvent.VK_UP)
        {    String Key_Pressed="";
             try{
        int row=jtbltest2.getSelectedRow();
        Key_Pressed=(jtbltest2.getModel().getValueAt(row,0).toString());
        String sql="SELECT * FROM students WHERE Studentid='"+Key_Pressed+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
            }}catch(Exception e) {JOptionPane.showMessageDialog(null, e);}
          try{       selectedcourseName();
      String sql="SELECT Test2 FROM test_quiz_works WHERE Studentid='"+Key_Pressed+"' and Courseid='"+courseid+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("Test2");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /15");
        }}catch(Exception e) {}
        }
    }//GEN-LAST:event_jtbltest2KeyReleased

    private void jtbltest1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbltest1KeyReleased
        // TODO add your handling code here:
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
          if(evt.getKeyCode()==KeyEvent.VK_DOWN||evt.getKeyCode()==KeyEvent.VK_UP)
        {    String Key_Pressed="";
             try{
        int row=jtbltest1.getSelectedRow();
        Key_Pressed=(jtbltest1.getModel().getValueAt(row,0).toString());
        String sql="SELECT * FROM students WHERE Studentid='"+Key_Pressed+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
            }}catch(Exception e) {JOptionPane.showMessageDialog(null, e);}
          try{       selectedcourseName();
      String sql="SELECT Test1 FROM test_quiz_works WHERE Studentid='"+Key_Pressed+"' and Courseid='"+courseid+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("Test1");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /15");
        }}catch(Exception e) {}
        }
    }//GEN-LAST:event_jtbltest1KeyReleased

    private void jtblworksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblworksKeyReleased
        // TODO add your handling code here:
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
          if(evt.getKeyCode()==KeyEvent.VK_DOWN||evt.getKeyCode()==KeyEvent.VK_UP)
        {     String Key_Pressed="";
             try{
        int row=jtblworks.getSelectedRow();
        Key_Pressed=(jtblworks.getModel().getValueAt(row,0).toString());
        String sql="SELECT * FROM students WHERE Studentid='"+Key_Pressed+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
            }}catch(Exception e) {JOptionPane.showMessageDialog(null, e);}
         try{       selectedcourseName();
      String sql="SELECT Works FROM test_quiz_works WHERE Studentid='"+Key_Pressed+"' and Courseid='"+courseid+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("Works");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /10");
        }}catch(Exception e) {}
        }
    }//GEN-LAST:event_jtblworksKeyReleased

    private void jtbltest1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbltest1MouseClicked
        // TODO add your handling code here:
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
        jlblresultname.setText("Test one");
        String Table_click="";
             try{   
        int row=jtbltest1.getSelectedRow();
        Table_click=(jtbltest1.getModel().getValueAt(row,0).toString());
       String sql="SELECT * FROM students WHERE Studentid='"+Table_click+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
        }}catch(Exception e) {JOptionPane.showMessageDialog(null, e);} 
        try{       selectedcourseName();
      String sql="SELECT Test1 FROM test_quiz_works WHERE Studentid='"+Table_click+"' and Courseid='"+courseid+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("Test1");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /15");
        }}catch(Exception e) {}     
    }//GEN-LAST:event_jtbltest1MouseClicked

    private void jtbltjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbltjKeyReleased
        // TODO add your handling code here:
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
         if(evt.getKeyCode()==KeyEvent.VK_DOWN||evt.getKeyCode()==KeyEvent.VK_UP)
        {    String Key_Pressed="";
             try{
        int row=jtbltj.getSelectedRow();
        Key_Pressed=(jtbltj.getModel().getValueAt(row,0).toString());
        String sql="SELECT * FROM students WHERE Studentid='"+Key_Pressed+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
            }}catch(Exception e) {JOptionPane.showMessageDialog(null, e);}
         try{       selectedcourseName();
      String sql="SELECT T.J FROM marks_report WHERE Studentid='"+Key_Pressed+"' and Courseid='"+courseid+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("T.J");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /50");
        }}catch(Exception e) {} 
        }
    }//GEN-LAST:event_jtbltjKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String resultname=jlblresultname.getText();
        resultname=resultname.trim();
      if(!jlblmessage1.getText().trim().isEmpty() || resultname=="T.J")
        {              
        
     if(!resultname.isEmpty())
     {                             
         String marksinput=jtxtmarksinput.getText().trim();
         String marksoutof=jtxtmarksoutof.getText().trim();
         String fn=jlblmarksfn.getText().trim();
         String ln=jlblmarksln.getText().trim();
         String studentid="";
         try{     
         String sql = "SELECT Studentid FROM students where First_Name='"+fn+"' and Last_Name='"+ln+"' and Classid='"+classid+"' ";
          pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            if(rs.next())
            {  studentid=rs.getString("Studentid"); } 
           }catch(Exception e){}
         
         if(!marksinput.isEmpty() && !marksoutof.isEmpty())
         { try{ 
           double marksinputval= Double.parseDouble(marksinput);
           double marksoutofval=Double.parseDouble(marksoutof);
           if(marksoutofval>0 && marksinputval>0 && marksinputval<=marksoutofval){
               
           if(resultname=="Quiz one")
           {
              try{   
                  double quiz=(marksinputval/marksoutofval)*5;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql77="update test_quiz_works set Quiz1='"+quizval+"' where Studentid='"+studentid+"' and Courseid='"+courseid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();
                  JOptionPane.showMessageDialog(null,"Marks changed.");
                  studentlist(jtblquiz1);       
                }catch(Exception e){}    
           }
           else if(resultname=="Quiz two")
           {
                try{
                  double quiz=(marksinputval/marksoutofval)*5;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql77="update test_quiz_works set Quiz2='"+quizval+"' where Studentid='"+studentid+"' and Courseid='"+courseid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();
                  JOptionPane.showMessageDialog(null,"Marks changed.");  
                  studentlist2(jtblquiz2);       
                }catch(Exception e){}
           }
           else if(resultname=="Test one")
           {
                try{
                  double quiz=(marksinputval/marksoutofval)*15;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql77="update test_quiz_works set Test1='"+quizval+"' where Studentid='"+studentid+"' and Courseid='"+courseid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();
                  JOptionPane.showMessageDialog(null,"Marks changed."); 
                  studentlist3(jtbltest1);      
                }catch(Exception e){}
           }
           else if(resultname=="Test two")
           {
               try{
                  double quiz=(marksinputval/marksoutofval)*15;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql77="update test_quiz_works set Test2='"+quizval+"' where Studentid='"+studentid+"' and Courseid='"+courseid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();
                  JOptionPane.showMessageDialog(null,"Marks changed.");
                   studentlist4(jtbltest2);       
                }catch(Exception e){}
           }
           else if(resultname=="Works")
           {
                try{
                  double quiz=(marksinputval/marksoutofval)*10;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql="select Works from test_quiz_works where Studentid='"+studentid+"' and Courseid='"+courseid+"'";
                  pst=conn.prepareStatement(sql);
                  rs=pst.executeQuery();
                  if(rs.next())
                  { double savedmarks=rs.getDouble("Works");
                    double newmarks=(quizval+savedmarks)/2;
                    String sql77="update test_quiz_works set Works='"+newmarks+"' where Studentid='"+studentid+"' and Courseid='"+courseid+"' ";
                    pst=conn.prepareStatement(sql77);
                    pst.execute();
                    JOptionPane.showMessageDialog(null,"Marks Saved.");
                    studentlist5(jtblworks);  
                  }
                }catch(Exception e){}
           }
           else if(resultname=="T.J")
           {
                try{
                  double quiz=(marksinputval/marksoutofval)*50;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql77="update marks_report set `T.J`='"+quizval+"' where Studentid='"+studentid+"' and Courseid='"+courseid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();
                  JOptionPane.showMessageDialog(null,"saved well."); 
                  studentlist6(jtbltj);
                }catch(Exception e){}
           }
           else if(resultname=="Exam")
           {
               try{
                  double quiz=(marksinputval/marksoutofval)*50;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql77="update marks_report set Exam='"+quizval+"' where Studentid='"+studentid+"' and Courseid='"+courseid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();
                  JOptionPane.showMessageDialog(null,"Marks changed."); 
                  studentlist7(jtblexam);
                }catch(Exception e){}
           }
           else if(resultname=="Behaviors")
           {    
               try{
                  double quiz=(marksinputval/marksoutofval)*50;
                  String quiz1=String.format("%.2f", quiz);
                  double quizval=Double.parseDouble(quiz1);
                  String sql77="update report set BehaviorsMarks='"+quizval+"' where Studentid='"+studentid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();
                  JOptionPane.showMessageDialog(null,"Marks changed."); 
                  studentlist8(jtblbehavior);
                }catch(Exception e){}
           }   
           }else JOptionPane.showMessageDialog(null,"Enter correct Marks."); 
         }catch(Exception e) {JOptionPane.showMessageDialog(null,"Enter numerical values."); }            
         }else JOptionPane.showMessageDialog(null,"Enter marks please."); 
     }else JOptionPane.showMessageDialog(null,"Select a student."); 
                }else JOptionPane.showMessageDialog(null,"Use SAVE Button for new Marks");  
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:        
       studentlist(jtblquiz1);
       studentlist2(jtblquiz2);
       studentlist3(jtbltest1);
       studentlist4(jtbltest2);
       studentlist5(jtblworks);
       int b=0;
            try{ 
                String sql2="SELECT COUNT(*) As nberofStd FROM students where Classid='"+classid+"'";
                pst=conn.prepareStatement(sql2);
                rs=pst.executeQuery();
                if(rs.next())
                  { b=rs.getInt("nberofStd"); 
                  } }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
       int i=0;
       int studentid[]=new int[b];
       try{     
         String sql = "SELECT Studentid FROM students where Classid='"+classid+"' ";
          pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next())
            {  studentid[i]=rs.getInt("Studentid"); i++; }
            
            }catch(Exception e){JOptionPane.showMessageDialog(null,e+"1end");}
        for(int j=0; j<i; j++)
        {       double TJmarks=0;          //System.out.println(studentid[j]);
       try{
           String sql2="select Quiz1 from test_quiz_works where Studentid='"+studentid[j]+"' and Courseid='"+courseid+"'";
                  pst=conn.prepareStatement(sql2);
                  rs=pst.executeQuery();
                  if(rs.next())
                  { String marks=rs.getString("Quiz1");
                    if(!marks.isEmpty())
                    {  double marksval=Double.parseDouble(marks);
                        TJmarks=TJmarks+marksval;
                    }}else TJmarks=TJmarks+0;
        }catch(Exception e){}
        try{       
            String sql2="select Quiz2 from test_quiz_works where Studentid='"+studentid[j]+"' and Courseid='"+courseid+"'";
                  pst=conn.prepareStatement(sql2);
                  rs=pst.executeQuery();
                  if(rs.next())
                  { String marks=rs.getString("Quiz2");
                    if(!marks.isEmpty())
                    {  double marksval=Double.parseDouble(marks);
                        TJmarks=TJmarks+marksval;
                    }}else TJmarks=TJmarks+0;
        }catch(Exception e){}       
           
        try{       
            String sql2="select Test1 from test_quiz_works where Studentid='"+studentid[j]+"' and Courseid='"+courseid+"'";
                  pst=conn.prepareStatement(sql2);
                  rs=pst.executeQuery();
                  if(rs.next())
                  { String marks=rs.getString("Test1");
                    if(!marks.isEmpty())
                    {  double marksval=Double.parseDouble(marks);
                        TJmarks=TJmarks+marksval;
                    }}else TJmarks=TJmarks+0;
        }catch(Exception e){}
        try{       
            String sql2="select Test2 from test_quiz_works where Studentid='"+studentid[j]+"' and Courseid='"+courseid+"'";
                  pst=conn.prepareStatement(sql2);
                  rs=pst.executeQuery();
                  if(rs.next())
                  { String marks=rs.getString("Test2");
                    if(!marks.isEmpty())
                    {  double marksval=Double.parseDouble(marks);
                        TJmarks=TJmarks+marksval;
                    }}else TJmarks=TJmarks+0;
        }catch(Exception e){}
        try{       
            String sql2="select Works from test_quiz_works where Studentid='"+studentid[j]+"' and Courseid='"+courseid+"'";
                  pst=conn.prepareStatement(sql2);
                  rs=pst.executeQuery();
                  if(rs.next())
                  { String marks=rs.getString("Works");
                    if(!marks.isEmpty())
                    {  double marksval=Double.parseDouble(marks);
                        TJmarks=TJmarks+marksval;
                    }}else TJmarks=TJmarks+0;
        }catch(Exception e){} 
              try{
                  
                  String sql77="update marks_report set `T.J`='"+TJmarks+"' where Studentid='"+studentid[j]+"' and Courseid='"+courseid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();                  
                }catch(Exception e){JOptionPane.showMessageDialog(null,e+"15");}
        } 
       studentlist6(jtbltj);
       
    for(int j=0; j<i; j++)   
    {      double tot=0;
        try{       
            String sql2="select `T.J`,`Exam` from marks_report where Studentid='"+studentid[j]+"' and Courseid='"+courseid+"'";
                  pst=conn.prepareStatement(sql2);
                  rs=pst.executeQuery();
                  if(rs.next())
                  { double tj=rs.getDouble("T.J");
                    double exam=rs.getDouble("Exam");
                    tot=tj+exam;
                  }
        }catch(Exception e){} 
         try{
                  
                  String sql77="update marks_report set Total='"+tot+"' where Studentid='"+studentid[j]+"' and Courseid='"+courseid+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();                  
        }catch(Exception e){JOptionPane.showMessageDialog(null,e+"15");}
    } 
       studentlist9(jtbltot);  
        
    for(int j=0; j<i; j++)   
    {      double totTJ=0 ,totExam=0 ,Tot=0 ,percent=0;
        try{       
            String sql2="select `T.J`,`Exam` from marks_report where Studentid='"+studentid[j]+"'";
                  pst=conn.prepareStatement(sql2);
                  rs=pst.executeQuery();
                  while(rs.next())
                  {  totTJ=totTJ+rs.getDouble("T.J");
                    totExam=totExam+rs.getDouble("Exam");
                  }
                  Tot=totTJ+totExam;
                   double perc=(Tot*100/300);
                  String perc2=String.format("%.2f", perc);
                  percent=Double.parseDouble(perc2);
        }catch(Exception e){} 
         try{
                  
                  String sql77="update report set Total='"+Tot+"', `Tot-T.J`='"+totTJ+"' , `Tot-Exam`='"+totExam+"', Percentage='"+percent+"' where Studentid='"+studentid[j]+"' ";
                  pst=conn.prepareStatement(sql77);
                  pst.execute();                  
        }catch(Exception e){JOptionPane.showMessageDialog(null,e+"15");}
    }  
    double Totalmarks[]=new double[b];
          int z=0; 
    try {   
          String sql22= "SELECT Total FROM report WHERE Classid='"+classid+"' ";
          pst=conn.prepareStatement(sql22);
          rs=pst.executeQuery();
          while(rs.next())
           {
               Totalmarks[z++]=rs.getDouble("Total");      
           }
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
      
    
    for (int j=0 ; j<(b-1) ; j++)
	{
		for (int x=0 ; x<(b-1) ; x++)
		{
			if (Totalmarks[x+1]<Totalmarks[x])
			{
				double t = Totalmarks[x];
				Totalmarks[x] = Totalmarks[x+1];
				Totalmarks[x+1]=t;
			}
		}  
	}  
   
         int p=1;
    for (int x=b ; x>0 ; x--)
	{  
            try{                  
                  String sql77="update report set Place='"+p+"' where Total='"+Totalmarks[x-1]+"' and Classid='"+classid+"'";
                  pst=conn.prepareStatement(sql77);
                  pst.execute(); 
                  p++;
                }catch(Exception e){JOptionPane.showMessageDialog(null,e);}           
	}
                int places[]=new int[b];
          int y=0;
     try {   
          String sql22= "SELECT Place FROM report WHERE Classid='"+classid+"' ";
          pst=conn.prepareStatement(sql22);
          rs=pst.executeQuery();
          while(rs.next())
           {
               places[y++]=rs.getInt("Place");      
           }
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
      
    
    for (int j=0 ; j<(b-1) ; j++)
	{
		for (int x=0 ; x<(b-1) ; x++)
		{
			if (places[x+1]<places[x])
			{
				int t = places[x];
				places[x] = places[x+1];
				places[x+1]=t;
			}
		}  
	}   
         int q=1;
    for (int x=0 ; x<b ; x++)
	{  try{
            if(places[x]==places[x+1])
            {try{                  
                  String sql77="update report set Place='"+q+"' where Place='"+places[x]+"' and Classid='"+classid+"'";
                  pst=conn.prepareStatement(sql77);
                  pst.execute(); 
                  p=p+2; x++;
                }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
            }
            else{
                try{                  
                  String sql77="update report set Place='"+q+"' where Place='"+places[x]+"' and Classid='"+classid+"'";
                  pst=conn.prepareStatement(sql77);
                  pst.execute(); 
                  q++;
                }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
            }
        }catch(Exception e){}
        }           
	
        
    JOptionPane.showMessageDialog(null,"saved well.");  
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtblexamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblexamMouseClicked
        // TODO add your handling code here:
         jlblmessage1.setText("");
        jtxtmarksinput.setText("");
        jlblresultname.setText("Exam");
        String Table_click="";
             try{   
        int row=jtblexam.getSelectedRow();
        Table_click=(jtblexam.getModel().getValueAt(row,0).toString());
       String sql="SELECT * FROM students WHERE Studentid='"+Table_click+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
        }}catch(Exception e) {JOptionPane.showMessageDialog(null, e);} 
        try{       selectedcourseName();
      String sql="SELECT Exam FROM marks_report WHERE Studentid='"+Table_click+"' and Courseid='"+courseid+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("Exam");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /50");
        }}catch(Exception e) {}     
    }//GEN-LAST:event_jtblexamMouseClicked

    private void jtblexamKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblexamKeyReleased
        // TODO add your handling code here:
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
         if(evt.getKeyCode()==KeyEvent.VK_DOWN||evt.getKeyCode()==KeyEvent.VK_UP)
        {    String Key_Pressed="";
             try{
        int row=jtblexam.getSelectedRow();
        Key_Pressed=(jtblexam.getModel().getValueAt(row,0).toString());
        String sql="SELECT * FROM students WHERE Studentid='"+Key_Pressed+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
            }}catch(Exception e) {JOptionPane.showMessageDialog(null, e);}
         try{       selectedcourseName();
      String sql="SELECT Exam FROM marks_report WHERE Studentid='"+Key_Pressed+"' and Courseid='"+courseid+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("Exam");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /50");
        }}catch(Exception e) {} 
        }
    }//GEN-LAST:event_jtblexamKeyReleased

    private void jtbltotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbltotMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jtbltotMouseClicked

    private void jtbltotKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtbltotKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jtbltotKeyReleased

    private void jtblbehaviorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtblbehaviorKeyReleased
        // TODO add your handling code here:
        jlblmessage1.setText("");
        jtxtmarksinput.setText("");
         if(evt.getKeyCode()==KeyEvent.VK_DOWN||evt.getKeyCode()==KeyEvent.VK_UP)
        {    String Key_Pressed="";
             try{
        int row=jtblbehavior.getSelectedRow();
        Key_Pressed=(jtblbehavior.getModel().getValueAt(row,0).toString());
        String sql="SELECT * FROM students WHERE Studentid='"+Key_Pressed+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
            }}catch(Exception e) {JOptionPane.showMessageDialog(null, e);}
         try{       selectedcourseName();
      String sql="SELECT BehaviorsMarks FROM report WHERE Studentid='"+Key_Pressed+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("BehaviorsMarks");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /50");
        }}catch(Exception e) {} 
        }        
    }//GEN-LAST:event_jtblbehaviorKeyReleased

    private void jtblbehaviorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblbehaviorMouseClicked
        // TODO add your handling code here:
         jlblmessage1.setText("");
        jtxtmarksinput.setText("");
        jlblresultname.setText("Behaviors");
        String Table_click="";
             try{   
        int row=jtblbehavior.getSelectedRow();
        Table_click=(jtblbehavior.getModel().getValueAt(row,0).toString());
       String sql="SELECT * FROM students WHERE Studentid='"+Table_click+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){
            String add1=rs.getString("First_Name");
            jlblmarksfn.setText(add1);
            String add2=rs.getString("Last_Name");
            jlblmarksln.setText(add2);
        }}catch(Exception e) {JOptionPane.showMessageDialog(null, e);} 
        try{       selectedcourseName();
      String sql="SELECT BehaviorsMarks FROM report WHERE Studentid='"+Table_click+"' ";
        pst=conn.prepareStatement(sql);
        rs=pst.executeQuery();
        if(rs.next()){ 
        String marks= rs.getString("BehaviorsMarks");
       if(!marks.isEmpty()) jlblmessage1.setText(marks+" /50");
        }}catch(Exception e) {} 
    }//GEN-LAST:event_jtblbehaviorMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        close();
        Report s1=new Report();
        Report.classidreport=classid;
        s1.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(StudentsMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentsMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentsMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentsMarks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentsMarks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> jcombocoursename;
    private javax.swing.JLabel jlblloggedclass;
    private javax.swing.JLabel jlblmarksfn;
    private javax.swing.JLabel jlblmarksln;
    private javax.swing.JLabel jlblmessage;
    private javax.swing.JLabel jlblmessage1;
    private javax.swing.JLabel jlblresultname;
    private javax.swing.JTable jtblbehavior;
    private javax.swing.JTable jtblexam;
    private javax.swing.JTable jtblquiz1;
    private javax.swing.JTable jtblquiz2;
    private javax.swing.JTable jtbltest1;
    private javax.swing.JTable jtbltest2;
    private javax.swing.JTable jtbltj;
    private javax.swing.JTable jtbltot;
    private javax.swing.JTable jtblworks;
    private javax.swing.JTextField jtxtmarksinput;
    private javax.swing.JTextField jtxtmarksoutof;
    // End of variables declaration//GEN-END:variables
}
