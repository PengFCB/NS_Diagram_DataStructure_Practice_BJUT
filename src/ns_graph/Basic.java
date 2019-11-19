package ns_graph;
//所有NS块的父类，抽象类型
abstract public class Basic {
	private String action;//语句或条件
        private Basic next;//后续分支
        private Basic back;
        private Basic up;
        private Basic begin;
        //private int caseNum;
        
       // public boolean flag=false;
	
	public Basic(){}
	/*public Basic(String action,Basic back){
            this.action=action;
            this.back=back;
            up=null;
        }
        public Basic(String action,Basic back,int caseNum){
            this.action=action;
            this.back=back;
            this.caseNum=caseNum;
            up=null;
        }*/
        /*public Basic(String action,Basic back,int caseNum,Basic up,Basic begin){
            this.action=action;
            this.back=back;
            this.caseNum=caseNum;
            this.up=up;
            this.begin=begin;
        }*/
        public Basic(String action,Basic back,Basic up,Basic begin){
            this.action=action;
            this.back=back;
            this.up=up;
            this.begin=begin;
        }
	
        public String getAction(){
            return action;
	}
	public void setAction(String action){
            this.action=action;
        }
        public Basic getNext(){
            return next;
        }
        public void setNext(Basic next){
            this.next=next;
        }
        public Basic getBack(){
            return back;
        }
        public void setBack(Basic back){
            this.back=back;
        }
        /*public int getCaseNum(){
            if(this.isCase())
                return caseNum;
            else return 0;
        }*/
        public Basic getBegin(){
            return begin;
        }
        public void setBegin(Basic begin){
            this.begin=begin;
        }
        
        public boolean isStandard(){
            return false;
        }
        public boolean isDoWhile(){
            return false;
        }
        public boolean isDoUntil(){
            return false;
        }
        public boolean isTF(){
            return false;
        }
        /*public boolean isCase(){
            return false;
        }*/
        public boolean isBeginner(){
            return false;
        }
        
        public void insertToNext(Basic nextNode){
            Basic temp;
            
            if(next==null){
                next=nextNode;
            }
            else{
                temp=next;
                next=nextNode;
                nextNode.next=temp;
                nextNode.next.setBack(nextNode);
            }
            //begin.addLength();
            
        }
        public void deleteNext(){
            if(next==null){
                return;
            }
            else if(next.next==null){
                next=null;
            }
            else{
                next=next.next;
                next.setBack(this);
            }
            //begin.subLength();
        }
        
        
        public Basic getTrueNext(){
            return null;
        }
        public Basic getFalseNext(){
            return null;
        }
        public Basic getStart(){
            return null;
        }
        public Basic[] getList(){
            return null;
        }
        public void addLength(){}
        public void subLength(){}
        public double getLength(){
            return -1;
        }
        public void setLength(double length){}
        //public void draw();

    /**
     * @return the up
     */
    public Basic getUp() {
        return up;
    }
}