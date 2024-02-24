package com.senai.first_road.apis

import com.google.gson.JsonObject
import com.senai.first_road.models.Login
import com.senai.first_road.models.Trilhas
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*
import java.util.*

interface EndpointInterface {
    @GET("trilha")
    fun listarTrilhas(): Call<List<Trilhas>>

    @POST("login")
    fun login(@Body usuario: Login): Call<JsonObject>

    @GET("usuarios/{idUsuario}")
    fun buscarUsuarioPorID(@Path(value = "idUsuario", encoded = true) idUsuario: UUID): Call<JsonObject>

    @Multipart
    @PUT("usuarios/editarImagem/{idUsuario}")
    fun editarImagemUsuario(
        @Part imagem: MultipartBody.Part,
        @Path(value = "idUsuario", encoded = true) idUsuario: UUID
    ) : Call<JsonObject>
}