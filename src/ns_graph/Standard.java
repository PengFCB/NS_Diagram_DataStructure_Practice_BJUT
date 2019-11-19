package ns_graph;

public class Standard extends Basic{
    
	public Standard(String action,Basic back,Basic father,Basic begin){
		super(action,back,father,begin);
	}
        
        @Override
        public boolean isStandard(){
            return true;
        }

}
