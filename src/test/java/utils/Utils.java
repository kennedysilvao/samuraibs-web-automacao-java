package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static void takeScreenshot(WebDriver driver, String fileName){
        // Captura evidência
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            // Função para adicionar no diretório
            addEvidencesDirectory(file, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addEvidencesDirectory(File file, String fileName) throws IOException {
        // Pega a data atual + hora atual e formata
        Date data = new Date();
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(data.getTime());

        // cria um novo diretório para armazenar a evidência
        File destFile = new File("./evidencias/" + fileName +" - " + timeStamp + ".jpeg");

        // Copia a evidência para o diretório
        FileUtils.copyFile(file, destFile);
    }
}
