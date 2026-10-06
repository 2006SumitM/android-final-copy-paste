package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class OrderFragment : Fragment() {

    interface OnMessageSendListener {
        fun onMessageSend(message: String)
    }

    private var listener: OnMessageSendListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OnMessageSendListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(
            R.layout.fragment_order,
            container,
            false
        )

        val food = arguments?.getString("Food").orEmpty()
        val qty = arguments?.getString("Qty").orEmpty()

        view.findViewById<TextView>(R.id.tvItem).text =
            "Item: $food"

        view.findViewById<TextView>(R.id.tvQty).text =
            "Quantity: $qty"

        view.findViewById<Button>(R.id.btnConfirm)
            .setOnClickListener {
                listener?.onMessageSend(
                    "Order Confirmed - Payment: CASH"
                )
            }

        view.findViewById<Button>(R.id.btnCancel)
            .setOnClickListener {
                listener?.onMessageSend("Order Cancelled")
            }

        return view
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }
}
