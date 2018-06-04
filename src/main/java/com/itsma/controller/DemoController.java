package com.itsma.controller;

import com.itsma.service.FileOperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

/**
 * Created by dengfan on 2017/10/27.
 */
@Controller
public class DemoController {
    @Autowired
    private FileOperatorService fileOperatorService;
    @RequestMapping("/")
    public String index3(Model model) throws IOException {
        String[] linuxFilePath=fileOperatorService.readfile("../webapps/automation/WEB-INF/classes/static/logs");
        String[] linuxFilePathMixmode=fileOperatorService.readfile("../webapps/automation/WEB-INF/classes/static/logs_mixmode1");
        String[] linuxFilePathUpgrade=fileOperatorService.readfile("../webapps/automation/WEB-INF/classes/static/logs_upgrade");
        // windows
        // File f3 = new File("..\\webapps\\automation\\WEB-INF\\classes\\static\\logs");
        //File f3 = new File("../webapps/automation/WEB-INF/classes/static/logs");
        //String f1 = f3.getAbsolutePath();
        //System.out.println("*********"+f1);

        long[] file=fileOperatorService.sort(linuxFilePath);
            model.addAttribute("messages", file);
        if(file.length>0) {
            model.addAttribute("firstdata", file[0]);
        }
        long[] mixmodeFile=fileOperatorService.sort(linuxFilePathMixmode);
        model.addAttribute("mixmessages", mixmodeFile);
        long[] upgradeFile=fileOperatorService.sort(linuxFilePathUpgrade);
        model.addAttribute("upgmessages", upgradeFile);


        return "index";
    }


}
