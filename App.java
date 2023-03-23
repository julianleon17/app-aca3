import javax.swing.JOptionPane;
import java.util.ArrayList;

public class App {
  // Lista de clientes
  static ArrayList<Cliente> clientsList = new ArrayList<Cliente>();

  // Lista de Automoviles
  static ArrayList<Automovil> automovilesList = new ArrayList<Automovil>();

  // Lista de alquileres
  static ArrayList<Alquiler> alquileresList = new ArrayList<Alquiler>();

  public static void main ( String[] args ) {
    // Set variables
    int cantidadConsignaciones = 0;
    int cantidadRetiros = 0;
    byte option = 0;
    String welcomeMessage =
    "==================================\n"
    + "\t Empresa ABC \n"
    + "==================================\n";

    String optionsMenu =
    "OPCIONES \n"
    + "1. Ingreso de clientes \n"
    + "2. Ingreso de automoviles \n"
    + "3. Registro de alquiler \n"
    + "4. Consultar automoviles \n"
    + "5. Consultar clientes \n"
    + "6. Consultar alquileres \n"
    + "7. Consultar alquileres por cliente \n"
    + "8. Salir \n";

    // Proccess ===============
    // Welcome
    System.out.println( welcomeMessage );

    do {
      option = Byte.parseByte( JOptionPane.showInputDialog( optionsMenu ) );
      String toPrint = "";

      switch ( option ) {
        // Clients
        case 1:
          // Get data
          String names = JOptionPane.showInputDialog( "Registra los Nombres: " );
          String surnames = JOptionPane.showInputDialog( "Registra los Apellidos: " );
          String address = JOptionPane.showInputDialog( "Registra la Direccion de residencia: " );
          String documentNumber = JOptionPane.showInputDialog( "Registra el Numero de Documento (Numeros): " );
          int contactNumber = Integer.parseInt( JOptionPane.showInputDialog( "Registra el Numero de contacto (Numeros): " ) );

          // Add client
          boolean clientExists = validateObjectExists( "client", documentNumber );

          // Create Client
          if ( clientExists ) {
            String message = "WARNING: This client exists!";

            // Show messages
            System.out.println( message  );
            JOptionPane.showMessageDialog( null, message );
          } else {
            Cliente client = new Cliente( names, surnames, address, contactNumber, Integer.parseInt( documentNumber ) );
            clientsList.add( client );
            System.out.println( "Client created successfully!" );
          }
        break;

        // Automoviles
        case 2:
          // Get data
          String brand = JOptionPane.showInputDialog( "Registra la Marca: " );
          String model = JOptionPane.showInputDialog( "Registra el Modelo: " );
          String plate = JOptionPane.showInputDialog( "Registra la Placa: " );

          /*====== NOTA:
            // String status = JOptionPane.showInputDialog( "Registra el Estado: " );

            No se pide que se ingrese el estado, esto porque al ser recien creado
            o agregado se supone que su estado es disponible
          *======*/

          // Add client
          boolean automovilExists = validateObjectExists( "automovil", plate );

          // Create Automovil
          if ( automovilExists ) {
            String message = "WARNING: This Automovil exists!";

            // Show messages
            System.out.println( message  );
            JOptionPane.showMessageDialog( null, message );
          } else {
            Automovil automovil = new Automovil( brand, model, plate, "disponible" );
            automovilesList.add( automovil );
            System.out.println( "Automovil created successfully!" );
          }
        break;

        // Alquileres
        case 3:
          // Get data
          String numeroDocumentoCliente = JOptionPane.showInputDialog( "Registra el Numero de documento del cliente: " );
          String placaAutomovil = JOptionPane.showInputDialog( "Registra la placa del automovil: " );
          String fechaInicial = JOptionPane.showInputDialog( "Registra la la fecha de entrega (YY-MM-DD): " );
          String diasParaAlquilar = JOptionPane.showInputDialog( "Registra la cantidad de dias para alquilar: " );

          // Add Alquiler
          boolean canCreateAlquiler = false;

          if ( validateObjectExists( "automovil", placaAutomovil ) ) {
            if ( validateObjectExists( "client", numeroDocumentoCliente ) ) {
              canCreateAlquiler = true;
            } else {
              JOptionPane.showMessageDialog( null, "WARNING: This Client does not exists!" );
              System.out.println( "WARNING: This Client does not exists!" );
            }
          } else {
            JOptionPane.showMessageDialog( null, "WARNING: This Automovil does not exists!" );
            System.out.println( "WARNING: This Automovil does not exists!" );
          }

          // Create Alquiler
          if ( canCreateAlquiler ) {
            boolean alquilerExists = validateObjectExists( "alquiler", placaAutomovil );

            if ( alquilerExists ) {
              String message = "WARNING: This Alquiler exists!";

              // Show messages
              System.out.println( message  );
              JOptionPane.showMessageDialog( null, message );
            } else {
              Alquiler alquiler = new Alquiler( numeroDocumentoCliente, placaAutomovil, fechaInicial, Integer.parseInt( diasParaAlquilar ) );
              alquileresList.add( alquiler );
              System.out.println( "Alquiler created successfully!" );
            }
          } else {
            // Show messages
            String message = "WARNING: The Alquiler could not be created!";

            System.out.println( message  );
            // JOptionPane.showMessageDialog( null, message );
          }
        break;

        case 4:
          // Print list of Automoviles
          printListOf( "automoviles" );
        break;

        case 5:
          // Print list of Clients
          printListOf( "clients" );
        break;

        case 6:
          // Print list of Alquileres
          printListOf( "alquileres" );
        break;

        case 7:
          String clientDocument = JOptionPane.showInputDialog( "Registra el documento del cliente: " );
          boolean isClientExists = validateObjectExists( "client", clientDocument );

          // Create Client
          if ( isClientExists ) {
            printAlquileresPerClient ( Integer.parseInt( clientDocument ) );
          } else {
            String message = "WARNING: This client does not exists!";

            // Show messages
            System.out.println( message  );
            JOptionPane.showMessageDialog( null, message );
          }
        break;

        case 8:
          System.out.println( "Bye!" );
        break;

        default:
          JOptionPane.showMessageDialog( null, "Invalid Option" );
        break;
      }
    } while ( option != 8 );
    System.exit( 0 );
  }

  // Methods
  public static boolean validateObjectExists( String objectType, String toSearch ) {
    boolean toReturn = false;

    switch ( objectType.toLowerCase() ) {
      case "client":
        for ( Cliente client : clientsList ) {
          if ( client.getNumeroDeDocumento() == Integer.parseInt( toSearch ) ) {
            toReturn = true;
          }
        }
      break;

      case "automovil":
        for ( Automovil automovil : automovilesList ) {
          if ( automovil.getPlaca().toLowerCase().equals( toSearch.toLowerCase() ) ) {
            toReturn = true;
          }
        }
      break;

      case "alquiler":
        for ( Alquiler alquiler : alquileresList ) {
          if ( alquiler.getPlacaAutomovil().toLowerCase().equals( toSearch.toLowerCase() ) ) {
            return true;
          }
        }
      break;
    }

    return toReturn;
  }

  // List objects
  public static void printListOf ( String listType ) {
    // Capitalize
    String firstLetter = listType.substring( 0, 1 ).toUpperCase();
    String listTypeListCapital = firstLetter + listType.substring( 1 );

    String toPrint = "List of " + listTypeListCapital + "\n";

    // Each elemetn
    switch ( listType.toLowerCase() ) {
      case "clients":
        for ( Cliente client : clientsList ) {
          toPrint += "\n Name: " + client.getNombres() + " - " + client.getApellidos();
          toPrint += "\n CC: " + client.getNumeroDeDocumento();
          toPrint += "\n==================\n";
        }
      break;

      case "automoviles":
        for ( Automovil automovil : automovilesList ) {
          toPrint += "\n Marca: " + automovil.getMarca() + " - " + automovil.getLinea();
          toPrint += "\n Placa: " + automovil.getPlaca();
          toPrint += "\n Estado: " + automovil.getEstado();
          toPrint += "\n==================\n";
        }
      break;

      case "alquileres":
        for ( Alquiler alquiler : alquileresList ) {
          toPrint += "\n Documento del cliente: " + alquiler.getNumeroDocumentoCliente();
          toPrint += "\n Placa del automovil: " + alquiler.getPlacaAutomovil();
          toPrint += "\n Fecha inicial: " + alquiler.getFechaInicial();
          toPrint += "\n Dias por alquilar: " + alquiler.getDiasParaAlquilar();
          toPrint += "\n==================\n";
        }
      break;
    }

    // Print list of objects
    JOptionPane.showMessageDialog( null, toPrint );
  }

  // Get alquileres per client
  public static void printAlquileresPerClient ( int clientDocument ) {
    String toPrint = "List of Alquileres of client by document " + clientDocument + "\n";

    for ( Alquiler alquiler : alquileresList ) {
      if ( Integer.parseInt( alquiler.getNumeroDocumentoCliente() ) == clientDocument ) {
      }
      toPrint += "\n Documento del cliente: " + alquiler.getNumeroDocumentoCliente();
      toPrint += "\n Placa del automovil: " + alquiler.getPlacaAutomovil();
      toPrint += "\n Fecha inicial: " + alquiler.getFechaInicial();
      toPrint += "\n Dias por alquilar: " + alquiler.getDiasParaAlquilar();
      toPrint += "\n==================\n";
    }

    // Print list of objects
    JOptionPane.showMessageDialog( null, toPrint );
  }
}
