public class ProductIterator implements ListIterator{
    /**
     * Design Pattern: Iterator Pattern
     * ProductIterator implements ListIterator
     */
    private ProductList productList;

    private int index = 0;
    public ProductIterator(ProductList productList) {
        this.productList = productList;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        if(this.productList == null)
            return false;
        return index < productList.size();
    }

    @Override
    public Product Next() {
        if(hasNext()){
            Product p = this.productList.get(index);
            index++;
            return p;
        }
        return null;
    }

    @Override
    public void moveToHead() {
        index = 0;
    }

    @Override
    public void remove() {

    }
}
