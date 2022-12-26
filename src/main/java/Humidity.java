public class Humidity extends feature {


    Sensor humidity_sensor = new Sensor(100, 15, "humidity_sensor");

    LED hum_led = new LED();

    public Humidity() {
        //These are default possible values for this feature.
        this.set_max = 60;
        this.set_min = 30;
        //********************
    }

    public void setMin(int set_min_u) {
        System.out.println("Please, enter the minimum humidity value that you want to be noticed: " +set_min_u);
        //set_min = sc.nextInt();
        set_min = set_min_u;
        if (set_min > 50 || set_min < 0) {
            System.out.println("Please, you should set adjustable value.");
            setMin(55);
        }else{
            System.out.println("Your minimum humidity value: " + set_min);
        }
    }


    public void setMax(int set_max_u){
        System.out.println("Please, enter the maximum humidity value that you want to be noticed: " +set_max_u);
        //set_max = sc.nextInt();
        set_max = set_max_u;
        if (set_max < set_min || set_max > 80) {
            System.out.println("Please, you should set adjustable value.");
            setMax(80);
        }else{
            System.out.println("Your maximum humidity value: " + set_max);
        }
    }

    public int currentValue() {
        return humidity_sensor.read();
    }

    public void warningLight() {
        int humWorth = humidity_sensor.read();
        if (set_max < humWorth) {
            hum_led.turnON("Red");

        } else if (set_min > humWorth) {
            hum_led.turnON("Blue");

        } else {
            hum_led.turnOFF();

        }

    }


}
