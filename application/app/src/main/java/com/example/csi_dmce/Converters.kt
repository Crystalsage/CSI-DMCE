package com.example.csi_dmce

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun otpToValue(otp: OTP): List<String> {
        return listOf(
            otp.value.toString(),
            otp.expiration_time.toString(),
            otp.creation_time.toString(),
            otp.isExpired.toString()
        )
    }

    @TypeConverter
    fun valueToOtp(value: String, expiration_time: String, creation_time: String, isExpired: String): OTP {
        return OTP(
            value.toInt(),
            creation_time.toInt(),
            expiration_time.toInt(),
            isExpired.toBoolean()
        )
    }
}