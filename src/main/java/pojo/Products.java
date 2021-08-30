package pojo;

public class Products {
    private String product;
    private String imageURL;
    private double dolarsPrice;
    private double eurosPrice;
    private double poundsPrice;



    public Products(String product, String imageURL, double dolarsPrice, double poundsPrice,
                    double eurosPrice){
        this.setProduct(product);
        this.setImageURL(imageURL);
        this.setDolarsPrice(dolarsPrice);
        this.setPoundsPrice(poundsPrice);
        this.setEurosPrice(eurosPrice);
    }


    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getDolarsPrice() {
        return this.dolarsPrice;
    }

    public void setDolarsPrice(double dolarsPrice) {
        this.dolarsPrice = dolarsPrice;
    }

    public double getPoundsPrice() {
        return this.poundsPrice;
    }

    public void setPoundsPrice(double poundsPrice) {
        this.poundsPrice = poundsPrice;
    }

    public double getEurosPrice() {
        return this.eurosPrice;
    }

    public void setEurosPrice(double eurosPrice) {
        this.eurosPrice = eurosPrice;
    }
}
