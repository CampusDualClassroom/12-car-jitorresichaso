package com.campusdual.classroom;

public class Car {
    public String brand;
    public String model;
    public static final int MAX_SPEED = 120;
    public String fuel;
    public int speedometer;
    public int tachometer;
    public String gear = "N";
    public boolean reverse = false;
    public int wheelsAngle = 0;

    public Car (String brand, String model, String fuel){
        this.brand = brand;
        this.model = model;
        this.fuel = fuel;
    }

    public Car(){
        this.brand = "Citroën";
        this.model = "Xsara";
        this.fuel = "Diesel";
    }

    public void start() {
        if (this.tachometer == 0){
            this.tachometer = 1000;
            System.out.println("Vehículo encendido");
        }else{
            System.out.println("Vehículo ya está encendido");
        }
    }

    public void stop() {
        if (this.speedometer == 0){
            this.tachometer = 0;
            System.out.println("Vehículo apagado");
        }else{
            System.out.println("No se puede apagar el vehículo. Primero tiene que estar detenido");
        }
    }
    public void accelerate() {
        if (this.tachometer > 0) {
            this.speedometer += 5;
            if (this.speedometer > MAX_SPEED) {
                this.speedometer = MAX_SPEED;
            }
        }
    }

    public void brake() {
        if (this.speedometer > 0) {
            this.speedometer -= 5;
            if (this.speedometer < 0) {
                this.speedometer = 0;
            }
        }
    }

    public void turnAngleOfWheels(int angle) {
        int newAngle = this.wheelsAngle + angle;
        if (newAngle > 45) {
            this.wheelsAngle = 45;
        } else if (newAngle < -45) {
            this.wheelsAngle = -45;
        } else {
            this.wheelsAngle = newAngle;
        }
    }

    public String showSteeringWheelDetail() {
        return "Ángulo actual del volante: " + this.wheelsAngle + " grados";
    }

    public boolean isReverse() {
        return this.reverse;
    }

    public void setReverse(boolean reverse) {
        if (this.speedometer == 0 && reverse) {
            this.reverse = true;
            this.gear = "R";
        } else if (!reverse) {
            this.reverse = false;
            this.gear = "N";
        }
    }

    public void showDetails() {
        System.out.println("Marca: " + this.brand);
        System.out.println("Modelo: " + this.model);
        System.out.println("Combustible: " + this.fuel);
        System.out.println("Velocidad: " + this.speedometer + " km/h");
        System.out.println("Revoluciones: " + this.tachometer + " rpm");
        System.out.println("Ángulo ruedas: " + this.wheelsAngle + "º");
        System.out.println("Marcha: " + this.gear);
    }

    public boolean isTachometerGreaterThanZero() {
        return this.tachometer > 0;
    }

    public boolean isTachometerEqualToZero() {
        return this.tachometer == 0;
    }

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.start();
        myCar.accelerate();
        myCar.turnAngleOfWheels(20);
        myCar.setReverse(true);
        myCar.showDetails();
    }
}
