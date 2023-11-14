package com.example.praktisimengajar.network.data.network;

import com.example.praktisimengajar.network.data.model.PostComment;
import com.example.praktisimengajar.network.data.model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    //GET	/posts
    @GET("/posts")
    Call<List<Posts>> getPosts();

    //GET	/posts/1
    @GET("/posts/{id}")
    Call<Posts> getPostsById(@Path("id") int id);

    //GET	/posts/1/comments
    @GET("/posts/{id}/comments")
    Call<List<PostComment>> getPostsComments(@Path("id") int id);

    //GET	/comments?postId=1
    @GET("/posts/comments")
    Call<List<PostComment>> getCommentsByPostId(@Query("postId") int id);

    //POST	/posts
    @POST("/posts")
    Call<Posts> postPosts();

    //PUT	/posts/1
    @PUT("/posts/{id}")
    Call<Posts> putPosts(@Path("id") int id);

    //PATCH	/posts/1
    @PATCH("/posts/{id}")
    Call<Posts> patchPosts(@Path("id") int id);

    //DELETE	/posts/1
    @DELETE("/posts/{id}")
    Call<Void> deletePosts(@Path("id") int id);

//    Hit with RequestBody
//    @POST("users/new")
//    Call<User> createUser(@Body User user);

//    @FormUrlEncoded
//    @POST("user/edit")
//    Call<User> updateUser(@Field("first_name") String first, @Field("last_name") String last);

//    @Multipart
//    @PUT("user/photo")
//    Call<User> updateUser(@Part("photo") RequestBody photo, @Part("description") RequestBody description);

//    @Headers({
//            "Accept: application/vnd.github.v3.full+json",
//            "User-Agent: Retrofit-Sample-App"
//    })
//    @GET("users/{username}")
//    Call<User> getUser(@Path("username") String username);

//    @GET("user")
//    Call<User> getUser(@Header("Authorization") String authorization)
}
