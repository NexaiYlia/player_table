package com.nexai.service;

import com.nexai.exception.CustomException;
import com.nexai.model.Player;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelFileCreator {

    public static void createFile(List<Player> players) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Player Rating");


        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Player Name");
        headerRow.createCell(1).setCellValue("Points");
        headerRow.createCell(2).setCellValue("Age");


        for (int i = 0; i < players.size(); i++) {
            XSSFRow row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue(players.get(i).getName());
            row.createCell(1).setCellValue(players.get(i).getNumberOfPoints());
            row.createCell(2).setCellValue(players.get(i).getAge());
        }


        try (FileOutputStream fileOut = new FileOutputStream("PlayerTable.xlsx")) {
            workbook.write(fileOut);
            System.out.println("Excel file generated successfully!");
        } catch (IOException e) {
            throw new CustomException("Input operation was failed");
        } finally {
            workbook.close();
        }
    }
}
