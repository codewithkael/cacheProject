package com.codewithkael.masoudcachesystem;

public interface IDownloadHelper {
    void OnDownloadFinished(String id,String path);
    void OnProgressChange(String id,int progress);
}
