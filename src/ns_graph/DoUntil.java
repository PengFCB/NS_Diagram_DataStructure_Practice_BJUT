package ns_graph;

public class DoUntil extends Basic{
	private Basic start;

	public DoUntil(String action,Basic back,Basic father,Basic begin){
		super(action,back,father,begin);
                start=new Beginner(this);
	}
	
        public Basic getStart(){
            return start;
        }
	
        @Override
        public boolean isDoUntil(){
            return true;
        }
}
