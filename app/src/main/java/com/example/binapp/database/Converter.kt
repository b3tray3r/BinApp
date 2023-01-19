//package com.example.binapp.database
//
//import androidx.room.TypeConverter
//import com.example.binapp.json.Bank
//import com.example.binapp.json.BinInfoItem
//
//
//class Converter {
//
//    @TypeConverter
//    fun fromBank(bank: Bank): String? {
//        return BinInfoItem().bank.toString()
//    }
//
//    fun toBank(value: String): Bank? {
//        return Bank(value)
//    }
//
//}