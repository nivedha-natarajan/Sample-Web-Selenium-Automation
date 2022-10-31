package com.framework.init;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.framework.utils.Configuration;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ExtentInit implements Configuration {

    protected static ExtentReports extent;
    protected static ExtentTest logger;
    public static String REPORT_PATH;
    public static String FOLDER_PATH;

    static void initializeReport(String suiteName) {

        File directory = new File(PROJECT_DIR + File.separator + "ExtentReports");
        if (!directory.exists()) directory.mkdir();

        String dateDir = PROJECT_DIR + File.separator + "ExtentReports" + File.separator +
                LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMMyyyy"));
        File dateDirectory = new File(dateDir);
        if (!dateDirectory.exists()) dateDirectory.mkdir();

        String timeDir = PROJECT_DIR + File.separator + "ExtentReports" + File.separator +
                LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMMyyyy")) +
                File.separator + LocalTime.now().format(DateTimeFormatter.ofPattern("hhmmss"));
        File timeDirectory = new File(timeDir);
        if (!timeDirectory.exists()) timeDirectory.mkdir();

        REPORT_PATH = timeDir;
        FOLDER_PATH = dateDir;

        ExtentHtmlReporter htmlReporter;
        htmlReporter = new ExtentHtmlReporter(timeDir + File.separator + "Report_" + suiteName + ".html");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        extent.setSystemInfo("OS : ", System.getProperty("os.name"));
        extent.setSystemInfo("OS Architecture : ", System.getProperty("os.arch"));
        extent.setSystemInfo("Java Version : ", System.getProperty("java.version"));
        extent.setSystemInfo("User Name : ", System.getProperty("user.name"));
        extent.setSystemInfo("Machine Name : ", System.getProperty("machine.name"));
        extent.setSystemInfo("IP Address : ", System.getProperty("machine.address"));

        extent.setAnalysisStrategy(AnalysisStrategy.TEST);

        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Test Report");
        htmlReporter.config().setTheme(Theme.DARK);

        String js =
                "let timeline = document.getElementsByClassName('panel-lead')[4];" +
                        "const time = parseInt(timeline.innerText.replace(',',''));" +
                        "const hours = Math.floor((time / (1000 * 60 * 60)) % 24);" +
                        "const minutes = Math.floor((time / (1000 * 60)) % 60);" +
                        "const seconds = Math.floor((time / 1000) % 60);" +
                        "const milliseconds  = parseInt((time % 1000) / 100);" +
                        "timeline.innerText = hours + \"h \" + minutes + \"m \" + seconds + \"s \" + milliseconds + \"ms\";" +
                        "let ver = document.querySelectorAll('.darken-3')[2];" +
                        "ver.style.display='none';" +
                        "let title = document.querySelector('.report-name');" +
                        "title.className='';" +
                        "title.innerHTML='<img src=\"/logo.svg\" width=100px/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Report </sub>'" +
                        "let logo = document.getElementsByClassName('brand-logo')[0];" +
                        "logo.style.display='none';";

        htmlReporter.config().setJS(js);

    }

    static void flushReport() {
        extent.flush();
    }

}

