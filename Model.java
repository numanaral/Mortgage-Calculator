public class Model {
        private int numOfPayments;
        private double principal;
        private double intRate;
        private int compound;
        private int frequency;
        private double intFactor;
        private double blendedPayment;
        private double totIntPaid;
        private double totIntandPrincipal;
        private double intOverPrincipal;
        private double avgIntPaidY;
        private double avgIntPaidM;
        private double amorizationInYears;
        // initializing variables for our calculations
        
        public Model(int a, double b, double c, int d, int e){
        	setNPRCF(a, b, c, d, e);
        	// constructor which calls for the method to set values
        }
        
        public Model(){
        	this(0, 0, 0, 0, 0);
        	// calls for the other constructor
        }
        
        public void setNPRCF(int a, double b, double c, int d, int e){
        	numOfPayments = a;
        	principal = b;
        	intRate = c;
        	compound = d;
            frequency = e;
            // method which sets functions
        }
        
        
        public double calculateBlendedPayment(){
        	intFactor = ((Math.pow(((double) (intRate / 200) + 1), (double) compound / frequency)) - 1);
        	return blendedPayment = (principal * intFactor) / (1 - (Math.pow((double) intFactor + 1, (double) numOfPayments * -1)));
        	// method which calculates the blended payment
        }
        
         public double calculateTotalInterestPaid(){
        	return totIntPaid = totIntandPrincipal - principal;
        }
        
		public double calculateTotalInterestandPrincipal(){
			return totIntandPrincipal = blendedPayment * numOfPayments; 	
		}
		
		public double calculateInterestOverPrincipalRatio(){
			return intOverPrincipal = totIntPaid / principal;
		}
		
		public double calculateAverageInterestPaidYearly(){
			return avgIntPaidY = totIntPaid / (numOfPayments / 12);
		}
		
		public double calculateAverageInterestPaidMonthly(){
			return avgIntPaidM = totIntPaid / numOfPayments;
		}
		
		public double calculateAmorizationInYears(){
			return amorizationInYears = (double) numOfPayments / 12;
		}		
        
        public double timeFrameConverter(int j){
        	 //Bonus #1
        	if (j == 1){
        		
        		numOfPayments *= 2;
        		frequency *= 2;
        		return calculateBlendedPayment();
        		
        	}else 
        		numOfPayments *= 4;
        		frequency *= 4;
        		return calculateBlendedPayment();
        	}
        // changing the values specifically to biweekly or weekly 
        

        
        public void changeCompoundFrequency(int k){
        	// Bonus #2
        	compound = k;
        }
        
        public void annualAmortizationTable(){
        	// Bonus #3
        }

        // above are 12 function to calculate user requested things
}


