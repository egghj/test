package cn.longyt.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class ThreadUtils2 {
    
    public static final String FILE_PATH = "D:\\test\\data\\source\\mybatis.jar";
    
    public static final String DEST_PATH = "D:\\test\\data\\target\\";

    @Test
    public void test01(){
        try {
            this.execute(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void execute(int threadSize) throws InterruptedException, ExecutionException {
        System.out.println("----程序开始运行----");
        long start = System.currentTimeMillis();
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(threadSize);
        // 创建多个有返回值的任务
        List<Future<String>> taskList = new ArrayList<Future<String>>();
        for (int i = 0; i < threadSize; i++) {
            Callable<String> task = new CopyFileCallable((i + 1) + "");
            // 执行任务并获取Future对象
            Future<String> f = pool.submit(task);
            taskList.add(f);
        }
        // 关闭线程池
        pool.shutdown();

        // 获取所有并发任务的运行结果
        for (Future<String> f : taskList) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println(f.get());
        }
        long costTime = System.currentTimeMillis() - start;
        System.out.println("----程序结束运行----，程序运行时间【" + costTime + "毫秒】");
    }
}

class CopyFileCallable implements Callable<String> {
    
    private String taskNum;

    CopyFileCallable(String taskNum) {
        this.taskNum = taskNum;
    }

    public String call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        long start = System.currentTimeMillis();
        for(int i=0;i<500;i++){
            //FileTools.copyFile(ThreadUtils2.FILE_PATH, ThreadUtils2.DEST_PATH + "mybatis_"+taskNum +"_"+ i + ".jar");
            FileUtils.copyFile(new File(ThreadUtils2.FILE_PATH), new File(ThreadUtils2.DEST_PATH + "mybatis_"+taskNum +"_"+ i + ".jar"));
        }
        long costTime = System.currentTimeMillis() - start;
        System.out.println(">>>" + taskNum + "任务终止");
        return ">>>" + taskNum + "任务返回运行结果,当前任务执行时间【" + costTime + "毫秒】";
    }
}
