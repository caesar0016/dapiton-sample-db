package com.example.dapiton_banse_week2.roomModel.car_rental;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CarRentalDao {

    // ==================== Services DAO ====================
    @Insert
    void insertService(CarRentalApp.Services service);

    @Query("SELECT * FROM services")
    List<CarRentalApp.Services> getAllServices();

    @Query("SELECT * FROM services WHERE service_id = :serviceId")
    CarRentalApp.Services getServiceById(int serviceId);

    @Query("DELETE FROM services WHERE service_id = :serviceId")
    void deleteServiceById(int serviceId);

    // ==================== Car DAO ====================
    @Insert
    void insertCar(CarRentalApp.Car car);

    @Query("SELECT * FROM cars")
    List<CarRentalApp.Car> getAllCars();

    @Query("SELECT * FROM cars WHERE car_id = :carId")
    CarRentalApp.Car getCarById(int carId);

    @Query("DELETE FROM cars WHERE car_id = :carId")
    void deleteCarById(int carId);

    // ==================== PencilBooking DAO ====================
    @Insert
    void insertPencilBooking(CarRentalApp.PencilBooking pencilBooking);

    @Update
    void updatePencilBooking(CarRentalApp.PencilBooking pencilBooking);

    @Query("SELECT * FROM pencil_bookings WHERE car_id = :carId AND status = 'Reserved' ORDER BY created_at ASC")
    List<CarRentalApp.PencilBooking> getPencilBookingsByCarFIFO(int carId);

    @Query("SELECT * FROM pencil_bookings WHERE car_id = :carId AND status = 'Reserved' AND ((startDate <= :endDate AND endDate >= :startDate)) ORDER BY created_at ASC")
    List<CarRentalApp.PencilBooking> getConflictingPencilBookings(int carId, long startDate, long endDate);

    @Query("SELECT * FROM pencil_bookings WHERE user_id = :userId")
    List<CarRentalApp.PencilBooking> getPencilBookingsByUser(int userId);

    @Query("DELETE FROM pencil_bookings WHERE pencilBooking_id = :pencilBookingId")
    void deletePencilBookingById(int pencilBookingId);

    // ==================== Rental DAO ====================
    @Insert
    void insertRental(CarRentalApp.Rental rental);

    @Query("SELECT * FROM rentals WHERE car_id = :carId ORDER BY created_at ASC")
    List<CarRentalApp.Rental> getRentalsByCarFIFO(int carId);

    @Query("SELECT * FROM rentals WHERE car_id = :carId AND ((startDate <= :endDate AND endDate >= :startDate)) ORDER BY created_at ASC")
    List<CarRentalApp.Rental> getConflictingRentals(int carId, long startDate, long endDate);

    @Query("SELECT * FROM rentals WHERE user_id = :userId")
    List<CarRentalApp.Rental> getRentalsByUser(int userId);

    @Query("DELETE FROM rentals WHERE confirmRent_id = :rentalId")
    void deleteRentalById(int rentalId);

    // ==================== Payment DAO ====================
    @Insert
    void insertPayment(CarRentalApp.Payment payment);

    @Query("SELECT * FROM payments WHERE rental_id = :rentalId")
    List<CarRentalApp.Payment> getPaymentsByRental(int rentalId);

    @Query("DELETE FROM payments WHERE payment_id = :paymentId")
    void deletePaymentById(int paymentId);

    // ==================== UserAccount DAO ====================
    @Insert
    void insertUserAccount(CarRentalApp.UserAccount userAccount);

    @Query("SELECT * FROM user_accounts WHERE acc_id = :userId")
    CarRentalApp.UserAccount getUserById(int userId);

    @Query("SELECT * FROM user_accounts WHERE username = :username AND password = :password")
    CarRentalApp.UserAccount login(String username, String password);

    @Query("DELETE FROM user_accounts WHERE acc_id = :userId")
    void deleteUserById(int userId);
}