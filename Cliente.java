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

  // Setters
  public void setNombres ( String newValue ) { this.nombres = newValue; }
  public void setApellidos ( String newValue ) { this.apellidos = newValue; }
  public void setDireccionDeResidencia ( String newValue ) { this.direccionDeResidencia = newValue; }
  public void setNumeroDeContacto ( int newValue ) { this.numeroDeContacto = newValue; }
  public void setNumeroDeDocumento ( int newValue ) { this.numeroDeDocumento = newValue; }
}
