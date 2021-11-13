package ru.ibs.hwdata.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ibs.hwdata.entities.Car;
import ru.ibs.hwdata.repo.CarRepository;

import java.sql.*;
import java.util.List;

@Service
public class CarDAO {
    /*private static int CAR_COUNTER;
    private static Connection connection;
    *//*spring.datasource.url=jdbc:postgresql://localhost:5432/myData
    spring.datasource.username=root
    spring.datasource.password=root
    spring.jpa.generate-ddl=create*//*

    private static final String URL = "jdbc:mysql://localhost:3306/newcars";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "roott";*/


    private CarRepository carRepository;

    public Car save(Car car){
        return carRepository.save(car);
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car findById(Integer id){
        return carRepository.getOne(id);
    }

    public void deleteById(Integer id){
        carRepository.deleteById(id);
    }

    public String str(){
        return "lala";
    }


   /* static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Car> index(){
        List<Car> car = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM new_table";
            ResultSet resultSet =statement.executeQuery(SQL);

            while (resultSet.next()){
                Car car1 = new Car();

                car1.setId(resultSet.getInt("id"));
                car1.setModel(resultSet.getString("model"));

                car.add(car1);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return car;
    }
    public Car show(int id){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM new_table WHERE id =?");

         preparedStatement.setInt(1,id);

         ResultSet resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void save(Car car){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO new_table VALUES(?)");

            preparedStatement.setString(1,car.getModel());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
