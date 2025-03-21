package n1ex1.models;

public class Product {
        private String name;
        private int price;

        public Product(String name, int price){
            this.name = name;
            this.price = price;
        }

        public String getName(){
            return this.name;
        }
        public int getPrice(){
            return this.price;
        }

        public void setName(String name){
            this.name = name;
        }
        public void setPrice(int price){
            this.price = price;
        }
}



