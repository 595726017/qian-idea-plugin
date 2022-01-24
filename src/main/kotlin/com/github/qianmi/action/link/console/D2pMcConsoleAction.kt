package com.github.qianmi.action.link.console

import com.github.qianmi.action.link.BaseLinkAction
import com.github.qianmi.infrastructure.domain.project.link.BaseLink
import com.github.qianmi.infrastructure.domain.project.link.console.D2pMcConsoleLink

class D2pMcConsoleAction : BaseLinkAction() {

    override fun getLinkProject(): BaseLink {
        return D2pMcConsoleLink.getInstance()
    }

}