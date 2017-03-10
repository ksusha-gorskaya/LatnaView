package Models;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;

/**
 * Created by ksgo0816 on 10.03.2017.
 */
public class GoodModel {
    //"IndexOfShop","IndexOfProduct","InPieces","InLiters", "InBoxes", "1-in pieces, 0-in boxes"
    private final SimpleLongProperty IndexOfShop;
    private final SimpleLongProperty IndexOfProduct;
    private final SimpleFloatProperty InPieces;
    private final SimpleFloatProperty InLiters;
    private final SimpleIntegerProperty InBoxes;
    private final SimpleIntegerProperty OneZero;

    public int getCountField(){return 6;}

    public GoodModel(long indexOfShop, long indexOfProduct, float inpieces, float inliters, int inboxes, int onezero){
        IndexOfShop = new SimpleLongProperty(indexOfShop);
        IndexOfProduct = new SimpleLongProperty(indexOfProduct);
        InPieces = new SimpleFloatProperty(inpieces);
        InLiters = new SimpleFloatProperty(inliters);
        InBoxes = new SimpleIntegerProperty(inboxes);
        OneZero = new SimpleIntegerProperty(onezero);
    }

    public long getIndexOfShop() {
        return IndexOfShop.get();
    }

    public SimpleLongProperty indexOfShopProperty() {
        return IndexOfShop;
    }

    public void setIndexOfShop(long indexOfShop) {
        this.IndexOfShop.set(indexOfShop);
    }

    public long getIndexOfProduct() {
        return IndexOfProduct.get();
    }

    public SimpleLongProperty indexOfProductProperty() {
        return IndexOfProduct;
    }

    public void setIndexOfProduct(long indexOfProduct) {
        this.IndexOfProduct.set(indexOfProduct);
    }

    public float getInPieces() {
        return InPieces.get();
    }

    public SimpleFloatProperty inPiecesProperty() {
        return InPieces;
    }

    public void setInPieces(int inPieces) {
        this.InPieces.set(inPieces);
    }

    public float getInLiters() {
        return InLiters.get();
    }

    public SimpleFloatProperty inLitersProperty() {
        return InLiters;
    }

    public void setInLiters(float inLiters) {
        this.InLiters.set(inLiters);
    }

    public int getInBoxes() {
        return InBoxes.get();
    }

    public SimpleIntegerProperty inBoxesProperty() {
        return InBoxes;
    }

    public void setInBoxes(int inBoxes) {
        this.InBoxes.set(inBoxes);
    }

    public int getOneZero() {
        return OneZero.get();
    }

    public SimpleIntegerProperty oneZeroProperty() {
        return OneZero;
    }

    public void setOneZero(int oneZero) {
        this.OneZero.set(oneZero);
    }
}