/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ns_graph;

/**
 *
 * @author liuyupeng
 */
public class Beginner extends Basic{
    //private Basic up;
    private double length;
    //private Basic upper;
    Beginner(Basic father){
        super("这里是Beginner",null,father,null);
        //this.up=up;
        length=0;
        super.setBegin(this);
       // upper=father;
    }
    
    @Override
    public boolean isBeginner(){
        return true;
    }
    @Override
    public double getLength(){
        return length;
    }
    @Override
    public void setLength(double length){
        this.length=length;
    }
   /* @Override
    public void addLength(){
        length=length+1;
        double i=1;
        Basic tmp=this;
        while(tmp.getUp()!=null){
            i=i/2;
            
            
            
            tmp=tmp.getUp().getBegin();
            tmp.setLength(tmp.getLength()+i);
        }
    }*/
   /* @Override
    public void subLength(){
        length=length-1;
        double i=1;
        Basic tmp=this;
        while(tmp.getUp()!=null){
            i=i/2;
            if(tmp.getUp().isTF()){
                if(length>getTFLength(tmp.getUp())){
                    tmp=tmp.getUp().getBegin();
                    continue;
                }                
            }
            
            
            tmp=tmp.getUp().getBegin();
            tmp.setLength(tmp.getLength()-i);
        }
    }*/
    
   /* private double getTFLength(Basic tfnode){
        if(!tfnode.isTF()){
            System.out.println("Wrong in getTFLength!");
            return -1;
        }
        double t,f;
        t=tfnode.getTrueNext().getLength();
        f=tfnode.getFalseNext().getLength();
        if(t>f) return t;
        else return f;
    }*/
    
}
