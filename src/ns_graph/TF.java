package ns_graph;

public class TF extends Basic{
	private Basic trueNext;
	private Basic falseNext;
	
	public TF(String action,Basic back,Basic father,Basic begin){
		super(action,back,father,begin);
                trueNext=new Beginner(this);
                falseNext=new Beginner(this);
	}
	
	public Basic getTrueNext() {
		return trueNext;
	}
	public void setTrueNext(Basic trueNext) {
		this.trueNext = trueNext;
	}
	public Basic getFalseNext() {
		return falseNext;
	}
	public void setFalseNext(Basic falseNext) {
		this.falseNext = falseNext;
	}
        public boolean isTF(){
            return true;
        }
	
	
}
