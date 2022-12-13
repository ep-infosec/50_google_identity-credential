package com.android.mdl.appreader.document

import com.android.mdl.appreader.R

// Just used for the test event
class RequestMulti003 : RequestDocument() {
    override val docType = "org.micov.1"
    override val nameSpace = "org.micov.vtr.1"
    private val nameSpace2 = "org.micov.attestation.1"
    override val dataItems = DataItems.values().asList()

    override fun getItemsToRequest(): Map<String, Map<String, Boolean>> {
        return mapOf(
            Pair(nameSpace, mapOf(Pair("pid_DL", false))),
            Pair(nameSpace2, mapOf(Pair("safeEntry_Leisure", false)))
        )
    }

    enum class DataItems(override val identifier: String, override val stringResourceId: Int) :
        RequestDataItem {
        SAFE_ENTRY_INDICATION("safeEntry_Leisure", R.string.micov_att_safeEntry_Leisure),
        ID_WITH_DRIVERS_LICENSE_NUMBER("pid_DL", R.string.micov_vtr_pid_DL)
    }
}