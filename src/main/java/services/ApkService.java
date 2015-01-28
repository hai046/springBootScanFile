package services;

import model.ApkInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApkService {
    private static final Logger logger = LoggerFactory
            .getLogger(ApkService.class);

    public static final int OPER_START = 0x00001;

    public static final int OPER_STOP = 0x00010;

    public static final int OPER_RUNNING = 0x00100;

    private List<ApkInfo> mList = new ArrayList<ApkInfo>();

    private int mOperate;

    private File mDir;

    private String mRootHttp = "http://apk.diandian.com/";
    private String mRootDir = "/Users/haizhu/Documents/workspace/";

    public ApkService() {
        setDir("/Users/haizhu/Documents/workspace/wuya-android-vest");
        start();
    }

    private void start() {
        setOperate(OPER_START);
        run();
    }

    public void setDir(String path) {
        this.mDir = new File(path);
    }

    public void setOperate(int operate) {
        this.mOperate = operate;
    }

    private void run() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                while ((mOperate & OPER_START) == OPER_START) {
                    // logger.debug("====pre runing========");
                    if ((mOperate & OPER_START) == OPER_RUNNING) {
                        logger.warn("======is runing  wait========");
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    scan();
                    try {
                        Thread.sleep(10 * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

            }
        }).start();
    }

    protected void scan() {

        List<ApkInfo> list = new ArrayList<ApkInfo>();
        if (mDir != null && mDir.isDirectory()) {
            for (File file : mDir.listFiles()) {
                ApkInfo apkInfo = ApkInfo.parse(file);
                if (apkInfo != null) {
                    apkInfo.setUrl(file.getPath().replace(mRootDir, mRootHttp));
                    list.add(apkInfo);
                }
            }
        }
        synchronized (mList) {
            mList.clear();
            mList.addAll(list);
        }

    }

    public List<ApkInfo> getCurrentApks() {
        return mList;
    }

}
