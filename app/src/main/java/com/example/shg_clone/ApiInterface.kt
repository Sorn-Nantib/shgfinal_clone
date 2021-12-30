package com.example.shg_clone

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {
    @Headers("Accept: application/json",
        "Content-Type: application/json",
        "Authorization: Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiNmJjM2JjYmQ2MGNhMjFjMDYwMmRlZTkzMmVjMThjNzVkNTBhNDYyN2EzMTFhOGNmOGJiZjZkNzkyMDA2NTQ0ZGI0ODU0MTM2MTNiMjQ4NTEiLCJpYXQiOjE2NDA3NDk3MjEuMzcwNzcyLCJuYmYiOjE2NDA3NDk3MjEuMzcwNzc2LCJleHAiOjE2NzIyODU3MjEuMzY5MDAyLCJzdWIiOiI2NTciLCJzY29wZXMiOltdfQ.ajIIXPE9UByPmDJe0qKjwY-oFdBjFKFYxBp0BACOuvBC7yTvUVGtUz5rIrbsbPYlb-dXNOP41wi6bZrzwhhqyYwKzmux8sRoUT_AbExHrpKRkFsyZ1RalcOXA4nNnB5NMRS30JGs68-Bka39ot2-q2SlmSsUzPg-L5TcpkhVRhYInZLe_67HYpskvnH-_YMbOerEu24eAU_pnUAngEi9-EkAYL5_RG3GqgRVtbv3Y2xrIgG0UcTANf-ZfiEFsCYGxvQQFlRMZVj5TlGxWqa57nvHcZgqYXIiP8wo1NujeR9k6Fi-8xNf8sIYH17f1cvjUYqlqGNoh52NucW4tR93YUgckPbwLYsZFFOC7NqkCflgYHHRwB0UvXpZrmp8Uk4GxXOn4YRitgYJOGYg1NWS7ThnmmS9_MmtSbHQuazg3H8Z7QmSjT0-6QVCTHVkkUOcR0tmkUwF4uZ0AePIc5EsdBdVG5njoD9fH7xi32uShdqIT75zs9tcjD9QK3SqhCD3Skp5_pqOi0mwH_l4TvGjEdc1WuyQjxr5QY7rl_grBAiKMEcVMycZe8E6qVroWiUWtCl9-p9QXis8wF9AAtV5-rQ28GcUEhCEcC9cg71AiztMZHc_biLIaorF32CNgpWKLUpspo8fiOLA8Z_mSZHRtyG6yueR3SR40htMZDdQNJ4\n",)
    @GET("api/v1/about-us")
  //  @GET("posts")
    fun getData(): Call<AboutUsX>
}