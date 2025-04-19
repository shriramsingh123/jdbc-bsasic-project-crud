package com.jspider.productCrud.repository;

import com.jspider.productCrud.connections.JdbcConnection;
import com.jspider.productCrud.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository{

    private final Connection connection = JdbcConnection.getConnection();


    @Override
    public List<Product> getAll() {
        String query ="select * from product";
        if (connection!= null){
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                List<Product> products = new ArrayList<>();
                while (resultSet.next()){
                    Product product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setColor(resultSet.getString("color"));
                    product.setPrice(resultSet.getDouble("price"));
                    product.setManufacturingDate(resultSet.getDate("mfgDate"));
                    products.add(product);
                }
                return products;
            } catch (SQLException e) {
                throw new RuntimeException("Connection Not Established while fetching the product");
            }
        }else return null;
    }

    @Override
    public Product getById(int id) {
        String query ="select * from product where id="+id;
        if (connection != null){
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                if (resultSet.next()){
                    Product product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setColor(resultSet.getString("color"));
                    product.setPrice(resultSet.getDouble("price"));
                    product.setManufacturingDate(resultSet.getDate("mfgDate"));
                    return product;
                }else return null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Exception In ProductRepositoryImpl.getById()"+e);
                }
            }
        }
        return null;
    }

    @Override
    public void insertProduct(Product product) {
        String query = "insert into product(id,name,color,price,mfgDate) value(?,?,?,?,?)";
        try {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,product.getId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setString(3,product.getColor());
            preparedStatement.setDouble(4,product.getPrice());
            preparedStatement.setDate(5,product.getManufacturingDate());
            int i = preparedStatement.executeUpdate();
            if (i>0){
                System.out.println("Product of Id ["+product.getId()+"] getting inserted" );
            }else{
                System.out.println("Product of Id ["+product.getId()+"] not inserted" );
            }


        } catch (SQLException e) {
            System.out.println("Exception In ProductRepositoryImpl.insertProduct()"+e);
        }finally {
            try {
                assert connection != null;
                connection.close();
            } catch (SQLException e) {
                System.out.println("Exception In ProductRepositoryImpl.insertProduct()"+e);
            }
        }
    }

    @Override
    public int addAll(List<Product> products) {
        String query ="insert into product(id,name,color,price,mfgDate) values(?,?,?,?,?)";
        int rows =0;
        if (connection!=null){
            try (PreparedStatement preparedStatement=connection.prepareStatement(query)){
                for (Product product:products){
                 preparedStatement.setInt(1,product.getId());
                 preparedStatement.setString(2,product.getName());
                 preparedStatement.setString(3,product.getColor());
                 preparedStatement.setDouble(4,product.getPrice());
                 preparedStatement.setDate(5,product.getManufacturingDate());
                 rows += preparedStatement.executeUpdate();
                }
            } catch (SQLException e) {
                System.out.println("Exception in ProductRepositoryImpl.addAll()"+e);
            }
        }
        return rows;
    }

    @Override
    public int deleteById(int id) {
        String query = "delete from product where id="+id;
        if (connection != null){
            try {
                return connection.prepareStatement(query).executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Getting SQLException while deleting the record");
            }
            finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Exception In ProductRepositoryImpl.deleteById()"+e);
                }
            }
        }else return 0;
    }



    @Override
    public int updateProduct(Product product, int id) {
        String query = "UPDATE product SET name = ?, color = ?, price = ?, mfgDate = ? WHERE id = ?";
        if (connection != null) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, product.getName());
                preparedStatement.setString(2, product.getColor());
                preparedStatement.setDouble(3, product.getPrice());
                preparedStatement.setDate(4, product.getManufacturingDate());
                preparedStatement.setInt(5, id);
                return preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Exception in ProductRepositoryImpl.updateProduct(): " + e);
            }
        }
        return 0;
    }

}
