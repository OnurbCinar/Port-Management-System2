public class HeavyContainer extends Containers {

    public HeavyContainer(int ID, int weight,int specialid,char a) {
        super(ID, weight,specialid);


    }
    public  HeavyContainer(int portID,int weight,int specialid){
        super(portID,weight,specialid);
        consumption();
    }


    void consumption() {
this.cumsumption = this.getWeight() * 3.00;

    }

    @Override
    public String toString() {
        return "HeacvyContainer=" + getID() ;
    }
}
