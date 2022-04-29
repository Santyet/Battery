package model;

public class Company{
	
    public static final int MAX_BATTERIES = 10;
	private Battery[] batteries;

	public Company() {
        this.batteries = new Battery[MAX_BATTERIES];
	}

    public Company(Battery[] batteries){
        this.batteries = batteries;
    }
	

    public void registerBattery(String name, double voltage, double cost, double capacity){
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new Battery(name, voltage, cost, capacity);

    }

    public void registerRechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new RechargeableBattery(name, voltage, cost, capacity, chargerNumber ,type);
        
    }
    
    private int getEmtyPosition() {
        int pos = -1;
        for (int i = 0; i < MAX_BATTERIES && pos == -1; i++) {
            if (batteries[i] == null) {
                pos = i;
            }
        }
        return pos;
    }

    public String showTotalBatteries() {

        String out = "";
        int count = 0;
        int count2 = 0;
        for(int i = 0;i<MAX_BATTERIES;i++){
           
            if(batteries[i] instanceof Battery){

                count++;
            }
            if(batteries[i] instanceof RechargeableBattery){

                count2++;
            }
            
        }
        count= count-count2;

        out = "normal batteries: "+ count + "\n" + "rechargeable batteries: " + count2;
    	return out;
    }
    
    public String showBatteriesInfo() {
    	String str = "";

        for(int i = 0;i<MAX_BATTERIES;i++){
           
            if(batteries[i] instanceof RechargeableBattery){

                str += batteries[i].toString();
            }else{

                if(batteries[i] instanceof Battery){

                    str += batteries[i].toString();
                }
            }
            
        }
    	return str;
    }
    

	public double calculateUsefulPromLifeCost(){

        double total = 0;
        int count = 0;
        for(int i = 0;i<MAX_BATTERIES;i++){

            if(batteries[i] instanceof RechargeableBattery){

                total+=((RechargeableBattery)batteries[i]).calculateUsefulLifeCost();
                count++;
            }
        }
        total=total/count;

		return total;
	}

}
