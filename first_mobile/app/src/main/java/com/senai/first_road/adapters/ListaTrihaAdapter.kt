package com.senai.first_road.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.senai.first_road.R
import com.senai.first_road.models.Trilhas

class ListaTrihaAdapter(

    private val context: Context,
    private val listaTrilha: List<Trilhas>
    ) : RecyclerView.Adapter<ListaTrihaAdapter.ViewHolder>() {

        class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

            //Essa função é responsável por chamar e atribuir valores para as views do item da RecyclerView
            fun vincularDadosNoItem(trilhas: Trilhas) {
                val titulo_trilha= itemView.findViewById<TextView>(R.id.titulo_trilha)
                titulo_trilha.text = trilhas.titulo_trilha

                val situacao = itemView.findViewById<TextView>(R.id.situacao)
                situacao.text = trilhas.situacao

                val descricao_trilha = itemView.findViewById<TextView>(R.id.descricao_trilha)
                descricao_trilha.text = trilhas.descricao_trilhas
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListaTrihaAdapter.ViewHolder {
            val inflater = LayoutInflater.from(context);

            val view = inflater.inflate(R.layout.fragment_trilha, parent, false)

            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ListaTrihaAdapter.ViewHolder, position: Int) {
            val itemTrilhas = listaTrilha[position]

            holder.vincularDadosNoItem(itemTrilhas)
        }

        override fun getItemCount(): Int {
            return listaTrilha.size
        }
    }
