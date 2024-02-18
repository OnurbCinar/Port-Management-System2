public class RefrigeratedContainer extends HeavyContainer {
    char type;
    public RefrigeratedContainer(int portID, int weight,int specialid,char type) {
        super(portID, weight,specialid);
        this.type=type;
    consumption();}
    void consumption() {
        this.cumsumption = this.getWeight() * 5.00;

    }
    @Override
    public String toString() {
        return "RefrigeratedContainer=" + getID() ;
    }
}
