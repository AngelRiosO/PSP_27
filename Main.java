import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

// Cambiamos el directorio de ejecución de nuestro prcoceso
public class Main{

    public static void main(String[] args) {
        // Captura directorios del sistema
        String userHome = System.getProperty("user.home");
        String userDir = System.getProperty("user.dir");
        // Pantalla
        System.out.println("Directorio del usuario logeado: " + userHome);
        System.out.println("Directorio de trabajo: " + userDir);

        try {
            // Evaluamos el sistema operativo
            String osNombre = System.getProperty("os.name");
            String comand;
            String rutTem;

            if (osNombre.toLowerCase().contains("win")) {
                comand = "cmd /c dir";
                rutTem = "c:/temp";
            } else {
                comand = "sh -c ls";
                rutTem = "/tmp";
            }

            // Utilizamos split para generar el proceso
            String[] argumentos = comand.split("\\s");
            ProcessBuilder pBuilder = new ProcessBuilder(argumentos);

            // Cambiamos el directorio de trabajo del proceso dependiendo del sistema operativo
            pBuilder.directory(new File(rutTem));

            // Creo algo
            Process process = pBuilder.start();
            //Stream del Proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            reader.lines().forEach(System.out::println);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}