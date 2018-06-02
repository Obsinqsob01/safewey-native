package me.luisguerra495.safewey

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.message.view.*

class MainActivity : AppCompatActivity() {

    val ArrayMessages = ArrayList<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ArrayMessages.add(Message("1", "Hello world", "mine"))
        
        val messageAdapter = MessageAdapter(ArrayMessages)
        listMessages.adapter = messageAdapter
    }

    inner class MessageAdapter : BaseAdapter {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val myView = layoutInflater.inflate(R.layout.message, null)

            myView.txtMessage.text = listMessagesAdapter[position].content

            return myView
        }

        override fun getItem(position: Int): Any {
            return listMessagesAdapter[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listMessagesAdapter.size
        }

        var listMessagesAdapter = ArrayList<Message>()
        constructor(listMessages: ArrayList<Message>) : super(){
            this.listMessagesAdapter = listMessages
        }
    }
}
