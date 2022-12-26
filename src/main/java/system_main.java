import java.util.Scanner;

public class system_main {
    public static void main(String[] args) {
        int i=0;
        String key = "1";
        Scanner scanner = new Scanner(System.in);
        //int temp_environment= (int)(Math.random()*40 + 5); //Since we cannot read a data from any sensor, we will generate a random environment temperature
        //int humi_environment = (int)(Math.random()*100); //Since we cannot read a data from any sensor, we will generate a random soil humidity.
        // Then, we read those datas by our Sensor class' read() function.
        Temperature temp = new Temperature();
        Humidity humidity = new Humidity();

        System.out.println("Please, press the enter button to get into the system.");

        if (user.press()) {
            System.out.println("\n----------User has pressed the enter button.----------  \n");

            System.out.println("******************************************************");

            System.out.println("Your system initialized. Default intervals for humidity and temperature are: ");
            System.out.println("TemperatureMin: " + temp.set_min + " TemperatureMax: " + temp.set_max + " " );
            System.out.println("HumidityMin   : " + humidity.set_min + " HumidityMax   : " + humidity.set_max+ " "  );

            System.out.println("******************************************************");

            welcome(temp, humidity);

            while (user.press()) {
                String operations = "\n1.Option: Set the temperature.\n" +
                                    "2.Option: Set the humidity.\n" +
                                    "3.Option: Quit setting options.";

                System.out.println("******************************************************");
                System.out.println(operations);
                System.out.println("******************************************************");
                System.out.println("You can choose mode whatever you want: ");

                //String key = scanner.nextLine();
                if(i==0) key = "1"; //User wants to change the temperature interval.
                else if(i==1) key = "2";
                else key = "q";



                if (key.equals("1")) {
                    System.out.println("\n----------User selects the first option to change temperature interval----------\n");
                    System.out.println("You can set your temperature values.");
                    temp.setMin(10);
                    temp.setMax(5);

                } else if (key.equals("2")) {
                    System.out.println("\n----------User selects the second option to change humidity interval----------\n");
                    System.out.println("You can set your humidity values.");
                    humidity.setMin(20);
                    humidity.setMax(80);


                } else if (key.equals("q")) {
                    System.out.println("\n----------User selects the third option to exit----------\n");
                    System.out.println("System operations will be finish.");
                    break;
                }
                i+=1;
            }

            currStatus(temp, humidity);
        } else {
            System.out.println("You need to start your system.");
        }

    }

    public static void welcome(Temperature temp, Humidity humidity) { //This method works when the system is waken up from sleep mode.


        System.out.println("Welcome to Plant Control System, current environment values are:");

        System.out.println("******************************************************");

        System.out.println("Current environment temperature is : " + temp.currentValue()); //Print out value
        System.out.println("Current soil humidity is           : " + humidity.currentValue()); //Print out value

        System.out.println("******************************************************");

        System.out.println("\nIf you want to set a max or min value, press 'Enter' button to get into system. ");
        System.out.println("\n----------User has pressed enter button----------");


    }

    public static void currStatus(Temperature temp, Humidity humidity) {
        System.out.println("******************************************************");
        System.out.println("LED state for temperature: ");
        temp.warningLight();
        System.out.println("******************************************************");
        System.out.println("LED state for humidity: ");
        humidity.warningLight();
        System.out.println("******************************************************");
    }

}
