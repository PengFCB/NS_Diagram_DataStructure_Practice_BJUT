/*package ns_graph;

public class Case extends Basic{
    private Basic list[];
    
    Case(String action,int num,Basic back,Basic father,Basic begin){
        super(action,back,num,father,begin);
        list=new Basic[num];
        for(int i=0;i<num;i++){
            list[i]=new Beginner(this);
        }
    }
    
    @Override
    public boolean isCase(){
        return true;
    }

    /**
     * @return the list
     */
 //   public Basic[] getList() {
 //       return list;
 //   }
    

//}
