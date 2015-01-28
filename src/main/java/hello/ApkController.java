package hello;

import model.ApkInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@Controller
public class ApkController {


    @RequestMapping("/")
    public String apk(@RequestParam(value = "rootDir", required = true, defaultValue = "/") String mRootDir, Model model) {

        String mRootHttp = "http://apk.s.diandian.com/";

        List<ApkInfo> list = new ArrayList<ApkInfo>();
        File mDir = new File(mRootDir);
        if (mDir.exists() && mDir != null && mDir.isDirectory()) {
            for (File file : mDir.listFiles()) {
                ApkInfo apkInfo = ApkInfo.parse(file);
                if (apkInfo != null) {
                    apkInfo.setUrl(file.getPath().replace("/data/jenkins/config/userContent/", mRootHttp));
                    list.add(apkInfo);
                }
            }
        }
        model.addAttribute("apks", list);
        return "apks";
    }




}
