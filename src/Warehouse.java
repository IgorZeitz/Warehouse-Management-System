import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private int id = -1; // automatically creating new warehouse id

    private String name;
    private String city;

    List<Warehouse> warehouses = new ArrayList<Warehouse>();

    Warehouse(String name, String city){
        id += 1;
        this.name = name;
        this.city = city;
    }

//    void add(Warehouse warehouse){
//        warehouses.add(id, warehouse);
//    }
//
//    void delete(int id){
//        warehouses.remove(id);
//        id -= 1;
//    }
//
//    void edit(int id, Warehouse warehouse){
//        warehouses.set(id, warehouse);
//    }

}
