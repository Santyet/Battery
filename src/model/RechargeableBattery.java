package model;

public class RechargeableBattery extends Battery implements Rechargeable {

    private int chargerNumber;
    private char type;
    public final static char BATTERY_LITIO = 'l';
    public final static char BATTERY_NIQUEL_CADIO = 'n';
    public final static double FACTOR_LITIO = 0.92;
    public final static double FACTOR_NIQUEL_CADIO = 0.80;
    

    public RechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        super(name, voltage, cost, capacity);
        this.chargerNumber = chargerNumber;
        this.type = type;
    }
    
    @Override
    public double calculateUsefulLifeCost(){

        double finalCost = 0;

        if(type=='l'){
            finalCost += (super.cost * super.voltage * super.capacity)/(1000*chargerNumber*FACTOR_LITIO); 
        }
        if(type=='n'){
            finalCost += (super.cost * super.voltage * super.capacity)/(1000*chargerNumber*FACTOR_NIQUEL_CADIO); 
        }
		return finalCost;
	}
    
}
