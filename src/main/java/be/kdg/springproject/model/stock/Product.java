package be.kdg.springproject.model.stock;

public final class Product
{
    private static int SEQUENCE_GENERATOR;
    private int product_id;
    private String description;
    private Double price;
    private String categoryName;

    public Product(String description, Double price, String categoryName)
    {
        this.product_id = SEQUENCE_GENERATOR++;
        this.description = description;
        this.price = price;
        this.categoryName = categoryName;
    }

    /**
     * Geeft de beschrijving van een product
     *
     * @return
     */
    public String getDescription()
    {
        return this.description;
    }

    public synchronized void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Geeft de prijs van een product
     *
     * @return
     */
    public Double getPrice()
    {
        return this.price;
    }

    public synchronized void setPrice(Double price)
    {
        this.price = price;
    }

    /**
     * Geeft de categorie van een product
     *
     * @return
     */
    public String getCategoryName()
    {
        return categoryName;
    }

    public synchronized void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    /**
     * Geeft het unieke product_id terug.
     *
     * @return
     */
    public int getProduct_id()
    {
        return product_id;
    }


    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 47 * hash + this.product_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Product other = (Product) obj;
        return this.product_id == other.product_id;
    }
}