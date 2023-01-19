//package com.example.binapp.database
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import androidx.room.TypeConverters
//import com.example.binapp.json.Bank
//import com.example.binapp.json.BinInfoItem
//
//@Database(entities = [BinInfoItem::class], version = 1, exportSchema = false)
//@TypeConverters(Converter::class)
//abstract class BinDataBase : RoomDatabase() {
//    companion object {
//        private var db: BinDataBase? = null
//        private const val DB_NAME = "main.db"
//        private val LOCK = Any()
//
//        fun getInstance(context: Context): BinDataBase {
//            synchronized(LOCK) {
//                db?.let { return it }
//                val instance: BinDataBase =
//                    Room.databaseBuilder(
//                        context,
//                        BinDataBase::class.java,
//                        DB_NAME
//                    ).addTypeConverter(Converter::class).build()
//                db = instance
//                return instance
//            }
//
//        }
//    }
//
//    abstract fun binInfoDao(): BinInfoDao
//}
