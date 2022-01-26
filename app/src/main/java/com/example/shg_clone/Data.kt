package com.example.shg_clone

data class DataAboutUs(
    val description: String,
    val id: Int,
    val image: String,
    val title: String
)
data class  DataLoginParam(
    val phone:String

    )
data class  DataLoginRes(
     val id: String,
    val phone:String,
    val code:Int,
    val code_expire:String,
    val retry_in:String,
    val retry_times:Int,
    val deleted_at:String,
    val created_at:String,
    val updated_at:String,

)
data class  DataOTPParam(
    val phone: String,
    val verify_code:Int
)
data class  DataOTP(
    val access_token: String,
    val token_type:String,
    val expires_at: Int,
)