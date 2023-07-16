public class PeakPrice extends Price {

    protected PeakPrice() {
        super();
    }

    protected PeakPrice(double adultPrice, double childrenWithBedPrice, double childrenWithoutBedPrice, double infantPrice) {
        super(adultPrice, childrenWithBedPrice, childrenWithoutBedPrice, infantPrice);
    }

    @Override
    public void setDomesticPrice() {
        super.setAdultPrice(2437);
        super.setInfantPrice(500);
        super.setChildrenWithBedPrice(2247);
        super.setChildrenWithoutBedPrice(2047);
    }

    @Override
    public void setOverseaPrice() {
        super.setAdultPrice(5097);
        super.setInfantPrice(500);
        super.setChildrenWithBedPrice(4897);
        super.setChildrenWithoutBedPrice(4697);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
