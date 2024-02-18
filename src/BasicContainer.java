public class BasicContainer extends Containers  {

    public BasicContainer(int ID, int weight,int speacialid) {
        super(ID, weight,speacialid);
        consumption();
    }
    void consumption() {

        this.cumsumption = this.getWeight() *2.50;

    }
    @Override
    public String toString() {
        return "BasicContainer=" + getID() ;
    }
}
