package com.biz.utils;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;

public class LocalFastDFSUtils {


    /**
     * @desc 非web本地方式上传文件
     */
    public static void uploadFile(){

        TrackerServer trackerServer = null;
        StorageServer storageServer = null;
        try {
            ClientGlobal.init("classpath:fastdfs.conf");

            TrackerClient trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();

            storageServer = trackerClient.getStoreStorage(trackerServer);
            // 定义 Storage 的客户端对象，需要使用这个对象来完成具体的文件上传、下载和删除等工作
            StorageClient client = new StorageClient(trackerServer, storageServer);

            String[] result = client.upload_file("", "jpg", null);

            for(String str : result) {
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }finally {

            try {
                if(trackerServer != null) {
                    trackerServer.close();
                }

                if(storageServer != null) {
                    storageServer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    //
    public void downloadFile() {

        TrackerServer trackerServer = null;
        StorageServer storageServer = null;
        try {
            ClientGlobal.init("classpath:fastdfs.conf");

            TrackerClient trackerClient = new TrackerClient();
            trackerServer = trackerClient.getConnection();

            storageServer = trackerClient.getStoreStorage(trackerServer);
            // 定义 Storage 的客户端对象，需要使用这个对象来完成具体的文件上传、下载和删除等工作
            StorageClient client = new StorageClient(trackerServer, storageServer);


            String groupName = "";
            String remoteFileName = "";
            String loadedFileName = "d:/abc.jpg";
            // result = 0 表示下载成功
            int result = client.download_file(groupName, remoteFileName, loadedFileName);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }finally {

            try {
                if(trackerServer != null) {
                    trackerServer.close();
                }

                if(storageServer != null) {
                    storageServer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }










}
