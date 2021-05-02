package com.codewithkael.masoudcachesystem.persistence;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.codewithkael.masoudcachesystem.ImageModel;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface LocationDao {

    @Insert (onConflict = IGNORE)
    Long[] insertImage(ImageModel... imageModels);

    @Insert (onConflict = REPLACE)
    void insertImages(ImageModel... locations);

    @Query("SELECT * FROM images")
    LiveData<List<ImageModel>> getImages();


    @Delete
    void delete(ImageModel... locations);

    @Query("DELETE FROM images")
    void deleteAll();

    @Query("SELECT * FROM images WHERE image_id = :imageId")
    ImageModel getImage(String imageId);

    @Update(onConflict = REPLACE)
    void update (ImageModel... locations);

    @Query("SELECT EXISTS (SELECT 1 FROM images WHERE image_id = :id)")
    Boolean exists(String id);


}
