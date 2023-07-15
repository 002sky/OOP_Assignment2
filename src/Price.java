public abstract class Price {
    private double AdultPrice;
    private double InfantPrice;

   protected Price(double AdultPrice, double InfantPrice) {
       this.AdultPrice = AdultPrice;
       this.InfantPrice = InfantPrice;
   }

   public double getAdultPrice() {
       return AdultPrice;
   }

    public double getInfantPrice() {
        return InfantPrice;
    }

    public  void setAdultPrice(double adultPrice){
        AdultPrice = adultPrice;
    }
    public  void  setInfantPrice(double infantPrice){
        InfantPrice = infantPrice;
    }

    public abstract void setPrice(double AdultPrice, double InfantPrice);


}

