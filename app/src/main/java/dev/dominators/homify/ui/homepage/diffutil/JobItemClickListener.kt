package dev.dominators.homify.ui.homepage.diffutil

import dev.dominators.homify.datamodel.NewJobData

interface JobItemClickListener {

    fun jobItemClicked(newJobData: NewJobData)
}