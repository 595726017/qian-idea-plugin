package com.github.qianmi.action.link

import com.github.qianmi.infrastructure.domain.project.link.BaseLink
import com.github.qianmi.infrastructure.domain.project.link.GitBookLink

class GitBookAction : BaseLinkAction() {

    override fun getLinkProject(): BaseLink {
        return GitBookLink.getInstance()
    }

}