public class NormalPrice extends Price{

    protected NormalPrice() {
        super();
    }

    protected NormalPrice(double adultPrice, double childrenWithBedPrice, double childrenWithoutBedPrice, double infantPrice) {
        super(adultPrice, childrenWithBedPrice, childrenWithoutBedPrice, infantPrice);
    }

    @Override
    public void setDomesticPrice() {
        super.setAdultPrice(1647);
        super.setInfantPrice(500);
        super.setChildrenWithBedPrice(1447);
        super.setChildrenWithoutBedPrice(1247);
    }

    @Override
    public void setOverseaPrice() {
        super.setAdultPrice(4297);
        super.setInfantPrice(500);
        super.setChildrenWithBedPrice(4087);
        super.setChildrenWithoutBedPrice(3897);
    }

    @Override
    public String toString() {
        return super.toString();

    }
}
