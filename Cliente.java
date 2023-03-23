public class Cliente {
  // Attributes
  private String nombres;
  private String apellidos;
  private String direccionDeResidencia;
  private int numeroDeContacto;
  private int numeroDeDocumento;

  // Constructor
  public Cliente ( String nombres, String apellidos, String direccionDeResidencia, int numeroDeContacto, int numeroDeDocumento ) {
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.direccionDeResidencia = direccionDeResidencia;
    this.numeroDeContacto = numeroDeContacto;
    this.numeroDeDocumento = numeroDeDocumento;
  }

  // Getters
  public String getNombres () { return this.nombres; }
  public String getApellidos () { return this.apellidos; }
  public String getDireccionDeResidencia () { return this.direccionDeResidencia; }
  public int getNumeroDeContacto () { return this.numeroDeContacto; }
  public int getNumeroDeDocumento () { return this.numeroDeDocumento; }

  /*=====
    NOTE:
    Los setters del cliente no son necesarios en el programa
  *=====*/
  // Setters
  private void setNombres ( String newValue ) { this.nombres = newValue; }
  private void setApellidos ( String newValue ) { this.apellidos = newValue; }
  private void setDireccionDeResidencia ( String newValue ) { this.direccionDeResidencia = newValue; }
  private void setNumeroDeContacto ( int newValue ) { this.numeroDeContacto = newValue; }
  private void setNumeroDeDocumento ( int newValue ) { this.numeroDeDocumento = newValue; }
}
