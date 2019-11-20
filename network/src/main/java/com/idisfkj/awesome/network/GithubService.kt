package com.idisfkj.awesome.network

import com.google.gson.JsonObject
import com.idisfkj.awesome.common.model.IssuesModel
import com.idisfkj.awesome.common.model.ReposModel
import com.idisfkj.awesome.common.model.UserModel
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

/**
 * Created by idisfkj on 2019-08-30.
 * Email : idisfkj@gmail.com.
 */
interface GithubService {

    @GET("/user")
    suspend fun getUser(): UserModel

    @GET("/users/{username}/repos")
    suspend fun getPros(@Path("username") username: String): Response<List<ReposModel>>

    @GET("/user/repos")
    suspend fun getPros(@QueryMap params: Map<String, String>): List<ReposModel>

    @POST("/{user}/repos")
    suspend fun createRepos(@Path("user") username: String, @Body params: JsonObject): Response<ReposModel>

    @POST("/repos/{user}/{repo}/issues")
    suspend fun createIssues(
        @Path("user") username: String,
        @Path("repo") repo: String,
        @Body params: JsonObject
    ): IssuesModel

    @POST("/login/oauth/access_token")
    suspend fun getAccessToken(@Body params: JsonObject): Response<ResponseBody>


}