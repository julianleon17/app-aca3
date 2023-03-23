public class Automovil {
  // Attributes
  private String marca;
  private String linea;
  private String placa;
  private String estado;

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
  public void setMarca ( String newValue ) { this.marca = newValue; }
  public void setLinea ( String newValue ) { this.linea = newValue; }
  public void setPlaca ( String newValue ) { this.placa = newValue; }
  public void setEstado ( String newValue ) { this.estado = newValue; }
}
