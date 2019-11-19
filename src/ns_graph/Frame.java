/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ns_graph;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;


/**
 *
 * @author liuyupeng
 */



public class Frame extends javax.swing.JFrame {
    private final Basic root;
    private Basic current;
    private int choice;//1ST 2DW 3DU 4TF 5Case
    private String action;
    
    private final double DH=100;

    /**
     * Creates new form Frame
     */
    public Frame() {
        initComponents();
        choice=1;
        root=new Beginner(null);
        current=root;
    }
    
    private void printManual(Basic beginner,JPanel pane,double h){
        double y=0;
        pane.setLayout(null);
        Basic tmp=beginner;
        
        while(tmp.getNext()!=null){
            tmp=tmp.getNext();
            if(tmp.isStandard()){
                JSt jst=new JSt(tmp.getAction());
                jst.setLocation(0, (int)y);
                jst.setSize(pane.getWidth(),(int)h);
                y=y+h;
                
                if(current==tmp){
                    jst.setBackground(Color.red);
                }
                else{
                    jst.setBackground(Color.WHITE);
                }
                
                pane.setSize(pane.getWidth(), (int)y);
                pane.setPreferredSize(pane.getSize());
                pane.add(jst);
                
            }
            else if(tmp.isTF()){
                JTFHead jtfhead=new JTFHead(tmp.getAction());
                jtfhead.setLocation(0, (int)y);
                jtfhead.setSize(pane.getWidth(), (int)h);
                y=y+h;
                
                if(current==tmp){
                    jtfhead.setBackground(Color.red);
                }
                else{
                    jtfhead.setBackground(Color.WHITE);
                }
                
                pane.add(jtfhead);
                pane.setSize(pane.getWidth(), (int)y);
                pane.setPreferredSize(pane.getSize());
                
                if(tmp.getTrueNext().getLength()==0 && tmp.getFalseNext().getLength()==0){
                    JTFBody jtfbody=new JTFBody();
                    jtfbody.setLocation(0,(int)y);
                    jtfbody.setSize(pane.getWidth(),(int)(h));
                    y=y+h;
                    pane.add(jtfbody);
                    continue;
                }
                
                double t,f,l;
                f=tmp.getFalseNext().getLength();
                t=tmp.getTrueNext().getLength();
                if(t>f) l=t;
                else l=f;
                
                JTFBody jtfbody=new JTFBody();
                jtfbody.setLocation(0, (int)y);
                jtfbody.setSize(pane.getWidth(), (int)(h*l));
                jtfbody.setPreferredSize(jtfbody.getSize());
                y=y+h*l;
                
                pane.setSize(pane.getWidth(), (int)y);
                pane.setPreferredSize(pane.getSize());
                jtfbody.getJPanelF().setSize(jtfbody.getWidth()/2, jtfbody.getHeight());
                jtfbody.getJPanelT().setSize(jtfbody.getWidth()/2, jtfbody.getHeight());
                                
                
                printManual(tmp.getTrueNext(),jtfbody.getJPanelT(),h);
                printManual(tmp.getFalseNext(),jtfbody.getJPanelF(),h);
                
                
                pane.add(jtfbody);
            }
            
            else if(tmp.isDoUntil()){
                JDU jdu=new JDU(tmp.getAction());
                jdu.setLocation(0, (int)y);
                jdu.setSize(pane.getWidth(),(int)(h*(tmp.getStart().getLength()+0.5)));
                jdu.getPanelLoop().setSize((int)(jdu.getWidth()-75), (int)(h*tmp.getStart().getLength()));
                if(tmp.getStart().getLength()==0){
                    jdu.setSize(pane.getWidth(),(int)(h*1.5));
                    y=y+h*1.5;
                }
                y=y+h*(tmp.getStart().getLength());
                
                if(current==tmp){
                    jdu.setBackground(Color.red);
                }
                else{
                    jdu.setBackground(Color.WHITE);
                }
                
                pane.setSize(pane.getWidth(), (int)y);
                pane.setPreferredSize(pane.getSize());
                
                printManual(tmp.getStart(),jdu.getPanelLoop(),h);
                
                pane.add(jdu);
                
            }
            else if(tmp.isDoWhile()){
                JDW jdw=new JDW(tmp.getAction());
                jdw.setLocation(0, (int)y);
                jdw.setSize(pane.getWidth(),(int)(h*(tmp.getStart().getLength()+0.5)));
                jdw.getPanelLoop().setSize((int)(jdw.getWidth()-75), (int)(h*tmp.getStart().getLength()));
                if(tmp.getStart().getLength()==0){
                    jdw.setSize(pane.getWidth(),(int)(h*1.5));
                    y=y+h*1.5;
                }
                y=y+h*(tmp.getStart().getLength());
                
                if(current==tmp){
                    jdw.setBackground(Color.red);
                }
                else{
                    jdw.setBackground(Color.WHITE);
                }
                
                pane.setSize(pane.getWidth(), (int)y);
                pane.setPreferredSize(pane.getSize());
                
                printManual(tmp.getStart(),jdw.getPanelLoop(),h);
                
                pane.add(jdw);
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        mainScrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        jRadioButtonSt = new javax.swing.JRadioButton();
        jRadioButtonDW = new javax.swing.JRadioButton();
        jRadioButtonDU = new javax.swing.JRadioButton();
        jRadioButtonTF = new javax.swing.JRadioButton();
        actionTextField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jCBNew = new javax.swing.JComboBox<>();
        jButtonBack = new javax.swing.JButton();
        jButtonIn = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonOut = new javax.swing.JButton();
        jCBChange = new javax.swing.JComboBox<>();
        save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NS图");

        mainScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        mainScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        mainScrollPane.setMaximumSize(new java.awt.Dimension(600, 32767));

        mainPanel.setMaximumSize(new java.awt.Dimension(500, 32767));
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.Y_AXIS));
        mainScrollPane.setViewportView(mainPanel);

        buttonGroup1.add(jRadioButtonSt);
        jRadioButtonSt.setSelected(true);
        jRadioButtonSt.setText("标准型");
        jRadioButtonSt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonStActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonDW);
        jRadioButtonDW.setText("DoWhile");
        jRadioButtonDW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDWActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonDU);
        jRadioButtonDU.setText("DoUntil");
        jRadioButtonDU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDUActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonTF);
        jRadioButtonTF.setText("判断");
        jRadioButtonTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTFActionPerformed(evt);
            }
        });

        actionTextField.setText("在此输入语句");
        actionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actionTextFieldActionPerformed(evt);
            }
        });

        addButton.setText("添加");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("删除");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jCBNew.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "向后添加" }));
        jCBNew.setToolTipText("");

        jButtonBack.setText("向前");
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });

        jButtonIn.setText("内层");
        jButtonIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInActionPerformed(evt);
            }
        });

        jButtonNext.setText("向后");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonOut.setText("外层");
        jButtonOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOutActionPerformed(evt);
            }
        });

        jCBChange.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "无内层" }));
        jCBChange.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCBChangeMouseClicked(evt);
            }
        });
        jCBChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBChangeActionPerformed(evt);
            }
        });

        save.setText("存为C");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jRadioButtonSt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonDW)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonDU)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButtonTF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(actionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCBChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCBNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jButtonIn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonOut))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteButton)))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonBack)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonNext))
                            .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBack)
                    .addComponent(jButtonIn)
                    .addComponent(jButtonNext)
                    .addComponent(jButtonOut)
                    .addComponent(jCBChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCBNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButtonTF)
                        .addComponent(jRadioButtonSt)
                        .addComponent(jRadioButtonDW)
                        .addComponent(jRadioButtonDU)
                        .addComponent(actionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(deleteButton)
                        .addComponent(addButton)
                        .addComponent(save)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonStActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonStActionPerformed
        // TODO add your handling code here:
        choice=1;
    }//GEN-LAST:event_jRadioButtonStActionPerformed

    private void jRadioButtonDWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDWActionPerformed
        // TODO add your handling code here:
        choice=2;
    }//GEN-LAST:event_jRadioButtonDWActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here
        //caseNum=caseTextField.getText();
        action=actionTextField.getText();
        int way=jCBNew.getSelectedIndex();
        changeCurrent(current);
        
        switch(choice){
        case 1:
            if(way==0){
                current.insertToNext(new Standard(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if((current.isDoWhile()||current.isDoUntil())&&way==1){
                changeCurrent(current.getStart());
                current.insertToNext(new Standard(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if(current.isTF()&&way==1){
                changeCurrent(current.getTrueNext());
                current.insertToNext(new Standard(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if(current.isTF()&&way==2){
                changeCurrent(current.getFalseNext());
                current.insertToNext(new Standard(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
           /* else if(current.isCase()){
                changeCurrent(current.getList()[way-1]);
                current.insertToNext(new Standard(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }*/
            
            //currentText.setText(current.getAction());
            
            break;
        case 2:
            if(way==0){
                current.insertToNext(new DoWhile(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if((current.isDoWhile()||current.isDoUntil())&&way==1){
                changeCurrent(current.getStart());
                current.insertToNext(new DoWhile(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if(current.isTF()&&way==1){
                changeCurrent(current.getTrueNext());
                current.insertToNext(new DoWhile(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if(current.isTF()&&way==2){
                changeCurrent(current.getFalseNext());
                current.insertToNext(new DoWhile(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            /*else if(current.isCase()){
                changeCurrent(current.getList()[way-1]);
                current.insertToNext(new DoWhile(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            */
            //currentText.setText(current.getAction());
            
            break;
        case 3:
            if(way==0){
                current.insertToNext(new DoUntil(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if((current.isDoWhile()||current.isDoUntil())&&way==1){
                changeCurrent(current.getStart());
                current.insertToNext(new DoUntil(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if(current.isTF()&&way==1){
                changeCurrent(current.getTrueNext());
                current.insertToNext(new DoUntil(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if(current.isTF()&&way==2){
                changeCurrent(current.getFalseNext());
                current.insertToNext(new DoUntil(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            /*else if(current.isCase()){
                changeCurrent(current.getList()[way-1]);
                current.insertToNext(new DoUntil(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            */
            //currentText.setText(current.getAction());
            
            break;
        case 4:
            if(way==0){
                current.insertToNext(new TF(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if((current.isDoWhile()||current.isDoUntil())&&way==1){
                changeCurrent(current.getStart());
                current.insertToNext(new TF(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if(current.isTF()&&way==1){
                changeCurrent(current.getTrueNext());
                current.insertToNext(new TF(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if(current.isTF()&&way==2){
                changeCurrent(current.getFalseNext());
                current.insertToNext(new TF(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
          /*  else if(current.isCase()){
                changeCurrent(current.getList()[way-1]);
                current.insertToNext(new TF(action,current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }*/
            
           // currentText.setText(current.getAction());
            
            break;
       /*case 5:
            char temp[]=caseNum.toCharArray();
            for(int i=0;i<temp.length;i++){
                if(temp[i]<'0'||temp[i]>'9'){
                    System.out.print("Wrong caseNum");
                    return;
                }
            }
            /*if(way==0)
                current.insertToNext(new Case(action,Integer.parseInt(caseNum),current,current.getUp()));
            current=current.getNext();
            
            if(way==0){
                current.insertToNext(new Case(action,Integer.parseInt(caseNum),current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if((current.isDoWhile()||current.isDoUntil())&&way==1){
                changeCurrent(current.getStart());
                current.insertToNext(new Case(action,Integer.parseInt(caseNum),current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if(current.isTF()&&way==1){
                changeCurrent(current.getTrueNext());
                current.insertToNext(new Case(action,Integer.parseInt(caseNum),current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if(current.isTF()&&way==2){
                changeCurrent(current.getFalseNext());
                current.insertToNext(new Case(action,Integer.parseInt(caseNum),current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            else if(current.isCase()){
                changeCurrent(current.getList()[way-1]);
                current.insertToNext(new Case(action,Integer.parseInt(caseNum),current,current.getUp(),current.getBegin()));
                changeCurrent(current.getNext());
            }
            
            
            currentText.setText(current.getAction());
            
            break;*/
        }
        
        //updateLength(root);
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void jRadioButtonDUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDUActionPerformed
        // TODO add your handling code here:
        choice=3;
    }//GEN-LAST:event_jRadioButtonDUActionPerformed

    private void jRadioButtonTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTFActionPerformed
        // TODO add your handling code here:
        choice=4;
    }//GEN-LAST:event_jRadioButtonTFActionPerformed

    private void actionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionTextFieldActionPerformed
        // TODO add your handling code here:
        action=actionTextField.getText();
    }//GEN-LAST:event_actionTextFieldActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
        changeCurrent(current.getBack());
    }//GEN-LAST:event_jButtonBackActionPerformed

    private void jCBChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBChangeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jCBChangeActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        // TODO add your handling code here:
        changeCurrent(current.getNext());
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInActionPerformed
        // TODO add your handling code here:
        if(current.isBeginner()||current.isStandard()){
            return;
        }
        if(current.isDoUntil()){
            if(current.getStart().getNext()==null) return;
            changeCurrent(current.getStart());
            return;
        }
        if(current.isDoWhile()){
            if(current.getStart().getNext()==null) return;
            changeCurrent(current.getStart());
            return;
        }
        if(current.isTF()){
            if(jCBChange.getSelectedIndex()==0){
                if(current.getTrueNext().getNext()==null) return;
                changeCurrent(current.getTrueNext());
                return;
            }
            if(jCBChange.getSelectedIndex()==1){
                if(current.getFalseNext().getNext()==null) return;
                changeCurrent(current.getFalseNext());
            }
                
        }
      /*  if(current.isCase()){
            int num=jCBChange.getSelectedIndex();
            changeCurrent(current.getList()[num]);
        }
        */
    }//GEN-LAST:event_jButtonInActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if(current==root) return;
        if(current.getBack().isBeginner()){
            current.getBack().setNext(current.getNext());
            if(current.getNext()!=null){
                current.getNext().setBack(current.getBack());
                changeCurrent(current.getNext());
            }
            else if(current.getUp()!=null){
                changeCurrent(current.getUp());
            }
            else{
                current=root;
                root.setNext(null);
            }
        }
        else{
            changeCurrent(current.getBack());
            current.deleteNext();
        }
        this.mainPanel.removeAll();
        updateLength(root);
        printManual(root,this.mainPanel,DH);
        mainPanel.updateUI();
        
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jCBChangeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCBChangeMouseClicked
        // TODO add your handling code here:
       /*if(current.isBeginner()||current.isStandard()){
            jCBChange.removeAllItems();
            jCBChange.addItem("无内层");
            return;
        }
        if(current.isDoUntil()||current.isDoWhile()){
            jCBChange.removeAllItems();
            jCBChange.addItem("循环体");
            return;
        }
        if(current.isTF()){
            jCBChange.removeAllItems();
            jCBChange.addItem("正确分支");
            jCBChange.addItem("错误分支");
            return;
        }
        /*if(current.isCase()){
            int num=current.getCaseNum();
            jCBChange.removeAllItems();
            for(int i=0;i<num;i++){
                jCBChange.addItem("分支"+i);
            }
        }*/
           
    }//GEN-LAST:event_jCBChangeMouseClicked

    private void jButtonOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOutActionPerformed
        // TODO add your handling code here:
        changeCurrent(current.getUp());
    }//GEN-LAST:event_jButtonOutActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        try {
            // TODO add your handling code here:
            File f=new File("text.txt");
            f.delete();
            
            save(root,0);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_saveActionPerformed

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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
        
        //TODO
        
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField actionTextField;
    private javax.swing.JButton addButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonIn;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonOut;
    private javax.swing.JComboBox<String> jCBChange;
    private javax.swing.JComboBox<String> jCBNew;
    private javax.swing.JRadioButton jRadioButtonDU;
    private javax.swing.JRadioButton jRadioButtonDW;
    private javax.swing.JRadioButton jRadioButtonSt;
    private javax.swing.JRadioButton jRadioButtonTF;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
    
    /*void in() throws FileNotFoundException, IOException{
        BufferedReader br=new BufferedReader (new FileReader("text.txt"));
        root.setNext(null);
        Basic tmp=root;
        while(tmp!=null){
            String str=new String(br.readLine());
            if(str.equals("###END###")){
                tmp=tmp.getUp();
            }
            
            if(str.equals("1")){
                tmp.setNext(new Standard(br.readLine(),tmp,tmp.getUp(),tmp.getBegin()));
                //continue;
            } 
            else if(str.equals("4")){
                tmp.setNext(new TF(br.readLine(),tmp,tmp.getUp(),tmp.getBegin()));
                //continue;
            }
            else if(str.equals("T")){
                tmp=tmp.getTrueNext();
            }
            else if(str.equals("F")){
                tmp=tmp.getFalseNext();
            }
            
            
        }
    }*/
    
    
    void save(Basic begin,int layer) throws IOException{
        
        
        FileWriter fw=new FileWriter("text.txt",true);
        Basic tmp=begin;
        while(tmp.getNext()!=null){
            tmp=tmp.getNext();
            if(tmp.isStandard()){
                
                //fw.write(1+"\n");
                for(int i=0;i<layer;i++)
                    fw.write("\t");
                
                fw.write(tmp.getAction()+"\n");
                fw.flush();
                
            }
            else if(tmp.isDoWhile()){
                
                //fw.write(2+"\n");
                for(int i=0;i<layer;i++)
                    fw.write("\t");
                fw.write("while("+tmp.getAction()+"){\n");
                fw.flush();
                
                save(tmp.getStart(),layer+1);
                
                
                 for(int i=0;i<layer;i++)
                    fw.write("\t");
                fw.write("}\n");
                fw.flush();
            }
            else if(tmp.isDoUntil()){
                
                //fw.write(3+"\n");
                 for(int i=0;i<layer;i++)
                    fw.write("\t");
                 fw.write("do{\n");
                 
                 save(tmp.getStart(),layer+1);
                 
                 for(int i=0;i<layer;i++)
                    fw.write("\t");
                 fw.write("}while("+tmp.getAction()+");\n");
                fw.flush();
            }
            else if(tmp.isTF()){
                
                //fw.write(4+"\n");
                //fw.flush();
                for(int i=0;i<layer;i++)
                    fw.write("\t");
                fw.write("if("+tmp.getAction()+"){\n");
                fw.flush();
                
                //fw.write("T\n");
                //fw.flush();
                save(tmp.getTrueNext(),layer+1);
                for(int i=0;i<layer;i++)
                    fw.write("\t");
                fw.write("}\n");
                fw.flush();
                
                for(int i=0;i<layer;i++)
                    fw.write("\t");
                fw.write("else{\n");
                fw.flush();
                save(tmp.getFalseNext(),layer+1);
                for(int i=0;i<layer;i++)
                    fw.write("\t");
                fw.write("}\n");
                fw.flush();
            }
            
        }
        //fw.write("###END###\n");
        //fw.flush();
    }
    
    double updateLength(Basic root){
        Basic tmp=root;
        root.setLength(0);
        while(tmp.getNext()!=null){
            tmp=tmp.getNext();
            root.setLength(root.getLength()+1);
            
            if(tmp.isStandard()){/*DO NOTHING*/}
            else if(tmp.isTF()){
                double t,f;
                t=updateLength(tmp.getTrueNext());
                f=updateLength(tmp.getFalseNext());
                
                if(t==0&&f==0){
                    t=f=1;
                }
                
                if(t>f) root.setLength(root.getLength()+t);
                else root.setLength(root.getLength()+f);
            }
            else if(tmp.isDoUntil()||tmp.isDoWhile()){
                double len;
                len=updateLength(tmp.getStart());
                
                if(len==0) len=1.5;
                
                
                root.setLength(root.getLength()+len-1+0.5);
                
            }
        }
        
        return root.getLength();
    }
    
    void changeCurrent(Basic now){
        if(now==null)
            return;
        else if(now.isBeginner()&&now.getNext()!=null){
            now=now.getNext();
        }
        current=now;
       // currentText.setText(now.getAction());
        if(now.isStandard()){
            jCBChange.removeAllItems();
            jCBChange.addItem("无内层");
            jCBNew.removeAllItems();
            jCBNew.addItem("向后添加");
        }
        if(now.isDoWhile()){
            jCBChange.removeAllItems();
            jCBChange.addItem("循环体");
            jCBNew.removeAllItems();
            jCBNew.addItem("向后添加");
            jCBNew.addItem("向内添加");
        }
        if(now.isDoUntil()){
            jCBChange.removeAllItems();
            jCBChange.addItem("循环体");
            jCBNew.removeAllItems();
            jCBNew.addItem("向后添加");
            jCBNew.addItem("向内添加");
        }
        if(now.isTF()){
            jCBChange.removeAllItems();
            jCBChange.addItem("正确分支");
            jCBChange.addItem("错误分支");
            jCBNew.removeAllItems();
            jCBNew.addItem("向后添加");
            jCBNew.addItem("正确分支");
            jCBNew.addItem("错误分支");
        }
        /*if(now.isCase()){                   
            jCBChange.removeAllItems();
            for(int i=0;i<now.getCaseNum();i++){
               jCBChange.addItem("分支"+i);
            }
            jCBNew.removeAllItems();
            jCBNew.addItem("向后添加");
            for(int i=0;i<now.getCaseNum();i++){
               jCBNew.addItem("分支"+i);
            }
        }*/
       /* if(now.getBack()!=null)
            prevText.setText(now.getBack().getAction());
        else
            prevText.setText("null");
        if(now.getNext()!=null)
            nextText.setText(now.getNext().getAction());
        else
            nextText.setText("null");
        if(now.getUp()!=null)
            upText.setText(now.getUp().getAction());
        else
            upText.setText("null");*/
        
        this.mainPanel.removeAll();
        updateLength(root);
        printManual(root,this.mainPanel,DH);
                
    }
}
