
package covid19;

public class ComboItem {
    private int id;
    private String nombre;
    private int cantidad;

    public ComboItem(int id, String descripcion) {
        this.id = id;
        this.nombre = descripcion;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return nombre;
    }

    public void setDescripcion(String descripcion) {
        this.nombre = descripcion;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
