public class WazzapWorld {
    public static void main(String[] args){
        System.out.println("Wazzzappp!");
        System.out.println("The path to success is to take massive, determined action.");
        System.out.println("A 1000 mile journey begins with one step");
        String name = "Lebron";
        int age = 37;
        Integer championships = 4;

        // System.out.println("Hi my name is " + name + " and I am " + age + " years young!");

        System.out.println(String.format("Hi my name is %s and I am %d years young", name, age  ));
        
        

        String place1 = "Miami          ";
        String activity1 = "      Eating Cuban food in ";
        String finalSentence = activity1.concat(place1);
        System.out.println(finalSentence.trim()); //.trim()
        //.indexOf()
        System.out.println(finalSentence.indexOf("Cub"));

        //.equals()
        String x = new String("hi!");
        String y = new String("hi!");
        
        System.out.println(x.equals(y));


        //conditionals example

        Integer num = 24;

        if(num == 23){
            System.out.println("Thats Jordan!");
        }else if (num == 8 || num == 24){
            System.out.println("Kobe!");
        }else if (num == 6){
            System.out.println("Thats Miami Lebron!");
        }
        else{
            System.out.println("Thats somebody else, whose name I don't remember");
        }





    }
}


