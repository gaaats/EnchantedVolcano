package com.snake.io.slither.gamerrrrr

import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.snake.io.slither.R
import com.snake.io.slither.databinding.FragmentEnteringBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class EnteringFragment : Fragment() {

    var counter = 0.05f
    var diff = 0.05f

    private var _binding: FragmentEnteringBinding? = null
    private val binding get() = _binding ?: throw RuntimeException("FragmentStartBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnteringBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            cycleUpAndDovnAlpha()

            binding.btnHeart.setOnClickListener {
                Snackbar.make(binding.root, "I love you too ♥♥♥", Snackbar.LENGTH_LONG).show()
            }
            binding.btnHeart1.setOnClickListener {
                Snackbar.make(binding.root, "I love you too ♥♥♥", Snackbar.LENGTH_LONG).show()
            }

            binding.lotLeftDovn.setOnClickListener {
                findNavController().navigate(R.id.action_enteringFragment_to_endFinishFragment)
            }
            binding.lotLeftTop.setOnClickListener {
                findNavController().navigate(R.id.action_enteringFragment_to_endFinishFragment)
            }
            binding.lotRightDovn.setOnClickListener {
                findNavController().navigate(R.id.action_enteringFragment_to_endFinishFragment)
            }
            binding.lotRightTop.setOnClickListener {
                findNavController().navigate(R.id.action_enteringFragment_to_endFinishFragment)
            }
        } catch (e: Exception) {
            snackBarError()
        }



        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun snackBarError() {
        Snackbar.make(
            binding.root,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }


    private fun cycleUpAndDovnAlpha() {
        lifecycleScope.launch {
            while (true) {
                binding.tvTitle.alpha = counter
                if (counter >= 1f) {
                    diff = -0.05f
                }
                if (counter <= 0.1f) {
                    diff = 0.05f
                }
                delay(30)
                counter += diff
            }
        }
    }

}