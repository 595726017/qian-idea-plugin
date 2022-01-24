package com.github.qianmi.action.link

import com.github.qianmi.infrastructure.domain.project.link.BaseLink
import com.github.qianmi.infrastructure.domain.project.link.RocketMqLink

class RocketMqAction : BaseLinkAction() {

    override fun getLinkProject(): BaseLink {
        return RocketMqLink.getInstance()
    }

}