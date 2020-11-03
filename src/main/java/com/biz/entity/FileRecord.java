package com.biz.entity;

/**
 * @table file_info
 */
public class FileRecord {
    /** id： */
    private String id;

    /** group_name：文件在FastDFS中的组名 */
    private String groupName;

    /** file_name：文件在FastDFS中路径+文件名 */
    private String fileName;

    /** file_size：文件大小用于下载时显示下载进度的 */
    private Long fileSize;

    /** file_type：文件类型 jpg,txt,png,css,word... */
    private String fileType;

    /** old_file_name：文件上传前的名字用于下载时显示默认文件用的 */
    private String oldFileName;

    /** user_id： */
    private Integer userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }

    public String getOldFileName() {
        return oldFileName;
    }

    public void setOldFileName(String oldFileName) {
        this.oldFileName = oldFileName == null ? null : oldFileName.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}