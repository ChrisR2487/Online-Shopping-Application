import java.util.ArrayList;
import java.util.List;

public class Item {
    int itemNum;
    String itemName;
    String category;
    double price;
    int itemQuantity = 1;
    List<Item> storage = new ArrayList<Item>();

    Item(int itemNum, String itemName, String category, double price, int itemQuantity){
        this.itemNum = itemNum;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
        this.itemQuantity = itemQuantity;
    }
    //Setters
    public void setItemNum(int itemNum) { this.itemNum = itemNum; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setCategory(String category) { this.category = category; }
    public void setPrice(double price) { this.price = price; }
    public void setItemQuantity(int itemQuantity) { this.itemQuantity = itemQuantity; }
    //Getters
    public int getItemNum() { return itemNum; }
    public String getItemName() { return itemName; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getItemQuantity() { return itemQuantity; }

    public void menu(){
        System.out.println("Welcome to Amazon!");
        System.out.println();
        System.out.println("Choose an option.");
        System.out.println("1) Create empty shopping cart");
        System.out.println("2) Add item to shopping cart ");
        System.out.println("3) Remove item from shopping cart ");
        System.out.println("4) Check out");
        System.out.print("Your Choice? ");
    }
    public void thanks(){
        System.out.println("Thank you for shopping with Amazon.");
        System.out.println("We hope to see you again!");
    }
    public void printCategories(ArrayList<Item> stuff){
        Item cat = new Item(0,"","",0.0,0);
        int catCounter = 0;
        for(int i = 0; i<stuff.size()-1; i++){
            if(i>0){
                cat = stuff.get(i);
                String startCat = cat.getCategory();
                cat = stuff.get(i-1);
                String beforeCat = cat.getCategory();
                if(!startCat.equals(beforeCat)){
                    catCounter++;
                    cat = stuff.get(i);
                    System.out.println(catCounter + ") " + cat.getCategory());
                }
            }
            else{
                catCounter++;
                cat = stuff.get(i);
                System.out.println(catCounter + ") " + cat.getCategory());
            }
        }
        System.out.println();
    }
    public void printBooks(ArrayList<Item> stuff){
        Item book = new Item(0,"","",0.0,0);
        System.out.println();
        for (Item item : stuff) {
            book = item;
            String cat = book.getCategory();
            if (cat.equals("Books")) {
                System.out.println(book);
            }
        }
    }
    public void printMovies(ArrayList<Item> stuff){
        Item movies = new Item(0,"","",0.0,0);
        System.out.println();
        for (Item item : stuff) {
            movies = item;
            String cat = movies.getCategory();
            if (cat.equals("Movies & TV")) {
                System.out.println(movies);
            }
        }
    }
    public void printMusic(ArrayList<Item> stuff){
        Item music = new Item(0,"","",0.0,0);
        System.out.println();
        for (Item item : stuff) {
            music = item;
            String cat = music.getCategory();
            if (cat.equals("Music")) {
                System.out.println(music);
            }
        }
    }
    public void printElectronics (ArrayList<Item> stuff){
        Item elem  = new Item(0,"","",0.0,0);
        System.out.println();
        System.out.println(stuff.get(9));
        System.out.println(stuff.get(10));
        System.out.println(stuff.get(11));

    }
    public void showCart (ArrayList<Item> stuff){
        Item elem = new Item(0,"","",0.0,0);
        System.out.println("Displaying the current contents of the shopping cart...");
        for(int i = 0; i<stuff.size(); i++){
            elem = stuff.get(i);
            int num = elem.getItemNum();
            String name = elem.getItemName();
            String cat = elem.getCategory();
            double price = elem.getPrice();
            int quantity = elem.getItemQuantity();
            System.out.println("Number: " + num);
            System.out.println("Name: " + name);
            System.out.println("Category: " + cat);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("");
        }
    }
    public int getIndex(int ID, ArrayList<Item> stuff){
        Item elem = new Item(0,"","",0.0,0);
        Item temp = new Item(0,"","",0.0,0);
        int index = 0;
        for(int i = 0; i<stuff.size(); i++){
            elem = stuff.get(i);
            if (ID == elem.getItemNum()){
                temp = stuff.get(i);
                index = stuff.indexOf(temp);
            }
        }
        return index;
    }
    public boolean checkID(int ID, ArrayList<Item> stuff){
        Item elem = new Item(0,"","",0.0,0);
        for(int i = 0; i<stuff.size(); i++){
            elem = stuff.get(i);
            if (ID == elem.getItemNum()){
                return true;
            }
        }
        return false;
    }
    public Item search(int ID, ArrayList<Item> stuff) {
        Item elem = new Item(0,"","",0.0,0);
        for (int i = 0; i<stuff.size(); i++) {
            elem = stuff.get(i);
            if (elem.getItemNum() == ID)
            {
                elem.setItemNum(elem.getItemNum());
                elem.setItemName(elem.getItemName());
                elem.setPrice(elem.getPrice());
                return elem;
            }
        }
        return null;
    }
    public double getTotal(ArrayList<Item> stuff){
        Item ok = new Item(0,"","",0.0,0);
        double total = 0.0;
        double temp = 0.0;
        for(int i = 0; i<stuff.size(); i++){
            ok = stuff.get(i);
            temp = ok.getPrice();
            total += temp * 1.06;
        }
        return total;
    }
    public String toString(){
        return itemNum +" "+ itemName +" "+ category +" $"+ price;
    }








}
