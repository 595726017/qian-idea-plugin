package com.github.qianmi.domain.project.tools

import com.alibaba.fastjson.JSONObject
import com.github.qianmi.action.dubboinvoke.InvokeDialog
import com.github.qianmi.util.MyPsiUtil
import com.intellij.psi.PsiMethod
import org.apache.commons.io.FilenameUtils
import java.util.stream.Collectors


class DubboAdminInvoke(
    /**
     * 是否支持
     */
    var isSupport: Boolean,
) {

    companion object {
        fun defaultDubboAdminInvoke(): DubboAdminInvoke {
            return DubboAdminInvoke(true)
        }

        private const val formatUrl = "invoke {packageName}.{className}.{methodName} ({argJson})"

        fun getInvokeCommand(methodPsi: PsiMethod, argList: Map<String, InvokeDialog.Arg>): String {
            val psiJavaFile = MyPsiUtil.getContainingPsiJavaFile(methodPsi)
            return formatUrl
                .replace("{packageName}", psiJavaFile.packageName)
                .replace("{className}", FilenameUtils.getBaseName(psiJavaFile.containingFile.name))
                .replace("{methodName}", MyPsiUtil.getMethodName(methodPsi))
                .replace("{argJson}", argList.values.stream()
                    .map { arg -> JSONObject.toJSONString(JSONObject.parse(arg.jTextArea.text)) }
                    .collect(Collectors.joining(",")))
        }
    }


}