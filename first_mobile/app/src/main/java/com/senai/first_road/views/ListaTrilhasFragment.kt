package com.senai.first_road.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.senai.first_road.adapters.ListaTrihaAdapter
import com.senai.first_road.apis.EndpointInterface
import com.senai.first_road.apis.RetrofitConfig
import com.senai.first_road.databinding.FragmentListaTrilhasBinding
import com.senai.first_road.models.Trilhas
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaTrilhasFragment : Fragment() {

    private val clienteRetrofit = RetrofitConfig.obterInstanciaRetrofit()

    private val endpoints = clienteRetrofit.create(EndpointInterface::class.java)

    private var _binding: FragmentListaTrilhasBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentListaTrilhasBinding.inflate(inflater, container, false)

        val root: View = binding.root

        // organiza os itens da Recycler em ordem vertical, sendo um debaixo do outro
        binding.recyclerTrilhas.layoutManager = LinearLayoutManager(requireContext())

        endpoints.listarTrilhas().enqueue(object : Callback<List<Trilhas>> {
            override fun onResponse(call: Call<List<Trilhas>>, response: Response<List<Trilhas>>) {
                val trilhas = response.body()

                binding.recyclerTrilhas.adapter = trilhas?.let { ListaTrihaAdapter(requireContext(), it) }
            }

            override fun onFailure(call: Call<List<Trilhas>>, t: Throwable) {
                println("Falha na requisição: ${t.message}")
            }

        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}