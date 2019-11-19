package ns_graph;

public class DoWhile extends Basic{
	private Basic start;

	public DoWhile(String action,Basic back,Basic father,Basic begin){
		super(action,back,father,begin);
                start=new Beginner(this);
	}
	
        public Basic getStart(){
            return start;
        }
	
        @Override
        public boolean isDoWhile(){
            return true;
        }
}
