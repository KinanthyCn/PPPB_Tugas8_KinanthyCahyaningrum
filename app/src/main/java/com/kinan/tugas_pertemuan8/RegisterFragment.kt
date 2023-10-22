package com.kinan.tugas_pertemuan8

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.kinan.tugas_pertemuan8.databinding.FragmentRegisterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
        companion object{

            var username:String? = "Kinan"
            var password:String? = "Kinan"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_register, container, false)


        with(view){

            findViewById<TextView>(R.id.login_txt).setOnClickListener {
                (requireActivity() as MainActivity).switchFragment(1)
            }

//            Pindah ke login (1)
            findViewById<Button>(R.id.btn_regist).setOnClickListener {
                if (findViewById<EditText>(R.id.input_username).text.isEmpty()){
                    findViewById<EditText>(R.id.input_username).error = "Username tidak boleh kosong"
                } else if (findViewById<EditText>(R.id.input_email).text.isEmpty()){
                    findViewById<EditText>(R.id.input_email).error = "Email tidak boleh kosong"
                } else if (findViewById<EditText>(R.id.input_phone).text.isEmpty()){
                    findViewById<EditText>(R.id.input_phone).error = "Nomor Telepon tidak boleh kosong"
                } else if (findViewById<EditText>(R.id.input_password).text.isEmpty()) {
                    findViewById<EditText>(R.id.input_password).error = "Password tidak boleh kosong"
                } else if (!findViewById<CheckBox>(R.id.checkbox_regist).isChecked) {
                    Toast.makeText(this@RegisterFragment.requireActivity(),"Anda belum menyetujui ToC", Toast.LENGTH_SHORT).show()
                }else  {
                    username = findViewById<EditText>(R.id.input_username).text.toString()
                    password = findViewById<EditText>(R.id.input_password).text.toString()



                    findViewById<EditText>(R.id.input_username).text?.clear()
                    findViewById<EditText>(R.id.input_email).text?.clear()
                    findViewById<EditText>(R.id.input_phone).text?.clear()
                    findViewById<EditText>(R.id.input_password).text?.clear()
                    findViewById<CheckBox>(R.id.checkbox_regist).isChecked = false

                    Toast.makeText(this@RegisterFragment.requireActivity(), "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
                    (requireActivity() as MainActivity).switchFragment(1)
                }
            }
        }

        return view
    }


    }
