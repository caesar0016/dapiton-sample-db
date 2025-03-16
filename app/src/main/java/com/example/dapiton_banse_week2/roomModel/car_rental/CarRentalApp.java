package com.example.dapiton_banse_week2.roomModel.car_rental;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

public class CarRentalApp {

    @Entity(tableName = "services")
    public class Services {
        @PrimaryKey(autoGenerate = true)
        public int service_id;

        public String name;
        public String description;
        public double price;
    }

    @Entity(tableName = "cars")
    public class Car {
        @PrimaryKey(autoGenerate = true)
        public int car_id;

        public String brand; // e.g., Toyota
        public String model; // e.g., Corolla
        public String carPlate; // License plate
        public int year; // Manufacturing year

        public Car(int car_id, String brand, String model, String carPlate, int year) {
            this.car_id = car_id;
            this.brand = brand;
            this.model = model;
            this.carPlate = carPlate;
            this.year = year;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "car_id=" + car_id +
                    ", brand='" + brand + '\'' +
                    ", model='" + model + '\'' +
                    ", carPlate='" + carPlate + '\'' +
                    ", year=" + year +
                    '}';
        }
    }

    @Entity(
            tableName = "pencil_bookings",
            foreignKeys = {
                    @ForeignKey(
                            entity = UserAccount.class,
                            parentColumns = "acc_id",
                            childColumns = "user_id",
                            onDelete = ForeignKey.CASCADE // Delete pencil bookings if user is deleted
                    ),
                    @ForeignKey(
                            entity = Car.class,
                            parentColumns = "car_id",
                            childColumns = "car_id",
                            onDelete = ForeignKey.CASCADE // Delete pencil bookings if car is deleted
                    )
            }
    )
    public class PencilBooking {
        @PrimaryKey(autoGenerate = true)
        public int pencilBooking_id;

        public int user_id; // Foreign key to UserAccount
        public int car_id; // Foreign key to Car

        public long startDate; // Use long for Date (timestamp)
        public long endDate; // Use long for Date (timestamp)
        public String status; // e.g., Reserved, Cancelled

        public long created_at; // Timestamp for FIFO logic

        public PencilBooking(int pencilBooking_id, int user_id, int car_id, long startDate, long endDate, String status, long created_at) {
            this.pencilBooking_id = pencilBooking_id;
            this.user_id = user_id;
            this.car_id = car_id;
            this.startDate = startDate;
            this.endDate = endDate;
            this.status = status;
            this.created_at = created_at;
        }

        @Override
        public String toString() {
            return "PencilBooking{" +
                    "pencilBooking_id=" + pencilBooking_id +
                    ", user_id=" + user_id +
                    ", car_id=" + car_id +
                    ", startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", status='" + status + '\'' +
                    ", created_at=" + created_at +
                    '}';
        }
    }

    @Entity(
            tableName = "rentals",
            foreignKeys = {
                    @ForeignKey(
                            entity = UserAccount.class,
                            parentColumns = "acc_id",
                            childColumns = "user_id",
                            onDelete = ForeignKey.CASCADE
                    ),
                    @ForeignKey(
                            entity = Car.class,
                            parentColumns = "car_id",
                            childColumns = "car_id",
                            onDelete = ForeignKey.CASCADE
                    )
            }
    )
    public class Rental {
        @PrimaryKey(autoGenerate = true)
        public int confirmRent_id;

        public int user_id; // Foreign key to UserAccount
        public int car_id; // Foreign key to Car
        public long startDate;
        public long endDate;
        public double totalCost;
        public long created_at; // Timestamp for FIFO logic
    }

    @Entity(tableName = "payments")
    public class Payment {
        @PrimaryKey(autoGenerate = true)
        public int payment_id;

        public int rental_id; // Foreign key to Rental
        public double amount;
        public String paymentMethod; // e.g., Credit Card, Cash
        public long paymentDate; // Timestamp
    }

    @Entity(tableName = "user_accounts")
    public class UserAccount {
        @PrimaryKey(autoGenerate = true)
        public int acc_id;

        public String name;
        public String username;
        public String password; // Store hashed passwords, not plain text
        public String role; // e.g., Admin, Customer
    }

}
