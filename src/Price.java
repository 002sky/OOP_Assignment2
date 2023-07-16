public abstract class Price {
    private double AdultPrice;
    private double ChildrenWithBedPrice;
    private double ChildrenWithoutBedPrice;
    private double InfantPrice;

    protected Price(double AdultPrice, double InfantPrice) {
        this.AdultPrice = AdultPrice;
        this.InfantPrice = InfantPrice;
    }

    public Price() {

    }

    public double getAdultPrice() {
        return AdultPrice;
    }

    public double getInfantPrice() {
        return InfantPrice;
    }

    public void setAdultPrice(double adultPrice) {
        AdultPrice = adultPrice;
    }

    public void setInfantPrice(double infantPrice) {
        InfantPrice = infantPrice;
    }

    public double getChildrenWithBedPrice() {
        return ChildrenWithBedPrice;
    }

    public void setChildrenWithBedPrice(double childrenWithBedPrice) {
        ChildrenWithBedPrice = childrenWithBedPrice;
    }

    public double getChildrenWithoutBedPrice() {
        return ChildrenWithoutBedPrice;
    }

    public void setChildrenWithoutBedPrice(double childrenWithoutBedPrice) {
        ChildrenWithoutBedPrice = childrenWithoutBedPrice;
    }

    public abstract void setDomesticPrice();

    public abstract void setOverseaPrice();

    public void setPrice(double AdultPrice, double ChildrenWithBedPrice, double ChildrenWithoutBedPrice, double InfantPrice) {
        this.setAdultPrice(AdultPrice);
        this.setInfantPrice(InfantPrice);
        this.setChildrenWithBedPrice(ChildrenWithBedPrice);
        this.setChildrenWithoutBedPrice(ChildrenWithoutBedPrice);
    }



    @Override
    public String toString() {
        return "\nAdult Price: " + getAdultPrice() +
                "\nChildren With Bed Price: " + getChildrenWithBedPrice() +
                "\nChildren Without Bed Price: " + getChildrenWithoutBedPrice() +
                "\n" + "Infant Price: " + getInfantPrice();
    }

}

