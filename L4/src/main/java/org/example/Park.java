package org.example;

public class Park {
    private String parkName;

    public Park(String parkName) {
        this.parkName = parkName;
    }

    public class Attraction {
        private String attractionName;
        private String workingHours;
        private double cost;

        public Attraction(String attractionName, String workingHours, double cost) {
            this.attractionName = attractionName;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public void info() {
            System.out.println("Название аттракциона: " + attractionName);
            System.out.println("Время работы: " + workingHours);
            System.out.println("Стоимость: " + cost + " рублей");
            System.out.println("- - - - - - - -");
        }
    }

    public static void main(String[] args) {
        Park park = new Park("Парк аттракционов Витебска");
        Attraction attraction1 = park.new Attraction("Горки", "10:00 - 19:00", 5);
        attraction1.info();
        Attraction attraction2 = park.new Attraction("Колесо обозрения", "10:00 - 21:00", 10);
        attraction2.info();
    }
}