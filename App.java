import javax.swing.JOptionPane;
import java.util.ArrayList;

public class App {
  // Lista de clientes
  static ArrayList<Cliente> clientsList = new ArrayList<Cliente>();

  // Lista de Automoviles
  ArrayList<Automovil> automovilesList = new ArrayList<Automovil>();

  // Lista de alquileres
  // ArrayList<Alquiler> AlquileresList = new ArrayList<Alquiler>();

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
    + "4. Consultar automóviles \n"
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
        case 1:
          // Get data
          String names = JOptionPane.showInputDialog( "Registra los Nombres: " );
          String surnames = JOptionPane.showInputDialog( "Registra los Apellidos: " );
          String address = JOptionPane.showInputDialog( "Registra la Direccion de residencia: " );
          int contactNumber = Integer.parseInt( JOptionPane.showInputDialog( "Registra el Numero de contacto (Numeros): " ) );
          int documentNumber = Integer.parseInt( JOptionPane.showInputDialog( "Registra el Numero de Documento (Numeros): " ) );

          // Add client
          boolean clientExists = validateClientExists( documentNumber );

          // Create a new client
          if ( clientExists ) {
            String message = "WARNING: This client exists!";

            // Show messages
            System.out.println(message  );
            JOptionPane.showMessageDialog( null, message );
          } else {
            Cliente client = new Cliente( names, surnames, address, contactNumber, documentNumber );
            clientsList.add( client );
            System.out.println( "Client created successfully!" );
          }
        break;

        case 2:
          System.out.println( "Opcion 2" );
        break;

        case 3:
          System.out.println( "Opcion 3" );
        break;

        case 4:
          System.out.println( "Opcion 4" );
        break;

        case 5:
          // Print list of clients
          printListOf( "clients" );
        break;

        case 6:
          System.out.println( "Opcion 6" );
        break;

        case 7:
          System.out.println( "Opcion 7" );
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
  public static boolean validateClientExists( int documentNumber ) {
    for ( Cliente client : clientsList ) {
      if ( client.getNumeroDeDocumento() == documentNumber ) {
        return true;
      }
    }
    return false;
  }

  // List objects
  public static void printListOf ( String typeList ) {
    // Capitalize
    String firstLetter = typeList.substring(0, 1).toUpperCase();
    String typeListCapitalized = firstLetter + typeList.substring(1);

    String toPrint = "List of " + typeListCapitalized + "\n";

    // Each elemetn
    switch ( typeList.toLowerCase() ) {
      case "clients":
        for ( Cliente client : clientsList ) {
          toPrint += "\n - Name: " + client.getNombres() + " CC: " + client.getNumeroDeDocumento();
        }
      break;

      case "automoviles":
        for ( Automovil automovil : automovilesList ) {
          toPrint += "\n - Name: " + client.getNombres() + " CC: " + client.getNumeroDeDocumento();
        }
      break;

      // case "alquiler":
      //   for ( Alquiler alquiler : AlquileresList ) {
      //     toPrint += "\n - Name: " + client.getNombres() + " CC: " + client.getNumeroDeDocumento();
      //   }
      // break;
    }

    // Print list of objects
    JOptionPane.showMessageDialog( null, toPrint );
  }
}
