public class Alquiler {
  // Attributes
  private String numeroDocumentoCliente;
  private String placaAutomovil;
  private String fechaInicial;
  private int diasParaAlquilar;

  // Constructor
    public Alquiler ( String numeroDocumentoCliente, String placaAutomovil, String fechaInicial, int diasParaAlquilar ) {
    this.numeroDocumentoCliente = numeroDocumentoCliente;
    this.placaAutomovil = placaAutomovil;
    this.fechaInicial = fechaInicial;
    this.diasParaAlquilar = diasParaAlquilar;
  }

  // Getters
  public String getNumeroDocumentoCliente () { return this.numeroDocumentoCliente;  }
  public String getPlacaAutomovil () { return this.placaAutomovil;  }
  public String getFechaInicial () { return this.fechaInicial;  }
  public int getDiasParaAlquilar () { return this.diasParaAlquilar;  }

  /*=====
    NOTE:
    Los setters del cliente no son necesarios en el programa
  *=====*/
  // Setters
  private void setNumeroDocumentoCliente ( String newValue ) { this.numeroDocumentoCliente = newValue; }
  private void setPlacaAutomovil ( String newValue ) { this.placaAutomovil = newValue; }
  private void setFechaInicial ( String newValue ) { this.fechaInicial = newValue; }
  private void setDiasParaAlquilar ( int newValue ) { this.diasParaAlquilar = newValue; }
}
