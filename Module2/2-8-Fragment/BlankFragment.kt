package com.example.fragmentex

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.fragmentex.databinding.FragmentBlankBinding


class BlankFragment : Fragment()
{

    private var _binding: FragmentBlankBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        // Inflate the layout for this fragment
        _binding = FragmentBlankBinding.inflate(inflater, container, false)
        val view = binding.root




        /*txt1.setOnClickListener {

            var i = Intent(requireActivity(),MainActivity::class.java)
            startActivity(i)
        }*/

        binding.txt1.setOnClickListener {

            var b1 = BlankFragment2()
            var fm: FragmentManager = requireFragmentManager()
            var ft: FragmentTransaction = fm.beginTransaction()
            ft.replace(R.id.frmid,b1).commit()

        }

        return view
    }


}