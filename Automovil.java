public class Automovil {
  // Attributes
  private String marca;
  private String linea;
  private String placa;
  private String estado; // Only 2 options: disponible - alquilado

  // Constructor
  public Automovil ( String marca, String linea, String placa, String estado ) {
    this.marca = marca;
    this.linea = linea;
    this.placa = placa;
    this.estado = estado;
  }

  // Getters
  public String getMarca () { return this.marca; }
  public String getLinea () { return this.linea; }
  public String getPlaca () { return this.placa; }
  public String getEstado () { return this.estado; }

  // Setters
  private void setMarca ( String newValue ) { this.marca = newValue; }
  private void setLinea ( String newValue ) { this.linea = newValue; }
  private void setPlaca ( String newValue ) { this.placa = newValue; }
  /*=====
    NOTE:
    Estos setters no son necesarios en el programa, solamente usamos el setter de estado
  *=====*/

  public void setEstado ( String newValue ) { this.estado = newValue; }
}
