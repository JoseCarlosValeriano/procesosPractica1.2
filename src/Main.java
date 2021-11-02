import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        System.out.println("Introduce la cantidad de navegadores que quieres ejecutar: ");
        int cantidad = lectura.nextInt();
        ArrayList<Process> processList = new ArrayList<Process>();

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");

        try {



            System.out.println("La hora de arranque del proceso es: " + returnExecutionTime());

            for (int i = 0; i < cantidad; i++) {
                Process process = processBuilder.start();
                processList.add(process);
            }

            for (Process process : processList) {
                process.waitFor(500, TimeUnit.MILLISECONDS);
                process.destroy();
            }

            System.out.println("La hora de finalización del proceso es: " + returnExecutionTime());



        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static String returnExecutionTime(){
        long hourExecuted = LocalDateTime.now().getHour();
        long minutesExecuted = LocalDateTime.now().getMinute();
        long secondsExecuted = LocalDateTime.now().getSecond();

        return hourExecuted + ":" + minutesExecuted + ":" + secondsExecuted;

    }

}