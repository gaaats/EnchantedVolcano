package com.snake.io.slither.gamerrrrr

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

    var counterAlpha = 0.05f
    var diffAlpha = 0.05f

    private var _biiiiiiinding: FragmentEnteringBinding? = null
    private val binding
        get() = _biiiiiiinding ?: throw RuntimeException("FragmentStartBinding = null")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _biiiiiiinding = FragmentEnteringBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            makeCycleUpAndDovnAlpha()

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
            makeError()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        _biiiiiiinding = null
        super.onDestroy()
    }

    private fun makeError() {
        Snackbar.make(
            binding.root,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }


    private fun makeCycleUpAndDovnAlpha() {
        lifecycleScope.launch {
            while (true) {
                binding.tvTitle.alpha = counterAlpha
                if (counterAlpha >= 1f) {
                    diffAlpha = -0.05f
                }
                if (counterAlpha <= 0.1f) {
                    diffAlpha = 0.05f
                }
                delay(30)
                counterAlpha += diffAlpha
            }
        }
    }

}