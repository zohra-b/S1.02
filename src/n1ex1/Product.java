package n1ex1;

public class Product {
        /// 1 fields
        private String name;
        private int price;

        //2 constructor
        public Product(String name, int price){
            this.name = name;
            this.price = price;
        }

        //3 getters
        public String getName(){
            return this.name;
        }
        public int getPrice(){
            return this.price;
        }

        //4 setters
        public void setName(String name){
            this.name = name;
        }
        public void setPrice(int price){
            this.price = price;
        }
}



