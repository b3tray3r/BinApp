//package com.example.binapp.database
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.example.binapp.json.BinInfoItem
//import io.reactivex.rxjava3.core.Completable
//import io.reactivex.rxjava3.core.Single
//
//
//@Dao
//interface BinInfoDao {
//
//    @Query("SELECT * FROM full_bin_list")
//    fun getBinList(): Single<BinInfoItem>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertBinList(priceList: List<BinInfoItem>) : Completable
//}