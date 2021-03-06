package com.example.shg_clone
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @Headers("Accept: application/json",
        "Content-Type: application/json",
        "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNTU4MzkyOTI5OTgyNWNmOTVhNmYyZjhhMDJhMzI4ODQxN2Y2ZjJiYWVkMTQyMTFlMzBjNGU0Yjg3NTJjNTA0NjhkZWMyMjlkOTRhOTZjNWUiLCJpYXQiOjE2NDIxNTMxNzkuMDY0NDU1LCJuYmYiOjE2NDIxNTMxNzkuMDY0NDU5LCJleHAiOjE2NzM2ODkxNzkuMDYxOTUyLCJzdWIiOiI3ODMiLCJzY29wZXMiOltdfQ.XIYKYuCajR8YI6M1_BdIgM3sr9ssCNjEvR-ssOgthGpsnXe2JT8ShCP4bb7EELeNiuzRhWpj1Am6Flzcga8gXo7QeHVld4jJLkf2POLyV9LViiW_jGoxQCpoGBMscswn3EDOwMMOdWkGgPaI_A1RF-bCP33f0OKbWmArvvgMmpKymWIE3ufqTSTiAz8XnZw5lGiAVrYmZpmfGLzuL9RyiSFL8qo0SigeyrVxJQIdXPVjfuPmBcPLc-fP4xgoHwWLBz3Sh2DtKepbQ6Kd6DxDbZKrd_msCiDeJYlG60fMrhq0574nE47wYp1CWfSHmKN-kgWzV3dExVyfbn3JLsk9btOvaDU-BabM4x1F2taPXnINZeb8KgxR8zZUlGO9q2_XMgto6R_ad4Rdhi3Za2xaqCFaOWh07-Qghvb7x9pMi1Rb54Oe6dELroP283j-5fmOtVvoQhpTlVhBYU7Wd2T7ROUHgX0JK71bpBsblpIXuyYfy0KIl3kOZimMonpFuNRi8nkMrFBPJunRcZyuyJJp90Se6epz6CLj3zXFZxOiBiz6ML9xh7xUAeqRBw-ILv3mBs8G6jL2fGRACjGCUv_qsQHJ3PonpO1J5lNTFy1qQCaKGo4K4FiFfILMUsHxdth4VGtgjv0d7y2FFRK8o5u5-Kh_XrVly7Hjft6UFh3gmt4\n",)
    @GET("api/v1/about-us")
    //  @GET("posts")
    fun getData(): Call<AboutUsX>

    @Headers("Accept: application/json",
        "Content-Type: application/json")
    @POST("api/request-otp")
    fun postLogin(@Body phone: Any): Call<DataLoginRes>

    @Headers("Accept: application/json",
        "Content-Type: application/json")
    @POST("api/verify-otp")
    fun postOTP(@Body phone: Any,@Body verify_code:Any): Call<DataOTP>

}

