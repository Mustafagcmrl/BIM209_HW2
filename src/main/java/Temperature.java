public class Temperature extends feature {


    Sensor temp_sensor = new Sensor(50, 10, "temp_sensor");

    LED temp_led = new LED();

    public Temperature() {
        //These are default possible values for this feature.
        this.set_max = 30;
        this.set_min = 20;
        //********************
    }


    public void setMin(int set_min_u) {
        System.out.println("Please, enter the minimum temperature value that you want to be noticed: " +set_min_u);
        //set_min = sc.nextInt();
        set_min = set_min_u;
        if (set_min > 50 || set_min < 0) {
            System.out.println("Please, you should set an appropriate value.");
            System.out.println("----------System warns user since s/he has entered an unappropriate value for a plant.\n");
            setMin(10);
        }else{
            System.out.println("Your minimum temperature value: " + set_min);
        }
    }


    public void setMax(int set_max_u){
        System.out.println("Please, enter the maximum temperature value that you want to be noticed: " +set_max_u);
        //set_max = sc.nextInt();
        set_max = set_max_u;
        if (set_max < set_min || set_max > 50) {
            System.out.println("\n----------Here user wants to set max value of the interval as '5' but s/he receives----------" +
                               "\n----------an error message since it is smaller than the min value of the interval----------\n");
            System.out.println("Please, you should set an appropriate value.");
            setMax(40);
        }else{
        System.out.println("Your maximum temperature value: " + set_max);
        }
    }


    public int currentValue() {
        return temp_sensor.read();
    }

    public void warningLight() {
        int tempWorth = temp_sensor.read();
        if (set_max < tempWorth) {
            temp_led.turnON("Red");
        } else if (set_min > tempWorth) {
            temp_led.turnON("Blue");
        } else {
            temp_led.turnOFF();
        }

    }

}
