package com.livermor.boostnoteclient.feature.edit

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.livermor.boostnoteclient.R
import com.livermor.boostnoteclient.model.NoteItem
import kotlinx.android.synthetic.main.fragment_edit.*

/**
 * @author dumchev on 19.07.2018.
 */
class EditFragment : Fragment() {

    private val noteItem: NoteItem by lazy { arguments?.getParcelable(ARGS_NOTE) as NoteItem }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_edit, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvNoteTitle.text = noteItem.title
        cvEdit.setCode(noteItem.text)
    }

    companion object {

        private const val ARGS_NOTE = "ARGS_NOTE"

        fun instance(item: NoteItem): EditFragment {
            val args = Bundle().apply { putParcelable(ARGS_NOTE, item) }
            return EditFragment().apply { arguments = args }
        }
    }
}